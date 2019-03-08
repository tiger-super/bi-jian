$(document).ready(function(){
	$(".li-auditing").click(function(){
		$("#load").attr("src","/manage/show/auditing/houseManageView");
	})
	$(".li-publish").click(function(){
		$("#load").attr("src","/manage/show/publish/houseManageView");
	})
})