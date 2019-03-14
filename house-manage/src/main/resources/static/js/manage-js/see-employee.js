let pageCurrent = 1;
$(document).ready(function() {
	loademployeeInformation();
})

function loademployeeInformation() {
	$
			.ajax({
				url : '/manage/session/get/employee/information',
				dataType : "json",
				type : "post",
				data : {
					"pageCurrent" : pageCurrent
				},
				success : function(result) {
					let list = result.list;
					$(".employee-tbody").empty();
					if (list != null) {
						for (let i = 0; i < list.length; i++) {
							$(".employee-tbody")
									.append(
											"<tr><td class='employeeId' value='"
													+ list[i].employeeId
													+ "'>"
													+ list[i].employeeId
													+ "</td>"
													+ "<td><img class='employeeImg' src='"
													+ list[i].employeeImgAddress
													+ "'></td><td>"
													+ list[i].employeeName
													+ "</td><td>"
													+ list[i].employeeSex
													+ "</td>"
													+ "<td>"
													+ list[i].employeeAge
													+ "</td><td>"
													+ list[i].employeePassword
													+ "</td><td>"
													+ list[i].employeePhone
													+ "</td>"
													+ "<td>"
													+ list[i].employeeMailbox
													+ "</td>"
													+ "<td>"
													+ list[i].employeeAddress
													+ "</td><td>"
													+ list[i].entryTime
													+ "</td><td>"
													+ "<button type='button' class='btn btn-warning add-black'>删除</button></td></tr>");
						}
						$(".employee-tbody td").css("line-height",
								$(".employee-tbody td").outerHeight(true) + "px");
						showPageView(result.page);
						$(".add-black")
								.click(
										function() {
											let employeeId = $(this).parents(
													"tr").children("td").eq(0)
													.text()
											$
													.ajax({
														url : '/manage/modify/black/state',
														dataType : "json",
														type : "post",
														data : {
															"pageCurrent" : pageCurrent,
															"condition" : "1",
															"employeeId" : employeeId
														},
														success : function(
																result) {
															if (result.result == true) {
																if (result.page.pageCurrent != 0) {
																	pageCurrent = result.page.pageCurrent;
																} else if (result.page.pageCurrent == 0) {
																	pageCurrent = 1;
																}
																loademployeeInformation();
															} else {
																alert("操作失败");
															}
														}
													})
										})
					}
				}

			});

}

function showPageView(page) {
	pageCurrent = page.pageCurrent;
	$.ajax({
		url : '/manage/get/show/page',
		dataType : "json",
		type : "post",
		data : page,
		success : function(result) {
			$(".page-show-content").empty();
			for (let i = 0; i < result.length; i++) {
				switch (result[i]) {
				case "上一页":
					$(".page-show-content").append(
							"<button class='btn upper' >" + result[i]
									+ "</button>")
					break;
				case "下一页":
					$(".page-show-content").append(
							"<button class='btn next' >" + result[i]
									+ "</button>")
					break;
				case "...":
					$(".page-show-content").append(
							"<button class='btn next-display disabled' >"
									+ result[i] + "</button>")
					break;
				case "" + (page.pageCurrent):
					$(".page-show-content").append(
							"<button class='btn btn-info page' >" + result[i]
									+ "</button>")
					break;
				default:
					$(".page-show-content").append(
							"<button class='btn page' >" + result[i]
									+ "</button>")
					break;
				}

			}
			$(".page").click(function() {
				pageCurrent = parseInt($(this).text());
				loademployeeInformation();
			})
			$(".next").click(function() {
				pageCurrent = pageCurrent + 1;
				loademployeeInformation();
			})
			$(".upper").click(function() {
				pageCurrent = pageCurrent - 1;
				loademployeeInformation();
			})
			$("#load", parent.document).css("height",
					$(document).outerHeight(true) + "px");
		}
	})
}