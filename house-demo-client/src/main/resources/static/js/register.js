var isName = false;
var isPassowrd = false;
var isPhone = false;
var isMailbox = false;
var isMailboxExist = false;

$(document).ready(function(){
    $("#register").submit(function() {
    	if (isName && isPassowrd && isPhone && isMailbox) {
    		if(isMailboxExist){
    			var mailVerificationCodeText = $(".mailVerificationCodeText").val();
    			$.ajax({
    				url : '/house/judge/mailVerificationCode',
    				type : "post",
    				dataType : "json",
    				data : {
    					"mailVerificationCodeText" : mailVerificationCodeText
    				},
    				success : function(result) {
    					if (result.result == "true") {
    						$.ajax({
    							url : '/house/handle/register',
    							type : "get",
    							data : $("#register").serialize(),
    							success : function(result) {
    								console.log(result);
    								if (result.result == "true") {
    									window.location.href = "/house/show/successView";
    								} else {
    									$(".mailVerificationCode-tips").removeClass("hide");
    					    	      	$(".mailVerificationCode-tips").text(result.reason);
    					    	      	$(".mailVerificationCodeText").parent().addClass("has-error");
    					    	      	$(".form-mailbox").parent().addClass("has-error");
    								}
    							}
    						});

    					} else {
    						$(".mailVerificationCode-tips").removeClass("hide");
    						if (result.result == "false") {
    							$(".mailVerificationCode-tips").text("验证码错误");
    						} else {
    							$(".mailVerificationCode-tips").text(result.result);
    						}
    					}
    				}

    			});	
    			
    			
    			
    			
    
  
    		}else{
    			$(".mailVerificationCode-tips").removeClass("hide");
    	      	$(".mailVerificationCode-tips").text("请验证邮箱");
    	      	$(".mailVerificationCodeText").parent().addClass("has-error");
    		}

		} else {		
				blurNameJudge();
				blurPasswordJudge();
				blurPhoneJudge();
				blurMailboxJudge();
		}
		return false;
    })
    
    
    $(".form-phone").blur(function(){
    	 blurPhoneJudge();
    });
    
      
    $(".form-name").blur(function(){
    	blurNameJudge();
    });
    
    
    
    
    $(".form-password").blur(function(){
    	 blurPasswordJudge();
    });
    
    
    
    $(".form-mailbox").blur(function(){
    	blurMailboxJudge();
    });
    // 邮箱验证
    $(".gainMailVerificationCode").click(function(){
    	if(isMailbox){
    	$(".gainMailVerificationCode").addClass("disabled");
    	$(".gainMailVerificationCode").attr("disabled", true);
     	 judgeMailboxExist();
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
    	}else{
    		$(".mailbox-tips").removeClass("hide");
        	$(".mailbox-tips").text("邮箱不能为空");
        	$(this).parent().addClass("has-error");
    	}
    })
})




function blurPhoneJudge(){
	  var  value = $(".form-phone").val();
      var ivalue = parseInt(value);
      if(value == ""){
      	$(".phone-tips").removeClass("hide");
      	$(".phone-tips").text("电话不能为空");
      	$(this).parent().addClass("has-error");
      }
      else if( isNaN(ivalue)){
      	$(".phone-tips").removeClass("hide");
      	$(".phone-tips").text("非法字符");
      	$(this).parent().addClass("has-error");
      }else{
      	$(this).parent().removeClass("has-error");
      	$(".phone-tips").addClass("hide");
      	isPhone = true;
      }
}



function blurNameJudge(){
	 var  value = $(".form-name").val();
     if(value == ""){
     	$(".name-tips").removeClass("hide");
     	$(".name-tips").text("用户名不能为空");
     	$(this).parent().addClass("has-error");
     }
     else{
     	$(this).parent().removeClass("has-error");
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


function blurMailboxJudge(){
	var re = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/; 
    var  value = $(".form-mailbox").val();
    if(value == ""){
    	$(".mailbox-tips").removeClass("hide");
    	$(".mailbox-tips").text("邮箱不能为空");
    	$(this).parent().addClass("has-error");
    }else if(!re.test(value)){
    		$(".mailbox-tips").removeClass("hide");
    	$(".mailbox-tips").text("非法格式");
    	$(this).parent().addClass("has-error");
    }
    else{
    	$(this).parent().removeClass("has-error");
    	$(".mailbox-tips").addClass("hide");
    	isMailbox = true;
    }
}


function judgeMailboxExist(){
	
	   var  value = $(".form-mailbox").val();
	   $.ajax({
			url : '/house/send/mailVerificationCode',
			type : "post",
			dataType : "json",
			data : {
				"customerMailbox" : value
			},
			success : function(result) {
				console.log(result)
				if(result == true){
					isMailboxExist = true;
				}else{
					$(".mailVerificationCode-tips").removeClass("hide");
	    	      	$(".mailVerificationCode-tips").text("邮箱不存在");
	    	      	$(".mailVerificationCodeText").parent().addClass("has-error");
	    	      	$(".form-mailbox").parent().addClass("has-error");
				}
			}

		});
}

function ajaxJudgeMailVerificationCode() {
	var mailVerificationCodeText = $(".mailVerificationCodeText").val();
	$.ajax({
		url : '/house/judge/mailVerificationCode',
		type : "post",
		dataType : "json",
		data : {
			"mailVerificationCodeText" : mailVerificationCodeText
		},
		success : function(result) {
			if (result.result == "true") {
				isMailVerificationCode = true;
			} else {
				$(".mailVerificationCode-tips").removeClass("hide");
				if (result.result == "false") {
					$(".mailVerificationCode-tips").text("验证码错误");
				} else {
					$(".mailVerificationCode-tips").text(result.result);
				}
			}
		}

	});
}

