package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;
import com.house.entity.Customer;
import com.house.mapper.PersonInfoManagementMapper;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestPersonInfoManagementMapper {
	@Autowired
	PersonInfoManagementMapper personInfoManagementMapper;
	@Test
	public void test() {
	Customer customer = new Customer();
	customer.setCustomerId("6");
	customer.setCustomerHeadImageAddress("sdfhkjsdhf.jpg");
	personInfoManagementMapper.updatePhotoAddressFromId(customer);
	}
}
