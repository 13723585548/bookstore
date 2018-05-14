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
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/css/seniorSearch.css' />">
	
  </head>
  
  <body>
  	<div id="divMain">
		<div id="divTitle">
			<span id="spanTitle">高级检索</span>
		</div>
		<div id="divBody">
			<form action="<c:url value='/findBookByCombination.action' />" id="editPassword" >
				<table id="tableForm">
					<tr>
						<td class="tdText">书名：</td>
						<td><input type="text" name="name"  class="inputClass"/></td>
						<td></td>
					</tr>
					<tr>
						<td class="tdText">作者：</td>
						<td><input type="text" name="author"  class="inputClass" /></td>
						<td></td>
					</tr>
					<tr>
						<td class="tdText">出版社：</td>
						<td><input type="text" name="press" class="inputClass"/></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="搜索" id="submitBtn" /></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
  </body>
</html>
