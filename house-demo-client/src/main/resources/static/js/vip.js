let money = 15;
let day = 1;
$(document).ready(function(){
   $(".vip-content-div").click(function(){
	   $(".vip-content-div").css("border-color","#eee");
	   $(this).css("border-color","red");
	   money = $(this).children(".vip-content").children(".vip-money").attr("value");
	   day = $(this).children(".vip-day").attr("value");
   })
   $(".vip-submit").click(function(){
	   window.location.href ='/house/session/show/pay/view?money='+money+'&day='+day;
   })
})