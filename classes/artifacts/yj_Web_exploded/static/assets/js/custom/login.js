function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	console.log(result);
	return result;
}

jQuery(function($) {
	$(document).on('click', '.toolbar a[data-target]', function(e) {
		e.preventDefault();
		var target = $(this).data('target');
		$('.widget-box.visible').removeClass('visible');// hide others
		$(target).addClass('visible');// show target
	});

	// 登录页面切换背景
	$('#btn-login-dark').on('click', function(e) {
		$('body').attr('class', 'login-layout');
		e.preventDefault();
	});
	$('#btn-login-light').on('click', function(e) {
		$('body').attr('class', 'login-layout light-login');
		e.preventDefault();
	});
	$('#btn-login-blur').on('click', function(e) {
		$('body').attr('class', 'login-layout blur-login');
		e.preventDefault();
	});

	// 验证找回密码表单 按钮点击之后开始验证表单
	$("#retrieveButton").bind("click", function() {
		$('#validationRetrieveForm').submit(); 
	});
	$('#validationRetrieveForm').validate({
		errorElement : 'div',
		errorClass : 'help-block',
		focusInvalid : false,
		ignore : "",
		rules : {
			email : {
				required : true,
				email : true
			}
		},
		messages : {
			email : {
				required : "请填写邮箱",
				email : "请填写正确的邮箱"
			}
		},
		invalidHandler : function(form) {
		}
	});

	// 按回车键触发登录事件
	$(document).keydown(function(event) {
		var key = window.event ? event.keyCode : event.which;
		if (key == 13) {
			$("#loginButton").click();
		}
	});

	// 验证登录表单
//	$("#loginButton").bind("click", function() {
//		$('#validationLoginForm').submit();
//	});
//	
//	$('#validationLoginForm').validate({
//		errorElement : 'div',
//		errorClass : 'help-block',
//		focusInvalid : false,
//		ignore : "",
//		rules : {
//			useridno : {
//				required : true,
//				
//			},
//			password : {
//				required : true,
//				minlength : 6,
//				maxlength : 14
//			}
//		},
//		messages : {
//			email : {
//				required : "请填写身份证号码或手机号",
//				
//			},
//			password : {
//				required : "请输入密码",
//				minlength : "密码长度至少为6个字符",
//				maxlength : "密码长度至多为14个字符"
//			}
//		},
//		highlight : function(e) {
//			$(e).closest('label').removeClass('has-info').addClass('has-error');
//		},
//		success : function(e) {
//			$(e).closest('label').removeClass('has-error');// .addClass('has-info');
//			$(e).remove();
//		},
//		errorPlacement : function(error, element) {
//			error.insertAfter(element.parent());
//			//error.appendTo('#invalid');
//		},
//		submitHandler : function(form) {
//			console.log("调用登录函数1l");
//			login();
//		},
//		invalidHandler : function(form) {
//		}
//	});

	$('[data-rel=tooltip]').tooltip({
		container : 'body'
	});
	
	$('#birthday').datepicker({
	    format: 'yyyy-mm-dd',
	    language: 'zh-CN'
	});

	// 验证注册表单
	$("#registerButton").bind("click", function() {
		$('#validationRegisterForm').submit();
	});
	$('#validationRegisterForm').validate({
		errorElement : 'div',
		errorClass : 'help-block',
		focusInvalid : false,
		ignore : "",
		rules : {
			userName : {
				required : true,
				minlength : 2,
				maxlength : 40
			},
			userIdno : {
				required : true,
				number : true,
				rangelength: [18,19]
			},
			sex : {
				required : true
			},
			userEmail : {
				required : true,
				email : true,
				maxlength : 30
			},
			userTel : {
				required : true,
				number : true,
				minlength : 11
				
			},
			userBirthday : {
				required : true
			},
			userPwd : {
				required : true,
				minlength : 6,
				maxlength : 14
			},
			repeatPassword : {
				required : true,
				minlength : 6,
				maxlength : 14,
				equalTo : "#password"
			},
			agree : {
				required : true,
			}
		},
		messages : {
			userName : {
				required : "请填写姓名",
				minlength : "姓名长度至少为2个字符",
				maxlength : "姓名长度至多为40个字符"
			},
			userIdno : {
				required : "请填写身份证号码",
				number : "只可填写数字",
				rangelength: "身份证号码长度为18位"
			},
			sex : "请选择性别",
			userEmail : {
				required : "请填写邮箱",
				email : "请填写正确的邮箱",
				maxlength : "邮箱长度至多为30个字符"
			},
			userTel : {
				required : "请填写手机号码",
				number:"请正确填写手机号码",
				minlength : "手机号码长度至少为11个字符"
			},
			userPwd : {
				required : "请输入密码",
				minlength : "密码长度至少为6个字符",
				maxlength : "密码长度至多为14个字符"
			},
			
			//agree : "您还未接受用户协议"
		},
		highlight : function(e) {
			$(e).closest('label').removeClass('has-info').addClass('has-error');
		},
		success : function(e) {
			$(e).closest('label').removeClass('has-error');// .addClass('has-info');
			$(e).remove();
		},
		errorPlacement : function(error, element) {
			error.insertAfter(element.parent());
		},
		submitHandler : function(form) {
			register1();
		},
		invalidHandler : function(form) {
			console.log("here1");
		}
	});
});	
