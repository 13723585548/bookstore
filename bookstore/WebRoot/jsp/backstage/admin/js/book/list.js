$(function() {
	$(".inner").hover(function() {
		$(this).css("border", "3px solid #FFCFB1");
	}, function() {
		$(this).css("border", "3px solid #ffffff");
	});
	
	/*$.ajax({
		   type: "POST",
		   url: "/bookstore/admin/findCategoryAllAdmin.action",
		   data: "",
		   dataType: "json",
		   success: function(result){
			   for(var i = 0; i < result.length; i++) {
				   $('#child').append("<optgroup label=" + result[i].name + ">");
				   for(var j = 0; j < result[i].children.length; j++) {
					   $('#child').append("<option value=" + result[i].children[j].id + ">" + result[i].children[j].name + "</option>");
				   }
				   $('#child').append("</optgroup>");
			   }
		   }
		});*/
});

function loadBookList() {
	var id = $('#child option:selected').val();
	window.location.href = "/bookstore/admin/findBookByConditionAdmin.action?condition=categoryId&value=" + id;
}
