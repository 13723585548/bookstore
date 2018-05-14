/*
 * 换一张验证码
 */
function refreshVerifyCode() {
	/*
	 * 1. 获取<img>元素
	 * 2. 重新设置它的src
	 * 3. 使用毫秒来添加参数
	 */
	$("#imgVerifyCode").attr("src", "/bookstore/verifyCode.jsp?time=" + new Date().getTime());

}