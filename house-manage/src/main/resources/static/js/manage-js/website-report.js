$(document).ready(function(){
    $("#load",parent.document).css("height",$(document).outerHeight(true)+"px");
    loadWebsite();
    getPublishHouseNumber();
    setInterval(function(){
    	wheterUpdateHouseData();
    },5000)
   loadWebsiteGraph()
})	


function getPublishHouseNumber(){
	$.ajax({
		url : '/manage/get/house/number',
		dataType : "json",
		type : "post",
		success : function(result) {
			$(".number").text(result.result);
		}
	});	
}

function wheterUpdateHouseData(){
	$.ajax({
		url : '/manage/update/house/data',
		dataType : "json",
		type : "post",
		success : function(result) {
		if(result.result){
			 getPublishHouseNumber();
		};
		}
	});	
}
function loadWebsiteGraph(){
	$.ajax({
		url : '/manage/session/load/website/graph',
		dataType : "json",
		type : "post",
		success : function(result) {
			loadVisitGraph(result.visit);
			loadPublishGraph(result.publish);
		}
	});	
}
function loadWebsite(){
	$.ajax({
		url : '/manage/session/load/website/data',
		dataType : "json",
		type : "post",
		success : function(result) {
			$(".visit").children(".head-data-result").text(result.visit);
			$(".publish-house").children(".head-data-result").text(result.publishHouseNumber);
			$(".no-publish-house").children(".head-data-result").text(result.noPublishHouseNumber);
			$(".customer").children(".head-data-result").text(result.customerNumber);
		}
	});	
}
function loadVisitGraph(list){
	   // 基于准备好的dom，初始化echarts实例
    let myChart = echarts.init(document.getElementById('website'));

    // 指定图表的配置项和数据
    let option = {
        title: {
            text: '本周网站访问量'
        },
        tooltip: {},
        legend: {
            data:['本周网站访问量']
        },
        xAxis: {
            data: ["周一","周二","周三","周四","周五","周六","周日"]
        },
        yAxis: {},
        series: [{
            name: '网站访问量',
            type: 'bar',
            data: list
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}


function loadPublishGraph(list){
	   // 基于准备好的dom，初始化echarts实例
    let myChart = echarts.init(document.getElementById('publish'));

    // 指定图表的配置项和数据
    let option = {
        title: {
            text: '本周房源发布量'
        },
        tooltip: {},
        legend: {
            data:['本周房源发布量']
        },
        xAxis: {
            data: ["周一","周二","周三","周四","周五","周六","周日"]
        },
        yAxis: {},
        series: [{
            name: '房源发布量',
            type: 'bar',
            data: list
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}