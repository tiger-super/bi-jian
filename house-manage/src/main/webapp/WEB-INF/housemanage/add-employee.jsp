<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/manage-css/add-employee.css">

<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/static/js/manage-js/add-employee.js"></script>
</head>
<body>
		<div class="col-sm-12">
			<div class="col-sm-2 employee-img-div">
				<img src="/static/img/employee.png" class="employee-img"/>
				<form method="POST" id="fileUploadFrom"
					enctype="multipart/form-data">
					<input type="file" id="fileInput" onchange="submitform()" name="photoFile">
				</form>
			</div>
		</div>
	<form class="form-horizontal" id="employee-from" role="form" autocomplete="off">
		<div class="form-group">

			<label for="firstname" class="col-sm-1 control-label">姓名</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" placeholder="请输入名字"
					name="employeeName">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-1 control-label">年龄</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" name="employeeAge"
					placeholder="请输入年龄">
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-1 control-label">性别</label>
			<div class="col-sm-3">
				<select class="form-control" name="employeeSex">
					<option>男</option>
					<option>女</option>
				</select>
			</div>
			<label for="lastname" class="col-sm-2 control-label">权限</label>
			<div class="col-sm-3">
				<select class="form-control" name="employeeRole">
					<option>超级管理员</option>
					<option>普通管理员</option>
				</select>
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-1 control-label">电话</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" name="employeePhone"
					placeholder="请输入电话">
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-1 control-label">邮箱</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" name="employeeMailbox"
					placeholder="请输入邮箱">
			</div>
		</div>

		<div class="form-group">
			<label for="lastname" class="col-sm-1 control-label"
				style="padding: 0px; padding-top: 7px">家庭住址</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" name="employeeAddress"
					placeholder="请输入家庭住址">
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-9 button-div">
				<button type="button" class="btn btn-success add">添加</button>
			</div>
		</div>
	</form>
</body>
</html>