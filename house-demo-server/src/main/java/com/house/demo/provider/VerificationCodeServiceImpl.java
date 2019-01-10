package com.house.demo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.verificationcode.VerificationCodeService;
import com.house.tool.MailVerificationCode;
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    
	@Override
	public String sendMailVerificationCode(String receiveMail,String sendText) {
	  String verificationCodeText = MailVerificationCode.creat();
	  String text = sendText+verificationCodeText;
	  boolean resultSend = MailVerificationCode.send(receiveMail,text);
	  if(resultSend) {
		  return  verificationCodeText;
	  }else {
		  return null;
	  }
	}

}
