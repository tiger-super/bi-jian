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
public class TestPersonInfo {
	@Autowired
	private PersonInfoManagementMapper personInfoManagementMapper;
    // 修改性别
	@Test
    public void testSex() {
    	Customer customer = new Customer();
    	customer.setCustomerSex("女");
    	customer.setCustomerId("3");
    	personInfoManagementMapper.updateSex(customer);
    }
	 // 修改姓名
	@Test
    public void testName() {
    	Customer customer = new Customer();
    	customer.setCustomerName("娜美");
    	customer.setCustomerId("3");
    	personInfoManagementMapper.updateName(customer);
    }
    
	// 查询用户名字和id
	@Test
	public void testQueryNameAndId() {
		Customer customer = new Customer();
    	customer.setCustomerPhone("17875511746");
		System.out.println(personInfoManagementMapper.selectCustomerIdAndCustomerName(customer));
		
	}
	// 测试根据id查询用户所有信息的方法
	@Test
	public void testSelectCustomerAllInfoFromId() {
		Customer customer = new Customer();
    	customer.setCustomerId("1");
    	System.out.println(personInfoManagementMapper.selectCustomerAllInfoFromId(customer));
	}
    @	Test
    public void testSelectPhotoAddressFromId() {
    	System.out.println(personInfoManagementMapper.selectPhotoAddressFromId("1"));
    }
}
