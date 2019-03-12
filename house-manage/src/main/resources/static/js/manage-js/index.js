let person = true;
$(document).ready(function() {
	$(".employee-information").hide();
	$(".employee-information").css("left",($(document).outerWidth(true)/2-250)+"px");
	$(".website").click(function(){
		$("#load").attr("src", "/manage/session/show/websiteReportView");
	})
	$(".li-auditing").click(function() {
		$("#load").attr("src", "/manage/session/show/auditing/houseManageView");
	})
	$(".li-publish").click(function() {
		$("#load").attr("src", "/manage/session/show/publish/houseManageView");
	})
	$(".li-customer").click(function() {
		$("#load").attr("src", "/manage/session/show/customer/manage");
	})
	$(".li-black").click(function() {
		$("#load").attr("src", "/manage/session/show/black/customer/manage");
	})
	$(".close-div").click(function(){
		$(".employee-information").hide();
	})
	$(".person").click(function(){
		$(".employee-information").show();
	})
	/*$(".dropdown-toggle").click(function(){
		if(person){
		$(".dropdown-menu").show();
		
		}else{
			$(".dropdown-menu").hide();
		}
		})*/
})