package com.house.demo.provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.customer.RegisterAndLoginService;
import com.house.entity.Customer;
import com.house.mapper.CustomerManagementMapper;

@Service
public class RegisterAndLoginServiceImpl implements RegisterAndLoginService{
    @Autowired
	CustomerManagementMapper cmm ;
	
	@Override
	public String loginSystemService(Customer customer) {
	    Customer ifCustomer = cmm.loginSystem(customer.getCustomerPhone());
	    if(ifCustomer == null) {
	    	return "不存在该用户";
	    }else {
	    	if(customer.getCustomerPassword().equals(ifCustomer.getCustomerPassword())) {
	    		return "true";
	    	}else {
	    		return "密码错误";
	    	}
	    }
	}

	@Override
	public String registerService(Customer customer) {
		int result = cmm.registerCustomer(customer);
		if(result != 0) {
			return "true";
		}else{
			return "false";
		}
	}
    
}
