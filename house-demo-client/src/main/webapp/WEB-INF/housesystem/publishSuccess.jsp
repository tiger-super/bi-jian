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
			$(".jump").text("房源信息已提交至后台,工作人员会在7个工作日内审核完毕，"+i+"秒后自动跳转到主界面！");
			i--;
		},1000)
		setTimeout(function(){window.location.href="/house/show/indexView"},6000);
	   }
	)
	</script>
</html>
