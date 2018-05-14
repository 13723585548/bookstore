<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='jsp/css/cart/list.css' />">
	<script type="text/javascript" src="<c:url value='jquery/jquery-1.5.1.js' />"></script>
	<script type="text/javascript" src="<c:url value='jsp/js/cart/list.js' />"></script>
	
  </head>
  
  <body>
  		<c:choose>
	    	<c:when test="${empty cartItemList }">
				<table width="95%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td align="right">
							<img align="top" src="<c:url value='/images/icon_empty.png'/>" />
						</td>
						<td>
							<span class="spanEmpty">您的购物车中暂时没有商品</span>
						</td>
					</tr>
				</table>  
			</c:when>
			<c:otherwise>
				<table width="95%" align="center" cellpadding="0" cellspacing="0">
					<tr align="center" bgcolor="#efeae5">
						<td align="left" width="50px">
							<input type="checkbox" id="selectAll" checked="checked"/><label for="selectAll">全选</label>
						</td>
						<td colspan="2">商品名称</td>
						<td>单价</td>
						<td>数量</td>
						<td>小计</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${cartItemList }" var="cartItem">
						<tr align="center">
							<td align="left">
								<input value="${cartItem.id }" type="checkbox" name="checkboxBtn" checked="checked" />
							</td>
							<td align="left" width="70px">
								<a href="<c:url value='findBookById.action?bookId=${cartItem.book.id }' />" class="linkImage">
									<img border="0" width="54" align="top" src="<c:url value='/${cartItem.book.imageB }'/>" />
								</a>
							</td>
							<td align="left" width="400px">
							    <a href="<c:url value='findBookById.action?bookId=${cartItem.book.id }' />"><span>${cartItem.book.name }</span></a>
							</td>
							<td><span>&yen;<span class="currPrice">${cartItem.book.currPrice }</span></span></td>
							<td>
								<a class="sub" id="${cartItem.id }sub"></a>
								<input class="quantity" readonly="readonly" type="text" value="${cartItem.quantity }" id="${cartItem.id }Quantity" />
								<a class="add" id="${cartItem.id }add"></a>
							</td>
							<td width="100px">
								<span class="price_n">&yen;<span class="subTotal" id="${cartItem.id }Subtotal">${cartItem.subtotal }</span></span>
							</td>
							<td>
								<a href="batchDeleteCartItem.action?cartItemIds=${cartItem.id }">删除</a>
							</td>
						</tr>
					</c:forEach>
					
					<tr>
						<td colspan="4" class="tdBatchDelete">
							<a href="javascript:batchDelete();">批量删除</a>
						</td>
						<td colspan="3" align="right" class="tdTotal">
							<span>总计：</span><span class="price_t">&yen;<span id="total"></span></span>
						</td>
					</tr>
					<tr>
						<td colspan="7" align="right">
							<a href="javascript:settlement();" id="settlement" class="settlement"></a>
						</td>
					</tr>
				</table>
				
				<form id="settlementForm" action="loadCartItems.action" method="post">
					<input type="hidden" name="cartItemIds" id="cartItemIds"/>
					<input type="hidden" name="total" id="hiddenTotal"/>					
				</form>
			</c:otherwise>
		</c:choose>
  </body>
</html>
