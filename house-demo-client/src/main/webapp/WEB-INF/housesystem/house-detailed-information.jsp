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
<link rel="stylesheet" href="/static/css/iconfont.css" />
<link rel="stylesheet" href="/static/css/house-detailed-information.css" />
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="/static/js/house-detailed-information.js"></script>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=nI6URMs9j07NGjGT3Ho2FRaj0NwdFMzx"></script>
<body>
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
				<c:choose>
					<c:when test="${empty sessionScope.customerSession.customerName}">
						<li><a href="/house/show/loginView"
							style="padding-right: 0px">登录</a></li>
						<li><a href="/house/show/registerView"
							style="padding-left: 5px">/&nbsp注册</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#">欢迎你！<span
								class="glyphicon glyphicon-user"></span>${sessionScope.customerSession.customerName}
						</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="/house/show/indexView">首页</a>
				<li><a href="/house/session/show/personView">个人中心</a></li>
				<li><a href="#">帮助中心</a></li>
				<li><a>投诉渠道</a></li>
				<li><a>网站导航</a></li>
				<c:if test="${not empty sessionScope.customerSession.customerName}">
					<li><a href="/house/quit">退出</a></li>
				</c:if>

			</ul>
		</div>
	</div>
	<div class="col-sm-1"></div>
	<div class="col-sm-10 house-info-window" houseId="${houseId}">

		<div class="col-sm-12 house-info-title">
			<div class="col-sm-11">
				<span>${house.houseName }</span><span style="margin-left: 10px">${house.houseInfo.houseStructure}</span>
			</div>
			<div class="col-sm-1 collection-div" >
			
				<div class="collection">
					<img src="/static/img/stars.png" class="collection-img">
				</div>
				<div style="font-weight: inherit; font-size: 8px">加入收藏</div>
			</div>
		</div>

		<div class="col-sm-12 house-info-content">
			<div class="col-sm-5 house-info-img-window"
				value='${house.houseInfo.houseImageAddress}'>
				<img src="/static/img/houseInfo.png" class="house-info-img-show">

				<div class="col-sm-11 house-info-list-window">
					<div class="col-sm-1 switch switch-left">
						<img src="/static/img/left.png">

					</div>
					<div class="col-sm-10 house-info-list-ul-window">

						<ul class="house-info-list-ul">
						</ul>
					</div>
					<div class="col-sm-1 switch switch-right"
						style="margin-left: 13px;">
						<img src="/static/img/right.png">

					</div>
				</div>
			</div>

			<div class="col-sm-7 house-other-info-window">
				<div class="col-sm-12 house-other-info">
					<div class="col-sm-12">
						<span class="house-money">${house.houseInfo.houseMoney}</span> <span
							class="house-money-company">元/月</span> <span>${house.houseInfo.houseDepoitWay}</span>
					</div>

					<div class="col-sm-12">
						<span>房屋类型：</span> <span>${house.houseInfo.houseDepoitWay}</span>
						<span>${house.houseInfo.houseSize}平米</span>
					</div>


					<div class="col-sm-12">
						<span>朝向楼层：</span> <span>${house.houseInfo.houseDirection}</span>

					</div>

					<div class="col-sm-12">

						<span>所在省市区：</span> <span class="addressProvince">${house.houseAddressProvince}</span>
						<span class="addressCity">${house.houseAddressCity}</span> <span
							class="addressArea">${house.houseAddressArea}</span>
					</div>


					<div class="col-sm-12">
						<span>详细地址：</span> <span class="address-info">${house. houseAddressInfo}</span>

					</div>


					<div class="col-sm-12">
						<div class="col-sm-12 publish-person-img-window">
							<div class="col-sm-2 publish-person-img-window"
								style="margin: 0px;">
								<img class="publish-person-img">
							</div>
							<div class="col-sm-8 publish"
								style="margin-top: 50px; font-size: 24px; font-weight: 700; color: #101d37;"
								publishId="${house.housePublisherId }"></div>
						</div>
					</div>

					<div class="col-sm-12 publish-person-phone-window">
						<div class="col-sm-2 publish-person-phone-logo">
							<img src="/static/img/phone.png">
						</div>
						<div class="col-sm-4  publish-person-phone">

							<div class="publish-person-phone-value" style="margin-top: 0px;"></div>
						</div>
					</div>
				</div>

			</div>



		</div>
	</div>




	<div class="col-sm-12" style="padding: 0px">
		<div class="col-sm-1"></div>
		<div class="col-sm-10 house-other-information-window">
			<div class="col-sm-1 house-other-information-word">房源详情</div>


			<div class="col-sm-12 house-device-info-windows">
				<div class="col-sm-10 house-device-info-div">
					<ul class="house-device-info-ul">
						<c:if test="${not empty house.device.bed}">
							<li><img src="/static/img/equipment/bed.png">
								<div class="house-device-info-name">床</div></li>
						</c:if>

						<c:if test="${not empty house.device.wardrobe}">
							<li><img src="/static/img/equipment/wardrobe.png">
								<div class="house-device-info-name">衣柜</div></li>
						</c:if>

						<c:if test="${not empty house.device.desk}">
							<li><img src="/static/img/equipment/desk.png">
								<div class="house-device-info-name">书桌</div></li>
						</c:if>

						<c:if test="${not empty house.device.air}">
							<li><img src="/static/img/equipment/air.png">
								<div class="house-device-info-name">空调</div></li>
						</c:if>


						<c:if test="${not empty house.device.heater}">
							<li><img src="/static/img/equipment/heater.png">
								<div class="house-device-info-name">热水</div></li>
						</c:if>


						<c:if test="${not empty house.device.washer}">
							<li><img src="/static/img/equipment/washer.png">
								<div class="house-device-info-name">洗衣机</div></li>
						</c:if>

						<c:if test="${not empty house.device.refigerator}">
							<li><img src="/static/img/equipment/refigerator.png">
								<div class="house-device-info-name">冰箱</div></li>
						</c:if>


						<c:if test="${not empty house.device.wifi}">
							<li><img src="/static/img/equipment/wifi.png">
								<div class="house-device-info-name">wifi</div></li>
						</c:if>


						<c:if test="${not empty house.device.sofa}">
							<li><img src="/static/img/equipment/sofa.png">
								<div class="house-device-info-name">沙发</div></li>
						</c:if>


						<c:if test="${not empty house.device.TV}">
							<li><img src="/static/img/equipment/tv.png">
								<div class="house-device-info-name">电视</div></li>
						</c:if>

						<c:if test="${not empty house.device.toilet}">
							<li><img src="/static/img/equipment/wc.png">
								<div class="house-device-info-name">厕所</div></li>
						</c:if>

						<c:if test="${not empty house.device.balcony}">
							<li><img src="/static/img/equipment/balcony.png">
								<div class="house-device-info-name">阳台</div></li>
						</c:if>



						<c:if test="${not empty house.device.cook}">
							<li><img src="/static/img/equipment/cook.png">
								<div class="house-device-info-name">厨房</div></li>
						</c:if>


						<c:if test="${not empty house.device.elevator}">
							<li><img src="/static/img/equipment/elevator.png">
								<div class="house-device-info-name">电梯</div></li>
						</c:if>

						<c:if test="${not empty house.device.tubeCoal}">
							<li><img src="/static/img/equipment/tubeCoal.png">
								<div class="house-device-info-name">煤管</div></li>
						</c:if>


						<c:if test="${not empty house.device.heating}">
							<li><img src="/static/img/equipment/heating.png">
								<div class="house-device-info-name">暖气</div></li>
						</c:if>

						<c:if test="${not empty house.device.escalator}">
							<li><img src="/static/img/equipment/escalator.png">
								<div class="house-device-info-name">扶梯</div></li>
						</c:if>

						<c:if test="${not empty house.device.smoke}">
							<li><img src="/static/img/equipment/smoke.png">
								<div class="house-device-info-name">排烟</div></li>
						</c:if>


						<c:if test="${not empty house.device.sewageDisposal}">
							<li><img src="/static/img/equipment/sewageDisposal.png">
								<div class="house-device-info-name">排污</div></li>
						</c:if>

						<c:if test="${not empty house.device.parking}">
							<li><img src="/static/img/equipment/parking.png">
								<div class="house-device-info-name">停车场</div></li>
						</c:if>
					</ul>
				</div>
			</div>


			<div class="col-sm-12 house-descripe-information-windows">
				<div class="col-sm-1 house-descripe-information-word">房源描述</div>
				<div class="col-sm-8 house-descripe-information">
					${house.houseInfo.houseDescripe}</div>


			</div>
		</div>






	</div>


	<div class="col-sm-12 house-baidu-api-windows" style="padding: 0px">
		<div class="col-sm-1" style="padding: 0px"></div>
		<div class="col-sm-10" style="padding: 0px">
			<div class="col-sm-12" style="padding: 0px">房源地图</div>
			<!-- 	<div class="col-sm-1"></div> -->
			<div class="col-sm-7" id="house-baidu-api"></div>
			<div class="col-sm-4" id="house-select-distance-result"></div>
			<div class="col-sm-12" style="padding: 0px">
				<div style="margin-top: 20px; margin-bottom: 20px">

					<label>测一测，看看该房源距离你的目的地(如:上学、工作地)是否近在眼前</label>
				</div>

				<form role="form" class="form-horizontal">
					<div class="form-group">
						<label class="col-sm-2 ">请输入目的地：</label>
						<div class="col-sm-6" style="padding: 0px">
							<input type="text" class="form-control select-distacne-input"
								placeholder="请输入该房源所在市的某个地址">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2">
							<label for="name">选择出行方式：</label>
						</div>
						<div class="col-sm-2" style="padding: 0px">
							<select class="form-control select-action-way">
								<option value="walking">步行</option>
								<option value="driving">驾车</option>
								<option value="transit">公交</option>
							</select>
						</div>
					</div>
				</form>
				<div class="col-sm-4  distance-button">
					<button class="btn btn-info select-button">
						查询</button>
				</div>
			</div>

		</div>
	</div>


<div class="col-sm-12 service-windows" style="height:200px;">
<div class="col-sm-1"></div>
<div class="col-sm-10 service-word">
相关服务
</div>
<div class="col-sm-12 service-img-div">
<div class="col-sm-1"></div>
<div class="col-sm-4 service-img-move">
<p class="service-title">搬家服务</p>
<p class="service-content">行李太多搬不动？</p>
<p class="service-content">专业人员来帮忙</p>

</div> 
<div class="col-sm-4 service-img-clean">
<p class="service-title">保洁服务</p>
<p class="service-content">健康卫生无小事</p>
<p class="service-content">保洁服务一条龙</p>
</div> 
</div>
</div>

<div class="tail-windows col-sm-12">
  <div class="col-sm-1"></div>
  <div class="col-sm-10 tail-content">
  <span>常见问题</span>
  <span class="line">|</span>
   <span>帮助中心</span>
  <span class="line">|</span>
   <span>意见反馈</span>
  <span class="line">|</span>
   <span>了解我们</span>
  <span class="line">|</span>
   <span>加入我们</span>
  <span class="line">|</span>
   <span>反欺诈联盟</span>
  <span class="line">|</span>
   <span>报案平台</span>
  <span class="line">|</span>
   <span>推广服务</span>
  <span class="line">|</span>
   <span>渠道招商</span>
  <span class="line">|</span>
   <span>Investor Relations</span>
  </div>
</div>

</body>

</html>