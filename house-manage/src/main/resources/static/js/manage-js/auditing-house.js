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
			 $("#load",parent.document).css("height",$(document).outerHeight(true)+"px");
			  console.log($(document).outerHeight(true))
		}
	});
	
}
function showPageView(page) {
	pageCurrent = page.pageCurrent;
	$.ajax({
		/*url : '/house/get/show/page',
		dataType : "json",
		type : "post",
		data : page,*/
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
				 informationLoad(addJson(getJson(),"pageCurrent",parseInt($(this).text())));
			})
			$(".next").click(function(){
				pageCurrent = pageCurrent+1;
				 informationLoad(addJson(getJson(),"pageCurrent",pageCurrent));
			})
			$(".upper").click(function(){
				pageCurrent = pageCurrent-1;
				 informationLoad(addJson(getJson(),"pageCurrent",pageCurrent));
			})
		}
	})
}


function renderIngInformation(house) {
	$(".house-information-list-window")
			.append(
					"<div class='col-sm-9 house-information-div'  value="
							+ house.houseId
							+ ">"
							+ "<div class='house-information-img col-sm-4'><img src='/static/publish-house-img/"
							+ house.houseInfo.houseImageAddress
							+ "'></div>"
							+ "<div class='col-sm-8' style='padding: 0px'><div class='house-information-word col-sm-10'>"
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
							+ "</span></div></div><div class='col-sm-12'><div class='col-sm-12'><img src='/static/img/stars.png'"
							+ "class='house-information-word-left-img'> <span>"
							+ house.followNumber
							+ "</span><span>人关注/</span><span>"
							+ house.housePublisherTime
							+ "发布</span>"
							+ "</div></div></div><div class='house-information-word-right col-sm-2'><span class='house-money'>"
							+ house.houseInfo.houseMoney
							+ "</span>"
							+ "<span style='color: red'>万</span></div></div></div></div>");
}
