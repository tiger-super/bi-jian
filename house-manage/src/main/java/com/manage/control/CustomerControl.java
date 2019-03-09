package com.manage.control;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.entity.Page;
import com.manage.service.CustomerManageService;

@Controller
@RequestMapping("/manage")
public class CustomerControl {
	@Autowired
	CustomerManageService customerManageService;
	@RequestMapping("/load/customer/information")
	@ResponseBody
    public Map<String,Object> getAllCustomerInformation(@RequestParam(required = false) Integer pageCurrent){
    	Page page = new Page();
		if(pageCurrent != null) {
		page.setPageCurrent(pageCurrent);
		}
		Map<String,Object> map = customerManageService.loadCustomerInformationService(page);
		map.put("page",page);
		return map;
    }
	@RequestMapping("/load/black/customer")
	@ResponseBody
    public Map<String,Object> getAllBlackCustomerInformation(@RequestParam(required = false) Integer pageCurrent){
    	Page page = new Page();
		if(pageCurrent != null) {
		page.setPageCurrent(pageCurrent);
		}
		Map<String,Object> map = customerManageService.loadBlackCustomerInformationService(page);
		map.put("page",page);
		return map;
    }
	@RequestMapping("/modify/black/state")
	@ResponseBody
	public Map<String,Object> blackCustomerControl(String condition,Integer pageCurrent,String customerId){
		Map<String,Object> map = customerManageService.blackManageService(pageCurrent,condition,customerId);
		return map;
	}
}
