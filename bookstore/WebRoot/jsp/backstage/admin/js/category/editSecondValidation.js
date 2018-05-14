$(function(){
	$("#editSecond").validate({
		rules : {
			name : {
				required : true		
			},
			desc : {
				required : true	
			}
		},
		messages : {
			name : {
				required : "分类名不能为空"
			},
			desc : {
				required : "分类描述不能为空"
			}
		},
		errorPlacement: function(error, element) {   
			error.appendTo(element.parent().next());
		}
	});
});