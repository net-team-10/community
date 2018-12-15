var index = require('../data/data_question.js')
var index_next = require('../data/data_question_next.js')
var focus = require('../data/focus_person.js')

function getData(url) {
  return new Promise(function(resolve, reject) {
    wx.request({
      url: url,
      data: {},
      header: {},
      success: function(res) {
        console.log("success")
        resolve(res)
      },
      fail: function(res) {
        reject(res)
        console.log("failed")
      }
    })
  })
}

function getData3() {
  return focus.focus;
}

function getData2() {
  return index.index;
}

function getNext() {
  return index_next.next;
}


function complete(str, len) {
  str = str.toString()
  while (str.length < len) {
    str = '0' + str
  }
  return str
}

function formatDate(date) {
  var year = date.getFullYear()
  var month = date.getMonth() + 1
  var day = date.getDate()

  var hour = date.getHours()
  var minute = date.getMinutes()

  month = complete(month, 2)
  day = complete(day, 2)
  hour = complete(hour, 2)
  minute = complete(minute, 2)

  return [year, month, day].join('-') + ' ' + [hour, minute].join(':')

}



module.exports.getData3 = getData3;
module.exports.getData = getData;
module.exports.getData2 = getData2;
module.exports.getNext = getNext;
module.exports.formatDate = formatDate;