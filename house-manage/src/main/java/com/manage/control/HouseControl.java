package com.manage.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.entity.AuditingFail;
import com.house.entity.House;
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
		}
		Map<String,Object> map = houseManageService.getAuditingHouse(page);
		map.put("page", page);
		return map;
	}
	
	@RequestMapping("/get/publish/houseInformation")
	@ResponseBody
	public Map<String,Object> getPublishHouseManageView(@RequestParam(required = false) Integer pageCurrent) {
		Page page = new Page();
		if(pageCurrent != null) {
		page.setPageCurrent(pageCurrent);
		}
		Map<String,Object> map = houseManageService.getPublishHouse(page);
		return map;
	}
	
	@RequestMapping("/modify/auditing/state")
	@ResponseBody
	public Map<String,Boolean> modifyHouseAuditingState(String houseId){
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		boolean result = houseManageService.modifyHouseAuditingStateService(houseId);
        map.put("result",result);
		return map;
	}
	@RequestMapping("/auditin/fail")
	@ResponseBody
	public Map<String,Boolean> auditingFail(AuditingFail auditingFail){
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		boolean result = houseManageService.auditingFailService(auditingFail);
        map.put("result",result);
		return map;
	}
	
	@RequestMapping("/session/audit/house/with/id")
	@ResponseBody
	public Map<String,Object> getAuditingHouseWithId(House house){
		return houseManageService.getAuditingHouseFromId(house.getHouseId());
	}
	
	@RequestMapping("/session/public/house/with/id")
	@ResponseBody
	public Map<String,Object> getPublicHouseWithId(House house){
		return houseManageService.getPublicHouseFromId(house.getHouseId());
	}
	
}
