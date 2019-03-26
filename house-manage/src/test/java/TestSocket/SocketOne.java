package TestSocket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SocketOne {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		 * try { BufferedReader br = new BufferedReader(new InputStreamReader(System.in
		 * )); System.out.println("请输入数据"); Socket socket = new Socket("127.0.0.1",
		 * 8000); DataOutputStream out = new DataOutputStream(socket.getOutputStream());
		 * DataInputStream in = new DataInputStream(socket.getInputStream());
		 * out.writeUTF("client"); new Thread(new AcceptIn(socket)).start(); new
		 * Thread(new AcceptOut(socket)).start(); }catch(ConnectException e) {
		 * System.out.println("当前系统无管理员上线"); }
		 */
		 Random rand = new Random();
		List<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		System.out.println(l.get(0));
		l.remove("a");
		System.out.println(l.get(0));
		for(int i= 0 ; i < 100 ; i++) {
			System.out.println(rand.nextInt(10));
		}
	}

}
