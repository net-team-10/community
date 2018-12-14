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
        feed: []
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        console.log("loaddata");
        var that = this;
        this.getData();
        this.getData2();
    },
    switchTab: function (e) {
        this.setData({
            currentNavtab: e.currentTarget.dataset.idx
        });
    },
  
    onShow: function () {

    },

 
    onUnload: function () {

    },

    bindItemTap: function() {
    wx.navigateTo({
      url: '../me/me'
    })
  },

    getData: function () {
        var focus = util.getData3();
        console.log("loaddata");
        var focus = focus.data;
        this.setData({
          focus: focus,
          focus_data_length: focus.length
    });
  },
    
  //使用本地 fake 数据实现刷新效果
  getData2: function () {
    var feed = util.getData2();
    var feed_data = feed.data;
    this.setData({
      feed: feed_data,
      feed_length: feed_data.length
    });
  },
})