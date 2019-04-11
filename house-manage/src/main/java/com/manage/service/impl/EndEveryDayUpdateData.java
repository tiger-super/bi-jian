package com.manage.service.impl;
/**
 * 
 * 创建业务逻辑类
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.entity.WebsiteCount;
import com.manage.dao.HouseManageDao;
import com.manage.dao.VipManageDao;
import com.manage.dao.WebsiteManagementMapper;
import com.manage.tool.Time;

@Service
public class EndEveryDayUpdateData {
	@Autowired
	WebsiteManagementMapper websiteManagementMapper;
	@Autowired
	HouseManageDao houseManageDao;
	@Autowired
	VipManageDao vipManageDao;
	public void end() {
	
		int housePublishNumberToday =  houseManageDao.selectTotalHasBeenPublishHouse();
		int houseLowerShelfNumberToday = houseManageDao.selectTotalNoToBeAuditingHouse();
		WebsiteCount wc = new WebsiteCount();
		wc.setTime(Time.getNowTimeforYearAndMonthAndDay());
		wc.setHouseLowerShelfNumberToday(houseLowerShelfNumberToday);
		wc.setHousePublishNumberToday(housePublishNumberToday);
		List<String> list = vipManageDao.accountPayMoneyAndNowDay(Time.getNowOtherTime());
		int sum = 0;
		for(int i = 0 ; i < list.size(); i++) {
			 sum += Integer.valueOf(list.get(i));
		}
		wc.setTodayPayNumber(sum);
		websiteManagementMapper.updateWebsiteData(wc);
	}
}
