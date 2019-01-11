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
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/nextVerification.js"></script>
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
				<li class="li-help-center"><a href="#" style="color: #2c82ff;">
						帮助中心</a></li>
			</ul>
		</div>
	</div>



	<div class="center">
		<div class="col-sm-3"></div>

		<div class="center-content col-sm-6">
			<div class="center-content-title">输入账号</div>
			<div class="col-sm-3"></div>

			<!-- 输入账号 -->
			<div class="col-sm-6 first-form">
				<div>请输入要重置密码的账号</div>
				<div>
					<input type="text" placeholder="帐号" class="form-control"
						id="account-number">
				</div>
				<div class="form-group">
					<div class="alert alert-warning hide account-number-tips"
						style="margin: 0px;"></div>
				</div>
				<div>请输入验证码</div>

				<div class="first-form-code" class="col-sm-12" style="height: 30px">
					<div class="col-sm-4">
						<input type="text" class="form-control  VerificationCode"
							placeholder="验证码" maxlength="4">
					</div>
					<div class="col-sm-4">
						<img class="code-image">
					</div>
					<div class="col-sm-4 replace-code">看不清，换一张</div>
				</div>
				<div class="form-group">
					<div class="alert alert-warning hide code-tips"
						style="margin: 0px;"></div>
				</div>

				<div class="col-sm-12">
					<button class="next btn btn-info btn-block">下一步</button>

				</div>
			</div>
			<!-- 完成验证 -->
			<div class="col-sm-6 second-form">
				点击获取验证码，验证码将发送至安全邮箱<span class="span-mail"></span>
			</div>
			<div class="col-sm-12 securify">
				<div class="col-sm-6">
					<input type="text" class="form-control mailVerificationCodeText"
						placeholder="输入邮箱验证码">
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-5">
					<button class="btn btn-info btn-block gainMailVerificationCode">获取验证码</button>
				</div>
			</div>


			<div class="form-group col-sm-12" style="margin-bottom: 0px">
				<div class="alert alert-warning hide mailCode-tips"
					style="margin: 0px;"></div>
			</div>
			<div class="col-sm-12">
				<button class="second btn btn-info btn-block">下一步</button>
			</div>
		</div>
		<!-- 修改密码 -->
		<div class="col-sm-6 three-form">
			<div>请输入新密码</div>
			<div>
				<input type="password" placeholder="新密码" class="form-control"
					id="new-password">
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide new-password-tips"
					style="margin: 0px;"></div>
			</div>
			<div>请确认密码</div>
			<div>
				<input type="password" placeholder="确认密码" class="form-control"
					id="confirm-password">
			</div>
			<div class="form-group" style="margin-bottom: 0px">
				<div class="alert alert-warning hide confirm-password-tips"
					style="margin: 0px;"></div>
			</div>

			<div class="col-sm-12" style="padding: 0px;">
				<button class="modify-password btn btn-info btn-block">下一步</button>

			</div>
		</div>


	</div>
	</div>
	<!-- 完成修改 -->
	<div class="true">
		<div class="col-sm-4"></div>
		<div class="true-content col-sm-5">
			<div class="col-sm-3" style="padding: 0px; padding-left: 25px">
				<img src="/static/img/true.png" class="true-image">
			</div>
			<div class="true-text col-sm-6">修改成功</div>
		</div>
	</div>
</body>
</html>
