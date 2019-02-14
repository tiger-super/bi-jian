$(document).ready(
		function() {
			informationLoad();
			$(".select-area-content-part")
					.click(
							function() {
								switch ($(".show-sort").attr("value")) {
								case "default":
									loadInformationFromArea($(this).text());
									break;
								case "money":
									switch ($(".show-sort-select-money").attr("value")) {
									case "0":
										loadInformationSort("1", $(this).text(), "houseMoney");
										break;
									case "1":
										loadInformationSort("0", $(this).text(), "houseMoney");
										break;
									}

									break;
								case "size":
									switch ($(".show-sort-select-size").attr("value")){
									case "0":
										loadInformationSort("1", $(this).text(), "houseSize");
										break;
									case "1":
										loadInformationSort("0",$(this).text(), "houseSize");
										break;
									}
									break;
								}

								$(".select-area-content-part").css("color",
										"black");
								$(this).css("color", "blue");
								$(".select-area-content").attr("value",
										$(this).text());
							})
			$(".show-sort-select-money").click(
					function() {
						$(".show-sort").attr("value", "money");
						let sort = $(this).attr("value");
						switchSortImage(sort, $(this));
						loadInformationSort(sort, $(".select-area-content")
								.attr("value"), "houseMoney");

					})
			$(".show-sort-select-size").click(
					function() {
						$(".show-sort").attr("value", "size");
						let sort = $(this).attr("value");
						switchSortImage(sort, $(this));
						loadInformationSort(sort, $(".select-area-content")
								.attr("value"), "houseSize");
					})
					
					$(".show-sort-select-default").click(function(){
						$(".show-sort").attr("value", "default");
						if($(".select-area-content").attr("value") == null){
							informationLoad();
							
						}else{
							loadInformationFromArea($(".select-area-content").attr("value"));
						}
						$(".show-sort-select").css("background-color", "white");
						$(this).css("background-color", "blue");
					})
		})
function switchSortImage(sort, thisDiv) {
	$(".show-sort-select").css("background-color", "white");
	thisDiv.css("background-color", "blue");
	if (sort == 0) {
		thisDiv.attr("value", "1");
		thisDiv.children(".show-sort-select-img").attr("src",
				"/static/img/arrow-down.png");
	} else {
		thisDiv.attr("value", "0");
		thisDiv.children(".show-sort-select-img").attr("src",
				"/static/img/arrow-up.png");
	}
}
function informationLoad() {
	$
			.ajax({
				url : '/house/get/house/list',
				dataType : "json",
				type : "post",
				data : {
					"houseInfo.houseSellWay" : $(".logo").attr("value")
				},
				success : function(result) {
					let length = result.length;
					$(".house-information-list-window").empty();
					$(".information-total").text(length);
					for (let i = 0; i < length; i++) {
						renderIngInformation(result[i]);
					}

					$(".house-information-img")
							.click(
									function() {
										let houseId = $(this).parents(
												".house-information-div").attr(
												"value");
										window.location.href = "/house/show/house/info?houseId="
												+ houseId;
									})

					$(".house-information-word-title")
							.click(
									function() {
										let houseId = $(this).parents(
												".house-information-div").attr(
												"value");
										window.location.href = "/house/show/house/info?houseId="
												+ houseId;
									})

				}
			});
}

function renderIngInformation(house) {
	$(".house-information-list-window")
			.append(
					"<div class='col-sm-9 house-information-div'  value="
							+ house.houseId
							+ ">"
							+ "<div class='house-information-img col-sm-4'><img src='http://localhost:8080/static/publish-house-img/"
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

function loadInformationFromArea(area) {

	$.ajax({
		url : '/house/get/house/list',
		dataType : "json",
		type : "post",
		data : {
			"houseInfo.houseSellWay" : $(".logo").attr("value"),
			"houseAddressArea" : area
		},
		success : function(result) {
			let length = result.length;
			$(".house-information-list-window").empty();
			$(".information-total").text(length);
			for (let i = 0; i < length; i++) {
				renderIngInformation(result[i]);
			}
		}
	})

}

function loadInformationSort(sort, area, condition) {
	let data;
	if (area != "") {
		data = {
			"houseInfo.houseSellWay" : $(".logo").attr("value"),
			"houseAddressArea" : area,
			"condition" : condition,
			"sort" : sort
		}
	} else {
		data = {
			"houseInfo.houseSellWay" : $(".logo").attr("value"),
			"condition" : condition,
			"sort" : sort
		}
	}
	$.ajax({
		url : '/house/get/house/list',
		dataType : "json",
		type : "post",
		data : data,
		success : function(result) {
			let length = result.length;
			$(".house-information-list-window").empty();
			$(".information-total").text(length);
			for (let i = 0; i < length; i++) {
				renderIngInformation(result[i]);
			}
		}
	})
}
