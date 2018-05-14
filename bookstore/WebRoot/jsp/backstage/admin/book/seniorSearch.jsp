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
    
    <title>高级搜索</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/backstage/admin/css/book/seniorSearch.css' />">
	

  </head>
  
  <body>
  
  	<form action="<c:url value='/admin/findBookByCombinationAdmin.action' />" >
  		<div class="mainBox"
				style="height:auto!important;height:550px;min-height:550px;">
				<h3>
					<span class="actionBtn">高级检索</span>
				</h3>
				<table border="0" cellpadding="8" cellspacing="0" class="tableBasic">
					<tr>
						<th align="left">图书名称</th>
						<th align="left"><input type="text" name="name" /></th>
					</tr>
					<tr>
						<th align="left">作者</th>
						<th align="left"><input type="text" name="author" /></th>
					</tr>				
					<tr>
						<th align="left">出版社</th>
						<th align="left"><input type="text" name="press" /></th>
					</tr>				
				</table>
				<br/><br/>
				<input type="submit" value="搜索" class="sub"/>
    			<input type="button" value="返回" onclick="history.go(-1)" class="sub"/> 				
			</div>
 	 </form> 
  </body>
</html>
