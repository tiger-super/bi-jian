package com.house.control;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
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
	// 设置超时时间
	@Reference(timeout=30000,retries=0)
    private VerificationCodeService verificationCodeService;

	// 获取验证码
	@RequestMapping("/gain/VerificationCode")
	@ResponseBody
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
			return "false";
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
		},  120 * 1000);
	}
	@RequestMapping("/judge/mailVerificationCode")
	@ResponseBody
	public  Map<String, String> judgeMailVerificationCode(String mailVerificationCodeText,HttpSession session) {
		Map<String, String> map = new HashMap<String,String>();
		String  mailVerificationCodeSession = (String) session.getAttribute("mailVerificationCodeText");
		if( mailVerificationCodeSession == null) {
			map.put("result", "验证码已失效，请重新获取");
		}else if(mailVerificationCodeSession.equals(mailVerificationCodeText)){
			map.put("result","true");
		}else {
			map.put("result","false");	
		}
		return map;
	}
	

}
