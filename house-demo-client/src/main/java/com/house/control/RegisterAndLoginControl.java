package com.house.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.customer.RegisterAndLoginService;
import com.house.entity.Customer;

@Controller
@RequestMapping("/house")
public class RegisterAndLoginControl {
	@Reference
	RegisterAndLoginService registerAndService;

	// 显示注册界面
	@RequestMapping("/show/registerView")
	public String showRegister() {
		return "register";
	}

	// 显示登录界面
	@RequestMapping("/show/loginView")
	public String showLogin() {
		return "login";
	}

	// 处理注册
	@RequestMapping("/handle/register")
	@ResponseBody
	public String handleRegiseter(Customer customer) {
		return registerAndService.registerService(customer);
	}

	// 处理登录
	@RequestMapping("/handle/login")
	@ResponseBody
	public String handleLogin(Customer customer) {
		return registerAndService.loginSystemService(customer);
	}

	// 登录成功
	@RequestMapping("/login/success/jump")
	public String loginSuccessJump(Customer customer) {
		return "index";
	}

	// 注册成功
	@RequestMapping("/register/success/jump")
	public String registerSuccessJump(Customer customer) {
		return "registerSuccess";
	}
	
}
