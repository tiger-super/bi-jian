package com.house.tool;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtil {

	// 静态方法：三个参数：文件的二进制，文件路径，文件名
	// 通过该方法将在指定目录下添加指定文件
	private void fileupload(byte[] file, String filePath) throws IOException {
		// 二进制流写入
		FileOutputStream out = new FileOutputStream(filePath);
		out.write(file);
		out.flush();
		out.close();
	}

	// 删除文件
	public void deleteFile(String folder) throws IOException {
		AnalysisXML ax = new AnalysisXML();
		String photoKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		StringBuffer path = new StringBuffer();
		path.append(photoKeepAddress + folder);
		// 类路径
		File file = new File(path.toString());

		if (file.exists()) {
			String[] fileString = file.list();
			for (int i = 0; i < fileString.length; i++) {
				StringBuffer sb = new StringBuffer(path.toString() + "/" + fileString[i]);
				new File(sb.toString()).delete();
			}
			file.delete();

		}
	}

	// 处理文件

	public boolean uploadCache(MultipartFile houseImg, String folder, List<String> list) {
		AnalysisXML ax = new AnalysisXML();
		String photoKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		// 获取文件名称,包含后缀
		String fileName = houseImg.getOriginalFilename();
		// 获得后缀
		String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		StringBuffer path = new StringBuffer();
		try {
			// 本地路径
			path.append(photoKeepAddress + folder);
			createFolder(path.toString());
			String photoAddress = PhoneAddressCreate.createAddress() + suffix;
			path.append("/" + photoAddress);

			fileupload(houseImg.getBytes(), path.toString());
			readCacheImgName(folder, list);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void createFolder(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public List<byte[]> readCacheImg(String folder, List<byte[]> list) throws IOException {
		StringBuffer path = new StringBuffer();
		AnalysisXML ax = new AnalysisXML();
		String photoKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		path.append(photoKeepAddress + folder);

		File file = new File(path.toString());
		String[] s = file.list();
		for (int i = 0; i < s.length; i++) {
			File f = new File(path.toString() + "/" + s[i]);
			BufferedImage bi = ImageIO.read(f);
			;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, "jpg", baos);
			list.add(baos.toByteArray());
		}
		deleteFile(folder);
		return list;
	}

	private List<String> readCacheImgName(String folder, List<String> list) throws IOException {
		AnalysisXML ax = new AnalysisXML();
		String photoKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		String photoVisitAddress = ax.getName(AnalysisXML.HOUSEVISITADDRESS);
		File file = new File(photoKeepAddress + folder);
		String[] s = file.list();
		for (int i = 0; i < s.length; i++) {
			list.add(photoVisitAddress + folder + "/" + s[i]);
		}
		return list;
	}
}
