const app = getApp()

Page({
    data: {
        motto: '欢迎来到社区',
        userInfo: {},
        hasUserInfo: false,
        canIUse: wx.canIUse('button.open-type.getUserInfo')
    },
    onLoad: function () {
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
    getUserInfo: function (e) {
        console.log(e)
        app.globalData.userInfo = e.detail.userInfo
        this.setData({
            userInfo: e.detail.userInfo,
            hasUserInfo: true
        })
    },
    onTap:function(e){
        console.log(this.data.userInfo)
        // wx.request({
        //     url: 'http://localhost:9090/user/add',
        //     data:{
        //         nickName:this.data.userInfo.nickName,
        //         avatarUrl:this.data.userInfo.avatarUrl,
        //         gender:this.data.userInfo.gender
        //     },
        //     method: "POST",
        //     header:{
        //         'content-type':'application/json'
        //     },
        //     success(res){
        //         console.log(res.data)
        //     }
        // })
        wx.switchTab({
            url: '../questions/questions',
        })

    }
})