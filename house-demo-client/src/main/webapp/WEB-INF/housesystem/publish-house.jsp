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
				<li><a href="#">欢迎你！<span class="glyphicon glyphicon-user"></span>
						<span class="head-span-customerName">${sessionScope.customerSession.customerName}</span>
				</a></li>
				<li><a href="/house/show/indexView">首页</a>
				<li><a href="/house/session/show/personView">个人中心</a></li>
				<li><a href="#">帮助中心</a></li>
				<li><a>投诉渠道</a></li>
				<li><a>网站导航</a></li>
				<li><a href="/house/quit">退出</a></li>
			</ul>
		</div>
	</div>


	<div class="content col-sm-12">
		<div class="col-sm-1"></div>
		<div class="col-sm-2 content-title">房源基本信息</div>
		<div class="col-sm-12">
			<form id="publish">
				<div class="col-sm-1"></div>
				<div class="col-sm-10">
					<!--出售方式-->
					<div class="col-sm-12 select">
						<div class="col-sm-2">
							<span class="select-sign">*</span> <span class="select-text">
								选择出售方式： </span>
						</div>
						<div class="col-sm-10 select-content">
							<input type="radio" name="houseInfo.houseSellWay"
								class="radio-sell-way" value="出售" required /> <label
								for="radio-sell-way">出售</label> <input type="radio"
								name="houseInfo.houseSellWay" class="radio-sell-way" value="租售"
								required /> <label for="radio-sell-way">租售</label>
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
									<span class="select-text province-select-text" name="houseAddressProvince">省份</span>

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
									<span class="select-text city-select-text">城市</span>

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
									<span class="select-text area-select-text">区域</span>

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
								name="houseAddressInfo" />

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

								<select class="form-control" name="houseInfo.houseType">
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
									<option>一室</option>
									<option>二室</option>
									<option>三室</option>
									<option>四室</option>
									<option>五室</option>
									<option>六室</option>
									<option>七室</option>
									<option>八室</option>
									<option>九室</option>
									<option>十室</option>
								</select>
							</div>
							<div class="col-sm-2 select-house-structure">
								<select class="form-control office">
									<option>请选择</option>
									<option>一厅</option>
									<option>二厅</option>
									<option>三厅</option>
									<option>四厅</option>
									<option>五厅</option>
									<option>六厅</option>
									<option>七厅</option>
									<option>八厅</option>
									<option>九厅</option>
									<option>十厅</option>
								</select>
							</div>
							<div class="col-sm-2 select-house-structure">
								<select class="form-control toilet">
									<option>请选择</option>
									<option>一卫</option>
									<option>二卫</option>
									<option>三卫</option>
									<option>四卫</option>
									<option>五卫</option>
									<option>六卫</option>
									<option>七卫</option>
									<option>八卫</option>
									<option>九卫</option>
									<option>十卫</option>
								</select>
							</div>
							<div class="col-sm-2 select-house-structure">
								<input type="text" placeholder="建筑面积" name="houseInfo.houseSize" />
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
									style="width: 110px; height: 32px;" name="houseInfo.houseMoney" />
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
								<select class="form-control" name="houseInfo.houseDepoitWay">
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
								style="width: 350px; height: 32px;" name="houseName" />

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
							<label><input  type="checkbox"
								value="1" name="device.bed"/>床 </label> <label><input 
								type="checkbox" value="1" name="device.wardrobe"/>衣柜</label> <label><input
								 type="checkbox" name="device.desk"/>书桌 </label> <label><input
								 type="checkbox" value="1" name="device.air"/>空调</label> <label><input
								 type="checkbox" value="1" name="device.heater"/>热水 </label> <label><input
								 type="checkbox" value="1" name="device.washer"/>洗衣机</label> <label><input
								 type="checkbox" value="1" name="device.refigerator"/>冰箱</label> <label><input
								 type="checkbox" value="1"  name="device.wifi"/>wifi</label> <label><input
								 type="checkbox" value="1"  name="device.sofa"/>沙发 </label> <label><input
								 type="checkbox" value="1" name="device.TV"/>电视</label> <label><input
								 type="checkbox" value="1" name="device.balcony"/>阳台 </label> <label><input
								 type="checkbox" value="1" name="device.toilet"/>厕所</label> <label><input
								 type="checkbox" value="1" name="device.elevator"/>电梯 </label> <label><input
								 type="checkbox" value="1" name="device.tubeCoal"/>煤管</label> <label><input
								 type="checkbox" value="1" name="device.heating"/>暖气 </label> <label><input
								 type="checkbox" value="1" name="device.escalator"/>扶梯</label> <label><input
								 type="checkbox" value="1" name="device.smoke"/>排烟</label> <label><input
								 type="checkbox" value="1" name="device.sewageDisposal"/>排污</label> <label><input
								 type="checkbox" value="1" name="device.parking"/>停车场</label>
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
								<textarea rows="5" cols="50" class="house-descripe" name="houseInfo.houseDescripe"></textarea>
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



</body>