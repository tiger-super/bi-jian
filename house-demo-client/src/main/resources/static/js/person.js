$(document).ready(function() {
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
			var inputNewValue = inputElement.val();
			var inputOldValue = inputElement.prop("value");
			if (!inputNewValue == inputOldValue) {
				var attribute = inputElement.prop("id");
				var urlAddress;
				switch (attribute) {
				case "customerName":
					urlAddress = "/house/session/modify/customerName";
					break;
				case "customerSex":
					urlAddress = "/house/session/modify/customerSex";
					break;
				case "customerAge":
					urlAddress = "/house/session/modify/customerAge";
					break;
				default:
					urlAddress = "/house/session/modify/customerMailbox";
					break;
				}
			}
			$.ajax({
				url : urlAddress,
				dataType : "json",
				type : "get",
				data : {
					attribute : inputNewValue
				},
				success : function(result) {
					if (result == "true") {
						inputElement.attr("value", inputNewValue);
					} else {
						inputElement.val(inputOldValue);
						alert("修改失败")
					}
				}
			});

		}

	})

})