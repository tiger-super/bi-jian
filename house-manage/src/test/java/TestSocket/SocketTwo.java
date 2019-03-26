package TestSocket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketTwo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		  try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in ));
				 System.out.println("请输入数据");
				 Socket socket = new Socket("127.0.0.1", 8000);
				 DataOutputStream out = new DataOutputStream(socket.getOutputStream());
				 DataInputStream in = new DataInputStream(socket.getInputStream());
				 out.writeUTF("employee");
					new Thread(new AcceptIn(socket)).start();
					new Thread(new AcceptOut(socket)).start();
		        }catch(ConnectException e) {
		        	System.out.println("当前系统无管理员上线");
		        }
			}

		}

