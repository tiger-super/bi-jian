package com.house.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.customer.PersonInfoService;
import com.house.entity.Customer;

@Controller
@RequestMapping("/house")
public class CustomerOperationController {
	@Reference
	PersonInfoService personInfoService;

	// 根据用户id获取用户信息
	@RequestMapping("/session/gain/info")
	@ResponseBody
	public Customer gainPersonInfo(HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		return personInfoService.queryCustomerInfo(customer);
	}

	// 修改用户密码
	@RequestMapping("/modify/customerPassword")
	public String modifyCustomerPassword(Customer customer) {
		return personInfoService.modifyCustomerPassword(customer);
	}
	
	// 根据账号查询是否存在该账号，返回账号带着这个账号的邮箱
	@RequestMapping("/exist/account/number")
	@ResponseBody
	public Customer ifExistAccountNumerReturnMail(Customer customer) {
		Customer result = personInfoService.ifExistAccountNumberReturnMail(customer);
		if(result != null) {
		return result;
		}else {
			return new Customer();
		}
	}
	
}
