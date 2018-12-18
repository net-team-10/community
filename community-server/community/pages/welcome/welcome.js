
var util = require('../../util/util.js')
const app = getApp()

Page({
  data: {
    motto: '欢迎来到社区',
    userInfo: {},
    hasUserInfo: false,
    canIUse: wx.canIUse('button.open-type.getUserInfo')
  },
  onLoad: function() {
    if (app.globalData.userInfo) {
      this.setData({
        userInfo: app.globalData.userInfo,
        hasUserInfo: true
      })
    } else if (this.data.canIUse) {
      // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
      // 所以此处加入 callback 以防止这种情况
      app.userInfoReadyCallback = res => {
        this.setData({
          userInfo: res.userInfo,
          hasUserInfo: true
        })
      }
    } else {
      // 在没有 open-type=getUserInfo 版本的兼容处理
      wx.getUserInfo({
        success: res => {
          app.globalData.userInfo = res.userInfo
          this.setData({
            userInfo: res.userInfo,
            hasUserInfo: true
          })
        }
      })
    }
  },
  getUserInfo: function(e) {
    // console.log(e)
    var info = e.detail.userInfo
    if (info){
      app.globalData.userInfo = info
      this.setData({
        userInfo: info,
        hasUserInfo: true
      })
    }
    
  },
  onTap: function(e) {
    // console.log(this.data.userInfo)
    var userInfo = this.data.userInfo
    
    var url = app.globalData.domain+"admin/add"
    var data = {
      nickName:userInfo.nickName,
      avatarUrl:userInfo.avatarUrl
    }

    var that = this

    wx.request({
      url: url,
      data: data,
      method: "POST",
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        var user = res.data
        app.globalData.userInfo = user
        app.globalData.userId = user.id
        that.setData({
          userInfo: user
        })
      }
    })

    wx.switchTab({
      url: '../questions/questions',
    })

  }
})