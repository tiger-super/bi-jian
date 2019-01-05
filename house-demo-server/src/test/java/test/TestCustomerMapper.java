package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;
import com.house.entity.Customer;
import com.house.mapper.CustomerManagementMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestCustomerMapper {
     @Autowired
     CustomerManagementMapper cmm ;
     // 测试注册
     @Test
     public void testRegister() {
    	 Customer customer = new Customer();
    	 customer.setCustomerPhone("17875511746");
    	 customer.setCustomerName("钟泰文");
    	 customer.setCustomerPassword("12345");
    	 cmm.registerCustomer(customer);
     }
     @Test
     public void testLogin() {
    	 Customer customer = cmm.loginSystem("17875511746");
    	 System.out.println(customer);
    	 customer = cmm.loginSystem("111");
    	 System.out.println(customer);
     }
}
