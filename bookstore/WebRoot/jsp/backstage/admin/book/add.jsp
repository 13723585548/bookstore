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
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsp/backstage/admin/css/book/add.css' />">
	<link rel="stylesheet" type="text/css" href="<c:url value='/plugin/calendar/calendar.css' />">
	<script type="text/javascript" src="<c:url value='/jquery/jquery-2.2.4.js' />"></script>
	<script type="text/javascript" src="<c:url value='/plugin/upload/jquery.form.js' />"></script>
	<script type="text/javascript" src="<c:url value='/jsp/backstage/admin/js/book/add.js' />"></script>
	<script type="text/javascript" src="<c:url value='/plugin/validation/jquery.validate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsp/backstage/admin/js/book/addValidation.js' />"></script>
	<script type="text/javascript" src="<c:url value='/plugin/calendar/calendar.js' />"></script>
	
	<style type="text/css">
		html {
			font: 500 14px 'roboto';
			color: #333;
			background-color: #fafafa;
		}
		a {
			text-decoration: none;
		}
		ul, ol, li {
			list-style: none;
			padding: 0;
			margin: 0;
		}		
		
	</style>
	
  </head>
  
  <body>
	<div>
		<form enctype='multipart/form-data' action="<c:url value='/admin/uploadImage.action' />" method="post" id=image_wForm>
			<span id="img_w" onclick="javascript:$('#image_w').click();">大图</span>		
			<input id="image_w" type="file" name="image" onchange="uploadImg(this)" style="display:none;"/>
		</form>
		<form enctype='multipart/form-data' action="<c:url value='/admin/uploadImage.action' />" method="post" id=image_bForm>
			<span id="img_b" onclick="javascript:$('#image_b').click();">小图</span>
			<input id="image_b" type="file" name="image"  onchange="uploadImg(this)" style="display:none;"/>
		</form>
		
		<div style="clear: both;">&nbsp;</div>
		<form action="<c:url value='/admin/addBook.action' />" method="post" id="form" >
			<div id="hidden">
				<div id="img_w_hidden"></div>	
				<div id="img_b_hidden"></div>
			</div>
			<div>
				<ul id="bookDetail">
					<li>书名： <input id="name" type="text" name="name"
						value="Spring实战(第3版)（In Action系列中最畅销的Spring图书，近十万读者学习Spring的共同选择）"
						style="width:500px;" /></li>
					<li>当前价：<input id="currPrice" type="text" name="currPrice"
						value="40.7" style="width:50px;" /></li>
					<li>定价： <input id="price" type="text" name="price"
						value="59.0" style="width:50px;" /> 折扣：<input id="discount"
						type="text" name="discount" value="6.9" style="width:30px;" />折
					</li>
				</ul>
				<hr style="margin-left: 50px; height: 1px; color: #dcdcdc" />
				<table>
					<tr>
						<td colspan="3">作者： <input type="text" id="author"
							name="author" value="Craig Walls" style="width:150px;" />
						</td>
					</tr>
					<tr>
						<td colspan="3">出版社： <input type="text" name="press"
							id="press" value="人民邮电出版社" style="width:200px;" />
						</td>
					</tr>
					<tr>
						<td colspan="3">出版时间：<input type="text" id="publishTime" readonly
							name="publishTime" value="2013-6-1" style="width:100px;" />
							<div id="publish"></div>
							</td>
					</tr>
					<tr>
						<td>版次： <input type="text" name="edition" id="edition"
							value="1" style="width:40px;" /></td>
						<td>页数： <input type="text" name="pageNum" id="pageNum"
							value="374" style="width:50px;" /></td>
						<td>字数： <input type="text" name="wordNum" id="wordNum"
							value="48700" style="width:80px;" /></td>
					</tr>
					<tr>
						<td width="250">印刷时间：<input type="text" name="printTime" readonly
							id="printTime" value="2014-5-1" style="width:100px;" />
							<div id="print"></div>
							</td>
						
						<td width="250">开本： <input type="text" name="bookSize"
							id="bookSize" value="16" style="width:30px;" /></td>
						<td width="250">纸张： <input type="text" name="paper" id="paper"
							value="胶版纸" style="width:80px;" /></td>
					</tr>
					<tr>
						<td>一级分类：<select name="parentId" id="parentId"
							onchange="loadChildren()">
								
								<c:forEach items="${parents }" var="parent">
									<option value="${parent.id }">${parent.name }</option>
								</c:forEach>

						</select>
						</td>
						<td>二级分类：<select name="categoryId" id="categoryId">	
						</select>
						</td>
						<td></td>
					</tr>
					<tr>
						<td><input type="submit" id="btn" class="btn" value="新书上架">
						</td>
						<td></td>
						<td></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	
</body>
</html>
