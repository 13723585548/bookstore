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
    
    <title>结算</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="<c:url value='jsp/css/cart/showItem.css' />">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/js/cart/showItem.js'/>"></script>
	<style type="text/css">
		#addr {
			width: 500px;
			height: 32px;
			border: 1px solid #7f9db9;
			padding-left: 10px;
			line-height: 32px;
		}
	</style>
  </head>
  
  <body>
	<c:choose>
		<c:when test="${empty cartItemList }">购物车条目为空</c:when>
		<c:otherwise>
			<form action="createOrder.action" method="post" id="createOrderForm">
				<c:forEach items="${cartItemIds }" var="cartItemId">
					<input type="hidden" name="cartItemIds" value="${cartItemId }" /> 
				</c:forEach>
				<table width="95%" align="center" cellpadding="0" cellspacing="0">
					<tr bgcolor="#efeae5">
						<td width="400px" colspan="5"><span style="font-weight: 900;">生成订单</span></td>
					</tr>
					<tr align="center">
						<td width="10%">&nbsp;</td>
						<td width="50%">图书名称</td>
						<td>单价</td>
						<td>数量</td>
						<td>小计</td>
					</tr>


					<c:forEach items="${cartItemList }" var="cartItem">
						<tr align="center">
							<td align="right">
								<a class="linkImage" href="<c:url value='findBookById.action?bookId=${cartItem.book.id }' />">
									<img border="0" width="54" align="top" src="<c:url value='/${cartItem.book.imageB }'/>" />
								</a>
							</td>
							<td align="left">
								<a href="<c:url value='findBookById.action?bookId=${cartItem.book.id }' />"><span>${cartItem.book.name }</span></a>
							</td>
							<td>&yen;${cartItem.book.currPrice }</td>
							<td>${cartItem.quantity }</td>
							<td><span class="price_n">&yen;<span class="subtotal">${cartItem.subtotal }</span></span>
							</td>
						</tr>
					</c:forEach>


					<tr>
						<td colspan="6" align="right"><span>总计：</span><span
							class="price_t">&yen;<span id="total">${total }</span></span></td>
					</tr>
					<tr>
						<td colspan="5" bgcolor="#efeae5">
						<span style="font-weight: 900">收货地址</span></td>
					</tr>
					<tr>
						<td colspan="6">
							<input id="addr" type="text" name="address" value="广州市 从化区 太平镇 广州大学华软软件学院 张三" />
						</td>
					</tr>
					<tr>
						<td style="border-top-width: 4px;" colspan="5" align="right">
							<a id="linkSubmit" href="javascript:$('#createOrderForm').submit();">提交订单</a>
						</td>
					</tr>
				</table>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>
