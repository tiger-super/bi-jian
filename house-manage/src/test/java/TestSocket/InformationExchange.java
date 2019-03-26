package TestSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class InformationExchange implements Runnable{
	 private Socket inSocket;
	    private Socket outSocket;
	 public InformationExchange(Socket inSocket,Socket outSocket) {
		 this.inSocket =inSocket;
	    	this.outSocket = outSocket;
	}
	@Override
	public void run() {
		try {
	
			DataInputStream in = new DataInputStream(inSocket.getInputStream());
			DataOutputStream out = new DataOutputStream(outSocket.getOutputStream());
			while(true) {
				System.out.println("聊天");
			String content = in.readUTF();
			System.out.println(content);
			out.writeUTF(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
