$(function () {
	// 日期框
	/*$("#publishtime").datepick({dateFormat:"yy-mm-dd"});
	$("#printtime").datepick({dateFormat:"yy-mm-dd"});*/

	// 编辑和删除按钮样式
	$("#editBtn").addClass("editBtn1");
	$("#delBtn").addClass("delBtn1");
	$("#editBtn").hover(
		function() {
			$("#editBtn").removeClass("editBtn1");
			$("#editBtn").addClass("editBtn2");
		},
		function() {
			$("#editBtn").removeClass("editBtn2");
			$("#editBtn").addClass("editBtn1");
		}
	);
	$("#delBtn").hover(
		function() {
			$("#delBtn").removeClass("delBtn1");
			$("#delBtn").addClass("delBtn2");
		},
		function() {
			$("#delBtn").removeClass("delBtn2");
			$("#delBtn").addClass("delBtn1");
		}
	);
});

$(function() {
	$("#box").attr("checked", false);
	$("#formDiv").css("display", "none");
	$("#show").css("display", "");	
	
	// 操作和显示切换
	$("#box").click(function() {
		var bool = $(this).is(':checked');
		/*var bool = $(this).attr("checked");*/
		if(bool) {
			$("#show").css("display", "none");
			$("#formDiv").css("display", "");
		} else {
			$("#formDiv").css("display", "none");
			$("#show").css("display", "");		
		}
	});
});


function loadChildren() {
	/*
	1. 获取pid
	2. 发出异步请求，功能之：
	  3. 得到一个数组
	  4. 获取id元素(<select>)，把内部的<option>全部删除
	  5. 添加一个头（<option>请选择2级分类</option>）
	  6. 循环数组，把数组中每个对象转换成一个<option>添加到cid中
	*/
	// 1. 获取pid
	var parentId = $("#parentId").val();
	 
	// 2. 发送异步请求
	$.ajax({
		async:true,
		cache:false,
		url : "/bookstore/admin/ajaxFindChildren.action",
		data : {
			parentId : parentId
		},
		type : "POST",
		dataType : "json",
		success:function(arr) {
			// 3. 得到id，删除它的内容
			$("#categoryId").empty();//删除元素的子元素
			//$("#categoryId").append($("<option>====请选择2级分类====</option>"));//4.添加头
			// 5. 循环遍历数组，把每个对象转换成<option>添加到cid中
			for(var i = 0; i < arr.length; i++) {
				var option = $("<option>").val(arr[i].id).text(arr[i].name);
				$("#categoryId").append(option);
			} 
		}
	});
}

/*
 * 点击编辑按钮时执行本函数
 */
function editForm() {
	$("#form").attr("action", "/bookstore/admin/editBook.action");
	$("#form").submit();
}
/*
 * 点击删除按钮时执行本函数
 */
 function deleteForm() {
	 $("#form").attr("action", "/bookstore/admin/delBook.action");
	$("#form").submit();	
}