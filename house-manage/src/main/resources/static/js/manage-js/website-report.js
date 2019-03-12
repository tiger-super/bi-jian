$(document).ready(function(){
    $("#load",parent.document).css("height",$(document).outerHeight(true)+"px");
    getPublishHouseNumber();
    setInterval(function(){
    	wheterUpdateHouseData();
    },5000)
})	


function getPublishHouseNumber(){
	$.ajax({
		url : '/manage/get/house/number',
		dataType : "json",
		type : "post",
		success : function(result) {
			$(".number").text(result.result);
		}
	});	
}

function wheterUpdateHouseData(){
	console.log("更新")
	$.ajax({
		url : '/manage/update/house/data',
		dataType : "json",
		type : "post",
		success : function(result) {
		if(result.result){
			 getPublishHouseNumber();
		};
		}
	});	
}