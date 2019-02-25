package com.manage.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/house")
public class HelloWoldControl {
	@RequestMapping("/show")
	public String showHelloWorld() {
		return "index";
	}
}
