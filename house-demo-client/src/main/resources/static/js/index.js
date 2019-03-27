$(document).ready(function(){
    $.ajax({
    	url:"/house/get/cookie",
        method:"post",
        dataType : "json",
        	success:function(result){
        		let city = result["city"];
        		if(city == null){
        			$(".show-city-a").text("请选择城市");
        		}else{
        			$(".show-city-a").text(result["city"]);
        			
        		}
        	}
    })
  
})