package com.manage.control;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.house.entity.Page;
import com.manage.service.impl.HouseManageServiceImpl;

@Controller
@RequestMapping("/manage")
public class HouseControl {
	@Autowired
	HouseManageServiceImpl houseManageService;
	@RequestMapping("/get/auditing/houseInformation")
	@ResponseBody
	public Map<String,Object> getAuditingHouseManageView(@RequestParam(required = false) Integer pageCurrent) {
		Page page = new Page();
		if(pageCurrent != null) {
		page.setPageCurrent(pageCurrent);
		page.setPageShowNow((page.getPageCurrent()-1)*page.getPageNumber());
		}
		Map<String,Object> map = houseManageService.getAuditingHouse(page);
		map.put("page", page);
		return map;
	}
}
