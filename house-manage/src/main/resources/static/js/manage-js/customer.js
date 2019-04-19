let pageCurrent = 1;
$(document).ready(function() {
	loadCustomerInformation();
	$(".select").click(function(){
		select();
	})
})

function loadCustomerInformation() {
	$.ajax({
		url : '/manage/load/customer/information',
		dataType : "json",
		type : "post",
		data : {
			"pageCurrent" : pageCurrent
		},
		success : function(result) {
			let list = result.list;
			$(".customer-tbody").empty();
			if(list != null){
			for (let i = 0; i < list.length; i++) {
				$(".customer-tbody").append(
						"<tr><td class='customerId' value='"+list[i].customerId +"'>" + list[i].customerId + "</td>"
								+ "<td><img class='customerImg' src='"
								+ list[i].customerHeadImageAddress
								+ "'></td><td>" + list[i].customerName
								+ "</td><td>" + list[i].customerSex + "</td>"
								+ "<td>" + list[i].customerAge + "</td><td>"
								+ list[i].customerPhone + "</td>" + "<td>"
								+ list[i].customerMailbox + "</td><td>"+
								"<button type='button' class='btn btn-warning add-black'>加入黑名单</button></td></tr>");
			}
			addFunction();
			$(".customer-tbody td").css("line-height",
					$(".customer-tbody td").height() + "px");
			showPageView(result.page);
			}
		}

	});

}
function addFunction(){
	$(".add-black").click(function(){
		let customerId = $(this).parents("tr").children("td").eq(0).text()
		$.ajax({
			url : '/manage/modify/black/state',
			dataType : "json",
			type : "post",
			data : {
				"pageCurrent" : pageCurrent,
				"condition":"1",
				"customerId":customerId
			},
			success : function(result) {
				if(result.result == true){
					if(result.page.pageCurrent != 0){
						pageCurrent = result.page.pageCurrent;
					}else if(result.page.pageCurrent == 0){
						pageCurrent = 1;
					}
					loadCustomerInformation();
				}else{
					alert("操作失败");
				}
			}
		})
	})
	
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
				loadCustomerInformation();
			})
			$(".next").click(function() {
				pageCurrent = pageCurrent + 1;
				loadCustomerInformation();
			})
			$(".upper").click(function() {
				pageCurrent = pageCurrent - 1;
				loadCustomerInformation();
			})
			$("#load", parent.document).css("height",
					$(document).outerHeight(true) + "px");
		}
	})
}	
	
function select(){
		$.ajax({
			url : '/manage/session/select/customer/with/id',
			dataType : "json",
			type : "post",
			data : {"customerId":$("#searchCustomer").val()},
			success : function(result) {
				if(result.result){
					$(".page-show-content").empty();
					$(".customer-tbody").empty();
					let customer = result.customer;
					$(".customer-tbody").append(
							"<tr><td class='customerId' value='"+customer.customerId +"'>" + customer.customerId + "</td>"
									+ "<td><img class='customerImg' src='"
									+ customer.customerHeadImageAddress
									+ "'></td><td>" + customer.customerName
									+ "</td><td>" + customer.customerSex + "</td>"
									+ "<td>" + customer.customerAge + "</td><td>"
									+ customer.customerPhone + "</td>" + "<td>"
									+ customer.customerMailbox + "</td><td>"+
									"<button type='button' class='btn btn-warning add-black'>加入黑名单</button></td></tr>");
					addFunction();
				}else{
					loadCustomerInformation();
				}
			}
		})
	}
