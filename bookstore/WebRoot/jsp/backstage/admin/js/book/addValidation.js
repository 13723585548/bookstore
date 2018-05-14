$(function(){
	
	$("#form").validate({
	
		rules : {
			name : {
				required : true		
			},
			currPrice : {
				required : true,
				number : true,
				max : 999,
				min : 1
			},
			price : {
				required : true,
				number : true,
				max : 999,
				min : 1
			},
			discount : {
				required : true,
				number : true,
				max : 9.9,
				min : 0
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
			printTime : {
				required : true,
				dateISO : true
			},
			edition : {
				required : true,
				digits : true,
				max : 999,
				min : 1
			},
			pageNum : {
				required : true,
				digits : true,
				max : 9999,
				min : 1
			},
			wordNum : {
				required : true,
				digits : true,
				max : 999999999,
				min : 1
			},
			bookSize : {
				required : true,
				digits : true,
				max : 99999,
				min : 1
			},
			paper : {
				required : true
			
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
				number : "请输入合法数字",
				max : "最大值999",
				min : "最小值1"
				
			},
			price : {
				required : "价格不能为空",
				number : "请输入合法数字",
				max : "最大值999",
				min : "最小值1"
				
			},
			discount : {
				required : "折扣不能为空",
				number : "请输入合法数字",
				max : "最大值9.9",
				min : "最小值0"
				
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
			printTime : {
				required : "出版日期不能为空",
				dateISO : "日期格式不正确"
			},
			edition : {
				required : "版次不能为空",
				digits : "请输入合法数字",
				max : "最大值999",
				min : "最小值1"
			},
			pageNum : {
				required : "页数不能为空",
				digits : "请输入合法数字",
				max : "最大值9999",
				min : "最小值1"
			},
			wordNum : {
				required : "字数不能为空",
				digits : "请输入合法数字",
				max : "最大值999999999",
				min : "最小值1"
			},
			bookSize : {
				required : "开本不能为空",
				digits : "请输入合法数字",
				max : "最大值99999",
				min : "最小值1'"
			},
			paper : {
				required : "纸张不能为空"
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