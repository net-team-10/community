// pages/discovery/discovery.js
var util = require('../../util/util.js')
var app = getApp()

Page({

    data: {
      problem: "选择 Kindle 而不是纸质书的原因是什么?",
      plain: true,
      answers: [],
      message: "+ 关注"
    },

    onLoad: function (options) {
        var answer_id = options.answer_id
        console.log(options)
    },
   
    bindItemTap: function (e) {
        wx.navigateTo({
          url: '../comment/comment'
    })
    },

  onText:function(e){
    wx.navigateTo({
      url: '../answer/answer'
    })
  },

    getData: function(){
      var answers = util.getNext()
      var answers_data = answers.data
       
    },
  careAnswerer:function(){
    if (this.data.message == "+ 关注") {
      this.setData({
        message: "已关注"
      });
      var that = this
      wx.showToast({
        title: '关注答主成功',
        icon: 'success',
        duration: 2000
      });
    } else if (this.data.message == "已关注") {
      this.setData({
        message: "+ 关注"
      });
      var that = this
      wx.showToast({
        title: '已取消关注',
        icon: 'success',
        duration: 2000
      });
    }
  }
    
})