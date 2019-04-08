let pageCurrent = 1;
$(document).ready(function() {
	 loadVipInformation();
})

function loadVipInformation(){
	$.ajax({
		url : '/manage/session/get/vip/order/information',
		dataType : "json",
		type : "post",
		data : {
			"pageCurrent" : pageCurrent
		},
		success : function(result) {
			if(result.result){
				let list = result.list;
				$(".vip-tbody").empty();
				for (let i = 0; i < list.length; i++) {
					showResult(list[i]);
				}
				$(".vip-tbody td").css("line-height",
						$(".vip-tbody td").outerHeight(true) + "px");
				showPageView(result.page);
			}
		}
	})
	
}

function showResult(vip){
	$(".vip-tbody").append(
			"<tr><td class='vipId' value='"
					+ vip.payId
					+ "'>"
					+ vip.payId
					+ "</td>"
					+ "<td>"+vip.payPeopleId
					+"</td><td>"
					+ vip.payPeopleName
					+ "</td><td>"
					+ vip.payMoney
					+ "</td>"
					+ "<td>"
					+ vip.payTime
					+ "</td></tr>");
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
				loadVipInformation();
			})
			$(".next").click(function() {
				pageCurrent = pageCurrent + 1;
				loadVipInformation();
			})
			$(".upper").click(function() {
				pageCurrent = pageCurrent - 1;
				loadVipInformation();
			})
			$("#load", parent.document).css("height",
					$(document).outerHeight(true) + "px");
		}
	})
}
