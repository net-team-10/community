// pages/notify/notify.js
var util = require('../../util/util.js')
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */

  data: {
    questions: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

    //调用应用实例的方法获取全局数据

  },

  bindItemTap: function(options) {
    wx.navigateTo({
      url: '../comment/comment',
    })
  },

  //使用本地 fake 数据实现刷新效果
  getData: function() {
    var questions = util.getData3();
    console.log("loaddata");
    var questions_data = questions.data;
    this.setData({
      questions: questions_data,
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {
    this.getData();
    this.onLoad()
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})