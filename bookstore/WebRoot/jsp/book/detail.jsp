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
    
    <title>图书详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='jsp/css/book/detail.css' />">
	<script type="text/javascript" src="<c:url value='jquery/jquery-2.2.4.js' />"></script>
	<script type="text/javascript" src="<c:url value='/plugin/validation/jquery.validate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/js/book/detailValidation.js' />"></script>

  </head>
  <body>

	<div class="divBookName">${book.name }</div>
	<div>
		<img align="top" src="<c:url value='/${book.imageW }'/>" class="img_image_w" />
		<div class="divBookDesc">
			<ul>
				<li>商品编号：${book.id }</li>
				<li>传智价：<span class="price_n">&yen;${book.currPrice }</span></li>
				<li>定价：<span class="spanPrice">&yen;${book.price }</span> 折扣：<span
					style="color: #c30;">${book.discount }</span>折
				</li>
			</ul>
			<hr class="hr1" />
			<table>
				<tr>
					<td colspan="3">作者：${book.author } 著</td>
				</tr>
				<tr>
					<td colspan="3">出版社：${book.press }</td>
				</tr>
				<tr>
					<td colspan="3">出版时间：${book.publishTime }</td>
				</tr>
				<tr>
					<td>版次：${book.edition }</td>
					<td>页数：${book.pageNum }</td>
					<td>字数：${book.wordNum }</td>
				</tr>
				<tr>
					<td width="180">印刷时间：${book.printTime }</td>
					<td>开本：${book.bookSize }开</td>
					<td>纸张：${book.paper }</td>
				</tr>
			</table>
			<div class="divForm">
				<form  action="<c:url value='/addCartItem.action' />" method="post" id="purchase" 
					<c:choose>
						<c:when test="${currentUser == null }">target="_top"</c:when>
					</c:choose>			
				 >
					 <input type="hidden" name="bookId" value="${book.id }" />
					  数量：<input id="cnt" style="width: 40px;text-align: center;" type="text"
						name="quantity" value="1" /><br/><br/>
					<input type="submit" value="" id="btn" /> 
				</form>
				
				<!-- <a id="btn" href="javascript:$('#purchase').submit();"></a> -->
			</div>
		</div>
	</div>
























	<%-- <ul>
	    	<li>商品编号：${book.id }</li>
	    	<li>传智价：<span>&yen;${book.currPrice }</span></li>
	    	<li>定价：<span>&yen;${book.price }</span>　折扣：<span>${book.discount }</span>折</li>
	    </ul>
	    <hr class="hr1"/>
		<table>
			<tr>
				<td colspan="3">
					作者：${book.author } 著
				</td>
			</tr>
			<tr>
				<td colspan="3">
					出版社：${book.press }
				</td>
			</tr>
			<tr>
				<td colspan="3">出版时间：${book.publishTime }</td>
			</tr>
			<tr>
				<td>版次：${book.edition }</td>
				<td>页数：${book.pageNum }</td>
				<td>字数：${book.wordNum }</td>
			</tr>
			<tr>
				<td width="180">印刷时间：${book.printTime }</td>
				<td>开本：${book.bookSize }开</td>
				<td>纸张：${book.paper }</td>
			</tr>
		</table>
		
		<form action="addCartItem.action" method="post" id="purchase">
				<input type="hidden" name="bookId" value="${book.id }"/>
  				我要买：<input id="cnt" style="width: 40px;text-align: center;" type="text" name="quantity" value="1"/>件
  				<!-- <input type="submit"  value="加入购物车" /> -->
  		</form>
  		<a id="btn" href="javascript:$('#purchase').submit();"></a> --%>
  </body>
</html>
