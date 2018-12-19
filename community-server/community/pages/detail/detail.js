// pages/detail/detail.js
var util = require('../../util/util.js')
var app = getApp()
Page({
  data: {
    question: {},
    answers: [],
    message: "关注问题",
    isMyQuestion: false,
    isClose: false,
    noAnswer: false,
    id: " ",
  },
  onLoad: function (options) {
    // 页面初始化 options为页面跳转所带来的参数
    var id = options.id;
    // console.log("questionId:"+id)
    //调用应用实例的方法获取全局数据
    this.setData({
      id: id
    })
    this.getData(id);

    if (this.data.isMyQuetion) {
      this.setData({
        message: "关闭问题"
      })
    }
  },
  onShow() {
    var options = {
      id: this.data.id
    }
    this.onLoad(options)
  },
  //事件处理函数
  bindItemTap: function (e) {
    // console.log(answer_id);
    // console.log(e.currentTarget.id)
    var answerId = e.currentTarget.id
    wx.navigateTo({
      //跳转至回答详情界面
      url: '../comment/comment?answerId=' + answerId
    })
  },

  onText: function (e) {

    var url = "../answer/answer?id=" + this.data.id
    wx.navigateTo({
      //跳转至回答界面
      url: url
    })
  },
  deleteAnswerTap: function(e){
    var answerId = e.currentTarget.id

    var that = this
    wx.showModal({
      title: '提示',
      content: '确定删除该回答吗？',
      success: function (sm) {
        var t = that
        if (sm.confirm) {
          
          wx.request({
            url: app.globalData.domain + "answer/del",
            data: { "answerId": answerId },
            method: 'POST',
            header: {
              'content-type': 'application/json'
            },
            success: function (res) {
              t.onShow()
            }
          })
        }
      }
    })
  },

  onBtn: function (e) {

    var isMyQues = this.data.isMyQuestion;
    if (isMyQues) {
      this.closeProblem()
    } else {
      this.careProblem()
    }

  },

  closeProblem: function () {
    if (this.data.message == "关闭问题") {
      this.setData({
        message: "开启问题"
      });

      var url = app.globalData.domain + 'question/close'
      var data = {
        questionId: this.data.id
      }

      wx.request({
        url: url,
        data: data,
        method: "POST",
        header: {
          'content-type': 'application/json'
        },
        success(res) {
        }
      })
      this.setData({
        isClose: true
      })


      wx.showToast({
        title: '关闭问题成功',
        icon: 'success',
        duration: 1000,
        mask: true
      });
    } else if (this.data.message == "开启问题") {
      this.setData({
        message: "关闭问题"
      });

      var url = app.globalData.domain + 'question/open'
      var data = {
        questionId: this.data.id
      }

      wx.request({
        url: url,
        data: data,
        method: "POST",
        header: {
          'content-type': 'application/json'
        },
        success(res) {
        }
      })

      this.setData({
        isClose: false
      })

      wx.showToast({
        title: '开启问题成功',
        icon: 'success',
        duration: 1000,
        mask: true
      });
    }


  },

  //关注问题按钮的点击插入数据库
  careProblem: function () {
    if (this.data.message == "关注问题") {
      this.setData({
        message: "取消关注"
      });

      var url = app.globalData.domain + 'question/focus'
      var data = {
        questionId: this.data.id,
        userId: app.globalData.userId
      }

      wx.request({
        url: url,
        data: data,
        method: "POST",
        header: {
          'content-type': 'application/json'
        },
        success(res) {
        }
      })

      wx.showToast({
        title: '关注问题成功',
        icon: 'success',
        duration: 1000,
        mask: true
      });
    } else if (this.data.message == "取消关注") {
      this.setData({
        message: "关注问题"
      });

      var url = app.globalData.domain + 'question/ignore'
      var data = {
        questionId: this.data.id,
        userId: app.globalData.userId
      }

      wx.request({
        url: url,
        data: data,
        method: "POST",
        header: {
          'content-type': 'application/json'
        },
        success(res) {
        }
      })

      wx.showToast({
        title: '已取消关注',
        icon: 'success',
        duration: 1000,
        mask: true
      });
    }
  },
  //使用本地 fake 数据实现刷新效果
  getData: function (id) {
    // console.log("getData:"+id)
    var answers = util.getNext();
    var answers_data = answers.data;
    this.setData({
      answers: answers_data,
      answers_data_length: answers_data.length
    });


    var data = {
      userId: app.globalData.userId,
      questionId: id
    }



    var that = this

    wx.request({
      url: app.globalData.domain + 'question/check',
      data: data,
      method: "POST",
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        // console.log(res.data)
        var questionVO = res.data
        var question = questionVO.question


        var isClose = false
        if (question.state == 0) {
          isClose = true
        }

        var message = ""
        // if(questionVO.myQuestion){
        if (question.state == 1) {
          message = "关闭问题"
        } else {
          message = "开启问题"
        }
        // }else{
        //   if(questionVO.focused){
        //     message = "取消关注"
        //   }else{
        //     message = "关注问题"
        //   }
        // }

        that.setData({
          question: question,
          isClose: isClose,
          isMyQuestion: true,
          message: message
        })

      }
    })


    wx.request({
      url: app.globalData.domain + 'answer/question',
      data: data,
      method: "POST",
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        // console.log(res.data)
        var answers = res.data
        var noAnswer = false;
        for (var i = 0; i < answers.length; i++) {
          if (answers[i].hide == 0) {
            break;
          }
        }

        if (i == answers.length) {
          noAnswer = true
        }
        that.setData({
          answers: answers,
          noAnswer: noAnswer
        })

      }
    })

  },
})