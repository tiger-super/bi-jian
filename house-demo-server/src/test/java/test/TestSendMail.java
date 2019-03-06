package test;
import org.junit.Test;

import com.house.tool.MailVerificationCode;


public class TestSendMail {
   @Test
   public void testSend() {
	   MailVerificationCode.send("347177277@qq.com","验证码");
   }

}
