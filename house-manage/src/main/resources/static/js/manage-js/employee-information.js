$(document).ready(function(){
	$(".content").hide();
	$(".select-sex").hide();
	$(".select-role").hide();
	$("#load", parent.document).css("height",
			$(document).outerHeight(true) + "px");
	$(".select").click(function(){
		select();
	})
	$(".modify").click(function() {
		var inputElement = $(this).parent().parent().find("input");
		var disabled = inputElement.prop("disabled");
		if (disabled == true) {
			$(this).text("确定");
			inputElement.attr("disabled", false);
			inputElement.css({"border" : "1px solid red","background" : "100% 100%"})
		} 
		else {
			$(this).text("修改");
			inputElement.attr("disabled", true);
			inputElement.css({"border" : "0","background" : "0 0"});
			var inputOldValue = inputElement.attr("value");
			var inputNewValue = inputElement.val();
			var data;
			if (!(inputNewValue == inputOldValue)) {
				var attribute = inputElement.prop("id");
				switch (attribute) {
				case "employeeName":
				data = {"employeeName" : inputNewValue,"employeeId":$("#employeeId").val()};
				break;
				case "employeePhone":
				data = {"employeePhone" : inputNewValue,"employeeId":$("#employeeId").val()};
				break;
				case "employeeAge":
				data = {"employeeAge" : inputNewValue,"employeeId": $("#employeeId").val()};
				break;
				case "employeeMailbox":
				data = {"employeeMailbox" : inputNewValue,"employeeId":$("#employeeId").val()};
				break;
				}
			$.ajax({
				url : "/manage/session/modify/employee/info",
				dataType : "json",
				type : "post",
				data : data,
				success : function(result) {
				 if (result.result == true) {
					inputElement.attr("value",inputNewValue);
				 }
				 else {
					inputElement.val(inputOldValue);alert("修改失败")
				 }
								
				 }
			})
		}
		}
	  })
$(".modifySex").click(function() {
	var inputElement = $(this).parent().parent().find("input");
	var disabled = inputElement.prop("disabled");
	var inputOldValue;
	var inputNewValue;
	if (disabled == true) {
		$(".select-sex").show();
		$("#employeeSex").hide();
		$(this).text("确定");
		inputElement.attr("disabled", false);
		switch (inputOldValue) {
			case "男":$(".select-sex-man").attr("selected", "selected");
					 break;
			case "女":$(".select-sex-woman").attr("selected", "selected");
					 break;
		}
			selected = "selected";
			$("#employeeSex").hide();
		} else {
			$(this).text("修改");
			inputOldValue = inputElement.attr("value");
		    inputElement.attr("disabled", true);
			inputNewValue = $('.select-sex').val();
            if (!(inputNewValue == inputOldValue)) {
				$.ajax({
					url : "/manage/session/modify/employee/info",
					dataType : "json",
					type : "post",
					data : {
							"employeeSex" : inputNewValue,
							"employeeId":$("#employeeId").val()
							},
					success : function(result) {
                    if (result.result == true) {
                    $(".select-sex").hide();
    				$("#employeeSex").show();
                    inputElement.val(inputNewValue);
					inputElement.attr("value",inputNewValue);
					} else {
						$(".select-sex").hide();
						$("#employeeSex").show();
					inputElement.val(inputOldValue);
					alert("修改失败")
					}
					}
					});

					}
            $(".select-sex").hide();
			$("#employeeSex").show();
				}

			})

			$(".modifyRole").click(function() {
				var inputElement = $(this).parent().parent().find("input");
				var disabled = inputElement.prop("disabled");
				var inputOldValue;
				var inputNewValue;
				if (disabled == true) {
					$(".select-role").show();
					$("#employeeRole").hide();
					$(this).text("确定");
					inputElement.attr("disabled", false);
					switch (inputOldValue) {
					case "超级管理员":$(".select-sex-super").attr("selected", "selected");
					break;
					case "普通管理员":$(".select-sex-ordinary").attr("selected", "selected");
					break;
					}
					selected = "selected";
					$("#employeeRole").hide();
				} else {
					$(this).text("修改");
					inputElement.attr("disabled", true);
					inputOldValue = inputElement.attr("value");
					inputNewValue = $('.select-role').val();
					if (!(inputNewValue == inputOldValue)) {
						$.ajax({
							url : "/manage/session/modify/employee/info",
							dataType : "json",
							type : "post",
							data : {
								"employeeRole" : inputNewValue,
								"employeeId":$("#employeeId").val()
							},
							success : function(result) {
								if (result.result == true) {
									$(".select-role").hide();
									$("#employeeRole").show();
							        inputElement.val(inputNewValue);
									inputElement.attr("value",inputNewValue);
								} else {
									$(".select-role").hide();
									$("#employeeRole").show();
									inputElement.val(inputOldValue);
									alert("修改失败")
								}
							}
						});
						
					}
					$(".select-role").hide();
					$("#employeeRole").show();
				}
				
			})
})


function select(){
	$(".content").show();
	$("#load", parent.document).css("height",
			$(document).outerHeight(true) + "px");
	$.ajax({
		url : '/manage/session/select/employee',
		dataType : "json",
		type : "post",
		data : {"employeeId":$("#searchEmployee").val()},
		success : function(result) {
		if(result.result == true){
			$(".head-img").attr("src",result.employee.employeeImgAddress);
			$("#employeeId").val(result.employee.employeeId);
			$("#employeeName").val(result.employee.employeeName);
			$("#employeePhone").val(result.employee.employeePhone);
			$("#employeeAge").val(result.employee.employeeAge);
			$("#employeeMailbox").val(result.employee.employeeMailbox);
			$("#entryTime").val(result.employee.entryTime);
			$("#employeeRole").val(result.employee.employeeRole);
			$("#employeePassword").val(result.employee.employeePassword);
			$("#employeeSex").val(result.employee.employeeSex);


			
			$("#employeeId").attr("value",result.employee.employeeId);
			$("#employeeName").attr("value",result.employee.employeeName);
			$("#employeePhone").attr("value",result.employee.employeePhone);
			$("#employeeAge").attr("value",result.employee.employeeAge);
			$("#employeeMailbox").attr("value",result.employee.employeeMailbox);
			$("#entryTime").attr("value",result.employee.entryTime);
			$("#employeeRole").attr("value",result.employee.employeeRole);
			$("#employeePassword").attr("value",result.employee.employeePassword);
			$("#employeeSex").attr("value",result.employee.employeeSex);
		}
		}
	})
}
function submitform() {
	var formData = new FormData($('#fileUploadFrom')[0]);
	formData.append("employeeId", $("#employeeId").val());
$.ajax({
		url : "/manage/session/modify/employee/img",
		type : "post",
		data : formData,
		processData : false,
		contentType : false,
		success : function(result) {
			if (result.result != "false") {
				$(".head-img").attr("src", "#");
				$(".head-img").attr("src", result.imgVisitAddress);
			} else {
				alter("修改失败");
			}
		}

	})
}
