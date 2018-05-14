$(function(){
	// 在键盘按下并释放及提交后验证提交表单
	$("#editPassword").validate({
		rules : {
			password : {
				required : true,
				minlength : 6,
				maxlength: 15
			},
			newPassword : {
				required : true,
				minlength : 6,
				maxlength: 15
			},
			confirmPassword : {
				 required : true,
				 equalTo: "#newPassword"
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
			password : {
				required : "请输入原密码",
				minlength : "密码长度不能小于6个字符",
				maxlength : "密码长度不能大于15个字符",
			},
			newPassword : {
				required : "请输入新密码",
				minlength : "密码长度不能小于6个字符",
				maxlength: "密码长度不能大于15个字符"
			},
			confirmPassword : {
				required : "请输入密码",
				 equalTo: "两次密码输入不一致"
			},
			verifyCode : {
				required : "请输入验证码",
				remote : "验证码错误"
			}
		}
		
	});
});