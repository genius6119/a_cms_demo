
var isTest=2//是否测试

var baseUrl = "http://api.51mixie.com:8080/supplier/";//正式
// baseUrl = "http://api.51mixie.com:8080/mixie/";
//登录URL
var loginUrl = "http://api.51mixie.com:8080/mixie/";

//var cdnUrl = "http://op41a8tok.bkt.clouddn.com/";  //成本报价URL地址
//var cdnUrl = "http://og4g6cx0k.bkt.clouddn.com/";  //觅鞋测试地址
var cdnUrl = "http://olnrpmstq.bkt.clouddn.com/"; //觅鞋正式

if(isTest==1){

	baseUrl = "http://106.14.254.109:8081/supplier/";
	loginUrl = "http://106.14.254.109:8081/mixie/"; 
	cdnUrl = "http://op41a8tok.bkt.clouddn.com/";  
}else if(isTest==2){

	baseUrl = "http://localhost:8080/supplier/";
	loginUrl = "http://106.14.254.109:8081/mixie/"; 
	cdnUrl = "http://op41a8tok.bkt.clouddn.com/";  
}


function alertSuccess(info) {
	parent.toastr.options = {
		"timeOut": "1000",
		"positionClass": "toast-top-center"
	}

	if(info == undefined) info = '操作成功';
	parent.toastr.success(info);
}

function alertError(info) {
	parent.toastr.options = {
		"timeOut": "1000",
		"positionClass": "toast-top-center"
	}

	if(info == undefined) info = '操作失败';
	parent.toastr.error(info);
}

function alertInfo(info) {
	parent.toastr.options = {
		"timeOut": "1000",
		"positionClass": "toast-top-center"
	}

	if(info == undefined) info = '提示';
	parent.toastr.info(info);
}

function alertWarning(info) {
	parent.toastr.options = {
		"timeOut": "1000",
		"positionClass": "toast-top-center"
	}

	if(info == undefined) info = '警告';
	parent.toastr.warning(info);
}

//获取url中的参数
function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if(r != null) return unescape(r[2]);
	return null; //返回参数值
}

var _focus_itemname = null;

function checkform(form) {
	var $input = form.find(".notnull[type!='radio'][type!='checkbox']");
	var flag = true;
	$input.each(function(i) {
		var VAL = "NOTNULL";

		//var t = $(this).closest(":hidden")
		var t = "";
		if(t.length == 0) {
			if(this.tagName == "SELECT" || this.tagName == "TEXTAREA" || this.tagName == "INPUT") {
				VAL = $(this).val();
			} else if(this.tagName == "SPAN") {
				VAL = $(this).find("input[name='" + this.id + "'][checked]").val();
			}
			if(VAL == "") {
				//alert(this.id + "__" + this.currentStyle.display)
				//				showalert('警告', '〖' + $.trim(form.find('label[for="' + this.id + '"]').text()) + '〗 不允许为空！', 'warning', function() {
				//					$("#" + _focus_itemname).focus();
				//				});
				//alert('〖' + $.trim(form.find('label[for="' + this.id + '"]').text()) + '〗 不允许为空！');
				toastr.warning('〖' + $.trim(form.find('label[for="' + this.id + '"]').text()) + '〗 不允许为空！');
				
				$("#" + _focus_itemname).focus();
				_focus_itemname = this.id;
				flag = false;
				return false;
			}
		}

	});

	$input = form.find(".number[type!='radio'][type!='checkbox']"); //判断是否为数字

	$input.each(function(i) {
		var VAL = "1";
		if(this.tagName != "SELECT") {
			//var t = $(this).closest(":hidden")
			var t = "";
			//alert(t.length)
			if(t.length == 0) {
				if(this.tagName == "TEXTAREA" || this.tagName == "INPUT") {
					if($.trim(this.value) != "")
						VAL = $.trim(this.value);
				}
				//                else if (this.tagName == "SPAN") {
				//                    VAL = $(this).find("input[name='" + this.id + "'][checked]").val();
				//                }
				if(!IsNumber(VAL)) {
					//alert(this.id + "__" + this.currentStyle.display)
					//					showalert('警告', '〖' + $.trim(form.find('label[for="' + this.id + '"]').text()) + '〗 只能是数字(且不能有小数点)！', 'warning', function() {
					//						$("#" + _focus_itemname).focus();
					//					});
					//alert("只能是数字");
					toastr.warning('只能是数字');
					_focus_itemname = this.id;
					flag = false;
					return false;
				}
			}
		}
	});

	$input = form.find(".decimal[type!='radio'][type!='checkbox']"); //判断是否为数字

	$input.each(function(i) {
		var VAL = "1";
		if(this.tagName != "SELECT") {
			//var t = $(this).closest(":hidden")
			var t = "";
			if(t.length == 0) {
				if(this.tagName == "TEXTAREA" || this.tagName == "INPUT") {
					if($.trim(this.value) != "")
						VAL = $.trim(this.value);
				}
				//                else if (this.tagName == "SPAN") {
				//                    VAL = $(this).find("input[name='" + this.id + "'][checked]").val();
				//                }
				if(!IsDecimal(VAL)) {
					//alert(this.id + "__" + this.currentStyle.display)
					//					showalert('警告', '〖' + $.trim(form.find('label[for="' + this.id + '"]').text()) + '〗 只能是数字(可以带小数点)！', 'warning', function() {
					//						$("#" + _focus_itemname).focus();
					//					});
					//alert("只能是数字,可以带小数");
					toastr.warning('只能是数字,可以带小数');
					_focus_itemname = this.id;
					flag = false;
					return false;
				}
			}
		}
	});
	
	
	$input = form.find(".plus-decimal[type!='radio'][type!='checkbox']"); //判断是否为正的数字
	$input.each(function(i) {
		var VAL = "1";
		if(this.tagName != "SELECT") {

				if(this.tagName == "TEXTAREA" || this.tagName == "INPUT") {
					if($.trim(this.value) != "")
						VAL = $.trim(this.value);
				}

				if(!isPlusDecimal(VAL)) {

					toastr.warning('只能是正的数字,可以带小数');
					_focus_itemname = this.id;
					flag = false;
					return false;
				}
		
		}
	});

	$input = form.find(".money[type!='radio'][type!='checkbox']"); //判断是否为金额数字
	$input.each(function(i) {
		var VAL = "1";
		if(this.tagName != "SELECT") {
			var t = "";
			if(t.length == 0) {
				if(this.tagName == "TEXTAREA" || this.tagName == "INPUT") {
					if($.trim(this.value) != "")
						VAL = $.trim(this.value);
				}
				if(!isMoney(VAL)) {
					
					toastr.warning('只能是金额数字');
					//alert("只能是金额数字");
					
					_focus_itemname = this.id;
					$("#" + _focus_itemname).focus();
					flag = false;
					return false;
				}
			}
		}
	});

	return flag;
}

function IsDecimal(s) {
	var reg = new RegExp(/^-?\d*\.?\d*$/);
	if(reg.test(s))
		return true;
	else
		return false;
}

function isPlusDecimal(s) {
	var reg = new RegExp(/^\d*\.?\d*$/);
	if(reg.test(s))
		return true;
	else
		return false;
}


function isMoney(s) {
	var regu = "^[0-9]+[\.][0-9]{0,3}$";
	var re = new RegExp(/^\d*\.?\d{0,4}$/);
	if(re.test(s)) {
		return true;
	} else {
		return false;
	}
}

function IsNumber(s) { //适于校验非负整数
	var reg = /^[01233456789]{1,}$/;
	if(reg.test(s))
		return true;
	else
		return false;
}

var formatDate = function(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	m = m < 10 ? '0' + m : m;
	var d = date.getDate();
	d = d < 10 ? ('0' + d) : d;
	return y + '-' + m + '-' + d;
};

var formatDateTime = function(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	m = m < 10 ? '0' + m : m;
	var d = date.getDate();
	d = d < 10 ? ('0' + d) : d;

	var h = date.getHours();
	h = h < 10 ? ('0' + h) : h;
	var mi = date.getMinutes();
	mi = mi < 10 ? ('0' + mi) : mi;
	return y + '-' + m + '-' + d + ' ' + h + ':' + mi;
};

function getDate(date1) {
	var date = new Date(date1);
	return formatDate(date);
}

function getDateTime(date1) {
	var date = new Date(date1);
	return formatDateTime(date);
}

//写cookies函数
function setCookie(name, value) //两个参数，一个是cookie的名子，一个是值
{
	var minute = 10; //此 cookie 将被保存 10 分钟
	var exp = new Date(); //new Date("December 31, 9998");
	exp.setTime(exp.getTime() + minute * 60 * 1000);
	document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString();
}

function getCookie(name) //取cookies函数       
{
	var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
	if(arr != null) return unescape(arr[2]);
	return null;

}

function delCookie(name) //删除cookie
{
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if(cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}

//取URL中参数值
function getUrlParmsByKey(key) {
	var args = new Object();
	var qry = document.location.search.substring(1); //获取查询串   
	var pairs = qry.split("&"); //在逗号处断开   
	for(var i = 0; i < pairs.length; i++) {
		var pos = pairs[i].indexOf('='); //查找name=val   
		if(pos == -1) continue; //如果没有找到就跳过   
		var argname = pairs[i].substring(0, pos); //提取name   
		var val = pairs[i].substring(pos + 1); //提取val   
		args[argname] = unescape(val); //存为属性(解码) 
	}
	return args[key];

}

function getToken() {

	return localStorage.token;
}

function getUserCode() {
	//return '2a9fe630-d505-409f-9f39-232373c54d98';
	return localStorage.userCode
}

function getNickName() {
	return localStorage.nickName;
}

function getUserName() {
	return localStorage.userName;
}

function getRealName() {
	return localStorage.realName;
}

function getUserRole(){
	return localStorage.getItem("userRole");
}

function getEnterpriseCode(){
	return localStorage.getItem("enterpriseCode");
}
function getEnterpriseName(){
	return localStorage.getItem("enterpriseName");
}

//function isLogined() {
//
//	if(getToken() == undefined || getToken() == null || getToken() == "" || getToken() == "null") {
//
//		return false;
//	}
//	return true;
//}

function isLogined() {

	if(getUserCode() == undefined || getUserCode() == null || getUserCode() == "" || getUserCode() == "null") {

		return false;
	}
	return true;
}


function checkLogined() {
	if(!isLogined()) {
		window.location.href = "../login.html";

	}
}

function logout() {

//	localStorage.removeItem("token");
//	localStorage.removeItem("userCode");
//	localStorage.removeItem("nickName");
//	localStorage.removeItem("mobile");	
	localStorage.clear();	
	window.location.href = "./login.html";
}

//1、存储：localStorage.setItem(key,value)
//如果key存在时，更新value
//
//2、获取：localStorage.getItem(key)
//如果key不存在返回null
//
//3、删除：localStorage.removeItem(key)
//一旦删除，key对应的数据将会全部删除
//
//4、全部清除：localStorage.clear()

function ajaxDo(url, data, type, a_contentType, CallBackFunc) {

	var contentType = "application/x-www-form-urlencoded";
	if(a_contentType == "json") {
		contentType = "application/json";
	}

	$.ajax({
		url: url,
		data: data,
		type: type,
		contentType: contentType,
		dataType: 'json',
		//beforeSend: function(request) {
		//    request.setRequestHeader("token22","1ff");
		//},
		//headers: {
		//	'token': getToken(),
		//	'userCode': getUserCode()
		//},
		success: function(result) {
			//20004 token超时 20005 抢登
			if(result.code == 20004 || result.code == 20005) {
				//alert(result.msg);
				setTimeout(function() {
					window.parent.location.href = "../login.html";
				}, 2000);
			} else {
				CallBackFunc(result);
			}
		},
		error: function(er) {
			//console.debug(JSON.stringify(er))
			//if(er.code == 50003) alert(er.msg);
			//else alert('请求失败，发送未知错误');
			//			alert(er);
		}
	});
}

//文件上传
function ajaxFileDo(formid, url, CallBackFunc) {

	$('#' + formid).ajaxSubmit({

		type: "POST", //提交类型
		dataType: "json", //返回结果格式
		url: url, //请求地址
		data: {}, //请求数据
//		headers: {
//			'token': getToken(),
//			'userCode': getUserCode()
//		},
		success: CallBackFunc,
		error: function(data) {
			alert(data); //请求失败的函数
		},
		async: true
	});
}

//取文件名不带后缀
function getFileNameNoExt(filepath) {
	var pos = strturn(GetFileExt(filepath));
	var file = strturn(filepath);
	var pos1 = strturn(file.replace(pos, ""));
	var pos2 = GetFileName(pos1);
	return pos2;

}
//取文件全名名称
function getFileName(filepath) {
	if(filepath != "") {
		var names = filepath.split("\\");
		return names[names.length - 1];
	}
}
function checkImg(file) {

	var filename = $("#" + file).val();
	var array = new Array('gif', 'jpeg', 'png', 'jpg'); //可以上传的文件类型 
	if(filename == '') {
		alert("让选择要上传的图片!");
		return false;
	} else {
		var fileContentType = filename.match(/^(.*)(\.)(.{1,8})$/)[3]; //这个文件类型正则很有用：） 
		var isExists = false;
		for(var i in array) {
			if(fileContentType.toLowerCase() == array[i].toLowerCase()) {
				isExists = true;
				return true;
			}
		}
		if(isExists == false) {
			return false;
		}
		return false;
	}
}


function strToCent(str) {
	if(str==""){
		return 0;
	}
	else{
		return parseCent(parseFloat(str));
	}
	
}

function parseCent(value) {
	return parseInt(value * 100) ;
}

function parseYuan(value) {
	return value / 100;
}

function strToDimi(str) {
	if(str==""){
		return 0;
	}
	else{
		return parseDimi(parseFloat(str));
	}
	
}

function parseDimi(value) {
	return parseInt(value * 10000) ;
}

//豪 万分之一员   转 元
function parseDimiToYuan(value) {
	return value / 10000;
}


//日期转时间戳
function stringToDate(stringTime) {
	var timestamp2 = Date.parse(new Date(stringTime));
	timestamp2 = timestamp2 / 1000;
	alert(timestamp2);
	return timestamp2;
}
//根据时间戳获取日期
function getLocalTime(nS) {
	return new Date(parseInt(nS)).toLocaleString().replace(/:\d{1,2}$/, ' ');
}

var formatDate = function(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	m = m < 10 ? '0' + m : m;
	var d = date.getDate();
	d = d < 10 ? ('0' + d) : d;
	return y + '-' + m + '-' + d;
};

function getDate(date1) {
	var date = new Date(date1);
	return formatDate(date);
}

function redirect(url) {
	location.href = url;
}
//延时跳转页面
function delayRedirect(url) {
	setTimeout(function() {
		redirect(url);
	}, 1000);
}

//分页方法
function showPage(totalCount, curPage, pageSize, newPageDiv) {
	var _LENGTH = 5; //最多显示页吗数5
	var pageArr = []; //
	var pageCount = 1;

	if(pageSize == undefined) {
		pageSize = 10;
	}

	//整页
	if(totalCount % pageSize == 0) {
		pageCount = totalCount / pageSize;
	} else { //非整页
		pageCount = (totalCount - totalCount % pageSize) / pageSize + 1;
	}

	//总页数小于5页
	if(pageCount <= _LENGTH) {
		for(var i = 0; i < pageCount; i++) {
			pageArr[i] = i + 1;
		}

	} else { //总页数大于5页
		if(curPage + 2 <= pageCount && curPage - 2 > 0) { //当前页没有超过总页数
			for(var i = 0; i < _LENGTH; i++) {
				pageArr[i] = curPage - 2 + i;
			}
		} else if(curPage <= 2) {
			pageArr = [1, 2, 3, 4, 5];
		} else {
			for(var i = 0; i < _LENGTH; i++) {
				pageArr[i] = pageCount - 4 + i;
			}
		}
	}
	//绘制页面
	drawPage(pageArr, curPage, pageCount, totalCount, newPageDiv);
}

//绘制分页dom方法
function drawPage(pageArr, curPage, pageCount, totalCount, newPageDiv) {
	var _html = "";
	if(curPage > 1) {
		_html += "<a href='javascript:void(0);' title='上一页' onclick=\"pageTurn(" + (curPage - 1) + ")\"><<</a>";
	}
	for(var i = 0; i < pageArr.length; i++) {
		if(pageArr[i] == curPage) {
			_html += "<a href='javascript:void(0);' style='background:#CCC'>" + pageArr[i] + "</a>";
		} else {
			_html += "<a href='javascript:void(0);' onclick=\"pageTurn(" + pageArr[i] + ")\">" + pageArr[i] + "</a>";
		}

	}
	if(curPage < pageCount) {
		_html += "<a href='javascript:void(0);' title='下一页' onclick=\"pageTurn(" + (curPage + 1) + ")\">>></a>";
	}
	_html += "<span class='rows'>共 " + totalCount + " 条记录</span>";
	if(newPageDiv != undefined) {
		$("#" + newPageDiv).html(_html);
	} else {
		$(".page").html(_html);
	}

}

			var supplier_category_json = [{
				id: 5,
				name: "加工厂"
			},{
				id: 0,
				name: "鞋底"
			}, {
				id: 1,
				name: "主料"
			}, {
				id: 2,
				name: "辅料"
			}, {
				id: 3,
				name: "固定费"
			}, {
				id: 4,
				name: "非固定费"
			}];
			

// 动态加载js脚本文件
    function loadScript(url) {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = url;
        document.body.appendChild(script);
    }