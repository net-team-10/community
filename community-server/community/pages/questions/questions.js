// pages/questions/questions.js
//questions.js

var util = require('../../util/util.js')
var app = getApp()
Page({
  data: {
    feed: [],
    questions: [],
  },
  //事件处理函数
  bindItemTap: function (e) {
    var qid = e.currentTarget.id;
    var url = '../detail/detail?id=' + qid
    wx.navigateTo({
      url: url
    })
  },

  onTap: function (e) {
    wx.navigateTo({
      url: '../ask/ask'
    })
  },

  onLoad: function () {
    // console.log('userid:'+app.globalData.userId)
    //调用应用实例的方法获取全局数据
    this.getData();

  },

  getData: function () {

    var url = app.globalData.domain + "question/all"

    var that = this

    wx.request({
      url: url,
      method: "GET",
      header: {
        'content-type': 'application/json'
      },
      success(res) {

        that.setData({
          questions: res.data
        })
      }
    })
  },
  onShow: function () {
    this.onLoad()
  },
  deleteQuestion: function (e) {
    var qid = e.currentTarget.id;

    var that = this
    wx.showModal({
      title: '提示',
      content: '确定删除该问题吗？',
      success: function (sm) {
        var t = that
        if (sm.confirm) {
          // 用户点击了确定 可以调用删除方法了
          // console.log(qid)
          // var toastText = "删除成功！";
          wx.request({
            url: app.globalData.domain + "question/del",
            data: { "questionId": qid },
            method: 'POST',
            header: {
              'content-type': 'application/json'
            },
            success: function (res) {
              t.onLoad()
            }
          })
        }
      }
    })
  },

})