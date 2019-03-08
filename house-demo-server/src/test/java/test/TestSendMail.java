package test;
import java.security.GeneralSecurityException;

import org.junit.Test;

import com.house.tool.MailVerificationCode;


public class TestSendMail {
   @Test
   public void testSend() throws GeneralSecurityException {
	   MailVerificationCode.send("347177277@qq.com","验证码");
   }

}
