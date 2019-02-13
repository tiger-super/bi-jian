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
<link rel="stylesheet" href="/static/css/house-list.css" />
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/house-list.js"></script>
<script type="text/javascript" src="/static/js/index.js"></script>

<body>
	<div class="navbar navbar-default head">
		<div class="container">
			<div class="col-sm-1" style="padding-right: 0px;">
				<img src="/static/img/houselogo.png" class="houselogo" />
			</div>
			<div class="navbar-header">
				<a href="#" class="navbar-brand logo" value=${houseSellWay}>住哪儿</a>
			</div>
			<div class="col-sm-1 place-div">
				<img src="/static/img/place.png" class="place-img" /> <span
					class="place"><a href="/house/show/selectAreaView"  class="show-city-a">> 

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

	<div class="content col-sm-11">
		<div class="col-sm-12 select-area-title-window">
			<div class="col-sm-1 select-area-title">位置</div>
			<div class="col-sm-2 select-area-title">
				<span style="margin-right: 15px;color:blue">区域</span><img
					src="/static/img/down.png">
			</div>
		</div>

		<div class="col-sm-12 select-area-content-window">
			<div class="col-sm-12 select-area-content" >
			<c:forEach items="${areaList}" var="area">
				<div class="col-sm-1 select-area-content-part">${area}</div>
			</c:forEach>

		</div>


		<div class="col-sm-12 show-sort-window">
			<div class="col-sm-9 show-sort">
				<div class="col-sm-2 show-sort-select" style="background-color:blue">默认排序</div>
				<div class="col-sm-2 show-sort-select">
					价钱 <img src="/static/img/arrow-down.png"
						class="show-sort-select-img">
				</div>
				<div class="col-sm-2 show-sort-select">
					面积 <img src="/static/img/arrow-down.png"
						class="show-sort-select-img">
				</div>
			</div>
			<div class="col-sm-9 modification"></div>
		</div>


		<div class="col-sm-12 information-total-window">
			<div class="col-sm-9  information-total-div">
				<h2>
					共找到&nbsp<span class="information-total">182</span>&nbsp个结果
				</h2>
			</div>
		</div>

		<div class="col-sm-12 house-information-list-window">
			<div class="col-sm-9 house-information-div">
				<div class="house-information-img col-sm-4">
					<img src="/static/img/house-img.jpg">

				</div>
				
				<div class="col-sm-8" style="padding:0px">
				
				<div class="house-information-word col-sm-7">
					<div class="house-information-word-title col-sm-12">地铁口
						新装修小三房 南向很实用</div>
				</div>

				<div class="house-information-word-left col-sm-10">
					<div class="col-sm-12">
					<div class="col-sm-12">
					<img src="/static/img/house.png" class="house-information-word-left-img">
					<span>3室1厅1卫</span><span>|</span><span>100平米</span><span>|</span><span>西南</span>
					</div>
					</div>
					<div class="col-sm-12">
					<div class="col-sm-12">
					<img src="/static/img/place2.png" class="house-information-word-left-img">
					<span>园新路爱民巷013</span>
					</div>
					</div>
					<div class="col-sm-12">
					<div class="col-sm-12">
					<img src="/static/img/stars.png" class="house-information-word-left-img">
					<span>161</span><span>人关注/</span><span>4月前发布</span>
					</div>
					
					</div>

				</div>

				<div class="house-information-word-right col-sm-2">
                 <span class="house-money">
                 113
                 </span><span style="color:red">万</span>				
				
				</div>
			
			
			</div>
			
			</div>
		</div>
	</div>
</body>

</html>