package com.house.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/house")
public class SystemController {
	@RequestMapping("/quit")
   public String quitSystem(HttpSession session) {
		session.setAttribute("customerSession", null);
	   return "index";
   }
}
