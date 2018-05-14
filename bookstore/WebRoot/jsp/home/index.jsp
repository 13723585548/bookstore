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
    
    <title>首页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css"  href="<c:url value='/jsp/css/home/index.css' />"/>
  </head>
  
  <body>
  
  	<!--顶部-->
    <div class="layout_top_header">
	    <span style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">
			<iframe frameborder="0" src="<c:url value='/jsp/home/top.jsp'/>" name="top"></iframe>
		</span>
    </div>
    <!--顶部结束-->
    <!--菜单-->
    <div class="layout_left_menu">
        	<iframe frameborder="0" src="<c:url value='/findAllCategory.action'/>" name="left"></iframe>
    </div>
    <!--菜单-->
    <div id="layout_right_content" class="layout_right_content">

        <div class="route_bg">
           &nbsp;
        </div>
        <div class="mian_content">
            <div id="page_content">
                <iframe frameborder="0" src="<c:url value='/findBookByCondition.action' />" name="body"></iframe>
            </div>
        </div>
       
    </div>
    

  </body>
</html>
