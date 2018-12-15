// pages/comment/comment.js
// pages/discovery/discovery.js
var util = require('../../util/util.js')
var app = getApp()

Page({

  data: {
    problem: "选择 Kindle 而不是纸质书的原因是什么?",
    plain: true,
    answer: {},
    comments: [],
    message: "关注答主",
    userInfo: {},
    comment: ""
  },

  onLoad: function(options) {
    this.getData();
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
      console.log(comment)
      var date = new Date()
      var dateString = util.formatDate(date)
      console.log(dateString)
      // wx.request({
      //     url: 'http://localhost:9090/user/add',
      //     data:{

      //     },
      //     method: "POST",
      //     header:{
      //         'content-type':'application/json'
      //     },
      //     success(res){
      //         console.log(res.data)
      //     }
      // })
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

  getData: function() {
    var answers = util.getNext()
    var answers_data = answers.data
    var comments = util.getNext()
    var comments_data = comments.data

    this.setData({
      answer: answers_data[0],
      comments: comments_data
    })

  },
  careAnswerer: function() {
    if (this.data.message == "关注答主") {
      this.setData({
        message: "取消关注"
      });
      var that = this
      wx.showToast({
        title: '关注答主成功',
        icon: 'success',
        duration: 1000
      });
    } else if (this.data.message == "取消关注") {
      this.setData({
        message: "关注答主"
      });
      var that = this
      wx.showToast({
        title: '已取消关注',
        icon: 'success',
        duration: 1000
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