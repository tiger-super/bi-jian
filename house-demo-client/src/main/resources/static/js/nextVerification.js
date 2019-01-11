var isAccountNumber = false;
var isCode = false;
$(document).ready(
		function() {
			$(".second-form").hide();
			$(".three-form").hide();
			$(".true").hide();
			// 获取验证码
			$(".code-image").attr("src", '/house/gain/VerificationCode');
			// 换一张验证码
			$(".replace-code").click(
					function() {
						$(".code-image").attr(
								"src",
								'/house/gain/VerificationCode?data='
										+ new Date());
					})

			$(".next").click(
					function() {
						if (isAccountNumber && isCode) {
							// 判断验证码是否正确
							$.ajax({
								url : '/house/judge/VerificationCode',
								type : "post",
								dataType : "json",
								data : {
									"VerificationCode" : $(".VerificationCode")
											.val()
								},
								success : function(result) {
									if (result == true) {
										ajaxAccountNumber();
									} else {
										$(".code-tips").removeClass("hide");
										$(".code-tips").text("验证码错误");
										$(".VerificationCode").parent()
												.addClass("has-error");
										$(".code-image").attr(
												"src",
												'/house/gain/VerificationCode?data='
														+ new Date());
										$(".VerificationCode").val("");
									}
								}
							});
						} else {
							blurCode();
							blurAccountNumber();
						}

					})
			// input失焦
			$("#account-number").blur(function() {
				blurAccountNumber();
			});
			// input失焦
			$(".VerificationCode").blur(function() {
				blurCode();
			});
			// 获得邮箱验证码
			$(".gainMailVerificationCode").click(function() {
				mailVerificationCode();
			})
			// 体检邮箱验证
			$(".second").click(function() {
				ajaxJudgeMailVerificationCode();
			})
			// 判断新密码是否为空
			$("#new-password").blur(function() {
				blurNewPassword();
			});
			// 判断确认密码是否为空
			$("#confirm-password").blur(function() {
				blurConfirmPassword();
			});
			// 提交新密码
			$(".modify-password").click(function() {
				ajaxSubmitNewPassword();
			})
		})
// 账号是否为空
function blurAccountNumber() {
	var value = $("#account-number").val();
	if (value == "") {
		$(".account-number-tips").removeClass("hide");
		$(".account-number-tips").text("账号不能为空");
		$("#account-number").parent().addClass("has-error");
		isAccountNumber = false;
	} else {
		$("#account-number").parent().removeClass("has-error");
		$(".account-number-tips").addClass("hide");
		isAccountNumber = true;
	}
}
// 验证码是否为空
function blurCode() {
	var value = $(".VerificationCode").val();
	if (value == "") {
		$(".code-tips").removeClass("hide");
		$(".code-tips").text("验证码不能为空");
		$(".VerificationCode").parent().addClass("has-error");
		isCode = false;
	} else {
		$(".VerificationCode").parent().removeClass("has-error");
		$(".code-tips").addClass("hide");
		isCode = true;
	}
}
// 账号验证
function ajaxAccountNumber() {
	$.ajax({
		url : '/house/exist/account/number',
		type : "post",
		dataType : "json",
		data : {
			"customerPhone" : $("#account-number").val()
		},
		success : function(result) {
			if (result.customerId == null) {
				$(".account-number-tips").removeClass("hide");
				$(".account-number-tips").text("账号不存在");
				$("#account-number").parent().addClass("has-error");
				$(".code-image").attr("src",
						'/house/gain/VerificationCode?data=' + new Date());
				$(".VerificationCode").val("");
			} else {
				$(".center-content-title").text("完成验证");
				$(".first-form").hide();
				$(".second-form").show();
				$(".second-form").attr("value", result.customerMailbox);
				$(".span-mail").text(result.customerMailbox);
				$(".three-form").attr("value",result.customerId);
			}
		}
	});
}

// 邮箱获取验证码特效
function mailVerificationCode() {
	$(".gainMailVerificationCode").addClass("disabled");
	$(".gainMailVerificationCode").attr("disabled", true);
	ajaxGainMailVerificationCode();
	var i = 60
	var interval = setInterval(function() {
		$(".gainMailVerificationCode").text(i + "秒后可在发送");
		i--;
	}, 1000);
	var time = setTimeout(function() {
		$(".gainMailVerificationCode").removeClass("disabled");
		$(".gainMailVerificationCode").attr("disabled", false);
		$(".gainMailVerificationCode").text("获取验证码");
		clearInterval(interval);
	}, 62000);
}

// ajax获取邮箱验证码
function ajaxGainMailVerificationCode() {
	var customerMailbox = $(".second-form").attr("value");
	$.ajax({
		url : '/house/send/mailVerificationCode',
		type : "post",
		dataType : "json",
		data : {
			"customerMailbox" : customerMailbox
		},
		success : function(result) {
		}

	});
}

function ajaxJudgeMailVerificationCode() {

	var mailVerificationCodeText = $(".mailVerificationCodeText").val();
	console.log(mailVerificationCodeText)
	$.ajax({
		url : '/house/judge/mailVerificationCode',
		type : "post",
		dataType : "json",
		data : {
			"mailVerificationCodeText" : mailVerificationCodeText
		},
		success : function(result) {
			if (result.result == "true") {
				$(".center-content-title").text("修改密码");
				$(".three-form").show();
				$(".second-form").hide();
			} else {
				$(".mailCode-tips").removeClass("hide");
				if (result.result == "false") {
					$(".mailCode-tips").text("验证码错误");
				} else {
					$(".mailCode-tips").text(result.result);
				}
			}
		}

	});
}

var isNewPassowrd = false;
function blurNewPassword() {
	var value = $("#new-password").val();
	if (value == "") {
		$(".new-password-tips").removeClass("hide");
		$(".new-password-tips").text("请输入新密码");
		$("#new-password").parent().addClass("has-error");
		isNewPassowrd = false;
	} else {
		$("#new-password").parent().removeClass("has-error");
		$(".new-password-tips").addClass("hide");
		isNewPassowrd = true;
	}
}

var isConfirmPassword = false;
function blurConfirmPassword() {
	var value = $("#confirm-password").val();
	if (value == "") {
		$(".confirm-password-tips").removeClass("hide");
		$(".confirm-password-tips").text("请输入新密码");
		$("#confirm-password").parent().addClass("has-error");
		isConfirmPassword = false;
	} else {
		$("#confirm-password").parent().removeClass("has-error");
		$(".confirm-password-tips").addClass("hide");
		isConfirmPassword = true;
	}
}

function ajaxSubmitNewPassword() {

	var confirmPassword = $("#confirm-password").val();
	var newPassword = $("#new-password").val();
	if (isConfirmPassword && isNewPassowrd) {
		if(confirmPassword == newPassword){ 
		$.ajax({
			url : '/house/modify/customerPassword',
			type : "post",
			dataType : "json",
			data : {
				"customerPassword" : newPassword,
		        "customerId": "1"
			},
			success : function(result) {
				if(result == true){
					$(".true").show();
					$(".center").hide();
				}else{
					window.location.href = "/house/show/retrievePasswordView";
				}
			}

		});
		}else{
			$(".confirm-password-tips").removeClass("hide");
			$(".confirm-password-tips").text("两次密码不一致");
			$("#confirm-password").parent().addClass("has-error");
			isConfirmPassword = false;
		}
	} else {
		blurConfirmPassword();
		blurNewPassword();
	}
}
