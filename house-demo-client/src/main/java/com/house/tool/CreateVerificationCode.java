package com.house.tool;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class CreateVerificationCode {

	// 验证码字符串内容
	private static char[] chs = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	private static final int NUMBER_OF_CHS = 4;
	// 图片宽
	private static final int IMG_WIDTH = 65;
	// 图片高
	private static final int IMG_HEIGHT = 25;

	public static BufferedImage create(HttpSession session) {
		Random r = new Random();
		// 实例化BufferedImage
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		// 验证码图片的背景颜色
		Color c = new Color(200, 200, 255);
		g.setColor(c);
		// 图片的边框
		g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		// 用于保存验证码字符串
		StringBuffer sb = new StringBuffer();
		int index; // 数组的下标
		for (int i = 0; i < NUMBER_OF_CHS; i++) {
			// 随机一个下标
			index = r.nextInt(chs.length);
			// 随机一个数字颜色
			g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150)));
			 // 画出字符
			g.drawString(chs[index] + "", 15 * i + 3, 18);
			// 保存验证码字符串
			sb.append(chs[index]);
		}
		session.setAttribute("piccode", sb.toString().toUpperCase());  
		return image;

	}
}
