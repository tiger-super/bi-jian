package com.house.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.customer.PersonInfoService;
import com.house.entity.Customer;

@Controller
@RequestMapping("/house")
public class ModifyPersonInfoController {
	@Reference
	PersonInfoService personInfoService;
	// 修改用户名
	@RequestMapping("/modify/customerName")
	public String modifyCustomerName(Customer customer) {
		return personInfoService.modifyCustomerName(customer);
	}

	// 修改用户年龄
	@RequestMapping("/modify/customerAge")
	public String modifyCustomerAge(Customer customer) {
		return  personInfoService.modifyCustomerAge(customer);
	}

	// 修改用户性别
	@RequestMapping("/modify/customerSex")
	public String modifyCustomerSex(Customer customer) {
		return  personInfoService.modifyCustomerSex(customer);
	}

	// 修改用户邮箱
	@RequestMapping("/modify/customerMailbox")
	public String modifyCustomerMailbox(Customer customer) {
		return  personInfoService.modifyCustomerMailbox(customer);
	}

	// 修改用户密码
	@RequestMapping("/modify/customerPassword")
	public String modifyCustomerPassword(Customer customer) {
		return  personInfoService.modifyCustomerPassword(customer);
	}

}
