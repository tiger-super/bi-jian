package com.house.control;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.customer.PersonInfoService;
import com.house.demo.customer.RegisterAndLoginService;
import com.house.entity.Customer;

@Controller
@RequestMapping("/house")
@SessionAttributes(value= {"customerSession"},types={Customer.class})
public class RegisterAndLoginController {
	@Reference
	RegisterAndLoginService registerAndService;
	@Reference
	PersonInfoService personInfoService;


	// 处理注册
	@RequestMapping("/handle/register")
	@ResponseBody
	public String handleRegiseter(Customer customer) {
		return registerAndService.registerService(customer);
	}

	// 处理登录
	@RequestMapping("/handle/login")
	@ResponseBody
	public String handleLogin(Customer customer,Map<String,Customer> map) {
		String result =  registerAndService.loginSystemService(customer);
		 if("true".equals(result)) {
		 map.put("customerSession",personInfoService.queryCustomerIdAndCustomerName(customer));
		 }
		return result;
	}
	
}
