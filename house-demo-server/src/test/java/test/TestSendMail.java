package test;

import java.util.Random;

import org.junit.Test;

import com.house.tool.MailVerificationCode;


public class TestSendMail {
   @Test
   public void testSend() {
	   MailVerificationCode.send("347177277@qq.com","验证码");
   }
   @Test
   public void testRum() {
	   Random r = new Random();
	   for(int i = 0 ;i < 10000 ;i++) {
	   }
   }
}
