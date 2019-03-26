package TestSocket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AcceptOut implements Runnable {
	 private Socket socekt;
	 DataOutputStream out; 
	 public AcceptOut(Socket socket) {
		 this.socekt = socket;
	 }
	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
		try {
			out = new DataOutputStream(socekt.getOutputStream());
		while(true) {
			System.out.println("请输入内容");
			String  read = br.readLine();
			out.writeUTF(read);
		}} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
}
