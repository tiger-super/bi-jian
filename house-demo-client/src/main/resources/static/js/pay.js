$(document).ready(function(){
   $(".pay-button").click(function(){ 
	   $.ajax({
    	url:"/house/session/handle/vip",
        method:"post",
        data:{"payId":$("WIDout_trade_no").attr("value"),"payMoney":("WIDtotal_amount").attr("value")},
        dataType : "json",
        	success:function(result){
        		
        	}
    })
   })
})