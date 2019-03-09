$(document).ready(function() {
	$(".employee-information").hide();
	$(".employee-information").css("left",($(document).outerWidth(true)/2-250)+"px");
	$(".li-auditing").click(function() {
		$("#load").attr("src", "/manage/show/auditing/houseManageView");
	})
	$(".li-publish").click(function() {
		$("#load").attr("src", "/manage/show/publish/houseManageView");
	})
	$(".li-customer").click(function() {
		$("#load").attr("src", "/manage/show/customer/manage");
	})
	$(".li-black").click(function() {
		$("#load").attr("src", "/manage/show/black/customer/manage");
	})
	$(".close-div").click(function(){
		$(".employee-information").hide();
	})
	$(".person").click(function(){
		$(".employee-information").show();
	})
})