var index = require('../data/data_question.js')
var index_next = require('../data/data_question_next.js')
var focus = require('../data/focus_person.js')

function getData(url) {
  return new Promise(function (resolve, reject) {
    wx.request({
      url: url,
      data: {},
      header: {
      },
      success: function (res) {
        console.log("success")
        resolve(res)
      },
      fail: function (res) {
        reject(res)
        console.log("failed")
      }
    })
  })
}

function getData3(){
  return focus.focus;
}

function getData2() {
  return index.index;
}

function getNext() {
  return index_next.next;
}
module.exports.getData3 = getData3;
module.exports.getData = getData;
module.exports.getData2 = getData2;
module.exports.getNext = getNext;
