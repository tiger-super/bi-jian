<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/manage-css/see-employee.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/manage-js/see-employee.js"></script>
</head>
<body>
<div class="col-sm-12 search-window">
<form class="form-horizontal" role="form" autocomplete="off">
<div class="form-group">
    <div class="col-sm-9">
      <input type="text" class="form-control" placeholder="请输入员工id" id="searchHouse">
    </div>
    <div class="col-sm-2 button-window">
    <button type="button" class="btn btn-info btn-lg btn-block select">查询</button>
    </div>
  </div>
</form>
</div>
	<table class="table table-bordered">
		<caption>员工数据表</caption>
		<thead class="employee-thead">
			<tr class="employee-title">
				<th>员工id</th>
				<th>员工头像</th>
				<th>员工姓名</th>
				<th>员工性别</th>
				<th>员工年龄</th>
				<th>员工密码</th>
				<th>员工电话</th>
				<th>员工邮箱</th>
				<th>员工住址</th>
				<th>入职时间</th>
			</tr>
		</thead>
		<tbody class="employee-tbody">
			
		</tbody>
	</table>
	
	<div class="col-sm-12 page-window">
<div class="col-sm-7"></div>
<div class="col-sm-5 page-show-content"></div>
</div>
</body>
</html>