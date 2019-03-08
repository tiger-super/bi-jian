package com.house.demo.provider;

import java.security.GeneralSecurityException;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.verificationcode.VerificationCodeService;
import com.house.tool.MailVerificationCode;
@Service
public class VerificationCodeServiceImpl implements VerificationCodeService {
    
	@Override
	public String sendMailVerificationCode(String receiveMail,String sendText) {
	  String verificationCodeText = MailVerificationCode.creat();
	  String text = sendText+verificationCodeText;
	  boolean resultSend = false;
	try {
		resultSend = MailVerificationCode.send(receiveMail,text);
	} catch (GeneralSecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		 return null;
	}
	  System.out.println("resultSend:"+resultSend);
	  if(resultSend) {
		  System.out.println("准备返回结果");
		  return  verificationCodeText;
	  }else {
		  return null;
	  }
	}

}
