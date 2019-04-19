let pageCurrent = 1;
$(document).ready(function() {
	loadCustomerInformation();
	$(".select").click(function(){
		$.ajax({
			url : '/manage/session/get/id/from/vip',
			dataType : "json",
			type : "post",
			data : {
					"customerId" : $("#searchVip").val(),
					},
			success : function(result) {
				if(result.result){
					$(".vip-tbody").empty();
					showInformation(result.customer,0);
				}else{
					alert("不存在该vip用户");
					 loadCustomerInformation();
				}
			}
		})
	})
	
	
})

function loadCustomerInformation() {
	$.ajax({
		url : '/manage/session/get/vip/information',
		dataType : "json",
		type : "post",
		data : {
			"pageCurrent" : pageCurrent
		},
		success : function(result) {
			let list = result.list;
			$(".vip-tbody").empty();
			if(list != null){
			for (let i = 0; i < list.length; i++) {
				showInformation(list[i],i);
			}
			showPageView(result.page);
			}
	}
	});

}

function showInformation(customer,i){
	$(".vip-tbody").append(
			"<tr><td class='customerId' value='"+customer.customerId +"'>" + customer.customerId + "</td>"
			+ "<td><img class='vipImg' src='"
			+ customer.customerHeadImageAddress
			+ "'></td><td>" + customer.customerName
			+ "</td><td>" + customer.customerSex + "</td>"
			+ "<td>" + customer.customerAge + "</td><td>"
			+ customer.customerPhone + "</td><td class='mailbox'>"
			+ customer.customerMailbox + "</td><td>"
			+ customer.vipRechargeTime + "</td><td class='stopTime'>"
			+ customer.vipStopTime + "</td><td>"+
			"<button type='button' class='button-"+i+" btn btn-success pay-remind'>续费提醒</button></td></tr>");
	if(ifRemind(customer.vipStopTime)){
		$(".button-"+i).removeClass("btn-success");
		$(".button-"+i).addClass("btn-warning");
	}

$(".vip-tbody td").css("line-height",
		$(".vip-tbody td").height() + "px");
$(".pay-remind").click(function(){
	let mailbox = $(this).parents("tr").children(".mailbox").text();
	let stopStr = $(this).parents("tr").children(".stopTime").text()
	let stopDate = stringToDate(stopStr);
	let day = subtractDate(stopDate,new Date());
	$.ajax({
		url : '/manage/session/remind/renew',
		dataType : "json",
		type : "post",
		data : {
			"day" : day,
			"mailbox":mailbox,
		},
		success : function(result) {
			if(result.result == true){
				
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




var stringToDate = function(dateStr){ 
    var separator="-"; 
    var dateArr = dateStr.split(separator); 
    var year = parseInt(dateArr[0]); 
    var month; 
// 处理月份为04这样的情况
if(dateArr[1].indexOf("0") == 0){
        month = parseInt(dateArr[1].substring(1)); 
    }else{ 
         month = parseInt(dateArr[1]); 
    } 
    var day = parseInt(dateArr[2]); 
    var date = new Date(year,month -1,day); 
    return date; 
} 
var subtractDate = function(date1,date2){  
	   var t= date1.getTime() - date2.getTime(); 
	   return  parseInt(t / (1000 * 60 * 60 * 24)); 
}

var ifRemind = function(date1){
	var date2 = new Date();
	
	if(subtractDate(stringToDate(date1),date2)<3){
		return true;
	}else{
		return false;
	}
}