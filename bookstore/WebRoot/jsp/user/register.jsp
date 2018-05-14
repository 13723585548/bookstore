<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/css/user/register.css' />">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-2.2.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/js/user/register.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/plugin/validation/jquery.validate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/js/user/registerValidation.js'/>"></script>

  </head>
  
  <body>

	<div id="divMain">
		<div id="divTitle">
			<span id="spanTitle">新用户注册</span>
		</div>
		<div id="divBody">
			<form:form action="regist.action" method="post" id="registForm" modelAttribute="userForm">
				<table id="tableForm">
					<tr>
						<td class="tdText">用户名：</td>
						<td class="tdInput"><input type="text" name="userCode" id="userCode"  value="${userForm.userCode }"  class="inputClass"/></td>
						<td><label class="errorClass">${errors.userCode }</label></td>
					</tr>
					<tr>
						<td class="tdText">登录密码：</td>
						<td><input type="password" name="password" id="password"  value="${userForm.password}" class="inputClass"/></td>
						<td><label class="errorClass">${errors.password}</label></td>
					</tr>
					<tr>
						<td class="tdText">确认密码：</td>
						<td><input type="password" name="confirmPassword" id="confirmPassword" value="${userForm.confirmPassword}" class="inputClass"/></td>
						<td><label class="errorClass">${errors.confirmPassword}</label></td>
					</tr>
					<tr>
						<td class="tdText">Email：</td>
						<td><input type="text" name="email" id="email"  value="${userForm.email}" class="inputClass" /></td>
						<td><label class="errorClass">${errors.email }</label></td>
					</tr>
					<tr>
						<td class="tdText">验证码：</td>
						<td><input type="text" name="verifyCode" id="verifyCode"  value="${userForm.verifyCode }" class="inputClass"/></td>
						<td><label class="errorClass">${errors.verifyCode}</label></td>
					</tr>
					<tr>
						<td>&nbsp;</td>						
						<td>
							<div id="divVerifyCode">
								<img id="imgVerifyCode" src="<c:url value='/verifyCode.jsp' />" />
								<label style="margin-left: 30px;"><a href="javascript:refreshVerifyCode()">换一张</a></label>
							</div>
							
						</td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="image" src="<c:url value='/images/regist1.jpg'/>" id="submitBtn" /></td>
						<td></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>

</body>
</html>
