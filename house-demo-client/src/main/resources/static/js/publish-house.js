var isSellWay = false;
// 地址
var isHouseAddress = false;
// 房屋详细地址
var isHouseDetailedAddress = false;
// 房屋类型
var isHouseType = false;
// 房屋大小
var isHouseSize = false;
// 房屋结构
var isHouseStructure = false;
// 房屋押金
var isDepoitWay = false;
// 房屋价钱
var isMoney = false;
// 房屋姓名
var isName = false;
// 房屋朝向
var isDirection = false;
// 房屋描述
var isDescripe = false;
// 房屋配置
var isHouseDevice = false;
$(document).ready(function() {
	$(".select-address-content").hide();
	$(".province").click(function() {
		showProvince();
	})
	$(".city").click(function() {
		showCity();
	})
	$(".area").click(function() {
		showArea();
	})

	$(".send").click(function() {
			var JsonData = decodeURIComponent($("#publish").serialize(), true);
			JsonData = transformationJson(JsonData);
			var Data = JSON.parse(JsonData);
			$.ajax({
				url : '/house/session/publish/house',
				type : "post",
				dataType : "json",
				data : Data,
				async : false,
				success : function(result) {
					if(result.result == "true"){
						window.location.href="/house/show/publish/success";
					}
				}
			});
	})
})
var provinceClick = false;
var cityClick = false;
var areaClick = false;
function showProvince() {
	if (provinceClick) {
		provinceClick = false;
		$(".province").children(".select-content").hide();
		$(".province-select").children(".select-img").css("background-image",
				"url(http://47.106.244.224:8088/static/img/down.png)");
	} else {
		provinceClick = true;
		$(".province").children(".select-content").show();
		$(".province-select").children(".select-img").css("background-image",
				"url(http://47.106.244.224:8088/static/img/up.png)");
		$(".province").children(".select-content");
		$(".province").children(".select-content").children(
				".select-content-ul").empty();
		$
				.ajax({
					url : '/house/gain/province',
					type : "post",
					dataType : "json",
					success : function(result) {
						for (let i = 0; i < result.length; i++) {
							$(".province").children(".select-content")
									.children(".select-content-ul").append(
											'<li>' + result[i] + '</li>')
						}

						$(".select-content-ul").children("li").mouseleave(
								function() {
									$(this).css({
										"background-color" : "white"
									});
								});
						$(".select-content-ul").children("li").mouseenter(
								function() {
									$(this).css({
										"background-color" : "#F8F8F8"
									});
								});

						$(".province-select-content-ul")
								.children("li")
								.click(
										function() {
											var value = $(this).text();
											$(".province-select-text").text(
													value);
											$(".province").children(
													".select-content").hide();
											$(".province-select")
													.children(".select-img")
													.css("background-image",
															"url(http://47.106.244.224:8088/static/img/down.png)");
										})
					}
				});
	}
}

function showCity() {
	var province = $(".province-select-text").text();
	if (province != "省份") {
		if (cityClick) {
			cityClick = false;
			$(".city").children(".select-content").hide();
			$(".city-select").children(".select-img").css("background-image",
					"url(http://47.106.244.224:8088/static/img/down.png)");

		} else {
			cityClick = true;
			$(".city").children(".select-content").show();
			$(".city-select").children(".select-img").css("background-image",
					"url(http://47.106.244.224:8088/static/img/up.png)");
			$(".city").children(".select-content");
			$(".city").children(".select-content").children(
					".select-content-ul").empty();
			$
					.ajax({
						url : '/house/gain/city',
						type : "post",
						dataType : "json",
						data : {
							"province" : province
						},
						success : function(result) {
							for (let i = 0; i < result.length; i++) {
								$(".city").children(".select-content")
										.children(".select-content-ul").append(
												'<li>' + result[i] + '</li>')
							}

							$(".select-content-ul").children("li").mouseleave(
									function() {
										$(this).css({
											"background-color" : "white"
										});
									});
							$(".select-content-ul").children("li").mouseenter(
									function() {
										$(this).css({
											"background-color" : "#F8F8F8"
										});
									});

							$(".city-select-content-ul")
									.children("li")
									.click(
											function() {
												var value = $(this).text();
												$(".city-select-text").text(
														value);
												$(".city").children(
														".select-content")
														.hide();
												$(".city-select")
														.children(".select-img")
														.css(
																"background-image",
																"url(http://47.106.244.224:8088/static/img/down.png)");
											});

						}
					})
		}

	}

}

function showArea() {
	var city = $(".city-select-text").text();
	var province = $(".province-select-text").text();
	if (city != "城市") {
		if (areaClick) {
			areaClick = false;
			$(".area").children(".select-content").hide();
			$(".area-select").children(".select-img").css("background-image",
					"url(http://47.106.244.224:8088/static/img/down.png)");
		} else {
			areaClick = true;
			$(".area").children(".select-content").show();
			$(".area-select").children(".select-img").css("background-image",
					"url(http://47.106.244.224:8088/static/img/up.png)");
			$(".area").children(".select-content");
			$(".area").children(".select-content").children(
					".select-content-ul").empty();
			$.ajax({
						url : '/house/gain/area',
						type : "post",
						dataType : "json",
						data : {
							"province" : province,
							"city" : city
						},
						success : function(result) {
							for (let i = 0; i < result.length; i++) {
								$(".area").children(".select-content")
										.children(".select-content-ul").append(
												'<li>' + result[i] + '</li>')
							}

							$(".select-content-ul").children("li").mouseleave(
									function() {
										$(this).css({
											"background-color" : "white"
										});
									});
							$(".select-content-ul").children("li").mouseenter(
									function() {
										$(this).css({
											"background-color" : "#F8F8F8"
										});
									});

							$(".area-select-content-ul")
									.children("li")
									.click(
											function() {
												var value = $(this).text();
												$(".area-select-text").text(
														value);
												$(".area").children(
														".select-content")
														.hide();

												$(".area-select")
														.children(".select-img")
														.css(
																"background-image",
																"url(http://47.106.244.224:8088/static/img/down.png)");
											});

						}
					})
		}

	}
}
function transformationJson(data) {
	var houseAddressProvince = $(".province-select-text").text();
	var houseAddressCity = $(".city-select-text").text();
	var houseAddressArea = $(".area-select-text").text();
	var houseStructure = $(".room").val() + $(".office").val()
			+ $(".toilet").val();

	var text = $(".house-descripe").val().replace(/\s|\xA0/g,"");
	var index = data.lastIndexOf("&houseInfo.houseDescripe");
	data = data.substring(0,index);
	data = data + "&houseAddressProvince=" + houseAddressProvince
			+ "&houseAddressCity=" + houseAddressCity + "&houseAddressArea="
			+ houseAddressArea + "&houseInfo.houseStructure=" + houseStructure;
	data = data.replace(/&/g, "\",\"");
	data = data.replace(/=/g, "\":\"");
	data = data+"\",\"houseInfo.houseDescripe\":\""+text;
	data = data.replace(/[\r\n]/g, "<br/>");
	data = "{\"" + data + "\"}";
	return data;
}

function submitform() {
	$.ajax({
		url : "/house/session/publish/house/upload",
		type : "post",
		data : new FormData($('#fileUploadFrom')[0]),
		processData : false,
		contentType : false,
		success : function(result) {
			$(".select-upload-img-show").empty();
			for (let i = 0; i < result.length; i++) {
				$(".select-upload-img-show").append(
						"<img src=" + result[i] + ">");
				$(".select-upload-button").css("padding-left", "270px");
				$(".select-upload-button").css("padding-top", "20px");
			}
		}

	})
}

function checkLeave(){ 
　　　$.ajax({
	url : "/house/delete/session",
	type : "post",
	success : function(result) {
		    document.cookie = folder + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;'
	}

})
　　　} 