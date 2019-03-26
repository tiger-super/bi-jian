package TestSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class AcceptIn implements Runnable {
	 private Socket socekt;
	 DataInputStream In; 
	 public AcceptIn(Socket socket) {
		 this.socekt = socket;
	 }
	@Override
	public void run() {
		try {
			In = new DataInputStream(socekt.getInputStream());
			while(true) {
			String content = In.readUTF();
			System.out.println(content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

