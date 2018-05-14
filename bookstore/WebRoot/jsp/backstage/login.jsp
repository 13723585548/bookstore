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
    
    <title>login</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/backstage/css/login.css' />">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-2.2.4.js' />"></script>
	<script type="text/javascript" src="<c:url value='/plugin/validation/jquery.validate.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/jsp/backstage/js/loginValidation.js' />"></script>
	<script type="text/javascript" src="<c:url value='/jsp/backstage/js/login.js' />"></script>
	

  </head>

<body>
	<DIV class="top_div"></DIV>
	<form action="<c:url value='/adminLogin.action' /> "  method="post" target="_top" id="form">
	<DIV
		style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 400px; height: 210px; text-align: center;">

		<DIV style="width: 165px; height: 96px; position: absolute;">

			<DIV class="tou"></DIV>

			<DIV class="initial_left_hand" id="left_hand"></DIV>

			<DIV class="initial_right_hand" id="right_hand"></DIV>
		</DIV>

		<P style="padding: 25px 0px 10px; position: relative;">
			<span style="color:red;" id="error">${userCodeError }</span><br/>
			<SPAN class="u_logo"></SPAN> 
			<INPUT class="ipt" type="text" name="name" placeholder="请输入用户名" >
		</P>

		<p style="position: relative;">
			<SPAN class="p_logo"></SPAN> 
			<INPUT class="ipt" id="password" name="password" type="password" placeholder="请输入密码" >
			<!-- <DIV style="padding:10px 60px 10px;float:left;">
				<input  type="checkbox" name="rememberMe" />自动登录
			</DIV> -->
		</p>
				
		<DIV
			style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
				
			<P style="margin: 10px 35px 20px 45px;">
				<input type="text" name="randomCode" size="8"  style="float:left;margin-left:15px;width:70px; height:30px;" id="verifyCode"/>
				<img src="<c:url value='verifyCode.jsp' />" style="float:left;margin-left:15px;" id="imgVerifyCode"/>
				<SPAN style="float:left;margin:-10px;height:70px;">
					<a href="javascript:refreshVerifyCode()" style="margin:30px;">换一张</a>
				</SPAN> 
				<SPAN style="float: right;margin:-10px;height:70px;">
					<input type="submit" value="登录"
						style="background: rgb(0, 142, 173); margin-top:10px; padding: 3px 5px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;" />
						<!-- <A style="background: rgb(0, 142, 173); padding: 7px 10px; border-radius: 4px; border: 1px solid rgb(26, 117, 152); border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
					href="javascript:document.getElementById('form').submit();">登录</A>  -->
				</SPAN>
			</P>
		</DIV>
	</DIV>
	</form>

</body>
</html>
