<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/house-information.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="/static/js/house-information.js"></script>
</head>
<body>
<table class="table table-hover">
  <caption>房源信息表</caption>
  <thead>
    <tr>
      <th class="col-sm-4">参数</th>
      <th class="col-sm-9">参数值</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>房源id</td>
      <td class="houseId">${map.house.houseId}</td>
    </tr>
    <tr>
      <td>房源名称</td>
      <td>${map.house.houseName}</td>
    </tr>
     <tr>
      <td>房源地址</td>
      <td>${map.house.houseAddressProvince}${map.house.houseAddressCity}${map.house.houseAddressArea}${map.house.houseAddressInfo}</td>
    </tr>
     <tr>
      <td>房源类型</td>
      <td>${map.house.houseInfo.houseType}</td>
    </tr>
     <tr>
      <td>房源价钱</td>
      <td>${map.house.houseInfo.houseMoney}</td>
    </tr>
     <tr>
      <td>房源大小</td>
      <td>${map.house.houseInfo.houseSize}</td>
    </tr>
     <tr>
      <td>房源结构</td>
      <td>${map.house.houseInfo.houseStructure}</td>
    </tr>
     <tr>
      <td>房源朝向</td>
      <td>${map.house.houseInfo.houseDirection}</td>
    </tr>
     <tr>
      <td>房源出售方式</td>
      <td>${map.house.houseInfo.houseSellWay}</td>
    </tr>
    
     <tr>
      <td>房源押金</td>
      <td>${map.house.houseInfo.houseDepoitWay}</td>
    </tr>
    
     <tr>
      <td>房源描述</td>
      <td>${map.house.houseInfo.houseDescripe}</td>
    </tr>
    <tr>
    <td>房源图片</td>
      <td >
      <c:forEach var="img" items="${map.list}">
      <div class="col-sm-2 img-div">
      <!--图片-->
      <img src=<c:out value="${img}"/> class="small-img" />
  
      <img src=<c:out value="${img}"/> class="big-img" />
</div>
      </c:forEach>
      
      </td>
    </tr>
  </tbody>
</table>

<c:if test="${map.house.houseAuditingState =='-1' }">
<div class="col-sm-12" style="border-top: 1px solid #ddd;">
<div class="col-sm-9">

</div>
<div class="col-sm-3 button-div" > 
<button type="button" class="btn btn-success apply">&nbsp;&nbsp;&nbsp;重新发布&nbsp;&nbsp;&nbsp;</button>
</div>
</div>
</c:if>
</body>
</html>