$(function() { 
	
	showTotal();
	
});

function showTotal(){
	var total = 0;
	$(".subtotal").each(function() {
		total += Number($(this).text());
	});
	$("#total").text(total.toFixed(2));
}