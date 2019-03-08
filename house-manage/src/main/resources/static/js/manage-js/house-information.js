$(document).ready(function() {
	$(".reason-div").hide();
     $(".big-img").hide();
	 $(".small-img").mouseover(function(){ 
		 $(this).parents("div").children(".big-img").show();  
     }).mouseout(function (){  
    	 $(this).parents("div").children(".big-img").hide();  
     });
	 $("#load",parent.document).css("height",$(document).outerHeight(true)+"px");
	 $(".yes").click(function(){
		 
		 $.ajax({
			 url : '/manage/modify/auditing/state',
				dataType : "json",
				type : "post",
				data : {"houseId":$(".houseId").text()},
				success : function(result) {
					if(result.result == true){
						alert("审批完毕");
					}else{
						alert("系统出错");
					}
					window.location.href="/manage/show/auditing/houseManageView";
				}
		 })
	 })
	 $(".no").click(function(){
			$(".reason-div").show();
			 $(parent.window).scrollTop(100);
	 })
	 $(".cancel").click(function(){
		 	$(".reason-div").hide();
	 })
	 $(".commit").click(function(){
      let houseAuditingReason = $(".reason-content").val();
      let houseId = $(".houseId").text();
      $.ajax({
			 url : '/manage/auditin/fail',
				dataType : "json",
				type : "post",
				data : {"houseId":houseId,"houseAuditingReason":houseAuditingReason},
				success : function(result) {
					if(result.result == true){
						window.location.href="/manage/show/auditing/houseManageView";
					}else{
						alert("系统发生了错误");
					}
				}
		 })
	 })
})
