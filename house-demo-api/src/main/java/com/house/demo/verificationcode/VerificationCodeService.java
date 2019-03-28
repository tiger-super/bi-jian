package com.house.demo.verificationcode;
public interface VerificationCodeService {

     // 发送邮箱验证码
     public String sendMailVerificationCode(String receiveMail,String sendText);
   
}
