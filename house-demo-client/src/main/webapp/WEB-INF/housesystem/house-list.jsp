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
<script type="text/javascript" src="/static/js/chat-loading.js"></script>
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
					class="place"><a href="/house/show/selectAreaView"
					class="show-city-a"></a></span>
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
								class="glyphicon glyphicon-user" id="usr" value='${sessionScope.customerSession.customerId}'></span>${sessionScope.customerSession.customerName}
						</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="/house/show/indexView">首页</a>
				<li><a href="/house/session/show/personView">个人中心</a></li>
				<li><a href="#" class="consult">在线咨询</a></li>
				<li><a href='/house/session/show/vip/view'>vip充值中心</a></li>
				<li><a href="/house/session/show/publish/house">房源发布</a></li>
				<c:if test="${not empty sessionScope.customerSession.customerName}">
					<li><a href="/house/quit">退出</a></li>
				</c:if>

			</ul>
		</div>
	</div>

	<div class="col-sm-1"></div>

	<div class="content col-sm-11" value = "condition=default">
		<div class="col-sm-12 select-area-title-window">
			<div class="col-sm-1 select-area-title">位置</div>
			<div class="col-sm-2 select-area-title">
				<span style="margin-right: 15px; color: blue">区域</span><img
					src="/static/img/down.png">
			</div>
		</div>

		<div class="col-sm-12 select-area-content-window">
			<div class="col-sm-12 select-area-content" value="">
				<c:forEach items="${areaList}" var="area">
					<div class="col-sm-1 select-area-content-part">${area}</div>
				</c:forEach>

			</div>


			<div class="col-sm-12 show-sort-window">
				<div class="col-sm-9 show-sort" value="default">
					<div class="col-sm-2 show-sort-select show-sort-select-default"
						style="background-color: blue">默认排序</div>
					<div class="col-sm-2 show-sort-select show-sort-select-money" value="0"> 
						价钱 <img src="/static/img/arrow-down.png"
							class="show-sort-select-img">
					</div>
					<div class="col-sm-2 show-sort-select show-sort-select-size" value="0">
						面积 <img src="/static/img/arrow-down.png"
							class="show-sort-select-img">
					</div>
				</div>
				<div class="col-sm-9 modification"></div>
			</div>


			<div class="col-sm-12 information-total-window">
				<div class="col-sm-9  information-total-div">
					<h2>
						共找到&nbsp<span class="information-total"></span>&nbsp个结果
					</h2>
				</div>
			</div>

			<div class="col-sm-12 house-information-list-window"></div>
		</div>
	    
	    <div class="col-sm-12 page-show">
	    <div class="col-sm-6"></div>
	     <div class="col-sm-5  page-show-content">
			</div>
	    </div>
	
	
	</div>
	<div class="col-sm-4 chat">
	
	
	</div>
</body>

</html>