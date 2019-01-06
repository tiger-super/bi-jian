<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/person.css" />
<link rel="stylesheet" href="/static/css/iconfont.css" />
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/person.js"></script>

<body>
	<div class="navbar navbar-default head">
		<div class="container">
			<div class="navbar-header">
				<a href="#" class="navbar-brand logo">住哪儿</a>
			</div>

			<ul class="nav navbar-nav navbar-right" id="head-nav">
				<li><a href="#">欢迎你！<span class="glyphicon glyphicon-user"></span>${sessionScope.customerSession.customerName}
				</a></li>
				<li><a href="#">退出</a></li>
			    <li><a href = "/house/session/show/personView">个人中心</a></li>
				<li><a href="#">帮助中心</a></li>
				<li><a>投诉渠道</a></li>
				<li><a>网站导航</a></li>
			</ul>
		</div>
	</div>
<div class="col-sm-1" ></div>
    <div class="col-sm-1 content-left content">
    	<ul class="nav">
    		<li class="content-li-head" style="margin-top:0px ;">
    			
    		<div>
        <input type="file" id="fileInput">
    		<img class="head-img" src="/static/img/renyuanzengjia.png"/>
    </div>
    		
    		</li>
    		<li>个人中心</li>
    		<li>我的发布</li>
    		<li>我的收藏</li>
    		<li>我的浏览</li>
    		
    		
    		
    	</ul>
    	
    	
    </div>
  
      <div class="col-sm-8 content-center content" >
    	<div class="person-head-title">个人信息
    	</div>
    	
    	<div class="person-info">
    		用户名：
    		<input type="text" value="请叫我tiger" id="customerName" class="customerInput" maxlength="20" disabled>
    	<span><i class="iconfont icon-icon_edit modify" >修改</i></span>
    	
    	</div>
    	
    	<div class="person-info">
    		电&nbsp&nbsp&nbsp&nbsp话：
    	<input type="text" value="请叫我tiger" id="customerPhone"  class="customerInput" maxlength="20" disabled>  	
    	</div>
    	
    	<div class="person-info">年&nbsp&nbsp&nbsp&nbsp龄：
    	<input type="text" value="请叫我tiger" id="customerAge" class="customerInput" maxlength="20" disabled>
    	<span><i class="iconfont icon-icon_edit modify">修改</i></span>
    	
    	</div>
    	
    	<div class="person-info">性&nbsp&nbsp&nbsp&nbsp别：
    	<input type="text" value="请叫我tiger" id="customerSex" class="customerInput" maxlength="20" disabled>
    	<span><i class="iconfont icon-icon_edit modify">修改</i></span>
    	</div>
    	
    	<div class="person-info">邮&nbsp&nbsp&nbsp&nbsp箱：
    	<input type="text" value="请叫我tiger" id="customerMailbox" class="customerInput" maxlength="20" disabled>
    	<span><i class="iconfont icon-icon_edit modify">修改</i></span>
    	</div>
    </div>
    	
	
      <div></div>
</body>