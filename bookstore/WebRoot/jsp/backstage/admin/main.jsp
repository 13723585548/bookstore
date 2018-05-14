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
    
    <title>main</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/backstage/admin/css/main.css' />">


  </head>
  
  <body>
	<div id="dcWrap">
		<div id="dcHead">
			<div id="head">
				<div class="logo">
					<!-- <a href="index.html"><img src="images/dclogo.gif" alt="logo"></a> -->
				</div>
				<div class="nav">				
					<ul class="navRight">
						<li class="M noLeft"><a href="JavaScript:void(0);">您好，${sessionScope.admin.name }</a></li>
						<li class="noRight"><a href="<c:url value='/adminLogout.action'/>">退出</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- dcHead 结束 -->
		<div id="dcLeft">
			<div id="menu">
				<ul class="top">
					<li><a href="<c:url value='/home.action' />" target="_blank"><i class="home"></i><em>首页</em></a></li>
				</ul>
				<ul>
					<li> <!-- class="cur" -->
						<a href="<c:url value='/admin/getAllCategory.action' />" target="body">
							<i class="productCat"></i><em>图书分类</em>
						</a>
					</li>
					<li>
						<a href="<c:url value='/admin/findBookByConditionAdmin.action' />" target="body">
							<i class="product"></i><em>图书列表</em>
						</a>
					</li>
					<li>
						<a href="<c:url value='/admin/addPrepare.action' />" target="body">
							<i class="product"></i><em>新书上架</em>
						</a>
					</li>
					<li>
						<a href="<c:url value='/admin/findAllOrder.action' />" target="body">
							<i class="product"></i><em>订单列表</em>
						</a>
					</li>
				</ul>
	
			</div>
		</div>
		<div id="dcMain">
			<!-- 当前位置 -->
			<div id="urHere">
				<b></b>
			</div>
			<iframe src="<c:url value='/admin/getAllCategory.action' />"  name="body"></iframe>
		</div>
		<div class="clear"></div>
		<div id="dcFooter">
			<div id="footer">
				<div class="line"></div>
				<ul>
					<li>版权所有 © 华软sise书店，并保留所有权利。</li>
				</ul>
			</div>
		</div>
		<!-- dcFooter 结束 -->
		<div class="clear"></div>
	</div>

</body>
</html>
