package test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;
import com.house.demo.provider.PayServiceImpl;
import com.house.entity.Pay;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestPayServiceImpl {
	@Autowired
	PayServiceImpl ps;
	@Test
    public void testHandlePay() {
		Pay pay = new Pay();
		pay.setPayMoney("40.00");
		pay.setPayPeopleId("1");
		pay.setPayId("123");
		ps.handlePay(pay);
	}
}
