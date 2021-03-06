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
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="/static/css/iconfont.css" />
<link rel="stylesheet" href="/static/css/index.css" />
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/js/index.js"></script>
<script type="text/javascript" src="/static/js/chat-loading.js"></script>
<body>
	<div class="navbar navbar-default head">
		<div class="container">
		<div class="col-sm-1" style="padding-right: 0px;"><img src="/static/img/houselogo.png" class="houselogo"/></div>
			<div class="navbar-header">
				<a href="#" class="navbar-brand logo">住哪儿</a>
			</div>
            <div class="col-sm-1 place-div">
            <img src="/static/img/place.png" class="place-img"/>
            <span class="place"><a href="/house/show/selectAreaView" class="show-city-a">
         
                              
                              </a></span>
            </div>
			<ul class="nav navbar-nav navbar-right" id="head-nav">
				<c:choose>
					<c:when test="${empty sessionScope.customerSession.customerName}">
						<li><a href="/house/show/loginView"
							style="padding-right: 0px">登录</a></li>
						<li><a href="/house/show/registerView"
							style="padding-left: 5px">/&nbsp注册</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#">欢迎你！<span
								class="glyphicon glyphicon-user" id="usr" value='${sessionScope.customerSession.customerId}'></span>${sessionScope.customerSession.customerName}
						</a></li>
					</c:otherwise>
				</c:choose>
					<li><a href="/house/show/indexView">首页</a>
				<li><a href="/house/session/show/personView">个人中心</a></li>
				<li><a href="#" class="consult">在线咨询</a></li>
				<li><a href='/house/session/show/vip/view'>vip充值中心</a></li>
				<li><a href="/house/session/show/publish/house">房源发布</a></li>
				<c:if test="${not empty sessionScope.customerSession.customerName}">
				<li><a href="/house/quit">退出</a></li>
				</c:if>
				
			</ul>
		</div>
	</div>

	<div class="col-sm-12 content">

		<div class="col-lg-1"></div>

		<div class="col-lg-10 house-content">
			<!--租房-->
			<div class="col-lg-4 house-window">
				<div class="col-lg-12 house">
					<a href="">
						<div class="col-lg-12 house-img house-rent">
							<div class="col-lg-7"></div>
							<div class="col-lg-5" style="margin-top: 25px;">
								<div class="title">租房</div>
								<div class="number">21套</div>
								<div class="see">
									<div class="col-lg-1" style="height: 20px; padding: 0px;"></div>
									<div class="col-lg-8 all" style="padding: 0px;"><a href=href="/house/show/house/list?houseInfo.houseSellWay=租售">查看全部</a></div>

									<div class="iconfont icon-bofang col-lg-1 icon"></div>

								</div>


							</div>
						</div>
					</a>
					<div class="col-lg-12 house-entrance">
						<table class="table table-bordered">

							<tbody>
								<tr>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售">
											<div class="col-sm=12" style="padding: 0px;">整租</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售&houseInfo.houseStructure=1室1厅">
											<div class="col-sm=12" style="padding: 0px;">一室一厅</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售&device.toilet='1'">
											<div class="col-sm=12" style="padding: 0px;">独立卫生间</div>
									</a></td>
								</tr>
								<tr>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售">
											<div class="col-sm=12" style="padding: 0px;">个人房源</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售&houseInfo.houseDepoitWay=押一付一">
											<div class="col-sm=12" style="padding: 0px;">押一付一</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售">
											<div class="col-sm=12" style="padding: 0px;">家电齐全</div>
									</a></td>
								</tr>
								<tr>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售&houseInfo.houseDirection=南">
											<div class="col-sm=12" style="padding: 0px;">朝南</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售&device.balcony='1'">
											<div class="col-sm=12" style="padding: 0px;">独立阳台</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseSellWay=租售">
											<div class="col-sm=12" style="padding: 0px;">短租</div>
									</a></td>
								</tr>
								<tr>
									<td colspan="3" style="border: 5px solid white"><a href="/house/show/house/list?houseInfo.houseSellWay=租售">
											<div class="col-sm=12" style="padding: 0px;">
												全部租房房源 <i class="iconfont icon-bofang icon"></i>
											</div>
									</a></td>

								</tr>
							</tbody>
						</table>

					</div>

				</div>
			</div>

			<!--二手房-->
			<div class="col-lg-4 house-window">
				<div class="col-lg-12 house">
					<a href="">
						<div class="col-lg-12 house-img house-second">

							<div class="col-lg-7"></div>
							<div class="col-lg-5" style="margin-top: 25px;">
								<div class="title">二手房</div>
								<div class="number">8266套</div>
								<div class="see">
									<div class="col-lg-1" style="height: 20px; padding: 0px;"></div>
									<div class="col-lg-8" all" style="padding: 0px;"><a href=href="/house/show/house/list?houseInfo.houseSellWay=出售">查看全部</div>

									<div class="iconfont icon-bofang col-lg-1 icon"></div>

								</div>
							</div>


						</div>
					</a>
					<div class="col-lg-12 house-entrance">
						<table class="table table-bordered">

							<tbody>
								<tr>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售&houseInfo.houseStructure=1室1厅">
											<div class="col-sm=12" style="padding: 0px;">一房一厅</div>
									</a></td>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">精装两居</div>
									</a></td>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">小三居</div>
									</a></td>
								</tr>
								<tr>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">准新房</div>
									</a></td>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">精装修</div>
									</a></td>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售&houseInfo.houseDirection=南北">
											<div class="col-sm=12" style="padding: 0px;">南北通透</div>
									</a></td>
								</tr>
								<tr>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">低总价</div>
									</a></td>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售&device.elevator=1">
											<div class="col-sm=12" style="padding: 0px;">带电梯</div>
									</a></td>
									<td style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售&houseInfo.houseType=别墅">
											<div class="col-sm=12" style="padding: 0px;">别墅</div>
									</a></td>
								</tr>
								<tr>
									<td colspan="3" style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">
												全部二手房源 <i class="iconfont icon-bofang icon"></i>
											</div>
									</a></td>

								</tr>
							</tbody>
						</table>

					</div>




				</div>
			</div>

			<!--商业地产-->
			<div class="col-lg-4 house-window">
				<div class="col-lg-12 house">
					<a href="">
						<div class="col-lg-12 house-img house-business">

							<div class="col-lg-7"></div>
							<div class="col-lg-5" style="margin-top: 25px;">
								<div class="title">商业地产</div>
								<div class="number">5310套</div>
								<div class="see">
									<div class="col-lg-1" style="height: 20px; padding: 0px;"></div>
									<div class="col-lg-8 all" style="padding: 0px;"><a href="/house/show/house/list?houseInfo.houseType=business">查看全部</a></div>

									<div class="iconfont icon-bofang col-lg-1 icon"></div>

								</div>
							</div>




						</div>
					</a>
					<div class="col-lg-12 house-entrance">
						<table class="table table-bordered">

							<tbody>
								<tr>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=商铺&houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">商铺出租</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=商铺&houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">商铺出售</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=写字楼&houseInfo.houseSellWay=出租">
											<div class="col-sm=12" style="padding: 0px;">写字楼出租</div>
									</a></td>
								</tr>
								<tr>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=写字楼&houseInfo.houseSellWay=出售">
											<div class="col-sm=12" style="padding: 0px;">写字楼出售</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=business">
											<div class="col-sm=12" style="padding: 0px;">生意转让</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=厂房">
											<div class="col-sm=12" style="padding: 0px;">厂房</div>
									</a></td>
								</tr>
								<tr>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=仓库">
											<div class="col-sm=12" style="padding: 0px;">仓库</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=土地">
											<div class="col-sm=12" style="padding: 0px;">
											土地</div>
									</a></td>
									<td style="border: 5px solid white;"><a href="/house/show/house/list?houseInfo.houseType=车位">
											<div class="col-sm=12" style="padding: 0px;">车位</div>
									</a></td>
								</tr>
								<tr>
									<td colspan="3" style="border: 5px solid white;"><a
										href="/house/show/house/list?houseInfo.houseType=business">
											<div class="col-sm=12" style="padding: 0px;">
												全部商业地产 <i class="iconfont icon-bofang icon"></i>
									</div></a></td>
								</tr>
							</tbody>
						</table>

					</div>



				</div>
			</div>
			<!--尾部-->
			<div class="col-sm-6 ">
				<a href="#">
					<div class="col-sm-12 tail tail-left">
						<div class="col-lg-1"></div>
						<div class="col-lg-5" style="margin-top: 50px;">
							<div class="title" style="font-size: 24px;">个人房源</div>
							<div class="number" style="font-size: 12px;">海量房东直租房源任你挑</div>
							<div class="see-tail">
								<div class="col-lg-1" style="height: 20px; padding: 0px;"></div>
								<div class="col-lg-8" style="padding: 0px;">点击进入</div>

								<div class="iconfont icon-bofang col-lg-1 icon"></div>

							</div>
						</div>


					</div>
				</a>

			</div>

			<div class="col-sm-6">
				<a href="#">
					<div class="col-sm-12 tail tail-right">
						<div class="col-lg-1"></div>
						<div class="col-lg-5" style="margin-top: 50px;">
							<div class="title" style="font-size: 24px;">个人房源</div>
							<div class="number" style="font-size: 12px;">海量房东直租房源任你挑</div>
							<div class="see-tail">
								<div class="col-lg-1" style="height: 20px; padding: 0px;"></div>
								<div class="col-lg-8" style="padding: 0px;">点击进入</div>

								<div class="iconfont icon-bofang col-lg-1 icon"></div>

							</div>
						</div>

					</div>
				</a>

			</div>






		</div>

		<div class="col-lg-1"></div>
	</div>

	<div class="col-lg-12" style="padding: 0px;">
		<div class="col-lg-1"></div>
		<div class="end col-lg-10">
			<div class="end-title">其他房产频道介绍</div>
			<div style="color: #999; font-size: 12px;">其他房产网为您提供其他房产信息，
				在此有大量其他房产信息供您选择， 每天都有几十万条房源信息更新， 人工审核真实有效，欢迎您使用58同 城其他房产网--其他房产网 触屏版</div>


			<div class="end-title">其他房产网相关热门城市</div>
			<div class="col-lg-12" style="padding: 0px">
				<ul class="end-ul">

					<li>北京房产网</li>
					<li>上海房产网</li>
					<li>广州房产网</li>
					<li>深圳房产网</li>
					<li>天津房产网</li>
					<li>南京房产网</li>
					<li>杭州房产网</li>
					<li>成都房产网</li>
					<li>烟台房产网</li>
					<li>石家庄房产网</li>
					<li>武汉房产网</li>
					<li>合肥房产网</li>
					<li>锦州房产网</li>
					<li>济南房产网</li>
					<li>沈阳房产网</li>
				</ul>

			</div>


			<div class="col-lg-12" style="margin-top: 10px; padding: 0px;">友情链接</div>


			<div class="col-lg-12 footer">

				<div class="col-lg-1"></div>
				<a href="#" style="margin-left: 0px;">常见问题</a><span>|</span> <a
					href="#">帮助中心</a><span>|</span> <a href="#">意见反馈</a><span>|</span>
				<a href="#">了解住哪儿</a><span>|</span> <a href="#">加入住哪儿</a><span>|</span>
				<a href="#">反欺诈联盟</a><span>|</span> <a href="#">报案平台</a><span>|</span>
				<a href="#">推广服务</a><span>|</span> <a href="#">渠道招商</a><span>|</span>
				<a href="#">先行赔付</a><span>|</span> <a href="#">Investor
					Relations</a>

			</div>

		</div>

	</div>
</body>

</html>