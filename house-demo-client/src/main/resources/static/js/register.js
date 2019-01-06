var isName = false;
var isPassowrd = false;
var isPhone = false;
var isMailbox = false;
$(document).ready(function(){
    $("#register").submit(function() {
    	if (isName && isPassowrd && isPhone && isMailbox) {
    		$.ajax({
				url : '/house/handle/register',
				type : "get",
				data : $("#register").serialize(),
				success : function(result) {
					if (result == "true") {
						window.location.href = "/show/successView";
					} else {
						$(".dataJudge").removeClass("hide");
						$(".text").text(result);
					}
				}
			});

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
