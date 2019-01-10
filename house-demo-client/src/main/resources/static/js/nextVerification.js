var isAccountNumber = false;
var isCode = false;
$(document).ready(
		function() {
			$(".second-form").hide();
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
			$(".gainMailVerificationCode").click(function(){
				 mailVerificationCode();
			})
			$(".second").click(function(){
				ajaxGainMailVerificationCode();
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
				$(".second-form").attr("value",result.customerMailbox);
			}
		}
	});
}



// 邮箱获取验证码
function mailVerificationCode(){
	var i = 60
	var interval = setInterval(function(){
		$(".gainMailVerificationCode").addClass("disabled");
		$(".gainMailVerificationCode").text(i+"秒后可在发送");
		i--;
	},1000);
	var time = setTimeout(function(){
		console.log("x")
	$(".gainMailVerificationCode").removeClass("disabled");
	$(".gainMailVerificationCode").text("获取验证码");
	clearInterval(interval);
	},62000);	
}


// ajax获取邮箱验证码
function ajaxGainMailVerificationCode(){
	var customerMailbox = $(".second-form").attr("value");
	$.ajax({
		url : '/house/send/mailVerificationCode',
		type : "post",
		dataType : "json",
		data : {
			"customerMailbox" : customerMailbox
		},
		success : function(result) {
			console.log(typeof result);
		}
	
});
}