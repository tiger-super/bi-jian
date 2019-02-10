let imageIndex = 0;
let maxImageVlaue ;
$(document).ready(function() {
	getPublisherInfo();
	getHouseInfoImage();
	$(".switch-left").click(function(){
		if(imageIndex > 0){
		imageIndex = imageIndex - 1;
		$(".house-info-list-ul").children("li").children("img").css("opacity","0.6");
		$(".house-info-list-ul").children("li").eq(imageIndex).children("img").css("opacity","1");
		 let imageAddress =  $(".house-info-list-ul").children("li").eq(imageIndex).children("img").attr("src");
	      $(".house-info-img-show").attr("src",imageAddress);
		 moveImage(imageIndex);
		}
	})
	$(".switch-right").click(function(){
		if(imageIndex < maxImageVlaue-1){
			imageIndex = imageIndex + 1;
			$(".house-info-list-ul").children("li").children("img").css("opacity","0.6");
			$(".house-info-list-ul").children("li").eq(imageIndex).children("img").css("opacity","1");
			 let imageAddress =  $(".house-info-list-ul").children("li").eq(imageIndex).children("img").attr("src");
		      $(".house-info-img-show").attr("src",imageAddress);
			 moveImage(imageIndex);
			}
	})
})

function getPublisherInfo() {
	$.ajax({
		url : '/house/get/publisher/info',
		dataType : "json",
		type : "post",
		data : {
			"publisherId" : $(".publish").attr("publishId")
		},
		success : function(result) {
			$(".publish").html(result.customerName + "(发布人)");
			var publishPersonImg = result.customerHeadImageAddress;
			if (publishPersonImg == null) {
				$(".publish-person-img").attr("src",
						"/static/img/renyuanzengjia.png");
			} else {

				$(".publish-person-img").attr(
						"src",
						"http://localhost:8080/static/customerPhoto/"
								+ publishPersonImg);
			}

			$(".publish-person-phone-value").html(result.customerPhone);
		}
	});

}
function getHouseInfoImage() {
    var folder = $(".house-info-img-window").attr("value");
	$.ajax({
		url : '/house/get/house/image',
		dataType : "json",
		type : "post",
		data : {
			"houseImageAddress" :  folder
		},
		success : function(result) {
			if(result != null && result.length != 0){
			$(".house-info-img-show").attr("src","http://localhost:8080/static/publish-house-img/"+folder+"/"+result[0]);
		
			for(let i = 0 ; i < result.length ; i++){
				let imageAddress="http://localhost:8080/static/publish-house-img/"+folder+"/"+result[i];
				$(".house-info-list-ul").append("<li class='imageAddress'><img src='"+imageAddress+"'></li>");
			}

			maxImageVlaue = $(".house-info-list-ul li").length;
			$(".house-info-list-ul").css("width",$(".house-info-list-ul li").length*84+"px");
			$(".house-info-list-ul").children("li").eq(0).children("img").css("opacity","1");
			$(".house-info-list-ul").children("li").css("cursor","pointer");
			// 图片切换
			$(".house-info-list-ul").children("li").click(function(){
				$(".house-info-list-ul").children("li").children("img").css("opacity","0.6");
		      $(this).children("img").css("opacity","1");
		      let imageAddress =  $(this).children("img").attr("src");
		      $(".house-info-img-show").attr("src",imageAddress);
		      // 图片数量
		      imageIndex = $(this).index();
		      moveImage();
			})
			}
		}
	})
}
function moveImage(){
	if(maxImageVlaue>3){
		if(imageIndex >= 3 && imageIndex <= maxImageVlaue-4){
			$(".house-info-list-ul").css("left",-(imageIndex-1)*84);
		}else if(imageIndex < 3){
			$(".house-info-list-ul").css("left",0);
		}else{
			$(".house-info-list-ul").css("left",-(maxImageVlaue-4)*84);
		}
	}
	
}