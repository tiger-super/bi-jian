<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>My WebSocket</title>
</head>
<link rel="stylesheet" href="/static/css/bootstrap/bootstrap.min.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
<body>
Welcome<br/>
<input id="text" type="text" /><button onclick="send()">Send</button>    <button onclick="closeWebSocket()">Close</button><button onclick="accept()">accept</button>
<div id="message" style="height:200px;width:300px;overflow-y: auto;overflow-x:hidden">

</div>
</body>

<script type="text/javascript">
    var websocket = null;
    
    //判断当前浏览器是否支持WebSocket
    if('WebSocket' in window){
        websocket = new WebSocket("ws://localhost:8082/websocket/1000/employee/管理员-1000");
    }
    else{
        alert('Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function(){
        setMessageInnerHTML("error");
    };

    //连接成功建立的回调方法
    websocket.onopen = function(event){
        setMessageInnerHTML("open");
    }

    //接收到消息的回调方法
    websocket.onmessage = function(event){
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function(){
        setMessageInnerHTML("close");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
        websocket.close();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML){
    	if(innerHTML.indexOf("&") != -1 ){
    	  let json = analysis(innerHTML);
    	  console.log(json)
    	  switch(json.role){
    	  case "employee":
    		  $('#message').append("<div><div style='text-align:right;font-size:5px'>"+json.name+"</div>"+
    		  "<div style='word-wrap:break-word; word-break:break-all; overflow: hidden;text-align:right'><div class='col-sm-3' style='padding:0px'></div>"+
    		  "<div class='col-sm-8' style='padding:0px;right:0px'><div style='background-color:#99FF00;display:inline-block;padding-left:10px;padding-right:10px;margin-top:5px;border-radius:7px;'>"+
    		  json.message+"</div></div><div class='col-sm-1' style='padding:0px'><img src='/static/img/chat/chat-e.png' style='height:30px;width:30px'></div></div></div>");
    		  break;
    	  case "customer":
    		  $('#message').append("<div><div style='text-align:left;font-size:5px'>"+json.name+"</div>"+
    	    		  "<div style='word-wrap:break-word; word-break:break-all; overflow: hidden;text-align:left'>"+
    	    		  "<div class='col-sm-1' style='padding:0px'><img src='/static/img/chat/chat-c.png' style='height:30px;width:30px'></div>"+
    	    		  "<div class='col-sm-8' style='padding:0px;right:0px'><div style='background-color:#11EEEE;display:inline-block;padding-left:10px;padding-right:10px;margin-top:5px;margin-left:5px;border-radius:7px;'>"+json.message+"</div></div></div></div>");
    		  break;
    	  }
    	}else{
    	  $('#message').append("<div style='width:250px;word-wrap:break-word; word-break:break-all; overflow: hidden;   '>"+innerHTML+"</div>");
    }
    }
    //关闭连接
    function closeWebSocket(){
   
        websocket.close();
    }

    //发送消息
    function send(){
        var message = $('#text').val();
        $('#text').val("");
        var socketMsg = {msg:message,ifWork:"false",fromUser:"1000",roleForFrom:"employee"};
        websocket.send(JSON.stringify(socketMsg));
    }
    function accept(){
        var socketMsg = {ifWork:"true",fromUser:"1000"};
        websocket.send(JSON.stringify(socketMsg));
    }
    function analysis(innerHTML){
    	
    	let data  = innerHTML.split("&");
        let name ;
        let message;
        let role;
        for(let i =0 ; i < data.length ;i++){
        let d = data[i].split("=")
        switch(d[0]){
        case "name":
        	name = d[1];
        	break;
        case "message":
        	message = d[1];
        	break;
        case "role":
        	role = d[1];
        	break;
        }
        }
        let json = {"name":name,"message":message,"role":role};
   	return json; 
    	

    }
</script>
</html>