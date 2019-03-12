package com.manage.tool;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.springframework.stereotype.Component;

@Component
public class ServerSocketTool {
	private ServerSocket server;
	public static boolean publishHouse = false;

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
