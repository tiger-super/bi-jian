<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/iconfont.css" />
<link rel="stylesheet" href="/static/css/vip.css" />
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/vip.js"></script>
<script type="text/javascript" src="/static/js/chat-loading.js"></script>
<body>
	<div class="navbar navbar-default head">
		<div class="container">
		<div class="col-sm-1" style="padding-right: 0px;"><img src="/static/img/houselogo.png" class="houselogo"/></div>
			<div class="navbar-header">
				<a href="#" class="navbar-brand logo">住哪儿</a>
			</div>
            <div class="col-sm-1 place-div">
            <img src="/static/img/place.png" class="place-img"/>
            <span class="place"><a href="/house/show/selectAreaView" class="show-city-a">
         
                              
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
<div class='col-sm-12' style='text-align:center'><h1>住哪儿VIP充值中心</h1></div>
<div class='col-sm-12' style='text-align:center;color:red;'><h6>成为我们的会员，解锁所有特权</h6></div>
<div class='col-sm-1'></div>
<div class='col-sm-10 vip-content-div-window'>
<div class='col-sm-12'>
<div class='col-sm-2 vip-content-div' style='margin-left:45px;border:1px solid red'>
<div class='col-sm-1'></div>
<div class='col-sm-10 vip-content'>
<div class='col-sm-12 vip-money' value='15'>15元</div>
</div>
<div class='col-sm-12 vip-day' value='1'>1个月</div>
</div>

<div class='col-sm-1'></div>

<div class='col-sm-2 vip-content-div'>
<div class='col-sm-1'></div>

<div class='col-sm-10 vip-content'>
<div class='col-sm-12 vip-money' value='40'>40元</div>
</div>
<div class='col-sm-12 vip-day' value='3'>3个月</div>
</div>

<div class='col-sm-1'></div>

<div class='col-sm-2 vip-content-div'>
<div class='col-sm-1'></div>
<div class='col-sm-10 vip-content'>
<div class='col-sm-12 vip-money' value='60'>60元</div>
</div>
<div class='col-sm-12 vip-day' value='6'>6个月</div>
</div>

<div class='col-sm-1'></div>

<div class='col-sm-2 vip-content-div'>
<div class='col-sm-1'></div>
<div class='col-sm-10 vip-content'>
<div class='col-sm-12 vip-money' value='128'>128元</div>
</div>
<div class='col-sm-12 vip-day' value='12'>12个月</div>
</div>
</div>

<div class='vip-tips col-sm-12'>友情提示：本系统只支持支付宝支付(沙箱版)</div>
<div class='col-sm-12 vip-button'>
<button type="button" class="btn btn-info vip-submit">确定</button></div>
</div>



			<div class="col-lg-12 footer">

				<div class="col-lg-2"></div>
				<a href="#" style="margin-left: 0px;">常见问题</a><span>|</span> <a
					href="#">帮助中心</a><span>|</span> <a href="#">意见反馈</a><span>|</span>
				<a href="#">了解住哪儿</a><span>|</span> <a href="#">加入住哪儿</a><span>|</span>
				<a href="#">反欺诈联盟</a><span>|</span> <a href="#">报案平台</a><span>|</span>
				<a href="#">推广服务</a><span>|</span> <a href="#">渠道招商</a><span>|</span>
				<a href="#">先行赔付</a><span>|</span> <a href="#">Investor
					Relations</a>

			</div>

</body>
</html>