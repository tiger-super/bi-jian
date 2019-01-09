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
		<link rel="stylesheet" href="/static/css/retrieve.css" />
	<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js" ></script>
	<script type="text/javascript" src="/static/js/nextVerification.js" ></script>
	<body>
			<div class="navbar navbar-default head">
		<div class="container">
			<div class="navbar-header">
				<ul class="nav navbar-nav " id="nav-left"> 
					
					<li><img src="/static/img/houselogo.png" id="imglogo"></li>
					<li><a href="#" class="navbar-brand logo">住哪儿账号中心</a></li>
				</ul>
			</div>

			<ul class="nav navbar-nav navbar-right" id="head-nav">
				<li class="li-help-center">
					<a href="#" style=" color: #2c82ff;">
						帮助中心</a>
				</li>
			</ul>
		</div>
	</div>
	
	
	
		<div class="center">
			<div class="col-sm-3"></div>
			
			<div class="center-content col-sm-6">
				<div class="center-content-title">
					输入账号
					
				</div>
				<div  class="col-sm-3"></div>
				<div  class="col-sm-6 first-form">
					<div>请输入要重置密码的账号</div>
					<div>
					<input type="text" placeholder="帐号" class="form-control" id="account-number">
					</div>
					<div class="form-group">
				<div class="alert alert-warning hide account-number-tips" style="margin: 0px;"></div>
			</div>
					<div>请输入验证码</div>
					
					<div class="first-form-code" class="col-sm-12" style="height:30px">
					<div class="col-sm-4"><input type="text" class="form-control  VerificationCode" maxlength="4"></div>
					<div class="col-sm-4"><img class="code-image"></div>
					<div class="col-sm-4 replace-code">看不清，换一张</div>
					</div>
					<div class="form-group">
				<div class="alert alert-warning hide code-tips" style="margin: 0px;"></div>
			</div>
					
					<div  class="col-sm-12">
						<button class="next btn btn-info btn-block">下一步</button>
					
					</div>
				</div>
					
				
			</div>
			
		</div>
	</body>
</html>
