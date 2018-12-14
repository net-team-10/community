// pages/discovery/discovery.js
var util = require('../../util/util.js')
var app = getApp()

Page({

    data: {
      problem: "选择 Kindle 而不是纸质书的原因是什么?",
      plain: true,
      answers: []
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
       
    }
    
})