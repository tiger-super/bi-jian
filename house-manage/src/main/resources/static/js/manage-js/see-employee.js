let pageCurrent = 1;
$(document).ready(function() {
	loademployeeInformation();
	$(".select").click(function(){
		select();
	})
})

function loademployeeInformation() {
	$.ajax({
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
							showResult(list[i]);
						}
						$(".employee-tbody td").css("line-height",
								$(".employee-tbody td").outerHeight(true) + "px");
						showPageView(result.page);
					}}
			});

}
function showResult(employee){
	$(".employee-tbody").append(
			"<tr><td class='employeeId' value='"
					+ employee.employeeId
					+ "'>"
					+ employee.employeeId
					+ "</td>"
					+ "<td><img class='employeeImg' src='"
					+ employee.employeeImgAddress
					+ "'></td><td>"
					+ employee.employeeName
					+ "</td><td>"
					+ employee.employeeSex
					+ "</td>"
					+ "<td>"
					+ employee.employeeAge
					+ "</td><td>"
					+ employee.employeePassword
					+ "</td><td>"
					+ employee.employeePhone
					+ "</td>"
					+ "<td>"
					+ employee.employeeMailbox
					+ "</td>"
					+ "<td>"
					+ employee.employeeAddress
					+ "</td><td>"
					+ employee.entryTime
					+ "</td><td><button type='button' class='btn btn-warning delete'>删除</button></td></tr>");
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


function select(){
	$.ajax({
		url : '/manage/session/select/employee',
		dataType : "json",
		type : "post",
		data : {"employeeId":$("#searchEmployee").val()},
		success : function(result) {
			if(result.result){
				$(".employee-tbody").empty();
				showResult(result.employee);
			}else{
				loademployeeInformation();
			}
		}
	})
}