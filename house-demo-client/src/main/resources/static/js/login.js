var isName = false;
var isPassowrd = false;
$(document).ready(function() {
	$("#login").submit(function() {
		if (isName && isPassowrd) {
			$.ajax({
				url : '/house/handle/login',
				type : "post",
				data : $("#login").serialize(),
				success : function(result) {
					if (result == "true") {
						window.location.href = "/house/show/indexView";
					} else {
						$(".dataJudge").removeClass("hide");
						$(".text").text(result);
					}
				}
			});

		} else {		
				blurNameJudge();
				blurPasswordJudge();
		}
		return false;

	})

	$(".form-id").blur(function() {
		blurNameJudge();
	});

	$(".form-password").blur(function() {
		blurPasswordJudge();
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