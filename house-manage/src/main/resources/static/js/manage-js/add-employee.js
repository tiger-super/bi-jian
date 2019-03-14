$(document).ready(
		function() {
			$("#load", parent.document).css("height",
					$(document).outerHeight(true) + "px");
			
			$(".add").click(function(){
				addEmployee();
			})
		})

// 上传头像
function submitform() {
	$.ajax({
		url : "/manage/session/photo/upload",
		type : "post",
		data : new FormData($('#fileUploadFrom')[0]),
		processData : false,
		contentType : false,
		success : function(result) {
			$(".employee-img").attr("src", result.imgAddress);
		}

	})
}


function addEmployee(){
	$.ajax({
		url : "/manage/session/add/employee",
		type : "post",
		data : $("#employee-from").serialize(),
		success : function(result) {
			alert("添加成功，注册账号为："+result.employeeId);
			window.location.reload();
		}

	})
}