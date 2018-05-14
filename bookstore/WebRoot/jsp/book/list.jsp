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
    
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/css/book/list.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/plugin/pager/kkpager_orange.css' />">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-2.2.4.js' />"></script>
	<script type="text/javascript" src="<c:url value='/plugin/pager/kkpager.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/jsp/js/book/list.js' />"></script>

  </head>
  
  <body>
  	
	<form action="<c:url value='/findBookByCombination.action' />"  id="search" target="body">
   		<input type="text" name="name" />  	
   		<a href="javascript:document.getElementById('search').submit();" >
   			<img align="top" border="0" src="<c:url value='/images/btn.bmp' />"/>
   		</a>
   		<a href="<c:url value='/jsp/seniorSearch.jsp'/>" style="font-size: 10pt; color: #404040;" target="body">高级搜索</a>
   	</form>
	<br/><br/>
	<ul>
		<c:forEach items="${pageBean.records }" var="book">
			<li>
				<div class="inner">
					<a class="pic" href="<c:url value='findBookById.action?bookId=${book.id }' />">
						<img src="<c:url value='/${book.imageB }' />" border="0" />
					</a>
					<p class="price">
						<span class="price_n">&yen;${book.currPrice }</span> 
						<span class="price_r">&yen;${book.price }</span>
						(<span class="price_s">${book.discount }折</span>)
					</p>
					<p>
						<a id="bookname" title="${book.name }"
							href="<c:url value='findBookById.action?bookId=${book.id }' />">${book.name }</a>
					</p>
					<%-- url标签会自动对参数进行url编码 --%>
					<c:url value="findBookByCondition.action" var="authorUrl">
		    			<c:param name="condition" value="author" />			
						<c:param name="value" value="${book.author }"/>
					</c:url>
					<c:url value="findBookByCondition.action" var="pressUrl">
		    			<c:param name="condition" value="press" />			
						<c:param name="value" value="${book.press }"/>
					</c:url>
					<p>
						<a title='${book.author }' href="${authorUrl }">${book.author }</a>
					</p>
					<p class="publishing">
						<span>出 版 社：</span><a href="${pressUrl }">${book.press }</a>
					</p>
					<p class="publishing_time"><span>出版时间：</span>${book.publishTime }</p>
				</div>
			</li>
		</c:forEach>
	</ul>
	<div id="pager">
  		<div id="kkpager"></div>
	</div>
  </body>
  	<script type="text/javascript">

		$(function(){
			 //生成分页
			//有些参数是可选的，比如lang，若不传有默认值
			kkpager.generPageHtml({
				pno : ${pageBean.pageCode},
				//总页码
				total : ${pageBean.totalPage},
				//总数据条数
				totalRecords : ${pageBean.totalRecord},
				
				getLink : function(n){
					return '${pageBean.url}' + "&pageCode=" + n;
				}			
			});
			
			$("#kkpager_btn_go_input").val(${pageBean.pageCode});
		});
	</script>
	
</html>
