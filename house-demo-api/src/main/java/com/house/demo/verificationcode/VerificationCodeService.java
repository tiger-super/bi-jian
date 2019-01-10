package com.house.demo.verificationcode;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface VerificationCodeService {
	// 获取验证码
     public void gainVerificationCode(HttpSession session,HttpServletResponse response);
  
     // 发送邮箱验证码
     public void sendMailVerificationCode();
   
}
