package com.house.tool;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.springframework.stereotype.Component;

@Component
public class SocketTool {
	private static int prot = 8000;

	private Socket socket;
	private DataOutputStream out;

	public void updateSendSocket(String content) {
		 AnalysisXML ax = new AnalysisXML();
		try {
			socket = new Socket(ax.getName(AnalysisXML.SOCKET), prot);
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(content);
		} catch (IOException e) {
               e.printStackTrace();
		}

	}
	
}
