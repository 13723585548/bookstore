$(function(){
	
	$("#purchase").validate({
		rules : {
			quantity : {
				required : true,
				digits : true,
				max : 999,
				min : 1 
			}
		},
		messages : {
			quantity : {
				required : "不能为空",
				digits : "请输入整数",
				max : "最大值999",
				min : "最小值1"
			}
		}
	}); 
	
});