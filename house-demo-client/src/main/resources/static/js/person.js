$(document)
		.ready(
				function() {
					// 显示我的收藏
					$(".my-collection").click(function() {
						$(".content-right").css("display", "none");
						$(".my-collection-view").css("display", "block");
						pageCurrent = 1;
						loadMyCollection();
					})
					$(".select-sex").hide();
					// 显示个人信息
					$(".person-information").click(function() {
						$(".content-right").css("display", "none");
						$(".person-information-view").css("display", "block");
					})
					// 显示我的发布
					$(".my-publish").click(
							function() {
								$(".content-right").css("display", "none");
								$(".my-publish-view").css("display", "block");
								let json = {};
								json.housePublisherState = "1";
								loadHouseInfo(json);
								$(".my-publish-view").attr("value", "1");
								$(".my-publish-content").attr("value",
										"housePublisherState");
								pageCurrent = 1;
							})
					// 显示已发布
					$(".publish-div").click(
							function() {
								$(".publish-div-button").css("color", "black");
								$(this).css("color", "red");
								let json = {};
								json.housePublisherState = "1";
								loadHouseInfo(json);
								$(".my-publish-view").attr("value", "1");
								$(".my-publish-content").attr("value",
										"housePublisherState");
								pageCurrent = 1;
							})
					// 显示未发布
					$(".no-publish-div").click(
							function() {
								$(".publish-div-button").css("color", "black");
								$(this).css("color", "red");
								let json = {};
								json.housePublisherState = "0";
								loadHouseInfo(json);
								$(".my-publish-view").attr("value", "0");
								$(".my-publish-content").attr("value",
										"housePublisherState");
								pageCurrent = 1;
							})
					// 显示待审核
					$(".to-be-audited-div").click(
							function() {
								$(".publish-div-button").css("color", "black");
								$(this).css("color", "red");
								let json = {};
								json.houseAuditingState = "0";
								loadHouseInfo(json);
								$(".my-publish-view").attr("value", "0");
								$(".my-publish-content").attr("value",
										"houseAuditingState");
								pageCurrent = 1;
							})
					// 显示审核失败
					$(".audit-failure").click(
							function() {
								$(".publish-div-button").css("color", "black");
								$(this).css("color", "red");
								let json = {};
								json.houseAuditingState = "-1";
								loadHouseInfo(json);
								$(".my-publish-view").attr("value", "-1");
								$(".my-publish-content").attr("value",
										"houseAuditingState");
								pageCurrent = 1;
							})
					$
							.ajax({
								url : '/house/session/gain/info',
								dataType : "json",
								type : "post",
								success : function(result) {
									$("#customerName").attr("value",
											result.customerName);
									$("#customerPhone").attr("value",
											result.customerPhone);
									$("#customerSex").attr("value",
											result.customerSex);
									$("#customerAge").attr("value",
											result.customerAge);
									$("#customerMailbox").attr("value",
											result.customerMailbox);
									if (result.customerHeadImageAddress != null) {
										$(".head-img")
												.attr(
														"src",
														result.customerHeadImageAddress);
									} else {
										$(".head-img")
												.attr("src",
														"/static/img/renyuanzengjia.png");
									}
								}
							});

					$(".modify")
							.click(
									function() {
										var inputElement = $(this).parent()
												.parent().find("input");
										var disabled = inputElement
												.prop("disabled");
										if (disabled == true) {
											$(this).text("确定");
											inputElement
													.attr("disabled", false);
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
											var inputOldValue = inputElement
													.attr("value");
											var inputNewValue = inputElement
													.val();
											var data;
											if (!(inputNewValue == inputOldValue)) {
												var attribute = inputElement
														.prop("id");
												var urlAddress;
												switch (attribute) {
												case "customerName":
													urlAddress = "/house/session/modify/customerName";
													data = {
														"customerName" : inputNewValue
													};
													break;
												case "customerAge":
													urlAddress = "/house/session/modify/customerAge";
													data = {
														"customerAge" : inputNewValue
													};
													break;
												default:
													urlAddress = "/house/session/modify/customerMailbox";
													data = {
														"customerMailbox" : inputNewValue
													};
													break;
												}
												$
														.ajax({
															url : urlAddress,
															dataType : "json",
															type : "post",
															data : data,
															success : function(
																	result) {
																if (result == true) {
																	inputElement
																			.attr(
																					"value",
																					inputNewValue);
																	if (attribute == 'customerName') {
																		$
																				.ajax({
																					url : '/house/session/gain/object',
																					success : function(
																							result) {
																						if (result != null) {
																							$(
																									".head-span-customerName")
																									.text(
																											result.customerName);
																						}
																					}

																				})
																	}
																} else {
																	inputElement
																			.val(inputOldValue);
																	alert("修改失败")
																}
															}
														});
											}
										}

									})

					$(".modifysex")
							.click(
									function() {
										var inputElement = $(this).parent()
												.parent().find("input");
										var disabled = inputElement
												.prop("disabled");
										var inputOldValue;
										var inputNewValue;
										if (disabled == true) {
											$(".select-sex").show();
											$("#customerSex").hide();
											$(this).text("确定");
											inputElement
													.attr("disabled", false);
											inputOldValue = inputElement
													.attr("value");
											switch (inputOldValue) {
											case "男":
												$(".select-sex-man").attr(
														"selected", "selected");
												break;
											case "女":
												$(".select-sex-woman").attr(
														"selected", "selected");
												break;
											}
											selected = "selected";
											$("#customerSex").hide();
										} else {
											$(this).text("修改");
											inputElement.attr("disabled", true);
											inputNewValue = $('.select-sex')
													.val();

											if (!(inputNewValue == inputOldValue)) {
												$
														.ajax({
															url : "/house/session/modify/customerSex",
															dataType : "json",
															type : "post",
															data : {
																"customerSex" : inputNewValue
															},
															success : function(
																	result) {

																if (result == true) {
																	inputElement
																			.attr(
																					"value",
																					inputNewValue);
																} else {
																	inputElement
																			.val(inputOldValue);
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
// 上传头像
function submitform() {
	$.ajax({
		url : "/house/session/photo/upload",
		type : "post",
		data : new FormData($('#fileUploadFrom')[0]),
		processData : false,
		contentType : false,
		success : function(result) {
			if (result != "false") {
				$(".head-img").attr("src", "#");
				$(".head-img").attr("src", result);
			} else {
				alter("上传失败");
			}
		}

	})
}
// 加载房源信息
function loadHouseInfo(data) {
	$.ajax({
		url : "/house/session/publish/manage",
		type : "post",
		dataType : "json",
		data : data,
		success : function(result) {

			let list = result.list;
			$(".my-publish-content").empty();
			for (let i = 0; i < list.length; i++) {
				showHouseInfo(list[i], i, $(".my-publish-content"));
			}
			showPageView(result.page, $(".my-publish-content"));
			// 下架事件
			$(".cancel-publish").click(
					function() {
						let houseId = $(this).parents(".publish-content-div")
								.attr("value");
						modifyHouseState({
							"housePublisherState" : "0",
							"houseId" : houseId
						}, "下架成功");
					})
			// 立即发布事件
			$(".immediately-publish").click(
					function() {
						let houseId = $(this).parents(".publish-content-div")
								.attr("value");
						modifyHouseState({
							"housePublisherState" : "1",
							"houseId" : houseId
						}, "发布成功");
					})
			// 申请事件
			$(".apply-publish").click(
					function() {
						let houseId = $(this).parents(".publish-content-div")
								.attr("value");
						modifyHouseState({
							"houseAuditingState" : "0",
							"houseId" : houseId
						}, "申请成功");
					})
			// 删除事件
			$(".delete").click(
					function() {
						let houseId = $(this).parents(".publish-content-div")
								.attr("value");
						deleteHouse({
							"houseId" : houseId
						});
					})
		}

	})
}
// 房源信息渲染
function showHouseInfo(house, i, div) {
	div
			.append("<div class='publish-content-div publish-content-div-"
					+ i
					+ " col-sm-12' value="
					+ house.houseId
					+ ">"
					+ "<div class='house-image-div col-sm-2' ><img src='"
					+ house.houseInfo.houseImageAddress
					+ "' class='house-image'></div><div class='publish-content col-sm-8'>"
					+ "<div class='col-sm-12 house-name'>" + house.houseName
					+ "</div><div class='col-sm-12 house-address'>"
					+ house.houseAddressProvince + house.houseAddressCity
					+ house.houseAddressArea + "</div><div "
					+ "class='col-sm-12'>" + house.houseInfo.houseSellWay
					+ "</div><div class='col-sm-12'>" + "<span >"
					+ house.houseInfo.houseStructure
					+ "&nbsp|&nbsp</span><span >" + house.houseInfo.houseSize
					+ "平米" + "&nbsp|&nbsp</span><span>"
					+ house.houseInfo.houseMoney + "元</span></div></div></div>");
	let key = $(".my-publish-content").attr("value");
	switch (key) {
	case "housePublisherState":
		switch ($(".my-publish-view").attr("value")) {
		case "1":
			$(".publish-content-div-" + i)
					.append(
							"<div class='operation-div col-sm-2' >"
									+ "<button type='button' class='btn btn-default btn-sm btn-info see'>"
									+ "<a href='/house/show/house/info?houseId="
									+ house.houseId
									+ "'>查看</a>"
									+ "</button>"
									+ "<button type='button' class='btn btn-default btn-sm  btn-warning cancel-publish'>下架</button>"
									+ "<button type='button' class='btn btn-default btn-sm btn-danger delete'>删除</button></div></div>")
			break;
		case "0":
			$(".publish-content-div-" + i)
					.append(
							"<div class='operation-div col-sm-2' >"
									+ "<button type='button' class='btn btn-default btn-sm btn-info see'>查看</button>"
									+ "<button type='button' class='btn btn-default btn-sm  btn-warning immediately-publish'>发布</button>"
									+ "<button type='button' class='btn btn-default btn-sm btn-danger delete'>删除</button></div></div>")
			break;
		}
		break;
	case "houseAuditingState":
		switch ($(".my-publish-view").attr("value")) {
		case "-1":
			$(".publish-content-div-" + i)
					.append(
							"<div class='operation-div col-sm-2' >"
									+ "<button type='button' class='btn btn-default btn-sm btn-info see'>查看</button>"
									+ "<button type='button' class='btn btn-default btn-sm  btn-warning apply-publish'>申请</button>"
									+ "<button type='button' class='btn btn-default btn-sm btn-danger delete'>删除</button></div></div>")
			break;
		case "0":
			$(".publish-content-div-" + i)
					.append(
							"<div class='operation-div col-sm-2' >"
									+ "<button type='button' class='btn btn-default btn-sm btn-info see'>查看</button>"
									+ "<button type='button' class='btn btn-default btn-sm btn-danger delete'>删除</button></div></div>")
			break;
		}
		break;
	}

}

let pageCurrent = 1;
// 分页功能
function showPageView(page, div) {
	div.append("<div class='col-sm-12' style='padding:0px'><div class='col-sm-6'></div><div class='col-sm-6 page-show-content'></div></div>");
	pageCurrent = page.pageCurrent;
	$.ajax({
		url : '/house/get/show/page',
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
			// 对应的页码
			$(".page").click(function() {
				pageCurrent = parseInt($(this).text());
				let json = getJson();
				json.housePublisherState = $(".my-publish-view").attr("value");
				json.pageCurrent = pageCurrent;
				loadHouseInfo(json);
			})
			// 下一页
			$(".next").click(function() {
				pageCurrent = pageCurrent + 1;
				let json = getJson();
				json.housePublisherState = $(".my-publish-view").attr("value");
				json.pageCurrent = pageCurrent;
				loadHouseInfo(json);

			})
			// 上一页
			$(".upper").click(function() {
				pageCurrent = pageCurrent - 1;
				let json = getJson();
				json.housePublisherState = $(".my-publish-view").attr("value");
				json.pageCurrent = pageCurrent;
				loadHouseInfo(json);
			})
		}
	})
}

function getJson() {
	let json = {};
	let key = $(".my-publish-content").attr("value");
	switch (key) {
	case "housePublisherState":
		json.housePublisherState = $(".my-publish-view").attr("value");
		break;
	case "houseAuditingState":
		json.houseAuditingState = $(".my-publish-view").attr("value");
		break;
	}
	return json;
}
// 修改房源状态
function modifyHouseState(data, text) {
	$.ajax({
		url : "/house/session/modify/state",
		type : "post",
		dataType : "json",
		data : data,
		success : function(result) {
			if (result == true) {
				alert(text);
				let json = {};
				json.pageCurrent = pageCurrent;
				switch (text) {
				case "发布成功":
					json.housePublisherState = "0";
					break;
				case "下架成功":
					json.housePublisherState = "1";
					break;
				case "申请成功":
					json.houseAuditingState = "-1";
				}
				loadHouseInfo(json);
			}
		}
	})
}
function deleteHouse(data) {
	if (confirm("你确定要删除掉该房源吗")) {
		/*
		 * $.ajax({ url : "/house/delete", type : "post", dataType : "json",
		 * data : data, success : function(result) { if(result == true){
		 * alert("删除成功") loadHouseInfo(json); } } })
		 */
	}
}
// 加载收藏信息
function loadMyCollection(data) {
	$
			.ajax({
				url : '/house/load/collection',
				type : 'post',
				dataType : 'json',
				data : data,
				success : function(result) {
					if (result.result == true) {
						$(".my-collection-content").empty();
						let house = result.list;
						if (house != undefined) {
							for (let i = 0; i < house.length; i++) {
								showHouseInfo(house[i], i,
										$(".my-collection-content"));
							}
							console.log(result.page)
							showPageView(result.page,$(".my-collection-content"));
						}
					}
				}
			})
}
/*// 收藏信息的分页功能
function showPageView(page) {
	$(".my-collection-content")
			.append(
					"<div class='col-sm-12' style='padding:0px'><div class='col-sm-6'></div><div class='col-sm-6 page-show-content'></div></div>");
	pageCurrent = page.pageCurrent;
	$.ajax({
		url : '/house/get/show/page',
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
				let json = getJson();
				json.housePublisherState = $(".my-publish-view").attr("value");
				json.pageCurrent = pageCurrent;
				loadMyCollection(json);
			})
			$(".next").click(function() {
				pageCurrent = pageCurrent + 1;
				let json = getJson();
				json.housePublisherState = $(".my-publish-view").attr("value");
				json.pageCurrent = pageCurrent;
				loadMyCollection(json);
			})
			$(".upper").click(function() {
				pageCurrent = pageCurrent - 1;
				let json = getJson();
				json.housePublisherState = $(".my-publish-view").attr("value");
				json.pageCurrent = pageCurrent;
				loadMyCollection(json);
			})
		}
	})
}*/