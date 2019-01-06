package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.CoumterApplication;
import com.house.demo.customer.PersonInfoService;
import com.house.entity.Customer;
import com.house.mapper.HouseManagementMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= CoumterApplication.class)
public class TestPersonInfo {
	@Reference
	PersonInfoService personInfoService;
	
	@Test
	public void testQueryNameAndId() {
		Customer customer = new Customer();
    	customer.setCustomerPhone("17875511746");
    	System.out.println(personInfoService);
		System.out.println(personInfoService.queryCustomerIdAndCustomerName(customer));
		
	}

}
