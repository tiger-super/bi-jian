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
<script type="text/javascript" src="/static/js/register.js"></script>
<style>
.col-center-block {
	position: absolute;
	top: 50%;
	-webkit-transform: translateY(-50%);
	-moz-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	-o-transform: translateY(-50%);
	transform: translateY(-50%);
}

.form-group {
	margin-bottom: 10px;
}
</style>
</head>

<body>
	<div
		class="col-lg-4 col-lg-offset-4  col-sm-6 col-sm-offset-3 col-xs-8 col-xs-offset-2 container col-center-block">
		<form class="form-signin form-horizontal" id="register" method="post" autocomplete="off" style="margin-top:100px">
			
			<div  class="form-group" > 
						<div class="col-sm-4"></div>
					<div class="col-sm-4">	
						<img src="/static/img/logo.jpeg" style="width: 100px;height: 100px;text-align:center"></div>
					</div>
					<div class="col-sm-4"></div>
				
				<div  class="form-group"> </div>
			
			
			
			<div class="form-group ">
				<label>用户名</label> <input class="form-control form-name"
					for="inputWarning" type="text" name="customerName" placeholder="请填写用户名">
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide name-tips" style="margin: 0px;"></div>
			</div>


			<div class="form-group ">
				<label>电话</label> <input class="form-control form-phone" type="text"
					name="customerPhone" placeholder="请填写电话号码">
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide phone-tips"
					style="margin: 0px;"></div>
			</div>

			<div class="form-group ">
				<label>邮箱</label> <input class="form-control form-mailbox"
					type="text" name="customerMailbox" placeholder="请填写要绑定的邮箱">
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide mailbox-tips"
					style="margin: 0px;"></div>
			</div>


			<div class="form-group ">
				<label>密码</label> <input class="form-control form-password"
					type="password" name="customerPassword" placeholder="请填写你的账号">
			</div>
			<div class="form-group">
				<div class="alert alert-warning hide password-tips"
					style="margin: 0px;"></div>
			</div>
            
            <div class="form-group">
            <label>验证码</label> 
            <div class="form-group">
					<div class="col-sm-7" >
						<input type="text" class="form-control mailVerificationCodeText"
							placeholder="输入邮箱验证码">
					</div>
	
					<div class="col-sm-5" >
						<button class="btn btn-info btn-block gainMailVerificationCode" type="button">获取验证码</button>
					</div>
					</div>
				</div> 
             <div class="form-group">
				<div class="alert alert-warning hide mailVerificationCode-tips"
					style="margin: 0px;"></div>
			</div>
            
             
			<div class="form-group">
				<button class="btn btn-primary btn-block" type="submit">注册</button>
			</div>
		</form>
		<div class="col-sm-5" style="padding:0px;margin-bottom:20px"><a href="/house/show/loginView">已有账户？去登陆</a></div>  
			<div class="col-sm-5"></div>  
			<div class="col-sm-2" style="padding:0px"><a href="/house/show/indexView">返回首页</a>
			</div>
	</div>
</body>
<script>
</script>
</html>