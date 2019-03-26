$(document).ready(function() {
	$(".consult").click(function(){
	$("body").append("	<div class='col-sm-3 chat' style='padding:0px;background-color:white;border:1px solid red;height:300px;position:fixed;right:10px;bottom:10px'>"
	+"<div class='col-sm-12 chat-content' style='padding:0px;height:250px;border:1px solid blue'><img class='content-img' src='/static/img/load.gif' style='height:200px;width:300px;'></div>"
	+"<div class='col-sm-12 import' style='padding:0px;height:50px;border:1px solid black'>" +
	"<div class='col-sm-9' style='padding:0px'><textarea class='send-content' rows='1' cols='30' style='height:35px;'></textarea></div>" +
	"<div class='col-sm-3' style='padding-left:5px'><button type='button' class='btn btn-info' style='width:70px;'>发送</button></div></div></div>");
	
	   
	   })					
})