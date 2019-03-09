$(document).ready(function() {
	$(".login").click(function(){
		login();
	})
})

function login(){
	$.ajax({
		url : '/manage/login',
		dataType : "json",
		type : "post",
		data : {"employeeId":$(".id").val(),"employeePassword":$(".password").val()},
		success : function(result) {
			if(result.result == "true"){
				window.location.href="/manage/session/show/indexView";     
			}else{
			 alert(result.result);
			}
		}
	});	
}