function switchSecond(obj) {
	
	var parentId = $(obj).attr("id");
	$("." + parentId + "second").children().slideToggle(150);
	
}

$(function(){
	$("td").hide();
	$("tr:not([class])").children().show();
});

