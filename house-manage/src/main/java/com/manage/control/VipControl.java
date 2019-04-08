package com.manage.control;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.entity.Customer;
import com.house.entity.Page;
import com.manage.service.VipManageService;
import com.manage.tool.MailVerificationCode;


@Controller
@RequestMapping("/manage")
public class VipControl {
	@Autowired
	VipManageService vipManageService;
	@RequestMapping("/session/get/vip/information")
	@ResponseBody
	public Map<String,Object>  getAllVipInformation(@RequestParam(required = false) Integer pageCurrent) {
		Page page = new Page();
		if(pageCurrent != null) {
		page.setPageCurrent(pageCurrent);
		}
		Map<String,Object> map = vipManageService.vipInformation(page);
		return map;
	}
	
	@RequestMapping("/session/remind/renew")
	@ResponseBody
	public Map<String,Boolean> remindRenew(String day,String mailbox){
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		String text = "你的住哪儿账户的vip还有"+(	 Integer.valueOf(day)+1)+"天到期,为了方便你今后在本系统的操作，请注意续费";
		boolean result;
		try {
			result = MailVerificationCode.send(mailbox,text);
		} catch (GeneralSecurityException e) {
			result = false;
		}
		map.put("result",result);
		return map;
	}
	@RequestMapping("/session/get/id/from/vip")
	@ResponseBody
	public Customer getVipCustomerFromId(Customer customer){
		return vipManageService.selectVipFromId(customer);
	}
	@RequestMapping("/session/show/pay/manage")
	public String getShowPayManage() {
		return "vip-pay-manage";
	}
	@RequestMapping("/session/get/vip/order/information")
	@ResponseBody
	public Map<String,Object> getVipOrderInformation(@RequestParam(required = false) Integer pageCurrent){
		Page page = new Page();
		if(pageCurrent != null) {
		page.setPageCurrent(pageCurrent);
		}
		Map<String,Object> map = vipManageService.vipOrderServer(page);
		return map;
	}
}
