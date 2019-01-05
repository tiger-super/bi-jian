<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
	<body>
		<p class="jump">
	    </p>
	</body>
	
	<script>
		var i = 5;
		$(document).ready(function(){
		setInterval(function(){
			$(".jump").text("注册成功,"+i+"秒后自动跳转到登录界面！");
			i--;
		},1000)
		setTimeout(function(){window.location.href="/house/show/loginView"},6000);
	   }
	)
	</script>
</html>
