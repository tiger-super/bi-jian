let pageCurrent = 1;
$(document).ready(function() {
	loadHouseInforMation();
})
function loadHouseInforMation(){
	$.ajax({
		url : '/manage/get/auditing/houseInformation',
		dataType : "json",
		type : "post",
		data : {"pageCurrent":pageCurrent},
		success : function(result) {
			let list = result.list;
			$(".house-information-list-window").empty();
			for(let i = 0; i < list.length; i++){
				 renderIngInformation(list[i]);
			}
			$(".approval").click(function(){
				let id = $(this).parents(".house-information-div").attr("value");
				window.location.href="/manage/show/house/information?houseId="+id;          
			})
			 showPageView(result.page);
		}
	});
	
}
function showPageView(page) {
	pageCurrent = page.pageCurrent;
	$.ajax({
		url : '/manage/get/show/page',
		dataType : "json",
		type : "post",
		data : page,
		success : function(result) {
			$(".page-show-content").empty();
			for(let i = 0 ; i < result.length ; i ++){
				switch(result[i]){
				case "上一页":
					$(".page-show-content").append("<button class='btn upper' >"+result[i]+"</button>")
					break;
				case "下一页":
					$(".page-show-content").append("<button class='btn next' >"+result[i]+"</button>")
					break;
				case "...":
				$(".page-show-content").append("<button class='btn next-display disabled' >"+result[i]+"</button>")
				break;
				case ""+(page.pageCurrent):
					$(".page-show-content").append("<button class='btn btn-info page' >"+result[i]+"</button>")
					break;
				default:
					$(".page-show-content").append("<button class='btn page' >"+result[i]+"</button>")
					break;
				}
				
			}
			$(".page").click(function(){
				pageCurrent = parseInt($(this).text());
				loadHouseInforMation();
			})
			$(".next").click(function(){
				pageCurrent = pageCurrent+1;
				loadHouseInforMation();
			})
			$(".upper").click(function(){
				pageCurrent = pageCurrent-1;
				loadHouseInforMation();
			})
			 $("#load",parent.document).css("height",$(document).outerHeight(true)+"px");
		}
	})
}


function renderIngInformation(house) {
	$(".house-information-list-window")
			.append(
					"<div class='col-sm-12 house-information-div'  value="
							+ house.houseId
							+ ">"
							+ "<div class='house-information-img col-sm-3'><img src='"
							+ house.houseInfo.houseImageAddress
							+ "'></div>"
							+ "<div class='col-sm-9' style='padding: 0px'><div class='house-information-word col-sm-10'>"
							+ "<div class='house-information-word-title col-sm-12'>"
							+ house.houseName
							+ "</div></div>"
							+ "<div class='house-information-word-left col-sm-10'><div class='col-sm-12'><div class='col-sm-12'>"
							+ "<img src='/static/img/house.png' class='house-information-word-left-img'> <span>"
							+ house.houseInfo.houseStructure
							+ "</span><span>"
							+ "|</span><span>"
							+ house.houseInfo.houseSize
							+ "</span><span>|</span><span>"
							+ house.houseInfo.houseDirection
							+ "</span></div>"
							+ "</div><div class='col-sm-12'><div class='col-sm-12'><img src='/static/img/place2.png'class='house-information-word-left-img'>"
							+ "<span>"
							+ house.houseAddressInfo
							+ "</span></div></div><div class='col-sm-12'><div class='col-sm-12'><img src='/static/img/time.png'"
							+ "class='house-information-word-left-img' style='width:20px;height:20px;margin-right:5px;margin-left:2px;'>"
							+ house.applicationTime
							+ "前申请</span>"
							+ "</div></div></div> <div class='col-sm-2 button-div'><button type='button' class='btn btn-default btn-sm btn-info approval'>审阅</button></div>");
}
