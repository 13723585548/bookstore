<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>top</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1 style="text-align: center; line-height: 30px;">网上书店系统后台管理</h1>
	<div style="line-height: 10px;">
		<span>管理员：${sessionScope.admin.name }</span> <a target="_top"
			href="<c:url value='/adminLogout.action'/>">退出</a> <span
			style="padding-left: 50px;"> <a
			href="<c:url value='/admin/getAllCategory.action' />" target="body">分类管理</a>
			<a href="<c:url value='/jsp/backstage/admin/book/main.jsp' />"
			target="body">图书管理</a> <a
			href="<c:url value='/admin/findAllOrder.action' />" target="body">订单管理</a>
		</span>
	</div>
</body>
</html>
