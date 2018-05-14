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
    
    <title>top.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

	

  </head>
  
  <body>

    	<!-- 根据用户是否登录，显示注册/登录链接 -->
    	<c:choose>
	    	<c:when test="${empty sessionScope.currentUser }">
				  <a href="<c:url value='/jsp/user/login.jsp'/>" target="_parent" >会员登录</a> |&nbsp; 
				  <a href="<c:url value='/jsp/user/register.jsp'/>" target="_parent">会员注册</a>	
			</c:when>
			<c:otherwise>
				<span style="float:right;margin-right:20px;color: #FFFFFF;">账号：${sessionScope.currentUser.userCode }</span>
				<a href="<c:url value='/myOrder.action' />" target="body">我的订单</a>
	    	
		    	<a href="<c:url value='/findCartItemByUser.action' />" target="body">我的购物车</a>
		    	
		    	<a href="<c:url value='/jsp/user/password.jsp' />" target="body">修改密码</a>
		    	  	
		    	<a href="<c:url value='/logout.action' />" target="_parent">退出</a>
			</c:otherwise>
    	</c:choose>
  </body>
</html>
