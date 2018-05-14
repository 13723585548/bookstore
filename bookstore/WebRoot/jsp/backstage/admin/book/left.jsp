<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
		<c:forEach items="${categoryList }" var="category">
    	${category.name}<br/>
    	<c:forEach items="${category.children}" var="child">
    		&nbsp;&nbsp;<a
				href="<c:url value='/admin/findBookByConditionAdmin.action?condition=categoryId&value=${child.id }' />"
				target='rbody'>${child.name }</a>
			<br />
		</c:forEach>
    	
    </c:forEach>
  </body>
</html>