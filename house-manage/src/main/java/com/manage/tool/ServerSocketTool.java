package com.manage.tool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ServerSocketTool {
	private ServerSocket server;
	public static boolean publishHouse = false;
	public static List<Socket> list = new ArrayList<Socket>();
	public static int count = 0;

	public void serverStart() {
		try {
			server = new ServerSocket(8000);
			System.out.println("服务开启");
			while (true) {
				Socket socket = server.accept();
				DataInputStream in = new DataInputStream(socket.getInputStream());
				String result = in.readUTF();
				switch (result) {
				case "house":
					setPublishHouse(true);
					break;
				case "client":
					System.out.println("用户请求");
					list.add(socket);
					count +=1;
					System.out.println("当前用户请求数量:"+count);
					break;
				case "employee":
					System.out.println("管理员处理");
					if(count > 0) {
						new Thread(new InformationExchange(list.get(0),socket)).start();	
						new Thread(new InformationExchange(socket,list.get(0))).start(); 
					}
					count-=1;
					System.out.println("当前用户请求数量:"+count);
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isPublishHouse() {
		return publishHouse;
	}

	public static void setPublishHouse(boolean publishHouse) {
		ServerSocketTool.publishHouse = publishHouse;
	}

}
