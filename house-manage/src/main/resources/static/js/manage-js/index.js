$(document).ready(function() {
	$("#load").attr("src", "/manage/show/customer/manage");
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
})