<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/publish-house.css" />
<link rel="stylesheet" href="/static/css/iconfont.css" />
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/publish-house.js"></script>

<body onbeforeunload="checkLeave()">
	<div class="navbar navbar-default head">
		<div class="container">
			<div class="col-sm-1" style="padding-right: 0px;">
				<img src="/static/img/houselogo.png" class="houselogo" />
			</div>
			<div class="navbar-header">
				<a href="#" class="navbar-brand logo">住哪儿</a>
			</div>
			<div class="col-sm-1 place-div">
				<img src="/static/img/place.png" class="place-img" /> <span
					class="place"><a href="/house/show/selectAreaView"> <c:choose>
							<c:when test="${empty sessionScope.placeSession}">
					                 请选择城市
					</c:when>
							<c:otherwise>
        ${ sessionScope.placeSession}
						</c:otherwise>
						</c:choose>

				</a></span>
			</div>
			<ul class="nav navbar-nav navbar-right" id="head-nav">
				<li><a href="#">欢迎你！<span class="glyphicon glyphicon-user"></span>
						<span class="head-span-customerName">${sessionScope.customerSession.customerName}</span>
				</a></li>
				<li><a href="/house/show/indexView">首页</a>
				<li><a href="/house/session/show/personView">个人中心</a></li>
				<li><a href="#">帮助中心</a></li>
				<li><a>投诉渠道</a></li>
				<li><a href="/house/session/show/publish/house">房源发布</a></li>
				<li><a href="/house/quit">退出</a></li>
			</ul>
		</div>
	</div>


	<div class="content col-sm-12">
		<div class="col-sm-1"></div>
		<div class="col-sm-2 content-title" old-id="${map.house.houseId}">房源基本信息</div>
		<div class="col-sm-12">
			<form id="publish" >
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
					<!--出售方式-->
					<div class="col-sm-12 select">
						<div class="col-sm-2">
							<span class="select-sign">*</span> <span class="select-text">
								选择出售方式： </span>
						</div>
						<div class="col-sm-10 select-content">
						<c:choose>
						  <c:when test="{map.house.houseInfo.houseSellWay =='出售'}">
							<input type="radio" name="houseInfo.houseSellWay"class="radio-sell-way" value="出售"  checked /> 
							<label for="radio-sell-way">出售</label> 
							<input type="radio"	name="houseInfo.houseSellWay" class="radio-sell-way" value="租售" required /> 
							<label for="radio-sell-way">租售</label>
							</c:when>
							<c:otherwise>
							<input type="radio" name="houseInfo.houseSellWay"class="radio-sell-way" value="出售"  required  /> 
							<label for="radio-sell-way">出售</label> 
							<input type="radio"	name="houseInfo.houseSellWay" class="radio-sell-way" value="租售" checked /> 
							<label for="radio-sell-way">租售</label>
							</c:otherwise>
                            </c:choose>
						</div>

					</div>
					<!--地址-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 39px;">
							<span class="select-sign">*</span> <span class="select-text">
								房源地址： </span>
						</div>
						<div class="col-sm-10 select-content">

							<div class="col-sm-3 province select">

								<div class="province-select address-select">
									<span class="select-text province-select-text" name="houseAddressProvince">${map.house.houseAddressProvince}</span>

									<div class="select-img"></div>
								</div>
								<div
									class="select-content select-address-content province-select-content">
									<ul
										class="select-content-address-ul select-content-ul province-select-content-ul">

									</ul>

								</div>
							</div>

							<div class="col-sm-3 city select">

								<div class="city-select address-select">
									<span class="select-text city-select-text">${map.house.houseAddressCity}</span>

									<div class="select-img"></div>
								</div>
								<div
									class="select-content select-address-content city-select-content">
									<ul
										class="select-content-address-ul select-content-ul city-select-content-ul">
									</ul>
								</div>
							</div>

							<div class="col-sm-3 area select">
								<div class="area-select address-select">
									<span class="select-text area-select-text">${map.house.houseAddressArea}</span>

									<div class="select-img"></div>
								</div>
								<div
									class="select-content select-address-content area-select-content">
									<ul
										class="select-content-address-ul select-content-ul area-select-content-ul">
									</ul>
								</div>
							</div>



						</div>

					</div>
					<!--详细地址-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 39px;">
							<span class="select-sign">*</span> <span class="select-text">
								详细地址： </span>
						</div>
						<div class="col-sm-10 select-content">

							<input class="house-name detailed-address" type="text"
								maxlength="50" style="width: 600px; height: 32px;"
								name="houseAddressInfo" value='${map.house.houseAddressInfo}' />

						</div>
					</div>
					<!--房源类型-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 39px;">
							<span class="select-sign">*</span> <span class="select-text">
								房源类型： </span>
						</div>
						<div class="col-sm-10 select-content">
							<div class="col-sm-2">

								<select class="form-control houseType-select" name="houseInfo.houseType">
									<option>请选择</option>
									<option>商品房</option>
									<option>公寓</option>
									<option>别墅</option>
									<option>写字楼</option>
									<option>仓库</option>
									<option>厂房</option>
									<option>土地</option>
									<option>商铺</option>
									<option>车位</option>

								</select>
							</div>
						</div>
					</div>
					<!--房屋户型-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 39px;">
							<span class="select-sign">*</span> <span class="select-text">
								房屋户型： </span>
						</div>
						<div class="col-sm-10 select-content">
							<div class="col-sm-2 select-house-structure">
								<select class="form-control room" >
									<option>请选择</option>
									<option>0室</option>
									<option>1室</option>
									<option>2室</option>
									<option>3室</option>
									<option>4室</option>
									<option>5室</option>
									<option>6室</option>
									<option>7室</option>
									<option>8室</option>
									<option>9室</option>
									<option>10室</option>
								</select>
							</div>
							<div class="col-sm-2 select-house-structure">
								<select class="form-control office">
									<option>请选择</option>
										<option>0厅</option>
									<option>1厅</option>
									<option>2厅</option>
									<option>3厅</option>
									<option>4厅</option>
									<option>5厅</option>
									<option>6厅</option>
									<option>7厅</option>
									<option>8厅</option>
									<option>9厅</option>
									<option>10厅</option>
								</select>
							</div>
							<div class="col-sm-2 select-house-structure">
								<select class="form-control toilet">
									<option>请选择</option>
										<option>0卫</option>
									<option>1卫</option>
									<option>2卫</option>
									<option>3卫</option>
									<option>4卫</option>
									<option>5卫</option>
									<option>6卫</option>
									<option>7卫</option>
									<option>8卫</option>
									<option>9卫</option>
									<option>10卫</option>
								</select>
							</div>
							<div class="col-sm-2 select-house-structure">
								<input type="text" placeholder="建筑面积" name="houseInfo.houseSize" value='${map.house.houseInfo.houseSize}'/>
							</div>
						</div>

					</div>
					<!--售价/月租-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 34px;">
							<span class="select-sign">*</span> <span class="select-text">
								售价/月租： </span>
						</div>
						<div class="col-sm-10 select-content">
							<div class="money-div col-sm-2">
								<input class="money" type="text" maxlength="10"
									style="width: 110px; height: 32px;" name="houseInfo.houseMoney" value='${map.house.houseInfo.houseMoney}'/>
								<span>元</span>
							</div>
						</div>

					</div>
					<!--押金方式-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 39px;">
							<span class="select-sign">*</span> <span class="select-text">
								付款方式： </span>
						</div>
						<div class="col-sm-10 select-content">
							<div class="col-sm-2">
								<select class="form-control depoitway" name="houseInfo.houseDepoitWay">
									<option>押一付一</option>
									<option>押二付一</option>
									<option>押三付一</option>
									<option>半年付</option>
									<option>全年</option>
								</select>
							</div>
						</div>

					</div>
					<!--标题-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 78px;">
							<span class="select-sign">*</span> <span class="select-text">
								标题： </span>
						</div>
						<div class="col-sm-10 select-content">

							<input class="house-name" type="text" maxlength="30"
								style="width: 350px; height: 32px;" name="houseName" value='${map.house.houseName}'/>

						</div>
					</div>
					<!--朝向-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 78px;">
							<span class="select-sign">*</span> <span class="select-text">
								朝向： </span>
						</div>
						<div class="col-sm-10 select-content">
							<div class="col-sm-2">
								<select class="direction form-control"
									name="houseInfo.houseDirection">
									<option>请选择</option>
									<option>东</option>
									<option>南</option>
									<option>西</option>
									<option>北</option>
									<option>东南</option>
									<option>东西</option>
									<option>东北</option>
									<option>南北</option>
									<option>西南</option>
									<option>西北</option>
								</select>
							</div>
						</div>

					</div>
					<!--房屋配置-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 39px;">
							<span class="select-sign">*</span> <span class="select-text">
								房屋配置： </span>
						</div>
						<div class="col-sm-10 select-content house-device-div">
							<label><input type="checkbox" value="1" name="device.bed"
							<c:if test='${map.house.device.bed == 1}'>
							checked
							</c:if>
							>床 </label> 
							<label><input type="checkbox" value="1" name="device.wardrobe"
                            <c:if test='${map.house.device.wardrobe == 1}'>
							checked
							</c:if>
							>衣柜</label> 
							<label><input type="checkbox" name="device.desk"  value="1"
							<c:if test='${map.house.device.desk == 1}'>
							checked
							</c:if>
							>书桌 </label> 
							<label><input type="checkbox" value="1" name="device.air"
							<c:if test='${map.house.device.air == 1}'>
							checked
							</c:if>
							>空调</label> 
							<label><input type="checkbox" value="1" name="device.heater"
							<c:if test='${map.house.device.heater == 1}'>
							checked
							</c:if>
							>热水 </label> 
							<label><input type="checkbox" value="1" name="device.washer"
							<c:if test='${map.house.device.washer == 1}'>
							checked
							</c:if>
                             >洗衣机</label> 
							<label><input type="checkbox" value="1" name="device.refigerator"
							<c:if test='${map.house.device.refigerator == 1}'>
							checked
							</c:if>
                            >冰箱</label>
							<label><input type="checkbox" value="1"  name="device.wifi"
							<c:if test='${map.house.device.wifi == 1}'>
							checked
							</c:if>
                            >wifi</label> 
							<label><input type="checkbox" value="1"  name="device.sofa"
							<c:if test='${map.house.device.sofa == 1}'>
							checked
							</c:if>
							>沙发 </label> 
							<label><input type="checkbox" value="1" name="device.TV"
							<c:if test='${map.house.device.TV == 1}'>
							checked
							</c:if>
							>电视</label> 
							<label><input type="checkbox" value="1" name="device.balcony"
							<c:if test='${map.house.device.balcony == 1}'>
							checked
							</c:if>
							>阳台 </label> 
							<label><input type="checkbox" value="1" name="device.toilet"
							<c:if test='${map.house.device.toilet == 1}'>
							checked
							</c:if>
							>厕所</label> 
							<label><input type="checkbox" value="1" name="device.elevator"
							 <c:if test='${map.house.device.elevator == 1}'>
							checked
							</c:if> 
							>电梯 </label>
							<label><input type="checkbox" value="1" name="device.tubeCoal"
							<c:if test='${map.house.device.tubeCoal == 1}'>
							checked
							</c:if>
							>煤管</label> 
							<label><input type="checkbox" value="1" name="device.heating"
							<c:if test='${map.house.device.heating == 1}'>
							checked
							</c:if>
							>暖气 </label> 
							<label><input type="checkbox" value="1" name="device.escalator"
							<c:if test='${map.house.device.escalator == 1}'>
							checked
							</c:if>
							>扶梯</label>
							<label><input type="checkbox" value="1" name="device.smoke"
							<c:if test='${map.house.device.smoke == 1}'>
							checked
							</c:if>
							>排烟</label>
							<label><input type="checkbox" value="1" name="device.sewageDisposal"
							<c:if test='${map.house.device.sewageDisposal == 1}'>
							checked
							</c:if>
							>排污</label>
							<label><input type="checkbox" value="1" name="device.parking"
							<c:if test='${map.house.device.parking == 1}'>
							checked
							</c:if>
							>停车场</label>
						</div>

					</div>
					<!--房屋描述-->
					<div class="col-sm-12 select">
						<div class="col-sm-2" style="padding-left: 39px;">
							<span class="select-sign">*</span> <span class="select-text">
								房源描述： </span>
						</div>
						<div class="col-sm-10 select-content">
							<div class="col-sm-8">
								<textarea rows="5" cols="50" class="house-descripe" name="houseInfo.houseDescripe"	>
								</textarea>
							</div>
						</div>

					</div>

				</div>

  </form>
  <form id="fileUploadFrom" >
					<!--照片上传 -->
					<div class="col-sm-12 select">
					<div class="col-sm-1" ></div>
						<div class="col-sm-2" style="padding-left: 39px;width:170px">
							<span class="select-sign">*</span> <span class="select-text">
								上传图片： </span>
						</div>
						<div class="col-sm-9 select-content select-upload-img-show">
					 <c:forEach items="${map.list}" var= "img">
					 <div>
					 
					 <img src= '${img}'>
					 </div>
					 </c:forEach>  
						</div>
						
                        <div class="col-sm-3 select-upload-button">
                        <div class="select-upload-button-window">
                        <div class="select-upload-button-title">
                        上传电脑中图片
                        </div>
                        
                        <div class="select-upload-button-content">
                        <div style=" position: relative;" class="select-upload-button-img-and-input">
                        <img  class="select-upload-button-img">
                      
                          <input type="file" multiple="multiple" name="photoFile" class="select-upload-button-input" onchange="submitform()">
                          </div>
                          <div style="font-size:10px;color:#9a9a9a;">选择电脑图片上传</div>
                        </div>
                        </div>
                        </div>
					</div>
  </form>
				<!--发布完成-->
				<div class="col-sm-12"
					style="margin-top: 30px; margin-bottom: 50px;">
					<div class="col-sm-2"></div>
					<div class="col-sm-2" style="margin-left: 63px;">
						<button class="btn btn-primary btn-lg send" style="width: 200px;">发布</button>
					</div>

				</div>


		</div>
	</div>

<script>
$(document).ready(function(){
	$(".select-upload-button").css("padding-left", "270px");
	$(".select-upload-button").css("padding-top", "20px");
$(".house-descripe").val('${map.house.houseInfo.houseDescripe}');
select($(".houseType-select option"),'${map.house.houseInfo.houseType}');
select($(".room option"),'${map.house.houseInfo.houseStructure}'.substring(0,1)+"室");
select($(".office option"),'${map.house.houseInfo.houseStructure}'.substring(2,3)+"厅");
select($(".toilet option"),'${map.house.houseInfo.houseStructure}'.substring(4,5)+"卫");
select($(".depoitway option"),'${map.house.houseInfo.houseDepoitWay}');
select($(".direction option"),'${map.house.houseInfo.houseDirection}');
})
function select(div,value){
	let length = div.length;
	for(let i = 0;i < length ;i++){
	if(div.eq(i).val() == value){
		div.eq(i).attr("selected","selected");
	};
	}
}
</script> 

</body>