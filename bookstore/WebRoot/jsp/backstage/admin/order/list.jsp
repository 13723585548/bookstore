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
    
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value='plugin/pager/kkpager_orange.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/backstage/admin/css/order/list.css' />">
	<script type="text/javascript" src="<c:url value='jquery/jquery-2.2.4.js' />"></script>
	<script type="text/javascript" src="<c:url value='plugin/pager/kkpager.min.js' />"></script>

  </head>
  
  <body>
	<p class="pLink">
		<a
			href="<c:url value='/admin/findOrderByStatus.action?status=1'/>">未付款</a>
		| <a
			href="<c:url value='/admin/findOrderByStatus.action?status=2'/>">已付款</a>
		| <a
			href="<c:url value='/admin/findOrderByStatus.action?status=3'/>">已发货</a>
		| <a
			href="<c:url value='/admin/findOrderByStatus.action?status=4'/>">交易成功</a>
		| <a
			href="<c:url value='/admin/findOrderByStatus.action?status=5'/>">已取消</a>
	</p>
	<div class="divMain">
			<div class="divTitle">
				<span style="margin-left: 150px;margin-right: 280px;">商品信息</span> <span
					style="margin-left: 40px;margin-right: 38px;">金额</span> <span
					style="margin-left: 50px;margin-right: 40px;">订单状态</span> <span
					style="margin-left: 50px;margin-right: 50px;">操作</span>
			</div>
			<br />
			<table align="center" border="0" width="100%" cellpadding="0"
				cellspacing="0">
	
				<c:forEach items="${pageBean.records }" var="order">
	
					<tr class="tt">
						<td width="320px">订单号：<a href="<c:url value='/admin/findOrderByIdAdmin.action?orderId=${order.id }' />">${order.id }</a></td>
						<td width="200px">下单时间：${order.time }</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr style="padding-top: 10px; padding-bottom: 10px;">
						<td colspan="2">
							<c:forEach items="${order.orderItemList }" var="orderItem">
								<a class="link2" href="<c:url value='/admin/loadBook.action?bookId=${orderItem.bookId }' />">
									<img border="0" width="70" src="<c:url value='/${orderItem.image_b }' />" />
								</a>
							</c:forEach>
						</td>
						<td width="115px"><span class="price_t">&yen;${order.total }</span>
						</td>
						<td width="142px">
							<c:choose>
								<c:when test="${order.status eq 1 }">(等待付款)</c:when>
								<c:when test="${order.status eq 2 }">(准备发货)</c:when>
								<c:when test="${order.status eq 3 }">(等待确认)</c:when>
								<c:when test="${order.status eq 4 }">(交易成功)</c:when>
								<c:when test="${order.status eq 5 }">(已取消)</c:when>
							</c:choose></td>
						<td>
						<td>
							<a href="<c:url value='/admin/findOrderByIdAdmin.action?orderId=${order.id }'/>">查看</a><br/>
							<c:if test="${order.status eq 1 }">
								<a href="<c:url value='/admin/findOrderByIdAdmin.action?orderId=${order.id }&btn=cancel'/>">取消</a><br/>						
							</c:if>
							<c:if test="${order.status eq 2 }">
								<a href="<c:url value='/admin/findOrderByIdAdmin.action?orderId=${order.id }&btn=deliver'/>">发货</a><br/>
							</c:if>			
						</td>
							
					</tr>
				</c:forEach>
			</table>
			<div id="kkpager"></div>
		</div>
		<script type="text/javascript">
		//init
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
		
</body>
</html>
