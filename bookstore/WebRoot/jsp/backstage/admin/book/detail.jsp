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
	
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/backstage/admin/css/book/detail.css' />">
	<%-- <script type="text/javascript" src="<c:url value='/jquery/jquery-2.2.4.js' />"></script> --%>
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js' />"></script>
	<script type="text/javascript" src="<c:url value='/jsp/backstage/admin/js/book/detail.js' />"></script>
	<script type="text/javascript" src="<c:url value='/plugin/validation/jquery.validate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/backstage/admin/js/book/detailValidation.js' />"></script>
  </head>
  
  <body>
  	<h3>
		<input type="checkbox" id="box">
		<label for="box" class="boxLabel">编辑或删除</label>
	</h3>
	<div id="show">
		<div class="sm">${book.name }</div>
		<img align="top" src="<c:url value='/${book.imageW }'/>" class="tp" />
		<div id="book" style="float:left;">
			<ul>
				<li>商品编号：${book.id }</li>
				<li>当前价：<span class="price_n">&yen;${book.currPrice }</span></li>
				<li>定价：<span style="text-decoration:line-through;">&yen;${book.price }</span>
					折扣：<span style="color: #c30;">${book.discount }</span>折
				</li>
			</ul>
			<hr style="margin-left: 50px; height: 1px; color: #dcdcdc" />
			<table class="tab">
				<tr>
					<td colspan="3">作者：${book.author }著</td>
				</tr>
				<tr>
					<td colspan="3">出版社：${book.press }
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
		</div>
	</div>


	<div id='formDiv'>
		<div class="sm">&nbsp;</div>
		<form method="post" id="form">
			<input type="hidden" name="id" value="${book.id }" /> 
			<input type="hidden" name="imageW"  value="${book.imageW }" />
			<input type="hidden" name="imageB"  value="${book.imageB }" />
			<img align="top" src="<c:url value='/${book.imageW }'/>" class="tp" />
			<div style="float:left;">
				<ul>
					<li>商品编号：${book.id }</li>
					<li>书名： <input id="name" type="text" name="name"
						value="${book.name }" style="width:500px;" /></li>
					<li>当前价：<input id="currPrice" type="text" name="currPrice"
						value="${book.currPrice }" style="width:50px;" /></li>
					<li>定价： <input id="price" type="text" name="price"
						value="${book.price }" style="width:50px;" /> 折扣：<input
						id="discount" type="text" name="discount"
						value="${book.discount }" style="width:30px;" />折
					</li>
				</ul>
				<hr style="margin-left: 50px; height: 1px; color: #dcdcdc" />
				<table class="tab">
					<tr>
						<td colspan="3">作者： <input id="author" type="text"
							name="author" value="${book.author }" style="width:150px;" />
						</td>
					</tr>
					<tr>
						<td colspan="3">出版社： <input id="press" type="text"
							name="press" value="${book.press }" style="width:200px;" />
						</td>
					</tr>
					<tr>
						<td colspan="3">出版时间：<input id="publishtime" type="text"
							name="publishTime" value="${book.publishTime }"
							style="width:100px;" /></td>
					</tr>
					<tr>
						<td>版次： <input id="edition" type="text" name="edition"
							value="${book.edition }" style="width:40px;" /></td>
						<td>页数： <input id="pageNum" type="text" name="pageNum"
							value="${book.pageNum }" style="width:50px;" /></td>
						<td>字数： <input id="wordNum" type="text" name="wordNum"
							value="${book.wordNum }" style="width:80px;" /></td>
					</tr>
					<tr>
						<td width="250px">印刷时间：<input id="printtime" type="text"
							name="printTime" value="${book.printTime }" style="width:100px;" /></td>
						<td width="250px">开本： <input id="booksize" type="text"
							name="bookSize" value="${book.bookSize }" style="width:30px;" /></td>
						<td>纸张： <input id="paper" type="text" name="paper"
							value="${book.paper }" style="width:80px;" /></td>
					</tr>
					<tr>
						<td>一级分类：<select name="parentId" id="parentId"
							onchange="loadChildren()">
								<c:forEach items="${parents }" var="parent">
									<option value="${parent.id }"
										<c:if test="${category.parentId eq parent.id }">selected="selected"</c:if>>${parent.name }</option>
								</c:forEach>
						</select>
						</td>
						<td>二级分类：<select name="categoryId" id="categoryId">
								<c:forEach items="${children }" var="child">
									<option value="${child.id }"
										<c:if test="${book.categoryId eq child.id }">selected="selected"</c:if>>${child.name }</option>
								</c:forEach>
						</select>
						</td>
						<td></td>
					</tr>
					<tr>
						<td colspan="2"><input onclick="editForm()" type="button"
							name="method" id="editBtn" class="btn" value="编　　辑"> <input
							onclick="deleteForm()" type="button" name="method" id="delBtn"
							class="btn" value="删　　除"></td>
						<td></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
</html>
