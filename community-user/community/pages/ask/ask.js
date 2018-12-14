var util = require('../../util/util.js')
var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {

    focus: false,
    texts: "",
    min: 10, //最少字数
    max: 300, //最多字数
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  onTap: function(e) {

    var qid = e.currentTarget.id;
    app.requestDetailed = qid;
    console.log(qid);
    wx.switchTab({
      url: '../questions/questions'
    })


  },

  textBlur: function(e) {
    var txt = e.detail.value;
    console.log("bindBlur事件" + txt);
  },

  showToast: function(e) {

    wx.showToast({
      title: "字数不足",
      duration: 1000,
      icon: "false",

    })

  },

  bindFormSubmit(e) {
    var txt = e.detail.value;
    // var len = this.inputs.len;
    // if (len <= this.data.min){
    //   this.showToast();

    // }
    // else{
    //   console.log(e.detail.value.textarea)
    // }

  },

  //字数限制  
  inputs: function(e) {
    // 获取输入框的内容
    var value = e.detail.value;
    // 获取输入框内容的长度
    var len = parseInt(value.length);

    //最少字数限制
    if (len <= this.data.min)
      this.setData({
        texts: "问题不能少于10个字哦"
      })
    else if (len > this.data.min) {
      this.setData({
        texts: " "
      })

    }

    //最多字数限制
    if (len > this.data.max) return;
    // 当输入框内容的长度大于最大长度限制（max)时，终止setData()的执行
    this.setData({
      currentWordNumber: len //当前字数  
    });



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