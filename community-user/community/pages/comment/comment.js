var util = require('../../util/util.js')
var app = getApp()

Page({

  data: {
    plain: true,
    userInfo:{},
    question:{},
    answer: {},
    answerer:{},
    comments: [],
    message: "关注答主",
    answerId:"",
    comment: ""
  },

  onLoad: function(options) {
    var userInfo = app.globalData.userInfo
    var answerId = options.answerId
    this.setData({
      answerId: answerId,
      userInfo:userInfo
    })
    this.getData(answerId);
    // console.log(app.globalData.userInfo)
    // this.setData({
    //     userInfo:app.globalData.userInfo
    // })

  },

  bindItemTap: function(e) {
    var comment = this.data.comment
    if (comment.length <= 0) {
      wx.showToast({
        title: '评论不能为空',
        icon: 'none',
        duration: 1000
      })
    } else {
      
      var date = new Date()
      var dateString = util.formatDate(date)
      
      var url = app.globalData.domain + 'comment/submit'
      var data = {
        answerId: this.data.answerId,
        userId: app.globalData.userId,
        content:this.data.comment,
        time: dateString
      }
      var that = this

      wx.request({
        url: url,
        data: data,
        method: "POST",
        header: {
          'content-type': 'application/json'
        },
        success(res) {
          var options={
            answerId: that.data.answerId
          }
          that.onLoad(options)
        }
      })
     
      this.setData({
        comment: ""
      })
    }
  },

  onText: function(e) {
    wx.navigateTo({
      url: '../answer/answer'
    })
  },

  getData: function(answerId) {
    var answers = util.getNext()
    var answers_data = answers.data
    var comments = util.getNext()
    var comments_data = comments.data

    var url = app.globalData.domain + 'answer/get'
    var data = {
      answerId: this.data.answerId,
      userId: app.globalData.userId
    }

    var that = this

    wx.request({
      url: url,
      data: data,
      method: "POST",
      header: {
        'content-type': 'application/json'
      },
      success(res) {
      //   console.log(res.data)
        var answerVO = res.data
        var answer = answerVO.answer
        var answerer = answer.user
        var question = answer.question
        var foc = answerVO.answererFocused
        var message = "";
        if (foc){
          message = "取消关注"
        }else{
          message = "关注答主"
        }
        that.setData({
          answer: answer,
          answerer: answerer,
          question: question,
          message:message
        })
      }
    })

    url = app.globalData.domain + 'comment/answer'

    wx.request({
      url: url,
      data: data,
      method: "POST",
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        that.setData({
          comments: res.data
        })
      }
    })

    

  },
  careAnswerer: function() {
    if (this.data.message == "关注答主") {
      this.setData({
        message: "取消关注"
      });

      var url = app.globalData.domain + 'user/focus'
      var data = {
        userId:app.globalData.userId,
        focusedUserId:this.data.answerer.id
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
        title: '关注答主成功',
        icon: 'success',
        duration: 1000,
        mask:true
      });
    } else if (this.data.message == "取消关注") {
      this.setData({
        message: "关注答主"
      });

      var url = app.globalData.domain + 'user/ignore'
      var data = {
        userId: app.globalData.userId,
        focusedUserId: this.data.answerer.id
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
  commentInput: function(e) {
    var comment = e.detail.value
    this.setData({
      comment: comment
    })
  }

})