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
    
    <title>添加分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/backstage/admin/css/category/addFirst.css' />">
	
	<script type="text/javascript" src="<c:url value='/jquery/jquery-2.2.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/plugin/validation/jquery.validate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/backstage/admin/js/category/addFirstValidation.js' />"></script>

  </head>
  
  <body>
  	 <form action="<c:url value='/admin/addCategory.action'/>" method="post" id="addFirst">
  		<div class="mainBox"
				style="height:auto!important;height:550px;min-height:550px;">
				<h3>
					<span class="actionBtn">添加一级分类</span>
				</h3>
				<table border="0" cellpadding="8" cellspacing="0" class="tableBasic">
					<tr>
						<th align="left">分类名称</th>
						<th align="left"><input type="text" name="name" id="name" /></th>
						<th></th>
					</tr>
					<tr>
						<th align="left">简单描述</th>
						<th align="left"><textarea rows="5" cols="50" name="desc" id="desc" ></textarea></th>
						<th></th>
					</tr>				
				</table>
				<br/><br/>
				<input type="submit" value="保存" class="sub"/>
    			<input type="button" value="返回" onclick="history.go(-1)" class="sub"/> 				
			</div>
 	 </form>   
  </body>
</html>
