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

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.verificationcode.VerificationCodeService;

@Controller
@RequestMapping("/house")
public class VerificationCodeController {
	@Reference
	VerificationCodeService verificationCodeService;

	// 获取验证码
	@RequestMapping("/gain/VerificationCode")
	public void gainVerificationCode(HttpSession session, HttpServletResponse response) {
		 verificationCodeService.gainVerificationCode(session,response);
		
	}

	// 判断验证码正确与否
	@RequestMapping("/judge/VerificationCode")
	@ResponseBody
	public String judgeVerificationCode(HttpSession session, String VerificationCode) {
		String piccode = (String) session.getAttribute("piccode");
		if (piccode == null) {
			return "false";
		} else if (piccode.equals(VerificationCode.toUpperCase())) {
			return "true";
		} else {
			return "false";
		}
	}

	// 发送邮箱验证码
	@RequestMapping("/send/mailVerificationCode")
	@ResponseBody
	public void sendMailVerificationCode() {

	}
}
