let websocket = null;
$(document).ready(function() {
	getId ();
	$(".chatNumber").hide();
	ConnectWebSockt();
	$(".chat-li").click(function(){
		$(".chat").remove();
	$("body").append("	<div class='col-sm-3 chat' style='padding:0px;background-color:#f5f5f5;height:337px;position:fixed;right:10px;bottom:10px'>"
			+"<div style='width:20px;position:absolute;right:0px;z-index:10000' class='close'><img src='/static/img/chat/close.png' style='height:20px;width:20px'></div>"
	+"<div class='col-sm-12' id='message' style='padding:0px;height:250px;border:1px solid #ddd;;overflow-y:auto;overflow-x:hidden'></div>"
	+"<div class='col-sm-12 import' style='background-color:#f5f5f5'>" +
	"<div class='col-sm-12' style='padding:0px'><textarea class='send-content' rows='2' cols='40' style='height:35px;width:294px;border:none;background-color:#f5f5f5;'></textarea></div>" +
	"<div class='col-sm-8'><button type='button' class='btn btn-info' id='content' style='height:30px;width:70px;line-height:18px'>连接</button>"+
	"<button type='button' class='btn btn-info send' style='height:30px;width:70px;line-height:18px;float:right'>发送</button></div></div></div>");
	$(".send").click(function(){
		send();
	})
	 $(".close").click(function(){
		 $(".chat").remove();
	 })
	$("#content").click(function(){
		$('#message').empty();
		accept();

	})
	 })		
	 
})


function ConnectWebSockt(){
	let ws = "ws://47.106.244.224:8082/websocket/"+$(".employeeId").attr("value")+"/employee/管理员-"+$(".employeeId").attr("value")
		/*let ws = "ws://localhost:8082/websocket/"+$(".employeeId").attr("value")+"/employee/管理员-"+$(".employeeId").attr("value");*/
	if('WebSocket' in window){
        websocket = new WebSocket(ws);
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
    }

    //接收到消息的回调方法
    websocket.onmessage = function(event){
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function(){
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function(){
        websocket.close();
    }
}
    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML){
    	if(innerHTML.indexOf("&") != -1 ){
    	  let json = analysis(innerHTML);
    	  let number = json.number;
    	  if(number != undefined){
    		  if(number == "0"){
    			  $(".chatNumber").hide();
    		  }else{
    			  $(".chatNumber").show();
    			  $(".chatNumber").text(number);
    		  }
    	  }else{
    	  switch(json.role){
    	  case "employee":
    		  $('#message').append("<div><div style='text-align:right;font-size:15px'>"+json.name+"</div>"+
    		  "<div style='word-wrap:break-word; word-break:break-all; overflow: hidden;text-align:right'>"+
    		  "<span style='background-color:#99FF00;display:inline-block;padding-left:10px;padding-right:10px;margin-top:5px;border-radius:7px;'>"+
    		  json.message+"</span><span  style='padding:0px'><img src='/static/img/chat/chat-e.png' style='height:30px;width:30px'></span></div></div>");
    		  break;
    	  case "customer":
    		  $('#message').append("<div><div style='text-align:left;font-size:15px'>"+json.name+"</div>"+
    	    		  "<div style='word-wrap:break-word; word-break:break-all; overflow: hidden;text-align:left'>"+
    	    		  "<span><img src='/static/img/chat/chat-c.png' style='height:30px;width:30px'></span>"+
    	    		  "<span  style='padding:0px;right:0px'><div style='background-color:#11EEEE;display:inline-block;padding-left:10px;padding-right:10px;margin-top:5px;margin-left:5px;border-radius:7px;'>"+json.message+"</span></div></div></div>");
    		  break;
    	  default:
    		  $('.content-img').remove();
    	  $('#message').append("<div style='width:250px;word-wrap:break-word; word-break:break-all; overflow: hidden;'>"+json.message+"</div>");
    	  break;
    	 
    	  }
    	  }
    	}else{
    	  $('#message').append("<div style='width:250px;word-wrap:break-word; word-break:break-all; overflow: hidden;'>"+innerHTML+"</div>");
    }
    }
    //关闭连接
    function closeWebSocket(){
        websocket.close();
    }
    //发送消息
    function send(){
        var message = $('.send-content').val();
        $('.send-content').val("");
        var socketMsg = {msg:message,ifWork:"false",fromUser:id,roleForFrom:"employee"};
        websocket.send(JSON.stringify(socketMsg));
    }

    function analysis(innerHTML){  	
    	let data  = innerHTML.split("&");
        let name ;
        let message;
        let role;
        let number;
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
        case "number":
        	number = d[1];
        }
        }
        let json = {"name":name,"message":message,"role":role,"number":number};
   	return json; 
    	

    }
    
    function accept(){
    	let id = $(".employeeId").attr("value");
        var socketMsg = {ifWork:"true",fromUser:id};
        websocket.send(JSON.stringify(socketMsg));
    }
    let id;
    function getId(){
    	$.ajax({
    	    	url:"/manage/session/chat",
    	        method:"post",
    	        dataType : "json",
    	        success:function(result){
    	        id = result.id;
    	        }
    	    })
    }