package com.manage.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manage.tool.SocketMsg;

@ServerEndpoint("/websocket/{sendId}/{role}/{name}")
@Component
public class WebSocket{
	/**
    *    这里稍微解释一下这些主要注解的作用 。
    *   • @ServerEndpoint("/ws") ：
    *     表示让 Spring 创建 WebSocket 的服务端点 ，其中请求地址是“／WebSocket”。
    *   • @OnOpen：
    *     标注客户端打开 WebSocket 服务端点调用方法。
    *   • @OnClose ： 
    *     标注客户端关 闭 WebSocket 服务端点调用方法。
    *   • @OnMessage ： 
    *     标注客户端发送消息， WebSocket 服务端点调用方法。
    *   • @OnError：
    *     标注客户 端请求 WebSocket 服务端点发生异常调用 方法。
    * 因为每一个客户端打开时，都会为其创建一个 WebSocket 对象，所以这里的打开方
    * 法中都会去计数并且将这个对象保存到 CopyOnWriteArraySet 中，这样就可以知道拥有多少连接。对
    * 于关 闭方法则是清除这个对象，并且计数减一。对于消息发送方法 ，则是通过轮询对所有的客户端
    * 连接都给予发送消息，所以所有的连接都可以收到这个消息。但是有时候可能只 是需要发送给特定13.4 WebSocket 应用 309
    * 的用户，则需要得到用户的信息，然后再发送给特定的用户 。
    */
 
    /**oncurrent 包的线程安全 Set ，用来存放每个客户端对应的 WebSocketServiceimpl 对象*/
    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();
    private static Map<String,Session> employeeMap = new HashMap<String, Session>();
    private static Map<String,Session> customerMap= new HashMap<String, Session>();
    private static Map<String,String> eAndC = new HashMap<String,String>();
    private static List<String> employeeIdList = new ArrayList<String>(); 
    private static List<String> customerIdList = new ArrayList<String>(); 
    private static Map<String,WebSocket> employeeWebSocketMap = new HashMap<String,WebSocket>();
    private static Map<String,WebSocket> customerWebSocketMap= new HashMap<String,WebSocket>();
    /**与某个客户端的连接会话，需要通过它来给客户端发送数据*/
    /** 连接建立成功调用的方法 */
    @OnOpen
    public void onOpen(Session session,@PathParam("sendId")String id,@PathParam("role")String role,@PathParam("name")String name){
        //加入 set 中
        switch(role) {
        case "customer":
        	customerMap.put(id,session);
        	customerIdList.add(id);
        	int index = customerIdList.indexOf(id);
        	sendMessage(session,"number="+index+"&");
        	messageTigs();
        	 customerWebSocketMap.put(id,this);
        	break;
        case "employee":
        	employeeIdList.add(id);
        	employeeMap.put(id,session);
        	messageTigs();
        	employeeWebSocketMap.put(id,this);
        	break;
        }
        webSocketSet.add(this);
        System.out.println("有新连接加入,当前在线人数为" + webSocketSet.size());
     
    }
    //连接关闭调用的方法
    @OnClose
    public void onClose(@PathParam("sendId")String id,@PathParam("role")String role,@PathParam("name")String name){
    	switch(role) {
        case "customer":
        	String employeeId = eAndC.get(id);
        	Session employee = employeeMap.get(employeeId);
        	 deleteMap(id,"customer");
        	 showClose(employee,name) ;
			/*
			 * eAndC.remove(id); eAndC.remove(employeeId ); customerMap.remove(id);
			 * customerIdList.remove(id);
			 */
        	break;
        case "employee":
        	String customerId = eAndC.get(id);
        	Session customer = customerMap.get(customerId);
        	showClose(customer,name);
        	eAndC.remove(id);
        	employeeIdList.remove(id);
        	employeeMap.remove(id);
        	break;
        }
        //从set中删除
        webSocketSet.remove(this);
    }
    /**
     * 收到客户端消息后调用的方法
     * @param message 客户端发送过来的消息
     * @param session
     */
    @OnMessage
	public void onMessage(String message, Session session,@PathParam("name")String name,@PathParam("role")String role){
    	ObjectMapper objectMapper = new ObjectMapper();
    	SocketMsg socketMsg = null;
		try {
			socketMsg = objectMapper.readValue(message, SocketMsg.class);
			socketMsg.setFromName(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
       if("true".equals(socketMsg.getIfWork())) {

    	   deleteMap(socketMsg.getFromUser(),"employee");
    	   if(customerIdList.size() > 0) {
        	String serverObejctId = distributionResource(socketMsg.getFromUser());
        	Session serverObejct = customerMap.get(serverObejctId);
        	messageTigs();
        	sendMessage(serverObejct,"message="+"管理员"+socketMsg.getFromUser()+"为你服务"+"&");    	
        	sendMessage(employeeMap.get(socketMsg.getFromUser()),"客户"+serverObejctId+"已成功连接");    	   
    	   }else {
    		   sendMessage(employeeMap.get(socketMsg.getFromUser()),"当前没有用户咨询");
    	   }
    	   } else {
        	String fromId = socketMsg.getFromUser();//发送者
			String acceptId = eAndC.get(fromId);
			Session fromSession = null; 
			Session toSession = null;
			switch(socketMsg.getRoleForFrom()) {
			case "customer":
				fromSession = customerMap.get(fromId);
				toSession = employeeMap.get(acceptId);
			break;
			case "employee":
				fromSession =  employeeMap.get(fromId);
				toSession = customerMap.get(acceptId);
			break;
			}//发送给接受者.
			if(toSession != null){
				//发送给发送者.
				  String content = "name="+socketMsg.getFromName()+"&"+"message="+socketMsg.getMsg()+"&role="+role;
				  sendMessage(toSession,content);
				  sendMessage(fromSession,content);
			}else{
				//发送给发送者.
				 sendMessage(fromSession,"系统消息：对方不在线");
			}
        }
    }
    //发送错误时调用
    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发送错误");
        error.printStackTrace();
    }
 
    /**
     * 发送消息
     * @param message 客户端消息
     * @throws IOException
     */
    
    public  String distributionResource(String employeeId) {
    	String customerId = null;
    	if(customerIdList.size() > 0) {
    	  customerId = customerIdList.get(0);
    	   customerIdList.remove(0);
    	   eAndC.put(employeeId,customerId );
    	   eAndC.put(customerId ,employeeId );
    	}
    	return customerId;
    }
    
    public void showClose(Session session,String role) {
    	if(session != null) {
    		sendMessage(session,role+"已下线");
    		
    	}
    }
    public  void messageTigs(){
    	for(int i = 0 ; i < employeeIdList.size() ; i++) {
    		Session employee = employeeMap.get(employeeIdList.get(i));
    		sendMessage(employee,"number="+customerIdList.size()+"&");
    	}
    }
    public  void lineUp() {
    	for(int i = 0 ; i < customerIdList.size() ; i++) {
    		Session customer = customerMap.get(customerIdList.get(i));
    		sendMessage(customer,"number="+i+"&");
    	}
    }
    public void deleteMap(String id,String role) {
    	String value = null;
    	switch(role) {
    	case "employee":
    	    value = eAndC.get(id);
    		if(value != null) {
    		Session session = customerMap.remove(value);
    		showClose(session,"管理员");
    		eAndC.remove(value);
    		eAndC.remove(id);
    		webSocketSet.remove(customerWebSocketMap.get(value));
    		customerWebSocketMap.remove(value);
    		}
    		break;
    	case "customer":
    		value = eAndC.get(id);
    		customerIdList.remove(id);
    		customerMap.remove(id);
    		eAndC.remove(id);
    		if(value != null) {
    		eAndC.remove(value);
    		}
    		break;
    	}
    	messageTigs();
    	lineUp();
    }
    public void  sendMessage(Session session,String message) {
    	synchronized(session){
    	    try {
				session.getBasicRemote().sendText(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }
}