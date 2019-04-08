$(document).ready(function() {
					informationLoad(getJson());
					$(".select-area-content-part").click(
							function(){
							 addCondtion("houseAddressArea",$(this).text());
							 informationLoad(getJson());
								$(".select-area-content-part").css("color",
										"black");
								$(this).css("color", "blue");
								$(".select-area-content").attr("value",
										$(this).text());
							})
					$(".show-sort-select-money").click(
							function() {
								 addCondtion("Condition","houseMoney");
								 let sort = $(this).attr("value");
								 switchSortImage(sort, $(this));
								 informationLoad(getJson());
								 $(".show-sort-select").css(
											"background-color", "white");
									$(this).css("background-color", "blue");
						
							})
					$(".show-sort-select-size").click(
							function() {
								 addCondtion("Condition","houseSize");
								 let sort = $(this).attr("value");
								switchSortImage(sort, $(this));
								informationLoad(getJson());
								$(".show-sort-select").css(
										"background-color", "white");
								$(this).css("background-color", "blue");
							})

					$(".show-sort-select-default")
							.click(
									function() {
										addCondtion("Condition","default");
										 let sort = $(this).attr("value");
										switchSortImage(sort, $(this));
										informationLoad(deleteSort(getJson()));
										$(".show-sort-select").css(
												"background-color", "white");
										$(this).css("background-color", "blue");
									})
				})
function switchSortImage(sort, thisDiv) {
	$(".show-sort-select").css("background-color", "white");
	thisDiv.css("background-color", "blue");
	if (sort == 0) {
		addCondtion("sort","0");
		thisDiv.attr("value", "1");
		thisDiv.children(".show-sort-select-img").attr("src",
				"/static/img/arrow-down.png");
	} else {
		addCondtion("sort","1");
		thisDiv.attr("value", "0");
		thisDiv.children(".show-sort-select-img").attr("src",
				"/static/img/arrow-up.png");
	}
}
function informationLoad(data) {
	$.ajax({
		url : '/house/get/house/list',
		dataType : "json",
		type : "post",
		data : data,
		success : function(result) {
			if(result.result){
			let length = result.page.pageTotal;
			$(".house-information-list-window").empty();
			$(".information-total").text(length);
			for (let i = 0; i < result.list.length; i++) {
				renderIngInformation(result.list[i]);
			}
			bindingEvent();
			showPageView(result.page);
			}else{
				window.location.href = "/house/show/selectAreaView";
			}
		}
	});
}

function bindingEvent() {
	$(".house-information-img").click(function() {
		let houseId = $(this).parents(".house-information-div").attr("value");
		window.location.href = "/house/show/house/info?houseId=" + houseId;
	})

	$(".house-information-word-title").click(function() {
		let houseId = $(this).parents(".house-information-div").attr("value");
		window.location.href = "/house/show/house/info?houseId=" + houseId;
	})

}

function renderIngInformation(house) {
	console.log(house);
	let moneyCompany;
	if(house.houseInfo.houseSellWay == '出售'){
		 moneyCompany = "万";
	}else{
		moneyCompany = "元/月";
	}
	$(".house-information-list-window")
			.append(
					"<div class='col-sm-9 house-information-div'  value="
							+ house.houseId
							+ ">"
							+ "<div class='house-information-img col-sm-4'><img src='"
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
							+ "<span style='color: red'>"+moneyCompany+"</span></div></div></div></div>");
}

let pageCurrent = 1;
function showPageView(page) {
	pageCurrent = page.pageCurrent;
	$.ajax({
		url : '/house/get/show/page',
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
// 添加数据
function addCondtion(key,value){
	let json = getJson();
	if(json[key] != undefined){
		json[key] = value;
		getString(json);
	}else{
		let newValue = $(".content").attr("value")+"&"+key+"="+value;
		$(".content").attr("value",newValue);
	}
}

function getJson(){
	let value = $(".content").attr("value");
	let data ;
	if(value != ""){
		data = transformationJson(value);
	}
	// 将json字符串转换为json对象
	return JSON.parse(data);
}
function addJson(json,key,value){
	json[key] = value;
	return json;
}
// 由json字符串转换为字符串
function getString(json){
	let data = JSON.stringify(json)
	data = data.replace(/{"/g, "");
	data = data.replace(/"}/g, "");
	data = data.replace(/","/g, "&");
	data = data.replace(/":"/g, "="); 
	$(".content").attr("value",data); 
	
}
// 将字符串转换为json字符串
function transformationJson(data) {
	data = data.replace(/&/g, "\",\"");
	data = data.replace(/=/g, "\":\"");
	data = "{\"" + data + "\"}";
	return data;
}


function deleteSort(json){
	if(json["sort"] != undefined){
		delete json["sort"];		
	}
	return json;
}