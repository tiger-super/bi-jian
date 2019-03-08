<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/manage-css/publish-house.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/manage-js/publish-house.js"></script>
</head>
<body>
<div class="col-sm-12 search-window">
<form class="form-horizontal" role="form">
<div class="form-group">
    <div class="col-sm-9">
      <input type="text" class="form-control" placeholder="请输入房源id" id="searchHouse">
    </div>
    <div class="col-sm-2 button-window">
    <button type="submit" class="btn btn-info btn-lg btn-block">查询</button>
    </div>
  </div>
</form>
</div>
<div class="col-sm-11" id="content" style="width:966px;">
<div class="house-information-list-window">

</div>
</div>
<div class="col-sm-12 page-window">
<div class="col-sm-7"></div>
<div class="col-sm-5 page-show-content"></div>
</div>
</body>
</html>