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
    
    <title>图书类别</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/menu/mymenu.css' />">
	
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js' />"></script>
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js' />"></script>
	
	<script type="text/javascript">
		/*
		 * 1. 对象名必须与第一个参数相同！
		   2. 第二个参数是显示在菜单上的大标题
		 */
		var bar = new Q6MenuBar("bar", "华软sise书店");
		$(function() {
			bar.colorStyle = 4;//指定配色样式，一共0,1,2,3,4
			bar.config.imgDir = "<c:url value='/menu/img/'/>";//小工具所需图片的路径
			bar.config.radioButton=true;//是否排斥，多个一级分类是否排斥
		
			/*
			1. 程序设计：一级分类名称
			2. Java Javascript：二级分类名称
			3. /goods/jsps/book/list.jsp：点击二级分类后链接到的URL
			4. body:链接的内容在哪个框架页中显示
			*/
			<c:forEach items="${categoryList}" var="category">
			  <c:forEach items="${category.children}" var="child">
				bar.add("${category.name}", "${child.name}", "/bookstore/findBookByCondition.action?condition=categoryId&value=${child.id }", "body");
			  </c:forEach>
			</c:forEach>
			
			$("#menu").html(bar.toString());
		});
	</script>
		
  </head>
  
  <body>
  
  
  	
  
  <div id="menu"></div>
  	
    <%-- <c:forEach items="${categoryList }" var="category">
    	${category.name}<br/>
    	<c:forEach items="${category.children}" var="child">
    		&nbsp;&nbsp;<a
				href="<c:url value='findBookByCondition.action?condition=categoryId&value=${child.id }' />"
				target='body'>${child.name }</a>
			<br />
		</c:forEach>
    </c:forEach> --%>
  </body>
</html>
