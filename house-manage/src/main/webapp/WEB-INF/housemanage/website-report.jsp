<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link href="http://fonts.googleapis.com/css?family=Oxygen|Marck+Script"
	rel="stylesheet" type="text/css">
<link href="/static/css/bootstrap.css" rel="stylesheet">
<link href="/static/css/font-awesome.css" rel="stylesheet">
<link href="/static/css/admin.css" rel="stylesheet">
<script src="/static/js/jquery.min.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/excanvas.min.js"></script>
<script src="/static/js/jquery.flot.min.js"></script>
<script src="/static/js/jquery.flot.resize.js"></script>
</head>
<body>
	<div >
		<!-- <div class="secondary-masthead">

			<ul class="nav nav-pills pull-right">

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"><i class="icon-user"></i> 钟泰文 <b
						class="caret"></b> </a>
					<ul class="dropdown-menu">
						<li><a href="profile.html">你的个人信息</a></li>
						<li class="divider"></li>
						<li><a href="">退出</a></li>
					</ul></li>
			</ul>

			<ul class="breadcrumb">
				<li><a href="#">管理员</a></li>
			</ul>

		</div> -->

		<div class="main-area dashboard">

			<div class="row">

				<div >

					<div class="slate clearfix">

						<a class="stat-column" href="#"> <span class="number">16</span>
							<span>本日访问量</span>

						</a> <a class="stat-column" href="#"> <span class="number">452</span>
							<span>本月访问量</span>

						</a> <a class="stat-column" href="#"> <span class="number">$2,512</span>
							<span>本月房源发布量</span>

						</a> <a class="stat-column" href="#"> <span class="number">348</span>
							<span>上一月新增用户量</span>
						</a>

					</div>

				</div>

			</div>

			<div class="row">

				<div class="span5">

					<div class="slate">

						<div class="page-header">
							<h2>
								<i class="icon-signal pull-right"></i>访问量
							</h2>
						</div>
						<div id="placeholder" style="height: 297px;"></div>

					</div>

				</div>



			</div>
		</div>

	</div>
	<script type="text/javascript">
	// 图片数据
$(function () {
    var d1 = [];
        d1.push([0, 32]);
        d1.push([1, 30]);
        d1.push([2, 24]);
        d1.push([3, 17]);
        d1.push([4, 11]);
        d1.push([5, 25]);
        d1.push([6, 28]);
        d1.push([7, 36]);
        d1.push([8, 44]);
        d1.push([9, 52]);
        d1.push([10, 53]);
        d1.push([11, 50]);
        d1.push([12, 45]);
        d1.push([13, 42]);
        d1.push([14, 40]);
        d1.push([15, 36]);
        d1.push([16, 34]);
        d1.push([17, 24]);
        d1.push([18, 17]);
        d1.push([19, 17]);
        d1.push([20, 20]);
        d1.push([21, 28]);
        d1.push([22, 36]);
        d1.push([23, 38]);

    $.plot($("#placeholder"), [ d1 ], { grid: { backgroundColor: 'white', color: '#999', borderWidth: 1, borderColor: '#DDD' }, colors: ["#FC6B0A"], series: { lines: { show: true, fill: true, fillColor: "rgba(253,108,11,0.4)" } } });
});
$(document).ready(function(){
    $("#load",parent.document).css("height",$(document).outerHeight(true)+"px");
})	
</script>
</body>
</html>