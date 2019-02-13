package com.house.tool;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

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
		public static void deleteFile(String folder) throws IOException {
			StringBuffer path = new StringBuffer(); 
			StringBuffer classPath = new StringBuffer(); 
			 path.append(new File("").getCanonicalPath()+"/src/main/resources/static/uploadcache/"+folder);
				//类路径
				classPath.append(ClassUtils.getDefaultClassLoader().getResource("").getPath()+"/static/uploadcache/"+folder);
				File file = new File(path.toString());
				File classFile = new File(classPath.toString());
				if(file.exists()) {
					String[] fileString = file.list();
					for(int i = 0 ; i < fileString.length; i++) {
						StringBuffer sb = new StringBuffer(path.toString()+"/"+fileString[i]);
						new File(sb.toString()).delete();
					}
				file.delete();
				}
				if(classFile.exists()) {
					String[] fileClassString = classFile.list();
					for(int i = 0 ; i < fileClassString.length; i++) {
						StringBuffer sb = new StringBuffer(classPath.toString()+"/"+fileClassString[i]);
						new File(sb.toString()).delete();
					}
		        classFile.delete();					
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
				//类路径
				classPath.append(ClassUtils.getDefaultClassLoader().getResource("").getPath()+"/static/uploadcache/"+folder);
				createFolder(classPath.toString());
				String photoAddress = PhoneAddressCreate.createAddress() + suffix;
				path.append("/"+photoAddress);
				classPath.append("/"+photoAddress);
				fileupload(houseImg.getBytes(),path.toString());
				fileupload(houseImg.getBytes(),classPath.toString());
				 readCacheImgName(folder, list); 
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
		public static List<byte[]> readCacheImg(String folder,List<byte[]> list) throws IOException{
			StringBuffer path = new StringBuffer(); 
			path.append(new File("").getCanonicalPath()+"/src/main/resources/static/uploadcache/"+folder);
			File file = new File(path.toString());
			String[] s = file.list();
			for(int i = 0 ; i < s.length ; i++) {
				File f = new File(path.toString()+"/"+s[i]);
				BufferedImage bi = ImageIO.read(f);;
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bi, "jpg", baos);
				list.add(baos.toByteArray());
			}
			deleteFile(folder);
			return list;
		}
		
		private static List<String> readCacheImgName(String folder,List<String> list) throws IOException{
			File file = new File(new File("").getCanonicalPath()+"/src/main/resources/static/uploadcache/"+folder);
			String[] s = file.list();
			for(int i = 0 ; i < s.length; i++) {
				list.add("/static/uploadcache/"+folder+"/"+s[i]);
			}
			return list;
		}
}
