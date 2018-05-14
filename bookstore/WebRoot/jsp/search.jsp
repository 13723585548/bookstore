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
    
    <title>搜索</title>
    
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
    	<form action="<c:url value='/findBookByCombination.action' />" method="post" id="search" target="body">
    		<input type="text" name="name" />  	
    		<a href="javascript:document.getElementById('search').submit();" >
    			<img align="top" border="0" src="<c:url value='/images/btn.bmp' />"/>
    		</a>
    		<a href="<c:url value='/jsp/seniorSearch.jsp'/>" style="font-size: 10pt; color: #404040;" target="body">高级搜索</a>
    	</form>
  </body>
</html>
