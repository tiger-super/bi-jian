package com.manage.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manage.service.impl.HouseManageServiceImpl;

@Controller
@RequestMapping("/manage")
public class ShowViewControl {
	@Autowired
	HouseManageServiceImpl houseManageService;
	@RequestMapping("/show/loginView")
	public String showLoginView() {
		return "login";
	}
	@RequestMapping("/session/show/indexView")
	public String showIndexView() {
		return "index";
	}
	@RequestMapping("/session/show/auditing/houseManageView")
	public String showAuditingHouseManageView() {
		return "auditing-house";
	}
	@RequestMapping("/session/show/publish/houseManageView")
	public String showPublishHouseManageView() {
		return "publish-house";
	}
	@RequestMapping("/session/show/websiteReportView")
	public ModelAndView showWebSiteReportView() {
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("website-report");
		return mv;
	}
	@RequestMapping("/session/show/house/information")
	public ModelAndView showHouseInformation(String houseId) {
		Map<String,Object> map = houseManageService.getHouseInformationFormHouseId(houseId);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("house-information");
	    mv.addObject("map", map);
		return mv;
	}
	@RequestMapping("/session/show/customer/manage")
	public String showCustomerManage() {
		return "customer";
	}
	@RequestMapping("/session/show/black/customer/manage")
	public String showBlackCustomerManage() {
		return "black-customer";
	}
	
	@RequestMapping("/session/show/add/employee")
	public String showAddEmployee() {
		return "add-employee";
	}
	
	@RequestMapping("/session/show/see/employee")
	public String showSeeEmployee() {
		return "see-employee";
	}
	@RequestMapping("/session/show/modify/employee")
	public String showModifyEmployee() {
		return "employee-information";
	}
	@RequestMapping("/show/chat")
	public String showChat() {
		return "chat";
	}
	@RequestMapping("/session/show/vip")
	public String showVip() {
		return "see-vip";
	}
}
