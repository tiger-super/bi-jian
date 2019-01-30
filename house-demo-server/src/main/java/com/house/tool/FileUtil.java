package com.house.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	//静态方法：三个参数：文件的二进制，文件路径，文件名
		//通过该方法将在指定目录下添加指定文件	
		public static void fileupload(byte[] file,String filePath) throws IOException {	
			//二进制流写入		
			FileOutputStream out = new FileOutputStream(filePath);
			System.out.println(filePath);
			System.out.println(file.length);
		    out.write(file);
		    out.flush();
		    out.close();
		}
		
		// 删除文件
		public static void deleteFile(String path) {
			 File file=new File(path);
	         if(file.exists()&&file.isFile()) {
	        	 file.delete();
	         }
		}
}
