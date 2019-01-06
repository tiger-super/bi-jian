package com.house.demo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.customer.PersonInfoService;
import com.house.entity.Customer;
@Service
public class PersonInfoServiceImpl implements PersonInfoService{

	@Override
	public String modifyCustomerAge(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyCustomerMailbox(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyCustomerName(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyCustomerPassword(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String modifyCustomerSex(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

}
