package com.manage.control;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.house.entity.Page;

@Controller
@RequestMapping("/manage")
public class ShowViewControl {
	@RequestMapping("/show/loginView")
	public String showLoginView() {
		return "login";
	}
	@RequestMapping("/show/indexView")
	public String showIndexView() {
		return "index";
	}
	@RequestMapping("/show/auditing/houseManageView")
	public String showAuditingHouseManageView() {
		return "auditing-house";
	}
	
	@RequestMapping("/show/websiteReportView")
	public ModelAndView showWebSiteReportView() {
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("website-report");
		return mv;
	}
}
