$(document).ready(function() {
	$.ajax({
			url : '/house/get/publisher/info',
			dataType : "json",
			type : "post",	
			data:{"publisherId":$(".publish").attr("publishId")},
			success : function(result) {
				$(".publish").html(result.customerName+"(发布人)");
				var publishPersonImg = result.customerHeadImageAddress;
				if(publishPersonImg == null){
					$(".publish-person-img").attr("src","/static/img/renyuanzengjia.png");
				}else{
					
					$(".publish-person-img").attr("src", "http://localhost:8080/static/customerPhoto/"+publishPersonImg);	
				}
				
				$(".publish-person-phone-value").html();
			}
	});
})
