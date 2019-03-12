<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">

<!-- Le styles -->
<link href="http://fonts.googleapis.com/css?family=Oxygen|Marck+Script"
	rel="stylesheet" type="text/css">
<link href="/static/css/manage-css/index.css" rel="stylesheet">
<link href="/static/css/bootstrap.css" rel="stylesheet">
<link href="/static/css/font-awesome.css" rel="stylesheet">
<link href="/static/css/admin.css" rel="stylesheet">
<script type="text/javascript" src="/static/js/jquery.min.js"></script>
<script src="/static/js/manage-js/index.js"></script>
<script src="/static/js/bootstrap.js"></script>
<script src="/static/js/excanvas.min.js"></script>
<script src="/static/js/jquery.flot.min.js"></script>
<script src="/static/js/jquery.flot.resize.js"></script>

</head>
<body>

	<div class="container">

		<div class="row">

			<div class="span2">

				<div class="main-left-col">

					<h1>
						<i class="icon-shopping-cart icon-large"></i> Adminize
					</h1>

					<ul class="side-nav">

						<li class="website"><a href="#"><i
								class="icon-signal"></i> 网站报告</a></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="collapse" data-target="#website-dropdown" href="#"><i
								class="icon-user"></i>员工管理 <b class="caret"></b></a>
							<ul id="website-dropdown" class="collapse">
								<c:if test="${employeeSession.employeeRole == '超级管理员'}">
									<li><a href="listing.html">添加员工</a></li>
									<li><a href="listing.html">员工查询</a></li>
									<li><a href="listing.html">权限设置</a></li>
								</c:if>
								<li><a href="">密码修改</a></li>
							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="collapse" data-target="#store-dropdown" href="#"><i
								class="icon-home"></i> 房源管理 <b class="caret"></b></a>
							<ul id="store-dropdown" class="collapse">
								<li class="li-auditing"><a href="#">待审核房源</a></li>
								<li><a class="li-publish">已发布房源</a></li>

							</ul></li>
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="collapse" data-target="#reports-dropdown" href="#"><i
								class="icon-group"></i>用户管理 <b class="caret"></b></a>
							<ul id="reports-dropdown" class="collapse">
								<li><a class="li-customer">用户查询</a></li>
								<li><a class="li-black">黑名单</a></li>
							</ul></li>

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="collapse" data-target="#settings-dropdown" href="#"><i
								class="icon-cogs"></i> 系统 </a>
							<ul id="settings-dropdown" class="collapse">

							</ul></li>


					</ul>

				</div>
				<!-- end main-left-col -->

			</div>
			<!-- end span2 -->

			<div class="span10">
				<div class="secondary-masthead">

					<ul class="nav nav-pills pull-right">

						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#"><i class="icon-user"></i>${employeeSession.employeeName}
								<b class="caret"></b> </a>
							<ul class="dropdown-menu">
								<li><a href="#" class="person">你的个人信息</a></li>
								<li class="divider"></li>
								<li><a href="/manage/quit">退出</a></li>
							</ul></li>
					</ul>

					<ul class="breadcrumb">
						<li><a href="#" value='${employeeSession.employeeId}'>管理员</a></li>
					</ul>

				</div>
				<iframe src="/manage/session/show/websiteReportView" width="100%"
					scrolling="no" frameborder="0" id="load"> </iframe>
			</div>
		</div>


	</div>
	<div class="employee-information">
	    <div class="close-div"><img src="/static/img/close.png" style="width:25px;height:25px"></div>
		<table class="table table-striped" style="margin-top:10px">
			<caption>个人信息</caption>
			<thead>
			<tr>
			<td rowspan="3" colspan="2" style="width:2px" >
         <img src="${employeeSession.employeeImgAddress}" style="width:150px;height:150px"> 
        </td>
			<td>账号</td>
			<td>${employeeSession.employeeId}</td>
			
			</tr>
			<tr>
			
			<td>姓名</td>
			<td>${employeeSession.employeeName}</td>
		
			</tr>
			<tr>
			
			<td>职位</td>
			<td>${employeeSession.employeeRole}</td>
		
			</tr>
			<tr>
			<td>性别</td>
			<td>${employeeSession.employeeSex}</td>
			<td>年龄</td>
	        <td>${employeeSession.employeeAge}</td>
			</tr>	
			
			
			<tr>
			<td>电话</td>
			<td>${employeeSession.employeePhone}</td>
			<td>邮箱</td>
	        <td>${employeeSession.employeeMailBox}</td>
			</tr>	
			
			<tr>
			<td>现居住地址</td>
			<td colspan="3">${employeeSession.employeeAddress}</td>
				
			</tbody>
		</table>
	</div>
</body>
</html>