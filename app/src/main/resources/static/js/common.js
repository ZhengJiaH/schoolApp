var webRootPath = ""; var wxAppId = "";
var LOADINGSTATUS = 0;
function request(params, isAsync ,callback) {//封装与后台交互的方法，即将前台数据传到后台
  var _url = params._url,
      _type = "POST",
      _noLoading = false;
  if(params._url){
    //delete params._url;
  }
  if(params.url) {
	  params._url = params.url;
	  delete params.url;
  }
  if(params._type){
    _type = params._type;
    delete params._type;
  }
  if(params._noLoading){
    _noLoading = params._noLoading;
    delete params._noLoading;
  }
  $.ajax({
    contentType: "application/json;charset=UTF-8",
    type: _type,
    url: _url,
    dataType: "json",
    data: JSON.stringify(params),
    async: isAsync,
    beforeSend: function() {
      if (isAsync && !_noLoading) {
        LOADINGSTATUS++;
        //$('#loadingWrapperBase').show();
      }
    },
    success: callback,
    error: function() {
      pageNoteError("服务器连接错误！");
    },
    complete: function() {
      if (isAsync && !_noLoading) {
        --LOADINGSTATUS;
        if (LOADINGSTATUS == 0) {
          //$('#loadingWrapperBase').fadeOut('slow');
        }
      }
    }
  });
}
function showLoading() {
  $("#loadingWrapper").show()
}
function hideLoading() {
  $("#loadingWrapper").hide()
}
function showShare() {
  $("#shareWrapper").show()
}
function hideShare() {
  $("#shareWrapper").fadeOut("slow")
}(function($) {
  $.fn.serializeJson = function() {
    var serializeObj = {};
    var array = this.serializeArray();
    var str = this.serialize();
    $(array).each(function() {
      if (serializeObj[this.name]) {
        if ($.isArray(serializeObj[this.name])) {
          serializeObj[this.name].push(this.value)
        } else {
          serializeObj[this.name] = [serializeObj[this.name], this.value]
        }
      } else {
        serializeObj[this.name] = this.value
      }
    });
    return serializeObj
  }
})(jQuery);

function requestCallBack(data, param) {
  if (param) {
    switch (data.status) {
    case "200":
      if (param.success) {
        param.success(data);
        break
      }
    case "412":
      if (param.warning) {
        param.warning(data);
        break
      }
    default:
      if (param.error) {
        param.error(data)
      }
    }
  }
}
function valueIsEmpty(val) {
  return (val === null || val === "" || typeof val == "undefined")
}
function ifNull(val, replace) {
  var returnStr = "";
  if (replace) {
    returnStr = replace
  }
  return (val === null || val === "") ? returnStr : val
}
function strToTime(time) {
  if (time === null || time === "") {
    return ""
  } else {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second
  }
}
function strToDate(time) {
  if (time === null || time === "") {
    return ""
  } else {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    return year + "-" + month + "-" + date;
  }
}
function getDate(str, splitStr) {
  if (valueIsEmpty(str)) {
    return ""
  }
  splitStr = splitStr ? splitStr : " ";
  return str.split(splitStr)[0]
}
function getUrlParam(name, default_) {
  default_ = (default_ == null) ? "" : default_;
  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
  var r = window.location.search.substr(1).match(reg);
  if (r != null) {
    return decodeURI(r[2])
  }
  return default_
}
function pageNote(config) {
// new PNotify({
//   title: config.title || "错误！",
//   text: config.text || "",
//   type: config.type || "error",
//   addclass: "stack-bar-bottom",
//   stack: {
//     dir1: "up",
//     dir2: "right",
//     spacing1: 0,
//     spacing2: 0
//   },
//   width: "70%",
//   delay: 3000
// })
}
function pageNoteError(message, title) {
  var _title = "发生错误！";
  if (title) {
    _title = title
  }
  pageNote({
    title: _title,
    text: message,
    type: "error"
  })
}
function pageNoteWarning(message, title) {
  var _title = "警告！";
  if (title) {
    _title = title
  }
  pageNote({
    title: _title,
    text: message,
    type: "warning"
  })
}
function pageNoteSuccess(message, title) {
  var _title = "温馨提示！";
  if (title) {
    _title = title
  }
  pageNote({
    title: _title,
    text: message,
    type: "success"
  })
}
function validateForm(selector, callback, errPlaceCallback) {
  var $validator = $(selector).validate({
    debug: true,
    ignore: "",
    submitHandler: function(form) {
      if (callback) {
        callback(form)
      }
      return false
    },
    highlight: function(element) {
      $(element).closest(".form-group").removeClass("has-success").addClass("has-error")
    },
    success: function(element) {
      $(element).closest(".form-group").removeClass("has-error");
      $(element).remove()
    },
    errorPlacement: function(error, element) {
      if (errPlaceCallback) {
        errPlaceCallback(error, element)
      } else {
        element.parent().append(error)
      }
    }
  });
  return $validator
}
Date.prototype.format = function(fmt) {
  var o = {
    "M+": this.getMonth() + 1,
    "d+": this.getDate(),
    "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12,
    "H+": this.getHours(),
    "m+": this.getMinutes(),
    "s+": this.getSeconds(),
    "q+": Math.floor((this.getMonth() + 3) / 3),
    S: this.getMilliseconds()
  };
  var week = {
    "0": "\u65e5",
    "1": "\u4e00",
    "2": "\u4e8c",
    "3": "\u4e09",
    "4": "\u56db",
    "5": "\u4e94",
    "6": "\u516d"
  };
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length))
  }
  if (/(E+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f" : "\u5468") : "") + week[this.getDay() + ""])
  }
  for (var k in o) {
    if (new RegExp("(" + k + ")").test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)))
    }
  }
  return fmt
};

/*function wxShare(config) {
  wx.config({
    debug: false,
    appId: config.appId,
    timestamp: config.timestamp,
    nonceStr: config.nonceStr,
    signature: config.signature,
    jsApiList: ["onMenuShareTimeline", "onMenuShareAppMessage", "onMenuShareQQ", "onMenuShareWeibo"]
  });
  wx.error(function(res) {
    console.log(res)
  });
  wx.ready(function() {
    wx.onMenuShareTimeline({
      title: config.desc,
      link: config.link,
      imgUrl: config.imgUrl,
      success: config.success,
      cancel: config.cancel
    });
    wx.onMenuShareAppMessage({
      title: config.title,
      desc: config.desc,
      link: config.link,
      imgUrl: config.imgUrl,
      type: (config.type || "link"),
      dataUrl: (config.dataUrl || ""),
      success: config.success,
      cancel: config.cancel
    });
    wx.onMenuShareQQ({
      title: config.title,
      desc: config.desc,
      link: config.link,
      imgUrl: config.imgUrl,
      success: config.success,
      cancel: config.cancel
    });
    wx.onMenuShareWeibo({
      title: config.title,
      desc: config.desc,
      link: config.link,
      imgUrl: config.imgUrl,
      success: config.success,
      cancel: config.cancel
    })
  })
}*/