<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/manage-css/black-customer.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript"
	src="/static/js/manage-js/black-customer.js"></script>
</head>
<body>
<div class="col-sm-12 search-window">
<form class="form-horizontal" role="form">
<div class="form-group">
    <div class="col-sm-9">
      <input type="text" class="form-control" placeholder="请输入黑名单id" id="searchCustomer" autocomplete="off">
    </div>
    <div class="col-sm-2 button-window">
    <button type="button" class="btn btn-info btn-lg btn-block select">查询</button>
    </div>
  </div>
</form>
</div>
	<table class="table table-bordered">
		<caption>用户数据表</caption>
		<thead class="customer-thead">
			<tr>
				<th>用户id</th>
				<th>用户头像</th>
				<th>用户姓名</th>
				<th>用户性别</th>
				<th>用户年龄</th>
				<th>用户电话</th>
				<th>用户邮箱</th>
				<th>操作按钮</th>
			</tr>
		</thead>
		<tbody class="customer-tbody">

		</tbody>
	</table>

	<div class="col-sm-12 page-window">
		<div class="col-sm-7"></div>
		<div class="col-sm-5 page-show-content"></div>
	</div>
</body>
</html>