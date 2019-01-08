<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/login.js"></script>
<style>
.col-center-block {
	position: absolute;
	top: 50%;
	-webkit-transform: translateY(-50%);
	-moz-transform:  translateY(-50%);
	-ms-transform:  translateY(-50%);
	-o-transform:  translateY(-50%);
	transform:  translateY(-50%);
}

.form-group {
	margin-bottom: 10px;
}

.alert {
	height: 35px;
	line-height: 8px
}

</style>
</head>

<body>
	<div
		class="col-lg-4 col-lg-offset-4  col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2 container col-center-block">
		<form class="form-signin form-horizontal" id="login" autocomplete="off">
			
			<div  class="form-group"> 
						<div class="col-sm-4"></div>
					<div class="col-sm-4">	
						<img src="/static/img/logo.jpeg" style="width: 100px;height: 100px;text-align:center"></div>
					</div>
					<div class="col-sm-4"></div>
				
				<div  class="form-group"> </div>
			
			
			<div class="form-group">
				<label>账号</label> <input class="form-control form-id" type="text"
					name="customerPhone"> 
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide name-tips" style="margin: 0px;"></div>
			</div>


			<div class="form-group">
				<label>密码</label> <input class="form-control form-password"
					type="password" name="customerPassword">
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide password-tips"
					style="margin: 0px;"></div>
			</div>


			<div class="form-group ">
				<div class="alert alert-danger alert-dismissable hide dataJudge" role="alert">
					<strong class="text"> </strong>
				</div>
			</div>

			<div class="form-group">
				<button class="btn btn-primary btn-block">登录</button>
			</div>
		</form>
		<div class="col-sm-5" style="padding: 0px;"><a href="/house/show/registerView">没有账户？去注册</a></div>  
			<div class="col-sm-4"></div>
			<div class="col-sm-3"><a >找回密码</a>
			</div>
	</div>
</body>

</html>