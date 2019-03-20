var isName = false;
var isPassowrd = false;
var  isVerificationCode = false;
$(document).ready(function() {
	$("#login").submit(function() {
		if (isName && isPassowrd && isVerificationCode) {
			$.ajax({
				url : '/house/judge/VerificationCode',
				type : "post",
				dataType : "json",
				data : {"VerificationCode":$(".VerificationCode").val()},
				success : function(result) {
					if(result == true){
						$.ajax({
							url : '/house/handle/login',
							type : "post",
							data : $("#login").serialize(),
							success : function(result) {
								if (result.result == "true") {
									window.location.href = "/house/show/indexView";
								} else {
									$(".result-tips").removeClass("hide");
									$(".result-tips").text(result.result);
								}
							}
						});
					}
					else{
						$(".VerificationCode-tips").removeClass("hide");
						$(".VerificationCode-tips").text("验证码不正确");
						$(".VerificationCode").parent().addClass("has-error");
						return false;
					}
				}
			});
			
			

		} else {		
				blurNameJudge();
				blurPasswordJudge();
				blurVerification();
		}
		return false;

	})

	$(".form-id").blur(function() {
		$(".result-tips").addClass("hide");
		blurNameJudge();
	});

	$(".form-password").blur(function() {
		$(".result-tips").addClass("hide");
		blurPasswordJudge();
	});
	
	$(".VerificationCode").blur(function() {
		$(".result-tips").addClass("hide");
		blurVerification();
	});

})

function blurNameJudge() {
	var value = $(".form-id").val();
	var ivalue = parseInt(value);
	if (value == "") {
		$(".name-tips").removeClass("hide");
		$(".name-tips").text("账号不能为空");
		$(".form-id").parent().addClass("has-error");
	} else if (isNaN(ivalue)) {
		$(".name-tips").removeClass("hide");
		$(".name-tips").text("非法账号");
		$(".form-id").parent().addClass("has-error");
	} else {
		$(".form-id").parent().removeClass("has-error");
		$(".name-tips").addClass("hide");
		isName = true;
	}
}

function blurPasswordJudge() {
	var value = $(".form-password").val();
	if (value == "") {
		$(".password-tips").removeClass("hide");
		$(".password-tips").text("密码不能为空");
		$(".form-password").parent().addClass("has-error");
		isPassowrd = false;
	} else {
		$(".form-password").parent().removeClass("has-error");
		$(".password-tips").addClass("hide");
		isPassowrd = true;
	}
}


function blurVerification(){
	var value = $(".VerificationCode").val();
	if (value == "") {
		$(".VerificationCode-tips").removeClass("hide");
		$(".VerificationCode-tips").text("验证码不能为空");
		$(".VerificationCode").parent().addClass("has-error");
		isVerificationCode = false;
	} else {
		$(".VerificationCode").parent().removeClass("has-error");
		$(".VerificationCode-tips").addClass("hide");
		isVerificationCode = true;
	}
}