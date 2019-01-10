package com.house.demo.provider;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.verificationcode.VerificationCodeService;
import com.house.tool.CreateVerificationCode;
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {

	@Override
	public void gainVerificationCode(HttpSession session,HttpServletResponse response) {
	
		BufferedImage image = CreateVerificationCode.create(session);
		try {
			OutputStream out = response.getOutputStream();
			ImageIO.write(image, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendMailVerificationCode() {
		// TODO Auto-generated method stub

	}

}
