$(document).ready(function() {
	$(".select-sex").hide();
	$(".person-information").click(function(){
		$(".content-right").css("display","none");
		$(".person-information-view").css("display","block");
	})
	$(".my-publish").click(function(){
		$(".content-right").css("display","none");
		$(".my-publish-view").css("display","block");
		loadHouseInfo("housePublisherState","1");
	})
	$.ajax({
		url : '/house/session/gain/info',
		dataType : "json",
		type : "post",
		success : function(result) {
			$("#customerName").attr("value", result.customerName);
			$("#customerPhone").attr("value", result.customerPhone);
			$("#customerSex").attr("value", result.customerSex);
			$("#customerAge").attr("value", result.customerAge);
			$("#customerMailbox").attr("value", result.customerMailbox);
			if (result.customerHeadImageAddress != null) {			
				$(".head-img").attr("src", "http://localhost:8080/static/customerPhoto/"+result.customerHeadImageAddress);
			}else{
				$(".head-img").attr("src","/static/img/renyuanzengjia.png");
			}
		}
	});

	$(".modify").click(function() {
		var inputElement = $(this).parent().parent().find("input");
		var disabled = inputElement.prop("disabled");
		if (disabled == true) {
			$(this).text("确定");
			inputElement.attr("disabled", false);
			inputElement.css({
				"border" : "1px solid red",
				"background" : "100% 100%"
			});
		} else {
			$(this).text("修改");
			inputElement.attr("disabled", true);
			inputElement.css({
				"border" : "0",
				"background" : "0 0"
			});
			var inputOldValue = inputElement.attr("value");
			var inputNewValue = inputElement.val();
			var data;
			if (!(inputNewValue == inputOldValue)) {
				var attribute = inputElement.prop("id");
				var urlAddress;
				switch (attribute) {
				case "customerName":
					urlAddress = "/house/session/modify/customerName";
					data = {"customerName":inputNewValue};
					break;
				case "customerAge":
					urlAddress = "/house/session/modify/customerAge";
					data = {"customerAge":inputNewValue};
					break;
				default:
					urlAddress = "/house/session/modify/customerMailbox";
				data = {"customerMailbox":inputNewValue};
					break;
				}
			$.ajax({
				url : urlAddress,
				dataType : "json",
				type : "post",
				data : data,
				success : function(result) {
					if (result == true) {
						inputElement.attr("value", inputNewValue);
						if(attribute == 'customerName'){
							$.ajax({
								url :'/house/session/gain/object',
									success : function(result) {
										if(result != null){
											$(".head-span-customerName").text(result.customerName);
										}
									}
								
							})
						}
					} else {
						inputElement.val(inputOldValue);
						alert("修改失败")
					}
				}
			});
			}
		}
		
	})
	
	
	
	
	$(".modifysex").click(function(){
		var inputElement = $(this).parent().parent().find("input");
		var disabled = inputElement.prop("disabled");
		var inputOldValue ;
		var inputNewValue;
		if (disabled == true) {
			$(".select-sex").show();
			$("#customerSex").hide();
			$(this).text("确定");
			inputElement.attr("disabled", false);
			inputOldValue = inputElement.attr("value");
			switch(inputOldValue){
			case "男":$(".select-sex-man").attr("selected","selected");
			break;
			case "女":$(".select-sex-woman").attr("selected","selected");
			break;
			}
			selected = "selected";
			$("#customerSex").hide();
		}else {
			$(this).text("修改");
			inputElement.attr("disabled", true);
			inputNewValue = $('.select-sex').val();
			
			if (!(inputNewValue == inputOldValue)) {
				$.ajax({
					url : "/house/session/modify/customerSex",
					dataType : "json",
					type : "post",
					data : {"customerSex":inputNewValue},
					success : function(result) {
					
						if (result == true) {
							inputElement.attr("value", inputNewValue);
						} else {
							inputElement.val(inputOldValue);
							alert("修改失败")
						}
					}
				});
				
			}
			$(".select-sex").hide();
			$("#customerSex").show();
		}
	     
	})

})


function submitform(){
		$.ajax({
			url : "/house/session/photo/upload",
			type : "post",
		    data: new FormData($('#fileUploadFrom')[0]),
			 processData: false,
			    contentType: false,
			success : function(result) {
			   if(result != "false" ){
				   $(".head-img").attr("src","#");
				 $(".head-img").attr("src","http://localhost:8080/static/customerPhoto/"+result);
			   }else{
				   alter("上传失败");
			   }
			}
			
		})
}


function loadHouseInfo(key,value){
	$.ajax({
		url : "/house/session/publish/manage",
		type : "post",
		dataType : "json",
	    data: {"housePublisherState":"1"},
		success : function(result) {
		   console.log(result)
		}
		
	})
}
