package com.house.demo.verificationcode;

import java.awt.image.BufferedImage;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public interface VerificationCodeService {

     // 发送邮箱验证码
     public String sendMailVerificationCode(String receiveMail,String sendText);
   
}
