// pages/me/me.js
var util = require('../../util/util.js')
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    navTab: ["提问", "回答"],
    currentNavtab: "0",
    questions: [],
    answers: [],
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

  getData: function() {
    var that = this
    var url = app.globalData.domain + "question/user/ask"
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
          questions: questions
        })
      }
    })

    url = app.globalData.domain + "answer/user/submitted"
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
          answers: answers
        })
      }

    })
    
  },

  bindQuestionItemTap(e) {
    var id = e.currentTarget.id
    wx.navigateTo({
      url: '../detail/detail?id='+id,
    })
  },
  bindAnswerItemTap(e) {
    var id = e.currentTarget.id
    wx.navigateTo({
      url: '../comment/comment?answerId='+id,
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    this.onLoad()
  },

 
})