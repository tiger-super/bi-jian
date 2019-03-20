package com.manage.service;

import java.util.Map;
import com.house.entity.AuditingFail;
import com.house.entity.Page;

public interface HouseManageService {
	Map<String, Object> getAuditingHouse(Page page);
	Map<String, Object> getPublishHouse(Page page);
	// 根据房源id获取房源信息
	Map<String, Object> getHouseInformationFormHouseId(String houseId);

	// 修改对应房源id的房源审核状态
	boolean modifyHouseAuditingStateService(String houseId);

	// 审核失败
	boolean auditingFailService(AuditingFail auditingFail);
	
	//根据房源id获得未审核的房源
	public Map<String,Object> getAuditingHouseFromId(String houseId);
	//根据房源id获得发布的房源
	public Map<String,Object> getPublicHouseFromId(String houseId);
}
