$(function(){
	loadChildren();
	$("#btn").addClass("btn1");
	$("#btn").hover(
		function() {
			$("#btn").removeClass("btn1");
			$("#btn").addClass("btn2");
		},
		function() {
			$("#btn").removeClass("btn2");
			$("#btn").addClass("btn1");
		}
	);

	$('#print').calendar({
	    trigger: '#printTime',
	    zIndex: 999,
		format: 'yyyy-mm-dd',
	    onSelected: function (view, date, data) {
	        console.log('event: onSelected');
	    },
	    onClose: function (view, date, data) {
	        console.log('event: onClose');
	        console.log('view:' + view);
	        console.log('date:' + date);
	        console.log('data:' + (data || 'None'));
	    }
	});

	$('#publish').calendar({
	    trigger: '#publishTime',
	    zIndex: 999,
		format: 'yyyy-mm-dd',
	    onSelected: function (view, date, data) {
	        console.log('event: onSelected');
	    },
	    onClose: function (view, date, data) {
	        console.log('event: onClose');
	        console.log('view:' + view);
	        console.log('date:' + date);
	        console.log('data:' + (data || 'None'));
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

function uploadImg(image) {

	$(image).parent().ajaxSubmit({
		success : function (data) {
			$(image).prev().empty();
			var img = $("<img />");
			img.attr("src",data);
			$(image).prev().append(img);
			if(image.id == "image_w"){
				$("#img_w_hidden").html("<input type='hidden' name='imageW' value='" + data + "' id='imageW' />");
			} else {
				$("#img_b_hidden").html("<input type='hidden' name='imageB' value='" + data + "'  id='imageB' />");
			}
		}
		
	});
}

/*function validImg() {
	var imageW = $("#imageW").val();
	var imageB = $("#imageB").val();
	if(!imageW || !imageB) {
		alert("大图、小图不能为空！");
		return false;
	}
	return true;
}
*/


