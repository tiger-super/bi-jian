package com.house.tool;

import java.security.GeneralSecurityException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailVerificationCode {
	  public static boolean send(String receiveMail,String text) throws GeneralSecurityException  {
	      // 发件人电子邮箱
	      String from = "347177277@qq.com";
	 
	      // 指定发送邮件的主机为 smtp.qq.com
	      String host = "smtp.qq.com";  //QQ 邮件服务器
	 
	      // 获取系统属性
	      Properties properties = System.getProperties();
	 
	      // 设置邮件服务器
	      properties.setProperty("mail.smtp.host", host);
	 
	      properties.put("mail.smtp.auth", "true");
	      
	      MailSSLSocketFactory sf = new MailSSLSocketFactory();
	        sf.setTrustAllHosts(true);
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.socketFactory", sf);
	      // 获取默认session对象
	      Session session = Session.getDefaultInstance(properties,new Authenticator(){
	        public PasswordAuthentication getPasswordAuthentication()
	        {
	         return new PasswordAuthentication("347177277@qq.com", "nrovebsqpuicbijb"); //发件人邮件用户名、密码
	        }
	       });
	 
	      try{
	    	  System.out.println("准备发送");
	         // 创建默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);
	         System.out.println("创建mimemessgae");
	         // Set From: 头部头字段
	         message.setFrom(new InternetAddress(from));
	         System.out.println("头部头字段");
	         // Set To: 头部头字段
	         System.out.println("加入字体RecipientType");
	        	 message.addRecipient(Message.RecipientType.TO,
                         new InternetAddress(receiveMail));
	 
	        	 System.out.println("加入字体");
	 
	         // Set Subject: 头部头字段
	         message.setSubject("住哪儿网邮箱验证");
	         System.out.println("加入字体消息体");
	         // 设置消息体
	         message.setText(text);
	         System.out.println("马上发送");
	         // 发送消息
	         Transport.send(message);
	         System.out.println("发送完毕");
	      }catch (MessagingException e) {
	    	  System.out.println("异常1号");
	    	  e.printStackTrace();
	        return false;
	      }catch(IllegalStateException e) {
	    	  System.out.println("异常2号");
		    return false;
		  }
	      return true;

}
     public static String creat() {
    	 Random r = new Random();
    	 StringBuffer sb = new StringBuffer();
    	 for(int i = 0 ; i < 6 ;i++) {
    		 sb.append(String.valueOf(r.nextInt(10)));
    	 }
    	 return sb.toString();
     }
	  }

