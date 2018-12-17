var util = require('../../util/util.js')
var app = getApp()

Page({

  /**
   * 页面的初始数据
   */
  data: {
    questionId:"",
    focus: false,
    texts: "",
    answer_content: "",
    anonymous: false,

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var questionId = options.id
    this.setData({
      questionId:questionId
    })
  },

  onTap: function(e) {
  
    var answer_content = this.data.answer_content

    if (answer_content.length < 10) {
      this.setData({
        texts: "回答不能少于10个字哦^_^"
      })
    } else {

      var date = util.formatDate(new Date())
      var anony = this.data.anonymous
      var state = 0
      if(anony){
        state = 1
      }

      var data = {
        userId: app.globalData.userId,
        content: answer_content,
        time: date,
        state: state,
        hide: 0,
        questionId:this.data.questionId
      }

      var url = app.globalData.domain +'answer/submit'
      wx.request({
          url: url,
          data:data,
          method: "POST",
          header:{
              'content-type':'application/json'
          },
          success(res){
          }
      })

      wx.showLoading({
        title: '正在发布',
        mask: true
      })

      var pageUrl = '../detail/detail?id='+this.data.questionId

      setTimeout(function () {
        wx.hideLoading()
        wx.redirectTo({
          url: pageUrl
        })
      }, 1000)
      
    }

  },
  bindFormSubmit(e) {
    var txt = e.detail.value;
    // console.log(e.detail.value.textarea)
  },

  //字数限制  
  inputs: function(e) {
    // 获取输入框的内容
    var value = e.detail.value;
    this.setData({
      answer_content: value
    });
    // 获取输入框内容的长度
    var len = value.length;

    //最少字数限制
    if (len <= this.data.min)
      this.setData({
        texts: "回答不能少于10个字哦"
      })
    else if (len > this.data.min) {
      this.setData({
        texts: " "
      })
    };

    

  },

  change(e) {
    this.setData({
      anonymous:e.detail.value
    })
  }
})