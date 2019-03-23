package com.manage.tool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {

	// 静态方法：三个参数：文件的二进制，文件路径，文件名
	// 通过该方法将在指定目录下添加指定文件
	public void fileupload(byte[] file, String filePath) throws IOException {
		FileOutputStream out = new FileOutputStream(filePath);
		out.write(file);
		out.flush();
		out.close();
	}

	// 删除文件
	public void deleteFile(String jpg) throws IOException {
		StringBuffer cachePath = new StringBuffer();
		AnalysisXML ax = new AnalysisXML();
		cachePath.append(ax.getName(AnalysisXML.EMPLOYEECACHEADDRESS));
		cachePath.append(jpg);
		File file = new File(cachePath.toString());
		file.delete();
	}
	public String cacheFile(String suffix,MultipartFile employeeImg){
		StringBuffer imgAddress = new StringBuffer();
		AnalysisXML ax = new AnalysisXML();
		imgAddress.append(ax.getName(AnalysisXML.EMPLOYEECACHEADDRESS));
		String img = EmployeeAddressCreate.createAddress();
		imgAddress.append(img).append(suffix);	
		try {
			fileupload(employeeImg.getBytes(),imgAddress.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img+suffix;
	}
	public String visitImg(String imgAddress) {
		StringBuffer imgVisitAddress  = new StringBuffer();
		AnalysisXML ax = new AnalysisXML();
		imgVisitAddress.append(ax.getName(AnalysisXML.EMPLOYEEVISITCACHEADDRESS)).append(imgAddress);
		return imgVisitAddress.toString();
	}
}
