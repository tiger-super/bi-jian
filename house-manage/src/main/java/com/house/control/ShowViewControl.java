package com.house.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/house")
public class ShowViewControl {
	@RequestMapping("/show/loginView")
	public String showLoginView() {
		return "login";
	}
}
