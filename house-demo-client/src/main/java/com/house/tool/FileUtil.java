package com.house.tool;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	//静态方法：三个参数：文件的二进制，文件路径，文件名
		//通过该方法将在指定目录下添加指定文件	
		private static  void fileupload(byte[] file,String filePath) throws IOException {	
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
		
		
		// 处理文件
		
		public static boolean  uploadCache(MultipartFile houseImg,String folder,List<String> list) {
			// 获取文件名称,包含后缀
			String fileName = houseImg.getOriginalFilename();
			// 获得后缀
			String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			StringBuffer path = new StringBuffer(); 
			StringBuffer classPath = new StringBuffer(); 
			try {
				//本地路径
				path.append(new File("").getCanonicalPath()+"/src/main/resources/static/uploadcache/"+folder);
				createFolder(path.toString());
				System.out.println(path.toString());
				//类路径
				classPath.append(ClassUtils.getDefaultClassLoader().getResource("").getPath()+"/static/uploadcache/"+folder);
				createFolder(classPath.toString());
				String photoAddress = PhoneAddressCreate.createAddress() + suffix;
				path.append("/"+photoAddress);
				classPath.append("/"+photoAddress);
				fileupload(houseImg.getBytes(),path.toString());
				fileupload(houseImg.getBytes(),classPath.toString());
				list.add("/static/uploadcache/"+folder+"/"+photoAddress);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		private static void createFolder(String path) {
			File file = new File(path);
			if(!file.exists()) {
				file.mkdirs();
			}
		}
}
