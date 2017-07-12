$(function() {
	/* 
	 * 实现注册按钮的图片切换
	 * */
	$("#submitBtn").hover(
		//鼠标移入
		function() {
			$(this).attr("src", "/goodplus/images/regist2.jpg");
		},
		//鼠标移出
		function() {
			$(this).attr("src", "/goodplus/images/regist1.jpg");
		});
	/*
	 * 核对表单无误 注册
	 * */
	$("#submitBtn").click(function(){
		if(yanzhengloginname()&&yanzhengloginpass()&&yanzhengloginpass()&&yanzhengemail()&&yanzhengverifyCode()){
			return true;
		}else{
			alert("表单填写有错误，请按照要求填写");
			return false;
		}
	})

	/*
	*  隐藏 没有内容的提示信息
	* */
	$(".errorClass").each(function() {
		showError($(this));
	});
	/*
	 * 获取焦点后自动隐藏提示信息
	 * */
	$(".inputClass").focus(function() {
		var id = $(this).attr("id") + "Error";
		// 强制删除 label 中的text
		$("#" + id).text("");
		showError($($("#" + id)));
	});
	/*
	 * 失去焦点后
	 * */
	$(".inputClass").blur(function() {
		var id = $(this).attr("id");
		eval("yanzheng" + id + "()");
	})
});




/*
 * 验证码换一张功能
 * */
function _hyz() {
	$("#imgVerifyCode").attr("src", "/goodplus/getverify?" + new Date());
};
/*
 * showError (element)
 */
function showError(element) {
	value = element.text();
	if (!value) {
		element.css("display", "none")
	} else {
		element.css("display", "")
	}
}

function yanzhengloginname() {
	var flag = false;
	var loginnamevalue = $("#loginname").val();
	// null
	if (!loginnamevalue) {
		$('#loginnameError').text("用户名不能为空！！");
		showError($('#loginnameError'));
		return false;
		
	}
	// lenght
	if (loginnamevalue.length < 2 || loginnamevalue.length > 13) {
		$("#loginnameError").text("用户名长度为2-13之间");
		showError($("#loginnameError"));
		return false;
	}
	// 往后台验证: loginname 是否存在
	$.ajax({
		//数据发给服务器的值
		data : {"loginname": loginnamevalue},
		// 发的是什么类型的值， 收的是什么类型的值
		dataType : "json",
		// 是否缓存
		cache : false,
		// 是否异步请求
		async : false,
		// 请求的方式
		type : "post",
		// 请求的requestMapping 的路径
		url : "/goodplus/valiloginname",
		// 接收的res 结果与处理方式 function
		success : function(result) {
			if (result) {
				$("#loginnameError").text("该用户名可以注册");
				showError($("#loginnameError"));
				return  flag=true;
			} else{
				$("#loginnameError").text("此用户已存在");
				showError($("#loginnameError"));
				return  flag=false;
			}
		}
	})
	return flag;
}

function yanzhengloginpass() {
	var flag = false;
	// 不能为null
	var loginpass = $("#loginpass").val();
	if (!loginpass) {
		$("#loginpassError").text("密码不能为空");
		showError($("#loginpassError"));
		return false;
	}
	// 密码长度不能小于6 大于10
	if (loginpass.length < 6 || loginpass.length > 10) {
		$("#loginpassError").text("密码长度不能小于6或者大于10");
		showError($("#loginpassError"));
		return false;
	} else {
		$("#loginpassError").text("填写无误");
		showError($("#loginpassError"));
		return flag=true;
	}
	return flag;
}


function yanzhengreloginpass() {
	var flag = false;
	var loginpass = $("#loginpass").val();
	var reloginpass = $("#reloginpass").val();
	var loginpass = $("#loginpass").val();
	if (loginpass){
		if(loginpass == reloginpass) {
		$("#reloginpassError").text("密码核对成功");
		showError($("#reloginpassError"));
		return flag=true;
	} else {
		$("#reloginpassError").text("确认密码失败 请仔细核对");
		showError($("#reloginpassError"));
		return false;
	}
	}else{
		$("#reloginpassError").text("请先输入密码再确认密码");
		showError($("#reloginpassError"));
	}
	return flag;
}


function yanzhengemail() {
	var flag = false;
	var email = $("#email").val();
	//不能为null
	if (!email) {
		$("#emailError").text("邮箱不能为空");
		showError($("#emailError"));
		return false;
	}
	//验证邮箱格式
	if (!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
		$("#emailError").text("邮箱格式不正确");
		showError($("#emailError"));
		return false;
	}
	$.ajax({
		//数据发给服务器的值
		data : {"email": email},
		// 发的是什么类型的值， 收的是什么类型的值
		dataType : "json",
		// 是否缓存
		cache : false,
		// 是否异步请求
		async : false,
		// 请求的方式
		type : "post",
		// 请求的requestMapping 的路径
		url : "/goodplus/valiEmail",
		// 接收的res 结果与处理方式 function
		success : function(result) {
			if (result) {
				$("#emailError").text("该邮箱未注册");
				showError($("#emailError"));
				flag=true;
			} else{
				$("#emailError").text("该邮箱已注册");
				showError($("#emailError"));
				return  flag=false;
			}
		}
	})
	return flag;
};

function yanzhengverifyCode(){
	var flag = false;
	var verifyCode = $("#verifyCode").val();
	if (!verifyCode) {
		$("#verifyCodeError").text("验证码不能为空");
		showError($("#verifyCodeError"));
		return false;
	}
	//验证验证码 
	$.ajax({
			//发送到服务器的值
			data : {"verifyCode":verifyCode},
			//发与收到的值的类型
			dataType : "json",
			//是否缓存
			cache : false,
			//是否异步
			async : false,
			//请求方式
			type : "post",
			//请求的路径
			url : "/goodplus/verifyCode",
			// 接收的res 结果与处理方式 function
			success : function(res) {
				if (res) {
					$("#verifyCodeError").text("验证码正确");
					showError($("#verifyCodeError"));
					flag=true;
				}else {
					$("#verifyCodeError").text("验证码错误");
					showError($("#verifyCodeError"));
					return false;
				}
			}
		}); 
	return flag;
}