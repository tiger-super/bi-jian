package TestSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketRun implements Runnable {
    private Socket client;
    private Socket employee;
    public SocketRun(Socket client,Socket employee) {
    	this.client = client;
    	this.employee = employee;
    }
	@Override
	public void run() {
		System.out.println("双方建立连接");
		try {
			DataInputStream clientIn = new DataInputStream(client.getInputStream());
			DataOutputStream clientOut = new DataOutputStream(client.getOutputStream());
			DataInputStream employeeIn = new DataInputStream(employee.getInputStream());
			DataOutputStream employeeOut = new DataOutputStream(employee.getOutputStream());
			/*
			 * while(true) { new Thread(new InformationExchange(clientOut,employeeIn
			 * )).start(); new Thread(new InformationExchange(employeeOut, clientIn
			 * )).start(); }
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
