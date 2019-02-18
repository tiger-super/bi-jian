let imageIndex = 0;
let maxImageVlaue;
$(document).ready(
		function() {
			baiduAPIRead();
			getPublisherInfo();
			getHouseInfoImage();
		$(".collection").click(function(){
			let value = $(".collection").attr("value");
				addOrDeleteCollection(value)
			})
			$(".select-button").click(function() {
				if ($(".select-distacne-input").val() != null) {
					calculateDistance()
				}
			})
			$(".switch-left")
					.click(
							function() {
								if (imageIndex > 0) {
									imageIndex = imageIndex - 1;
									$(".house-info-list-ul").children("li")
											.children("img").css("opacity",
													"0.6");
									$(".house-info-list-ul").children("li").eq(
											imageIndex).children("img").css(
											"opacity", "1");
									let imageAddress = $(".house-info-list-ul")
											.children("li").eq(imageIndex)
											.children("img").attr("src");
									$(".house-info-img-show").attr("src",
											imageAddress);
									moveImage(imageIndex);
								}
							})
			$(".switch-right")
					.click(
							function() {
								if (imageIndex < maxImageVlaue - 1) {
									imageIndex = imageIndex + 1;
									$(".house-info-list-ul").children("li")
											.children("img").css("opacity",
													"0.6");
									$(".house-info-list-ul").children("li").eq(
											imageIndex).children("img").css(
											"opacity", "1");
									let imageAddress = $(".house-info-list-ul")
											.children("li").eq(imageIndex)
											.children("img").attr("src");
									$(".house-info-img-show").attr("src",
											imageAddress);
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
			whetherAlreadyCollection();
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
					"houseImageAddress" : folder
				},
				success : function(result) {
					if (result != null && result.length != 0) {
						$(".house-info-img-show").attr(
								"src",
								"http://localhost:8080/static/publish-house-img/"
										+ folder + "/" + result[0]);

						for (let i = 0; i < result.length; i++) {
							let imageAddress = "http://localhost:8080/static/publish-house-img/"
									+ folder + "/" + result[i];
							$(".house-info-list-ul").append(
									"<li class='imageAddress'><img src='"
											+ imageAddress + "'></li>");
						}

						maxImageVlaue = $(".house-info-list-ul li").length;
						$(".house-info-list-ul").css("width",
								$(".house-info-list-ul li").length * 84 + "px");
						$(".house-info-list-ul").children("li").eq(0).children(
								"img").css("opacity", "1");
						$(".house-info-list-ul").children("li").css("cursor",
								"pointer");
						// 图片切换
						$(".house-info-list-ul").children("li")
								.click(
										function() {
											$(".house-info-list-ul").children(
													"li").children("img").css(
													"opacity", "0.6");
											$(this).children("img").css(
													"opacity", "1");
											let imageAddress = $(this)
													.children("img")
													.attr("src");
											$(".house-info-img-show").attr(
													"src", imageAddress);
											// 图片数量
											imageIndex = $(this).index();
											moveImage();
										})
					}
				}
			})
}
function moveImage() {
	if (maxImageVlaue > 3) {
		if (imageIndex >= 3 && imageIndex <= maxImageVlaue - 4) {
			$(".house-info-list-ul").css("left", -(imageIndex - 1) * 84);
		} else if (imageIndex < 3) {
			$(".house-info-list-ul").css("left", 0);
		} else {
			$(".house-info-list-ul").css("left", -(maxImageVlaue - 4) * 84);
		}
	}

}

var map;
function baiduAPIRead() {
	let houseAddress = $(".addressProvince").text() + $(".addressCity").text()
			+ $(".addressArea").text() + $(".address-info").text();
	// 百度地图API功能
	map = new BMap.Map("house-baidu-api");
	var myGeo = new BMap.Geocoder();
	// 开启滚轮缩放
	map.enableScrollWheelZoom();
	// 左上角添加缩放平移控件和比例尺
	var top_left_control = new BMap.ScaleControl({
		anchor : BMAP_ANCHOR_TOP_LEFT
	});
	var top_left_navigation = new BMap.NavigationControl();
	map.addControl(top_left_control);
	map.addControl(top_left_navigation);
	// 将地址解析结果显示在地图上，并调整地图视野
	myGeo.getPoint(houseAddress, function(point) {
		if (point) {
			map.centerAndZoom(point, 12);
			var marker = new BMap.Marker(point); // 创建标注
			marker.setAnimation(BMAP_ANIMATION_BOUNCE);
			map.addOverlay(marker); // 将标注添加到地图中
			var opts = {
				width : 100, // 信息窗口宽度
				enableMessage : true,// 设置允许信息窗发送短息
			}
			var infoWindow = new BMap.InfoWindow("房屋地址：" + houseAddress, opts); // 创建信息窗口对象
			marker.addEventListener("click", function() {
				map.openInfoWindow(infoWindow, point); // 开启信息窗口
			});
		}
	})
}

function calculateDistance() {
	var actionWay = $(".select-action-way").val();
	let end = $(".select-distacne-input").val();

	let start = $(".addressProvince").text() + $(".addressCity").text();
	let startInfo = $(".addressArea").text() + $(".address-info").text();
	// 百度地图API功能
	var myGeo = new BMap.Geocoder();
	// 将地址解析结果显示在地图上，并调整地图视野
	myGeo.getPoint(start, function(point) {
		map.centerAndZoom(point, 11);
	})
	switch (actionWay) {
	case "walking":
		// 步行功能
		var walking = new BMap.WalkingRoute(map, {
			renderOptions : {
				map : map,
				panel : "house-select-distance-result",
				autoViewport : true
			}
		});

		walking.search(startInfo, end); 
		break;
	case "driving":
		// 驾车功能
		var driving = new BMap.DrivingRoute(map, {
			renderOptions : {
				map : map,
				panel : "house-select-distance-result",
				autoViewport : true
			}
		});
		driving.search(startInfo, end);

		break;
	case "transit":

		// 公车功能
		var transit = new BMap.TransitRoute(map, {
			renderOptions : {
				map : map,
				panel : "house-select-distance-result"
			}
		});
		transit.search(startInfo, end);
		break;
	}
}

function showCollection(){
	/*$.ajax({
		url : '/house/get/house/image',
		dataType : "json",
		type : "post",
		data : {
			"houseId" : $(".house-info-img-window").attr("value");
		},
		success : function(result) {
			
		}
	});*/
}

function whetherAlreadyCollection(){
	$.ajax({
		url : '/house/judge/collection/state',
		dataType : "json",
		type : "post",
		data : {
			"collectionHouseId" : $(".house-info-window").attr("value")
		},
		success : function(result) {
			if(result == true){
				$(".collection").attr("value","1");
				$(".collection-img").attr("src","/static/img/click-stars.png");
				$(".collection-word").html("取消收藏");
			}else{
				$(".collection").attr("value","0");
				$(".collection-img").attr("src","/static/img/stars.png");
				$(".collection-word").html("加入收藏");
			}
		}
	});
}

function addOrDeleteCollection(value){
	$.ajax({
		url : "/house/modify/collection/state",
		dataType : "json",
		type : "post",
		data : {
			"collectionHouseId" : $(".house-info-window").attr("value"),
			"modify":$(".collection").attr("value")
		},
		success : function(result) {
		
			switch(result.result){
			case "true":
				switch(value){
				case "0":
					$(".collection-img").attr("src","/static/img/click-stars.png");
					$(".collection").attr("value","1");
					$(".collection-word").html("取消收藏");
					break;
				case "1":
					$(".collection-img").attr("src","/static/img/stars.png");
					$(".collection").attr("value","0");
					$(".collection-word").html("加入收藏");
					break;
				}
				break;
			case "false":
				alert("服务器错误")
				break;
			case "login":
			window.location.href = "/house/show/loginView";
			break;
		}
		}
	})
}



