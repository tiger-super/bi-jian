package TestSocket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketServer {
	public static int count = 0;
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8000);
		List<Socket> list = new ArrayList<Socket>();
		System.out.println("服务开启");
		while (true) {
			Socket socket = server.accept();
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String result = in.readUTF();
			switch(result) {
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
	}
}
