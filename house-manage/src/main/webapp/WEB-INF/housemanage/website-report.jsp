<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="/static/css/manage-css/website-report.css" rel="stylesheet">
<link href="/static/css/bootstrap/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script src="/static/js/echarts.common.min.js"></script>
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script src="/static/js/manage-js/website-report.js"></script>
</head>
<body>
	<div class="col-sm-2 head-data visit" style="width: 18.666667%">
		<div class="col-sm-12 head-data-img-div">
			<img src="/static/img/website.png" class="head-data-img">
		</div>
		<div class="head-data-wrold col-sm-12">本日网站访问量</div>
		<div class="head-data-result col-sm-12"></div>
	</div>
	<div class="col-sm-1"></div>
	<div class="col-sm-2 head-data no-publish-house"
		style="width: 18.666667%">
		<div class="col-sm-12 head-data-img-div">
			<img src="/static/img/no-publish-house.png" class="head-data-img">
		</div>
		<div class="head-data-wrold col-sm-12">未发布的房源</div>
				<div class="head-data-result col-sm-12"></div>

	</div>
	<div class="col-sm-1"></div>
	<div class="col-sm-2 head-data publish-house" style="width: 18.666667%">
		<div class="col-sm-12 head-data-img-div">
			<img src="/static/img/publish-house.png" class="head-data-img">
		</div>
		<div class="head-data-wrold col-sm-12">本日发布房源数量</div>
				<div class="head-data-result col-sm-12"></div>
	</div>
	<div class="col-sm-1"></div>
	<div class="col-sm-2 head-data customer" style="width: 18.666667%">
		<div class="col-sm-12 head-data-img-div">
			<img src="/static/img/customer.png" class="head-data-img">
		</div>
		<div class="head-data-wrold col-sm-12">拥有客户量</div>
				<div class="head-data-result col-sm-12"></div>
	</div>
	
	 <div class="col-sm-12" id="website" ></div>
	  <div class="col-sm-12" id="publish" ></div>
</body>
</html>