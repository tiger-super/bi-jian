let person = true;
let password = true;
$(document).ready(function() {
	$(".modifyPasssword-div").hide();
	$(".employee-information").hide();
	$(".employee-information").css("left",($(document).outerWidth(true)/2-250)+"px");
	$(".modifyPasssword-div").css("left",($(document).outerWidth(true)/2-100)+"px");
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
	$(".li-modify-employee").click(function() {
		$("#load").attr("src", "/manage/session/show/modify/employee");
	})
	$(".close-div").click(function(){
		$(".employee-information").hide();
	})
	$(".person").click(function(){
		$(".modifyPasssword-div").hide();
		$(".employee-information").show();
		password=true;
	})
	$(".li-add-employee").click(function(){
		$("#load").attr("src", "/manage/session/show/add/employee");
	})
	
	$(".li-see-employee").click(function(){
		$("#load").attr("src", "/manage/session/show/see/employee");
	})
	$(".modifyPassword").click(function(){
		$(".employee-information").hide();
		if(password){
			$(".modifyPasssword-div").show();
			password=false;
		}else{
			password=true;
			$(".modifyPasssword-div").hide();
		}
	})
	
	$(".modify").click(function(){
	$.ajax({
			url : '/manage/session/modify/password',
			dataType : "json",
			type : "post",
			data : {
				"employeeId" : $(".employeeId").attr("value"),
				"employeePassword":$(".new-password").val()
			},
			success : function(result) {
				if(result.result){
					password=true;
					$(".modifyPasssword-div").hide();
					alert("修改成功");
				}else{
					alert("系统错误");
				}
			}
		})
	})
})