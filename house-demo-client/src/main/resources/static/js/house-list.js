$(document).ready(function() {

	$.ajax({
			url : '/house/get/house/list',
			dataType : "json",
			type : "post",
			data:{"houseInfo.houseSellWay":$(".logo").attr("value")},
			success : function(result) {
				console.log("x");
				console.log(result)
			}
	});
})
