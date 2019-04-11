package com.house.control;

import java.util.HashMap;
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
	private RegisterAndLoginService registerAndLoginService;
	@Reference
	private PersonInfoService personInfoService;


	// 处理注册
	@RequestMapping("/handle/register")
	@ResponseBody
	public Map<String,String> handleRegiseter(Customer customer) {
		return registerAndLoginService.registerService(customer);
	}

	// 处理登录
	@RequestMapping("/handle/login")
	@ResponseBody
	public Map<String,String> handleLogin(Customer customer,Map<String,Customer> map) {
		Map<String,String> result = new HashMap<String,String>();
		String value =  registerAndLoginService.loginSystemService(customer);
		 if("true".equals(value)) {
		 map.put("customerSession",personInfoService.queryCustomerIdAndCustomerName(customer));
		 }
		 result.put("result",value);
		return result;
	}
	
}
