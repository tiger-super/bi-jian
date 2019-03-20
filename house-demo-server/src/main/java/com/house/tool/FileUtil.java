package com.house.tool;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

import com.house.entity.House;

@Component
public class FileUtil {
	/**
	 * 保存文件
	 * 
	 * @param file     文件的二进制信息
	 * @param filePath 文件路径
	 * @throws IOException
	 */
	public static void fileupload(byte[] file, String filePath) throws IOException {
		// 二进制流写入
		FileOutputStream out = new FileOutputStream(filePath);
		out.write(file);
		out.flush();
		out.close();
	}

	public static byte[] getImageBinary(String Imgpath) {
		File f = new File(Imgpath);
		BufferedImage bi;
		try {
			bi = ImageIO.read(f);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, "jpg", baos);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 删除文件
	 * 
	 * @param path 文件路径
	 */
	public static void deleteFile(String path) {
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			file.delete();
		}

	}

	/**
	 * 删除文件夹
	 * 
	 * @param path 文件夹路径
	 */
	public static void deleteFolder(String path) {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
	}

	/**
	 * 删除指定文件夹及文件夹下所有内容
	 * 
	 * @param folder  文件夹名
	 * @param address 文件夹的路径
	 */
	public static void deleteFile(String folder, String address) {
		StringBuffer path = new StringBuffer();
		path.append(address).append(folder);
		// 类路径
		File file = new File(path.toString());
		if (file.exists()) {
			String[] fileString = file.list();
			for (int i = 0; i < fileString.length; i++) {
				StringBuffer sb = new StringBuffer(path.toString() + "/" + fileString[i]);
				deleteFile(sb.toString());
			}
			deleteFolder(path.toString());
		}
	}

	/**
	 * 读取文件
	 * 
	 * @param list         对象
	 * @param visitAddress 文件访问路径
	 * @param keepAddress  文件保存路径
	 * @return
	 */
	public static String getObjectImgVisitPath(String imageFolder, String visitAddress, String keepAddress) {
		StringBuffer keepPath = new StringBuffer();
		StringBuffer visitPath = new StringBuffer();
		keepPath.append(keepAddress + imageFolder);
		File file = new File(keepPath.toString());
		String[] images = file.list();
		visitPath.append(visitAddress + imageFolder + "/" + images[0]);
		return visitPath.toString();
	}

	// 创建文件夹
	public void createFolder(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	// 处理缓存
	public boolean keepImg(byte[] imgByte, String folder, String suffixName, String cacheAddress, String id) {
		StringBuffer path = new StringBuffer();
		try {
			// 本地路径
			path.append(cacheAddress + folder);
			// 创建文件夹
			createFolder(path.toString());
			// 照片名字和照片后缀
			String photoAddress = PhoneAddressCreate.createAddress(id) + suffixName;
			path.append("/" + photoAddress);
			// 写入缓存
			fileupload(imgByte, path.toString());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 获取缓存访问路径
	public List<String> cacheVistPath(String folder, String cacheVisitPath, String cacheKeepPath) {
		StringBuffer cachePath = new StringBuffer();
		cachePath.append(cacheKeepPath).append(folder);
		List<String> imgVisit = new ArrayList<String>();
		List<String> folderValue = getFolderValue(cachePath.toString());
		for (int i = 0; i < folderValue.size(); i++) {
			StringBuffer visitPath = new StringBuffer();
			visitPath.append(cacheVisitPath).append(folder).append("/").append(folderValue.get(i));
			imgVisit.add(visitPath.toString());
		}

		return imgVisit;
	}

	/**
	 * 获取文件夹所有内容
	 * 
	 * @param folderPath 文件夹路径
	 * @return
	 */
	public List<String> getFolderValue(String folderPath) {
		File file = new File(folderPath);
		List<String> list = new ArrayList<String>();
		String[] values = file.list();
		for (int i = 0; i < values.length; i++) {
			list.add(values[i]);
		}
		return list;
	}

	// 读取图片的二进制信息
	public List<byte[]> readImg(String folder, String readPath) {
		List<byte[]> list = new ArrayList<byte[]>();
		StringBuffer path = new StringBuffer();
		path.append(readPath + folder);
		File file = new File(path.toString());
		String[] s = file.list();
		for (int i = 0; i < s.length; i++) {
			File f = new File(path.toString() + "/" + s[i]);
			try {
				BufferedImage bi = ImageIO.read(f);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bi, "jpg", baos);
				list.add(baos.toByteArray());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
