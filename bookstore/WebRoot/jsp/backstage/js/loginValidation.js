$(function(){
	
	$("#form").validate({
		rules : {
			name : {
				required : true,
				minlength : 3,
				maxlength : 18
			},
			password : {
				required : true,
				minlength : 5,
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
			name : {
				required : "请输入用户名",
				minlength : "用户名长度不能小于3个字符",
				maxlength : "用户名长度不能大于18个字符"
			},
			password : {
				required : "请输入密码",
				minlength : "密码长度不能小于5个字符",
				maxlength : "密码长度不能大于15个字符"
			},
			randomCode : {
				required : "请输入验证码",
				remote : "验证码错误"
			}
		},
		errorPlacement: function(error, element) {   
			
			$("#error").text("");
			error.appendTo($("#error"));
			
		}
	});
	
});