package com.house.control;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.verificationcode.VerificationCodeService;
import com.house.tool.CreateVerificationCode;

@Controller
@RequestMapping("/house")
public class VerificationCodeController {
	@Reference
	VerificationCodeService verificationCodeService;

	// 获取验证码
	@RequestMapping("/gain/VerificationCode")
	public void gainVerificationCode(HttpSession session, HttpServletResponse response) {
		BufferedImage image = CreateVerificationCode.create(session);
		try {
			OutputStream out = response.getOutputStream();
			ImageIO.write(image, "jpg", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public String sendMailVerificationCode(String customerMailbox, HttpSession session) {
		String mailVerificationCodeText = verificationCodeService.sendMailVerificationCode(customerMailbox, "您的验证码为：");
		if (mailVerificationCodeText != null) {
			session.setAttribute("mailVerificationCodeText", mailVerificationCodeText);
			removeAttrbute(session, "mailVerificationCodeText");
			return "true";
		}else {
			return "验证码失效请重新发送";
		}
	}
     // 设置验证码有效时间
	private void removeAttrbute(HttpSession session, String attrName) {
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// 删除session中存的验证码
				session.removeAttribute(attrName);
				timer.cancel();
			}
		},  60 * 1000);
	}

}
