$(function(){
	$("#form").validate({
		rules : {
			name : {
				required : true		
			},
			currPrice : {
				required : true,
				number : true
			},
			price : {
				required : true,
				number : true
			},
			discount : {
				required : true,
				number : true
			},
			author : {
				required : true
			},
			press : {
				required : true
			},
			publishTime : {
				required : true,
				dateISO : true
			},
			parentId : {
				required : true
			},
			categoryId : {
				required : true
			}

		},
		messages : {
			name : {
				required : "图书名称不能为空"
			},
			currPrice : {
				required : "当前价不能为空",
				number : "请输入合法数字"
			},
			price : {
				required : "价格不能为空",
				number : "请输入合法数字"
			},
			discount : {
				required : "折扣不能为空",
				number : "请输入合法数字"
			},
			author : {
				required : "作者不能为空"
			},
			press : {
				required : "出版社不能为空"
			},
			publishTime : {
				required : "出版日期不能为空",
				dateISO : "日期格式不正确"
			},
			parentId : {
				required : "请选择一级分类"
			},
			categoryId : {
				required : "请选择二级分类"
			}	
		}
	});
});