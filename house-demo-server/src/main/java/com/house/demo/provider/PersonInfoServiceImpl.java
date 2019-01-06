package com.house.demo.provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.customer.PersonInfoService;
import com.house.entity.Customer;
import com.house.mapper.PersonInfoManagementMapper;
@Service
public class PersonInfoServiceImpl implements PersonInfoService{
	@Autowired
    PersonInfoManagementMapper personInfoManagementMapper;
	@Override
	public String modifyCustomerAge(Customer customer) {
		int result =  personInfoManagementMapper.updateAge(customer);
		if( result == 1) {
			return "true";
		}else {
			return "false";
		}
	}

	@Override
	public String modifyCustomerMailbox(Customer customer) {
		int result =  personInfoManagementMapper.updateMailbox(customer);
		if( result == 1) {
			return "true";
		}else {
			return "false";
		}
	}

	@Override
	public String modifyCustomerName(Customer customer) {
		int result =  personInfoManagementMapper.updateName(customer);
		if( result == 1) {
			return "true";
		}else {
			return "false";
		}
	}

	@Override
	public String modifyCustomerPassword(Customer customer) {
		int result =  personInfoManagementMapper.updatePassword(customer);
		if( result == 1) {
			return "true";
		}else {
			return "false";
		}
	}

	@Override
	public String modifyCustomerSex(Customer customer) {
		int result =  personInfoManagementMapper.updateSex(customer);
		if( result == 1) {
			return "true";
		}else {
			return "false";
		}
	}

	@Override
	public Customer queryCustomerIdAndCustomerName(Customer customer){
		return personInfoManagementMapper.selectCustomerIdAndCustomerName(customer);
	}

}
