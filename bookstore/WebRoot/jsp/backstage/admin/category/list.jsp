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
    
    <title>分类列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/backstage/admin/css/category/list.css' />">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-2.2.4.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/backstage/admin/js/category/list.js'/>"></script>

  </head>
  
  <body>
	
		<div class="mainBox"
				style="height:auto!important;height:550px;min-height:550px;">
				<h3>
					<a href="<c:url value='/jsp/backstage/admin/category/addFirst.jsp' />" class="actionBtn add">添加分类</a>图书分类
				</h3>
				<table width="100%" border="0" cellpadding="8" cellspacing="0"
					class="tableBasic">
					<tr>
						<th width="120" align="left">分类名称</th>
						<th align="left">简单描述</th>
						<th width="80" align="center">操作</th>
					</tr>
					
					
					<c:forEach items="${categoryList }" var="category">
					<tr>
						<td align="left"><a href="javascript:void;" onclick="switchSecond(this);" id="${category.id }">${category.name }</a></td>
						<td>${category.desc }</td>
						<td align="center">
							<a href="<c:url value='/admin/addSecondPrepare.action?parentId=${category.id }'/>">添加</a> | 
							<a href="<c:url value='/admin/editPrepare.action?categoryId=${category.id }' />">编辑</a> | 
							<a href="<c:url value='/admin/deleteParent.action?categoryId=${category.id }'/>">删除</a>
						</td>
					</tr>
						<c:forEach items="${category.children }" var="child">
						<tr class="${category.id }second" >
							<td align="left">- ${child.name }</td>
							<td>${child.desc }</td>
							<td align="center">
								<a href="<c:url value='/admin/editSecondPrepare.action?categoryId=${child.id }' />">编辑</a> | 
								<a href="<c:url value='/admin/deleteChild.action?categoryId=${child.id }'/>">删除</a>
							</td>
						</tr>
						</c:forEach>
					</c:forEach>
					
				</table>
			</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	<%-- <h2 style="text-align: center;">分类列表</h2>
	<table align="center" border="1" cellpadding="0" cellspacing="0">
		<caption class="captionAddOneLevel">
			<a href="<c:url value='/jsp/backstage/admin/category/addFirst.jsp' />">添加一级分类</a>
		</caption>
		<tr class="trTitle">
			<th>分类名称</th>
			<th>描述</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${categoryList }" var="category">
			<tr class="trOneLevel">
				<td width="200px;">${category.name }</td>
				<td>${category.desc }</td>
				<td width="200px;"><a
					href="<c:url value='/admin/addSecondPrepare.action?parentId=${category.id }'/>">添加二级分类</a>
					<a href="<c:url value='/admin/editPrepare.action?categoryId=${category.id }' />">修改</a>
					<a onclick="return confirm('您是否真要删除该一级分类？')"
					href="<c:url value='/admin/deleteParent.action?categoryId=${category.id }'/>">删除</a>
				</td>
			</tr>
			<c:forEach items="${category.children }" var="child">
				<tr class="trTwoLevel">
					<td>${child.name }</td>
					<td>${child.desc }</td>
					<td width="200px;" align="right"><a
						href="<c:url value='/admin/editSecondPrepare.action?categoryId=${child.id }' />">修改</a>
						<a onclick="return confirm('您是否真要删除该二级分类？')"
						href="<c:url value='/admin/deleteChild.action?categoryId=${child.id }'/>">删除</a>
					</td>
				</tr>
			</c:forEach>
		</c:forEach> 
	</table>--%>
</body>
</html>
