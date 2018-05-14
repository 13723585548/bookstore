$(function(){
	// 在键盘按下并释放及提交后验证提交表单
	$("#registForm").validate({
		rules : {
			userCode : {
				required : true,
				minlength : 3,
				maxlength : 18,
				remote : {
					async : false,
					type : "POST",
					url : "checkUser.action",
					data : {
						usercode : function() {
							return $("#userCode").val();
						}
					},
					dataType : "json"
				}
                									
			},
			password : {
				required : true,
				minlength : 6,
				maxlength: 15
			},
			confirmPassword : {
				 required : true,
				 equalTo: "#password"
			},
			email : {
				required : true,
		        email : true,
		        remote : {
		        	async : false,
					type : "POST",
					url : "checkEmail.action",
					data : {
						email : function() {
							return $("#email").val();
						}
					},
					dataType : "json"
		        } 
			},
			verifyCode : {
				required : true,
				remote : {
					async : false,
					type : "POST",
					url : "checkVerifyCode.action",
					data : {
						verifyCode : function() {
							return $("#verifyCode").val();
						}
					},
					dataType : "json"
				}
			}
		},
		messages : {
			userCode : {
				required : "请输入用户名",
				minlength : "用户名长度不能小于3个字符",
				maxlength : "用户名长度不能大于18个字符",
				remote : "用户名已被注册"
			},
			password : {
				required : "请输入密码",
				minlength : "密码长度不能小于6个字符",
				maxlength : "密码长度不能大于15个字符",
			},
			confirmPassword : {
				 required : "请输入密码",
				 equalTo: "两次密码输入不一致"
			},
			email : {
				required : "邮箱不能为空",
				email : "请输入一个正确的邮箱",
				remote : "该邮箱已被注册"
			},
			verifyCode : {
				required : "请输入验证码",
				remote : "验证码错误"
			}
		},
		errorPlacement: function(error, element) {   
			error.appendTo(element.parent().next());   
		}
	});
});