$(function(){
	$("#form").validate({
		rules : {
			userCode : {
				required : true,
				minlength : 3,
				maxlength : 18,
			},
			password : {
				required : true,
				minlength : 6,
				maxlength: 15
			},
			randomCode : {
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
			},
			password : {
				required : "请输入密码",
				minlength : "密码长度不能小于6个字符",
				maxlength : "密码长度不能大于15个字符",
			},
			randomCode : {
				required : "请输入验证码",
				remote : "验证码错误"
			}
		}
	});
	
});