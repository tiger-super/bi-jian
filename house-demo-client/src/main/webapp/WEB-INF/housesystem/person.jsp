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
<link rel="stylesheet" href="/static/css/person.css" />
<link rel="stylesheet" href="/static/css/iconfont.css" />
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/person.js"></script>
<script type="text/javascript" src="/static/js/index.js"></script>
<script type="text/javascript" src="/static/js/chat-loading.js"></script>
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
					class="place"><a href="/house/show/selectAreaView"
					class="show-city-a"> </a></span>
			</div>
			<ul class="nav navbar-nav navbar-right" id="head-nav">
				<li><a href="#">欢迎你！<span
								class="glyphicon glyphicon-user" id="usr" value='${sessionScope.customerSession.customerId}'></span>
						<span class="head-span-customerName">${sessionScope.customerSession.customerName}</span>
				</a></li>
				<li><a href="/house/show/indexView">首页</a>
				<li><a href="/house/session/show/personView">个人中心</a></li>
				<li><a href="#" class="consult">在线咨询</a></li>
				<li><a>投诉渠道</a></li>
				<li><a href="/house/session/show/publish/house">房源发布</a></li>
				<li><a href="/house/quit">退出</a></li>
			</ul>
		</div>
	</div>
	<div class="col-sm-1"></div>
	<div class="col-sm-1 content-left content">
		<ul class="nav">
			<li class="content-li-head" style="margin-top: 0px; height: 150px">
				<img class="head-img" />
				<form method="POST" id="fileUploadFrom"
					enctype="multipart/form-data">
					<input type="file" id="fileInput" name="photoFile"
						onchange="submitform()">
				</form>
			</li>
			<li class="person-information">个人中心</li>
			<li class="my-publish">我的发布</li>
			<li class="my-collection">我的收藏</li>
			<li class="">我的浏览</li>



		</ul>


	</div>

	<div
		class="col-sm-8 content-center content   person-information-view content-right">
		<div class="person-head-title">个人信息</div>

		<div class="person-info">
			用户名： <input type="text" id="customerName" class="customerInput"
				maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modify">修改</i></span>

		</div>

		<div class="person-info">
			电&nbsp&nbsp&nbsp&nbsp话： <input type="text" id="customerPhone"
				class="customerInput" maxlength="20" disabled>
		</div>

		<div class="person-info">
			年&nbsp&nbsp&nbsp&nbsp龄： <input type="text" id="customerAge"
				class="customerInput" maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modify">修改</i></span>

		</div>

		<div class="person-info">
			性&nbsp&nbsp&nbsp&nbsp别： <select class="select-sex">
				<option class="select-sex-man">男</option>
				<option class="select-sex-woman">女</option>
			</select> <input type="text" id="customerSex" class="customerInput"
				maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modifysex">修改</i></span>
		</div>

		<div class="person-info">
			邮&nbsp&nbsp&nbsp&nbsp箱： <input type="text" id="customerMailbox"
				class="customerInput" maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modify">修改</i></span>
		</div>
	</div>


	<div class="col-sm-8  content my-publish-view content-right" value="1"
		style="display: none">
		<div class="person-head-title col-sm-12" value="housePublisherState">
			<div class="publish-div publish-div-button col-sm-2"
				style="color: red">已发布</div>
			<div class="no-publish-div publish-div-button col-sm-2">未发布</div>
			<div class="to-be-audited-div publish-div-button col-sm-2">待审核</div>
			<div class="audit-failure publish-div-button col-sm-2">审核失败</div>
		</div>
		<div class="col-sm-12 my-publish-content"></div>
	</div>


	<div class="col-sm-8  content my-collection-view content-right">
		<div class="col-sm-12 my-collection-content"></div>
	</div>

</body>