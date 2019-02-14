package com.house.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.house.entity.House;

public class FileUtil {
	//静态方法：三个参数：文件的二进制，文件路径，文件名
		//通过该方法将在指定目录下添加指定文件	
		public static void fileupload(byte[] file,String filePath) throws IOException {	
			//二进制流写入		
			FileOutputStream out = new FileOutputStream(filePath);
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
		
		public static List<House> readHousImg(List<House> list) {
			for(int i = 0 ; i < list.size() ; i++) {
			StringBuffer path = new StringBuffer();
			String imageFolder = list.get(i).getHouseInfo().getHouseImageAddress();
			try {
				path.append(new File("").getCanonicalPath() + "/src/main/resources/static/publish-house-img/"
						+ imageFolder);
			} catch (IOException e) {
				e.printStackTrace();
			}
			File file = new File(path.toString());
			String[] images = file.list();
			list.get(i).getHouseInfo().setHouseImageAddress(imageFolder+"/"+images[0]);
			}
			return list;
		}
}
