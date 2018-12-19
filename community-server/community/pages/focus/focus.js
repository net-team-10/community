// pages/focus/focus.js
var util = require('../../util/util.js')
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    navTab: ["问题", "答主"],
    currentNavtab: "0",
    focusedQuestions:[],
    focusedUserAnswers:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function() {
    this.getData();
  },
  switchTab: function(e) {
    this.setData({
      currentNavtab: e.currentTarget.dataset.idx
    });
  },

  onShow: function() {
    this.onLoad()
  },


  onUnload: function() {

  },

  bindQuestionItemTap(e) {
    var questionId = e.currentTarget.id
    wx.navigateTo({
      url: '../detail/detail?id='+questionId,
    })
  },
  bindAnswerItemTap(e) {
    var answerId = e.currentTarget.id
    wx.navigateTo({
      url: '../comment/comment?answerId='+answerId,
    })
  },

  getData: function() {

    var that = this
    var url = app.globalData.domain + "question/focused"
    var data = {
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
        var questions = res.data
        that.setData({
          focusedQuestions:questions
        })
      }
    })

    url = app.globalData.domain + "answer/user/focused"
    wx.request({
      url: url,
      data: data,
      method: "POST",
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        var answers = res.data
        that.setData({
          focusedUserAnswers:answers
        })
      }

    })

  }
})