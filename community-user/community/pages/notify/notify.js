// pages/notify/notify.js
var util = require('../../util/util.js')
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */

  data: {
    comments: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

    //调用应用实例的方法获取全局数据
    this.getData();
  },

  bindItemTap: function(e) {
    var answerId = e.currentTarget.id
    wx.navigateTo({
      url: '../comment/comment?answerId='+answerId,
    })
  },

  //使用本地 fake 数据实现刷新效果
  getData: function() {

    var that = this
    var url = app.globalData.domain+"comment/user"
    var data={
      userId:app.globalData.userId
    }
    wx.request({
      url: url,
      data:data,
      method: "POST",
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        var comments = res.data
        that.setData({
          comments:comments
        })
      }

    })
    

    
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    this.onLoad()
  }

  
})