<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/iconfont.css" />
<link rel="stylesheet" href="/static/css/manage-css/employee-information.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/manage-js/employee-information.js"></script>
</head>
<body>
<div class="col-sm-12 search-window">
<form class="form-horizontal" role="form" autocomplete="off">
<div class="form-group">
    <div class="col-sm-9">
      <input type="text" class="form-control" placeholder="请输入员工id" id="searchEmployee">
    </div>
    <div class="col-sm-2 button-window">
    <button type="button" class="btn btn-info btn-lg btn-block select">查询</button>
    </div>
  </div>
</form>
</div>
<div class="content">

<div class="col-sm-4 employee-img-div">
<img class="head-img" />
<form method="POST" id="fileUploadFrom"enctype="multipart/form-data">
<input type="file" id="fileInput" name="photoFile"onchange="submitform()">
</form>
</div>

<div>

<div class="col-sm-12">
       	<div class="person-info">
			编&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp号： <input type="text" id="employeeId"
				class="customerInput" maxlength="20" disabled>
		</div>
       
       <div class="person-info">
			姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名： <input type="text" id="employeeName" class="customerInput"
				maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modify">修改</i></span>

		</div>

		<div class="person-info">
			电&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp话： <input type="text" id="employeePhone"
				class="customerInput" maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modify">修改</i></span>
		</div>

		<div class="person-info">
			年&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp龄： <input type="text" id="employeeAge"
				class="customerInput" maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modify">修改</i></span>

		</div>

		<div class="person-info">
			性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别： <select class="select-sex">
				<option class="select-sex-man">男</option>
				<option class="select-sex-woman">女</option>
			</select> <input type="text" id="employeeSex" class="customerInput"
				maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modifySex">修改</i></span>
		</div>

		<div class="person-info">
			邮&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp箱： <input type="text" id="employeeMailbox"
				class="customerInput" maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modify">修改</i></span>
		</div>
		
		<div class="person-info">
			入职时间： <input type="text" id="entryTime"
				class="customerInput" maxlength="20" disabled> 
		</div>
		<div class="person-info">
			权&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp限：
			 <select class="select-role">
				<option class="select-sex-super">超级管理员</option>
				<option class="select-sex-ordinary">普通管理员</option>
			</select> 
			 <input type="text" id="employeeRole"
				class="customerInput" maxlength="20" disabled> <span><i
				class="iconfont icon-icon_edit modifyRole">修改</i></span>
		</div>
		<div class="person-info">
			密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码： <input type="text" id="employeePassword"
				class="customerInput" maxlength="20" disabled> 
		</div>
</div>

</div>
</div>
</body>
</html>