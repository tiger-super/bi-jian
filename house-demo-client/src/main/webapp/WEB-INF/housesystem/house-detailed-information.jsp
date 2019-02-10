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
<script type="text/javascript" src="/static/js/house-detailed-information.js"></script>
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
    <span>${house.houseName }</span><span style="margin-left:10px">${house.houseInfo.houseStructure}</span>
      </div>
    <div class="col-sm-1">
   <div >
    <img src="/static/img/stars.png">
    </div>
    <div style="font-weight: inherit;font-size:8px"  >
    加入收藏
  </div>
    </div>
    </div>
    
    <div class="col-sm-12 house-info-content">
    <div class="col-sm-5 house-info-img-window" value='${house.houseInfo.houseImageAddress}'>
    <img src="/static/img/houseInfo.png" class="house-info-img-show">
    
    <div class="col-sm-11 house-info-list-window" >
    <div class="col-sm-1 switch switch-left">
    <img src="/static/img/left.png">
    
    </div>
    <div class="col-sm-10 house-info-list-ul-window" >

   <ul class="house-info-list-ul">
    </ul>
    </div>
     <div class="col-sm-1 switch switch-right" style="margin-left: 13px;">
    <img src="/static/img/right.png">
    
    </div>
    </div>
    </div>
    
    <div class="col-sm-7 house-other-info-window">
    <div class="col-sm-12 house-other-info">
    <div class="col-sm-12">
    <span class="house-money">${house.houseInfo.houseMoney}</span>
    <span class="house-money-company">元/月</span>
    <span>${house.houseInfo.houseDepoitWay}</span>
    </div>
    
    <div class="col-sm-12">
    <span>房屋类型：</span>
    <span>${house.houseInfo.houseDepoitWay}</span>
    <span>${house.houseInfo.houseSize}平米</span>
    </div>
    
    
    <div class="col-sm-12">
    <span>朝向楼层：</span>
    <span>${house.houseInfo.houseDirection}</span>
    
    </div>
    
    <div class="col-sm-12">
    
    <span>所在省市区：</span>
    <span>${house.houseAddressProvince}${house.houseAddressCity}${house.houseAddressArea}</span>
    </div>
    
    
    <div class="col-sm-12">
    <span>详细地址：</span>
    <span>${house. houseAddressInfo}</span>
    
    </div>
    
    
    <div class="col-sm-12">
    <div class="col-sm-12 publish-person-img-window">
    <div class="col-sm-2 publish-person-img-window" style="margin:0px;">
   <img  class="publish-person-img">
    </div>
    <div class="col-sm-8 publish" style="margin-top:50px;font-size: 24px;font-weight: 700;color: #101d37;" publishId="${house.housePublisherId }">
    
    </div>
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
	
</body>

</html>