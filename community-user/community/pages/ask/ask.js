var util = require('../../util/util.js')
var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {

    focus: false,
    texts: "",
    content_len_min: 10, //最少字数
    content_len_max: 300, //最多字数
    content: "",
    title: "",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

  },

  onTap: function(e) {
    var title = this.data.title;
    var content = this.data.content;
    var date = new Date();

    console.log("title:" + (title.length > 0));
    console.log("content:" + (content.length > 0));



    if (title.length == 0) {
      this.setData({
        texts: "标题不能为空哦^_^"
      })
    } else if (content.length < 10) {
      this.setData({
        texts: "问题描述不能少于10个字哦^_^"
      })
    } else {
      wx.switchTab({
        url: '../questions/questions'
      })
    }

    // wx.request({
    //     url: 'http://localhost:9090/user/submit',
    //     data:{
    //         nickname:,
    //         title:title,
    //         content:content,
    //         time:date,
    //         state:1

    //     },
    //     method: "POST",
    //     header:{
    //         'content-type':'application/json'
    //     },
    //     success(res){
    //         console.log(res.data)
    //     }
    // })

    // console.log("tap")



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
  title_inputs: function(e) {
    this.setData({
      title: e.detail.value
    });
  },


  //字数限制  
  content_inputs: function(e) {
    // 获取输入框的内容
    var value = e.detail.value;
    // 获取输入框内容的长度
    var len = parseInt(value.length);

    //最少字数限制
    if (len <= this.data.content_len_min)
      this.setData({
        texts: "问题描述不能少于10个字哦^_^"
      })
    else if (len > this.data.content_len_min) {
      this.setData({
        texts: " "
      })

    }

    //最多字数限制
    if (len > this.data.content_len_max) return;
    // 当输入框内容的长度大于最大长度限制（max)时，终止setData()的执行
    this.setData({
      currentWordNumber: len //当前字数  
    });


    this.setData({
      content: e.detail.value
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