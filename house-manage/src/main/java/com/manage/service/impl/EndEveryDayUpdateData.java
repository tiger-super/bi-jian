package com.manage.service.impl;
/**
 * 
 * 创建业务逻辑类
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.entity.WebsiteCount;
import com.manage.dao.HouseManageDao;
import com.manage.dao.WebsiteManagementMapper;
import com.manage.tool.Time;

@Service
public class EndEveryDayUpdateData {
	@Autowired
	WebsiteManagementMapper websiteManagementMapper;
	@Autowired
	HouseManageDao houseManageDao;
	
	public void end() {
	
		int housePublishNumberToday =  houseManageDao.selectTotalHasBeenPublishHouse();
		int houseLowerShelfNumberToday = houseManageDao.selectTotalNoToBeAuditingHouse();
		WebsiteCount wc = new WebsiteCount();
		wc.setTime(Time.getNowTimeforYearAndMonthAndDay());
		wc.setHouseLowerShelfNumberToday(houseLowerShelfNumberToday);
		wc.setHousePublishNumberToday(housePublishNumberToday);
		websiteManagementMapper.timingInsertData();
	}
}
