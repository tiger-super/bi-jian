package com.house.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.house.entity.Customer;

@Controller
@RequestMapping("/house")
public class ViewJumpController {
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

	// 显示注册成功
	@RequestMapping("/show/successView")
	public String registerSuccessJump() {
		return "registerSuccess";
	}

	// 显示主界面
	@RequestMapping("/show/indexView")
	public String showIndex() {
		return "index";
	}

	// 显示个人中心
	@RequestMapping("/session/show/personView")
	public String showPerson(HttpSession session) {
		return "person";
	}
	
	// 显示找回密码
	@RequestMapping("/show/retrievePasswordView")
	public String showRetrievePassword(){
		return "retrievePassword";
	}

}
