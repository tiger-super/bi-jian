var pc;
$(document).ready(function() {
	$(".select-content").hide();
	gainProvinceAndCity();
	$(".province-select").click(function(){
		 ProvinceClickTigger();
	})
	
		
	
	$(".city-select").click(function(){
		 CityClickTigger()
	})

});

function gainProvinceAndCity() {
	$.ajax({
		url : '/house/gain/province/and/city',
		type : "post",
		dataType : "json",
		success : function(result) {
			pc = result;
			gainProvincePinyin();
		}
	});

}
var first = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' ];
function gainProvincePinyin() {
	$
			.ajax({
				url : '/house/gain/pinyin/province',
				type : "post",
				dataType : "json",
				success : function(result) {
					for (var i = 0; i < first.length; i++) {
						var province = result[first[i]];
						if (province != null) {
							$(".content")
									.append(
											'<div class="col-sm-12 content-div content-div-'
													+ i
													+ '"><div class="col-sm-1 pinyin py">'
													+ first[i] + '</div></div>');
							for (let j = 0; j < province.length; j++) {
								if (j >= 1) {
									$(".content-div-" + i)
											.append(
													'<div class="col-sm-1 pinyin"></div>');
								}
								$(".content-div-" + i).append(
										'<div class="col-sm-11 content-window content-window-'
												+ i + j + '"></div>')

								$(".content-window-" + i + j)
										.append(
												'<span class="sjx"></span><div class="col-sm-1 province-div">'
														+ province[j]
														+ '</div><div class="col-sm-10  city-div city-div-'
														+ i + j + '"></div>');
								for (let m = 0; m < pc[province[j]].length; m++) {
									$(".city-div-" + i + j).append(
											'<span class=""><a>'
													+ pc[province[j]][m]
													+ '</a></span>')
								}

							}
						}
					}
					$(".sjx").hide();
					for (var m = 0; m < 26; m++) {
						var children = $('.content-div-' + m).children(".py");
						var height = $('.content-div-' + m).outerHeight();
						children.css({
							"height" : height,
							"line-height" : height + "px"
						});

					}
					$(".content-window").mouseenter(function() {
						var height = ($(this).outerHeight() - 7) / 2;
						$(this).parent().children(".py").css({
							"background-color" : "#FF552E",
							"color" : "white"
						});
						$(this).children(".sjx").show();
						$(this).children(".sjx").css("top",height);
					});

					$(".content-window").mouseleave(function() {
						$(this).parent().children(".py").css({
							"background-color" : "#F8F8F9",
							"color" : "#afb3bb"
						});
						$(this).children(".sjx").hide();
					});

				}
			});

}

var provinceClick = false;
var cityClick = false;
var ifProvince = false;

function ProvinceClickTigger(){
	if(provinceClick){
		provinceClick = false;
		$(".province").children(".select-content").hide();
		$(".province-select").children(".select-img").css("background-image","url(http://localhost:8088/static/img/down.png)");
	}else{
		provinceClick = true;
		$(".province").children(".select-content").show();
		$(".province-select").children(".select-img").css("background-image","url(http://localhost:8088/static/img/up.png)");
	$(".province").children(".select-content");
	$(".province").children(".select-content").children(".select-content-ul").empty();
	$.ajax({
		url : '/house/gain/province',
		type : "post",
		dataType : "json",
		success : function(result) {
			for(let i = 0; i < result.length ; i++){
				$(".province").children(".select-content").children(".select-content-ul").append('<li>'+result[i]+'</li>')
			}
		
			$(".select-content-ul").children("li").mouseleave(function() {
				$(this).css({"background-color":"white"});
			});
			$(".select-content-ul").children("li").mouseenter(function() {
				$(this).css({"background-color":"#F8F8F8"});
			});
			
			$(".province-select-content-ul").children("li").click(function(){
				var value = $(this).text();
				$(".province-select-text").text(value);
				provinceClick = false;
				$(".province").children(".select-content").hide();
				$(".province-select").children(".select-img").css("background-image","url(http://localhost:8088/static/img/down.png)");
			})
		}
	});
	}
}

function CityClickTigger(){
	var province = $(".province-select-text").text();
	if(province != "省份"){
	if(cityClick){
		cityClick = false;
		$(".city").children(".select-content").hide();
		$(".city-select").children(".select-img").css("background-image","url(http://localhost:8088/static/img/down.png)");
	}else{
		cityClick = true;
		$(".city").children(".select-content").show();
		$(".city-select").children(".select-img").css("background-image","url(http://localhost:8088/static/img/up.png)");
     	$(".city").children(".select-content");
	    $(".city").children(".select-content").children(".select-content-ul").empty();
	$.ajax({
		url : '/house/gain/city',
		type : "post",
		dataType : "json",
		data:{"province":province},
		success : function(result) {
			for(let i = 0; i < result.length ; i++){
				$(".city").children(".select-content").children(".select-content-ul").append('<li>'+result[i]+'</li>')
			}
		
			$(".select-content-ul").children("li").mouseleave(function() {
				$(this).css({"background-color":"white"});
			});
			$(".select-content-ul").children("li").mouseenter(function() {
				$(this).css({"background-color":"#F8F8F8"});
			});
			
			$(".city-select-content-ul").children("li").click(function(){
				var value = $(this).text();
				$(".city-select-text").text(value);
				provinceClick = false;
				$(".city").children(".select-content").hide();
				$(".city-select").children(".select-img").css("background-image","url(http://localhost:8088/static/img/down.png)");
			})
		}
	});
	}
	}
}