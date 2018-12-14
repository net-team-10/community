// pages/detail/detail.js
var util = require('../../util/util.js')
var app = getApp()
Page({
  data: {
    problem: "选择 Kindle 而不是纸质书的原因是什么?",
    plain: true,
    answers: []
  },
  onLoad: function(options) {
    // 页面初始化 options为页面跳转所带来的参数
    var id = options.qid;
    var that = this
    //调用应用实例的方法获取全局数据
    this.getData();
  }, 
  //事件处理函数
  bindItemTap: function(e) {
    var answer_id = e.currentTarget.id;
    app.requestDetailed = answer_id;
    console.log(answer_id);
    wx.navigateTo({
      //跳转至回答详情界面
      url: '../discovery/discovery'
    })
  },

  onText:function(e){
    var answer_id = e.currentTarget.id;
    app.requestDetailed = answer_id;
    console.log(answer_id);
    wx.navigateTo({
      //跳转至回答详情界面
      url: '../answer/answer'
    })
  },

  //关注问题按钮的点击插入数据库
  careProblem:function(){

  },
  //使用本地 fake 数据实现刷新效果
  getData: function () {
    var answers = util.getNext();
    console.log("loaddata");
    var answers_data = answers.data;
    this.setData({
      answers: answers_data,
      answers_data_length: answers_data.length
    });
  },
})