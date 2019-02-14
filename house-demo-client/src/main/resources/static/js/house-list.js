$(document).ready(function() {
	informationLoad();
	$(".select-area-content-part").click(function(){
		loadInformationFromArea($(this).text());
		$(".select-area-content-part").css("color","black")
		$(this).css("color","blue");
	})
})


function informationLoad(){
	$.ajax({
		url : '/house/get/house/list',
		dataType : "json",
		type : "post",
		data:{"houseInfo.houseSellWay":$(".logo").attr("value")},
		success : function(result) {
			let length = result.length;
			$(".house-information-list-window").empty();
			$(".information-total").text(length);
			for(let i = 0 ; i < length ; i++){
				renderIngInformation(result[i]);
			}
			
			$(".house-information-img").click(function(){
				let houseId = $(this).parents(".house-information-div").attr("value");
				window.location.href = "/house/show/house/info?houseId="+houseId;
			})
			
			$(".house-information-word-title").click(function(){
				let houseId = $(this).parents(".house-information-div").attr("value");
				window.location.href = "/house/show/house/info?houseId="+houseId;
			})
		}
	});	
}


function renderIngInformation(house){
	$(".house-information-list-window").append("<div class='col-sm-9 house-information-div'  value="+house.houseId+">"+
			"<div class='house-information-img col-sm-4'><img src='http://localhost:8080/static/publish-house-img/"+house.houseInfo.houseImageAddress+"'></div>"+
			"<div class='col-sm-8' style='padding: 0px'><div class='house-information-word col-sm-10'>"+
			"<div class='house-information-word-title col-sm-12'>"+house.houseName+"</div></div>"+
			"<div class='house-information-word-left col-sm-10'><div class='col-sm-12'><div class='col-sm-12'>"+
			"<img src='/static/img/house.png' class='house-information-word-left-img'> <span>"+house.houseInfo.houseStructure+"</span><span>"+
			"|</span><span>"+house.houseInfo.houseSize+"</span><span>|</span><span>"+house.houseInfo.houseDirection+"</span></div>"+
			"</div><div class='col-sm-12'><div class='col-sm-12'><img src='/static/img/place2.png'class='house-information-word-left-img'>"+
			"<span>"+house.houseAddressInfo+"</span></div></div><div class='col-sm-12'><div class='col-sm-12'><img src='/static/img/stars.png'"+
			"class='house-information-word-left-img'> <span>"+house.followNumber+"</span><span>人关注/</span><span>"+house.housePublisherTime+"发布</span>"+
			"</div></div></div><div class='house-information-word-right col-sm-2'><span class='house-money'>"+ house.houseInfo.houseMoney+"</span>"+
	"<span style='color: red'>万</span></div></div></div></div>");
	
}

function loadInformationFromArea(area){
	$.ajax({
		url : '/house/get/house/list',
		dataType : "json",
		type : "post",
		data:{"houseInfo.houseSellWay":$(".logo").attr("value"),"houseAddressArea":area},
		success : function(result) {
			let length = result.length;
			$(".house-information-list-window").empty();
			$(".information-total").text(length);
			for(let i = 0 ; i < length ; i++){
				renderIngInformation(result[i]);
			}
		}})
	}

