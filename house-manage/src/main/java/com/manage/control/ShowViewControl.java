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
	@RequestMapping("/show/auditing/houseManageView")
	public String showAuditingHouseManageView() {
		return "auditing-house";
	}
	@RequestMapping("/show/publish/houseManageView")
	public String showPublishHouseManageView() {
		return "publish-house";
	}
	@RequestMapping("/show/websiteReportView")
	public ModelAndView showWebSiteReportView() {
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("website-report");
		return mv;
	}
	@RequestMapping("/show/house/information")
	public ModelAndView showHouseInformation(String houseId) {
		Map<String,Object> map = houseManageService.getHouseInformationFormHouseId(houseId);
		ModelAndView mv = new ModelAndView();
	    mv.setViewName("house-information");
	    mv.addObject("map", map);
		return mv;
	}
	@RequestMapping("/show/customer/manage")
	public String showCustomerManage() {
		return "customer";
	}
	@RequestMapping("/show/black/customer/manage")
	public String showBlackCustomerManage() {
		return "black-customer";
	}
}
