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
	<link rel="stylesheet" href="/static/css/selectArea.css" />
	<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/static/js/selectArea.js" ></script>
	<body>
		<div class="col-sm-2" style="margin-top: 20px;margin-left:30px ;">
			<div class="col-sm-3" style="padding-right: 0px;"><img src="/static/img/houselogo.png" class="houselogo"/></div>
			<div class="col-sm-6 house-title">住哪儿</div>
			
		</div>
		<div class="col-sm-12"></div>
		
		
		<div class="col-sm-6 search">
        <img src="/static/img/srearch.png" class="sreach-img">
    <input type="text" placeholder="搜索城市" class="citySearch"/>
			<button class="searchSumit btn btn-info btn-primary"> 搜索</button>
		</div>
			<div class="col-sm-12"></div>
			
			
			
			<div class="col-sm-12" style=" margin-top: 50px;">
	  <div class="col-sm-1 choose" >
	  	城市选择
	  	
	  </div>
	  
	  
	<div class="col-sm-2 province select">
		
	   <div class="province-select">
	   	<span class="select-text province-select-text">省份</span>
	   	
	   	<div class="select-img"></div>
	   </div>
	  	<div class="select-content province-select-content">
	  		<ul class="select-content-ul province-select-content-ul">
	  			
	  		</ul>
	  		
	  	</div>
	  </div>
	  
	 <div class="col-sm-2 city select">
		
	   <div class="city-select">
	   	<span class="select-text city-select-text">城市</span>
	   	
	   	<div class="select-img"></div>
	   </div>
	  	<div class="select-content city-select-content">
	  		<ul class="select-content-ul city-select-content-ul">
	  		</ul>
	  	</div>
	  </div>
	  
	  </div>
	  
	  

	  
	  <div class="col-sm-10 content" style="padding: 0px;">
	  	</div>

	  	
	</body>
</html>
