<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/manage-css/see-vip.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/manage-js/see-vip.js"></script>
</head>
<body>
<div class="col-sm-12 search-window">
<form class="form-horizontal" role="form" autocomplete="off">
<div class="form-group">
    <div class="col-sm-9">
      <input type="text" class="form-control" placeholder="请输入vip用户id" id="searchVip">
    </div>
    <div class="col-sm-2 button-window">
    <button type="button" class="btn btn-info btn-lg btn-block select">查询</button>
    </div>
  </div>
</form>
</div>
	<table class="table table-bordered">
		<caption>用户数据表</caption>
		<thead class="vip-thead">
			<tr class="vip-title">
				<th>用户id</th>
				<th>用户头像</th>
				<th>用户姓名</th>
				<th>用户性别</th>
				<th>用户年龄</th>
				<th>用户电话</th>
				<th>用户邮箱</th>
				<th>起始时间</th>
				<th>到期时间</th>
				<th>操作按钮</th>
			</tr>
		</thead>
		<tbody class="vip-tbody">
			
		</tbody>
	</table>
	
	<div class="col-sm-12 page-window">
<div class="col-sm-7"></div>
<div class="col-sm-5 page-show-content" style="text-align:right"></div>
</div>
</body>
</html>