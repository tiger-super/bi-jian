package com.house.control;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.tool.CreateVerificationCode;

@Controller
@RequestMapping("/house")
public class VerificationCodeController {
	@RequestMapping("/gain/VerificationCode")
	public void gainVerificationCode(HttpServletRequest request, HttpServletResponse response) {
		BufferedImage image = CreateVerificationCode.create(request.getSession());
		try {
			OutputStream out = response.getOutputStream();
			ImageIO.write(image, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/judge/VerificationCode")
	@ResponseBody
	public String judgeVerificationCode(HttpSession session, String VerificationCode) {
		String piccode = (String) session.getAttribute("piccode");
		if (piccode == null) {
			return "false";
		} else if (piccode.equals(VerificationCode)) {
			return "true";
		} else {
			return "false";
		}
	}
}
