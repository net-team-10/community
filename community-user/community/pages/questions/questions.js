// pages/questions/questions.js
//questions.js

var util = require('../../util/util.js')
var app = getApp()
Page({
  data: {
    feed: [],
    feed_length: 0
  },
  //事件处理函数
  bindItemTap: function (e) {
    var qid=e.currentTarget.id;
    app.requestDetailed=qid;
    console.log(qid);
    wx.navigateTo({
      url: '../detail/detail'
    })
  },

  onTap:function(e){
    var qid = e.currentTarget.id;
    app.requestDetailed = qid;
    console.log(qid);
    wx.navigateTo({
      url: '../ask/ask'
    })
  },

  onLoad: function () {
    console.log('onLoad')
    var that = this
    //调用应用实例的方法获取全局数据
    this.getData();
  },
  //使用本地 fake 数据实现刷新效果
  getData: function () {
    var feed = util.getData2();
    console.log("loaddata");
    var feed_data = feed.data;
    this.setData({
      feed: feed_data,
      feed_length: feed_data.length
    });
  },

})
