<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/css/user/password.css' />">
	<script type="text/javascript" src="<c:url value='jquery/jquery-2.2.4.js' />"></script>
	<script type="text/javascript" src="<c:url value='/jsp/js/user/password.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/plugin/validation/jquery.validate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/js/user/passwordValidation.js'/>"></script>
  </head>
  
  <body>
  	<div id="divMain">
		<div id="divTitle">
			<span id="spanTitle">修改密码</span>
		</div>
		<div id="divBody">
			<form action="<c:url value='/updatePassword.action' />" method="post" id="editPassword" >
				<table id="tableForm">
					<tr>
						<td class="tdText">原密码：</td>
						<td><input type="password" name="password" id="password" class="inputClass"/></td>
						<td></td>
					</tr>
					<tr>
						<td class="tdText">新密码：</td>
						<td><input type="password" name="newPassword" id="newPassword"  class="inputClass" /></td>
						<td></td>
					</tr>
					<tr>
						<td class="tdText">确认密码：</td>
						<td><input type="password" name="confirmPassword" id="confirmPassword" class="inputClass"/></td>
						<td></td>
					</tr>
					<tr>
						<td class="tdText">验证码：</td>
						<td><input type="text" name="verifyCode" id="verifyCode" class="inputClass"/></td>
						<td></td>
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
						<td><input type="submit" value="修改密码" id="submitBtn" /></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
  	
  </body>
</html>

