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
						<input type="radio" name="houseInfo.houseSellWay" class="radio-sell-way" value="出售"  required/> <label
							for="radio-sell-way">出售</label> <input type="radio"
							name="houseInfo.houseSellWay" class="radio-sell-way" value="租售"  required/> <label
							for="radio-sell-way">租售</label>
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
								<span class="select-text province-select-text">省份</span>

								<div class="select-img"></div>
							</div>
							<div class="select-content select-address-content province-select-content">
								<ul class="select-content-address-ul select-content-ul province-select-content-ul">

								</ul>

							</div>
						</div>

						<div class="col-sm-3 city select">

							<div class="city-select address-select">
								<span class="select-text city-select-text">城市</span>

								<div class="select-img"></div>
							</div>
							<div class="select-content select-address-content city-select-content">
								<ul class="select-content-address-ul select-content-ul city-select-content-ul">
								</ul>
							</div>
						</div>

						<div class="col-sm-3 area select">
							<div class="area-select address-select">
								<span class="select-text area-select-text">区域</span>

								<div class="select-img"></div>
							</div>
							<div class="select-content select-address-content area-select-content">
								<ul class="select-content-address-ul select-content-ul area-select-content-ul">
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
							maxlength="50" style="width: 600px; height: 32px;" />

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

							<select class="form-control">
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
							<select class="form-control">
								<option>请选择</option>
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
							<select class="form-control">
								<option>请选择</option>
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
							<select class="form-control">
								<option>请选择</option>
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
							<input type="text" placeholder="建筑面积" />
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
								style="width: 110px; height: 32px;" /> <span>元</span>
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
							<select class="form-control">
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
							style="width: 350px; height: 32px;" />

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
							<select class="direction form-control">
								<option>请选择</option>
								<option value="">东</option>
								<option value="">南</option>
								<option value="">西</option>
								<option value="">北</option>
								<option value="">东南</option>
								<option value="">东西</option>
								<option value="">东北</option>
								<option value="">南北</option>
								<option value="">西南</option>
								<option value="">西北</option>
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
						<label><input name="house-device" type="checkbox" value="" />床
						</label> <label><input name="house-device" type="checkbox"
							value="" />衣柜</label> <label><input name="house-device"
							type="checkbox" value="" />书桌 </label> <label><input
							name="house-device" type="checkbox" value="" />空调</label> <label><input
							name="house-device" type="checkbox" value="" />热水 </label> <label><input
							name="house-device" type="checkbox" value="" />洗衣机</label> <label><input
							name="house-device" type="checkbox" value="" />冰箱</label> <label><input
							name="house-device" type="checkbox" value="" />wifi</label> <label><input
							name="house-device" type="checkbox" value="" />沙发 </label> <label><input
							name="house-device" type="checkbox" value="" />电视</label> <label><input
							name="house-device" type="checkbox" value="" />阳台 </label> <label><input
							name="house-device" type="checkbox" value="" />厕所</label> <label><input
							name="house-device" type="checkbox" value="" />电梯 </label> <label><input
							name="house-device" type="checkbox" value="" />煤管</label> <label><input
							name="house-device" type="checkbox" value="" />暖气 </label> <label><input
							name="house-device" type="checkbox" value="" />扶梯</label> <label><input
							name="house-device" type="checkbox" value="" />排烟</label> <label><input
							name="house-device" type="checkbox" value="" />排污</label> <label><input
							name="house-device" type="checkbox" value="" />停车场</label>
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
							<textarea rows="5" cols="50" class="house-descripe"></textarea>
						</div>
					</div>

				</div>
                <!--照片上传 -->
				<div class="col-sm-12 select">
					<div class="col-sm-2" style="padding-left: 39px;">
						<span class="select-sign">*</span> <span class="select-text">
							上传图片： </span>
					</div>
					<div class="col-sm-10 select-content"></div>

				</div>


			</div>
		
		
	<!--发布完成-->
	<div class="col-sm-12" style="margin-top: 30px; margin-bottom: 50px;">
		<div class="col-sm-2"></div>
		<div class="col-sm-2" style="margin-left: 55px;">
			<button class="btn btn-primary btn-lg" style="width: 200px;">发布</button>
		</div>

	</div>
		
		</form>
		</div>
	</div>



</body>