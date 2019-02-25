package com.manage.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ShowViewControl {
	@RequestMapping("/show/loginView")
	public String showLoginView() {
		return "login";
	}
	@RequestMapping("/show/indexView")
	public ModelAndView showIndexView() {
		ModelAndView mv = new ModelAndView();
		
		return mv;
	}
}
