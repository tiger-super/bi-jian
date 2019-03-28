package com.manage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manage.dao.HouseManageDao;
import com.manage.dao.WebsiteManagementMapper;

/**
 * 
 * 创建业务逻辑类
 *
 */
@Service
public class DailyInsertNewData {

	@Autowired
	WebsiteManagementMapper websiteManagementMapper;
	@Autowired
	HouseManageDao houseManageDao;

	public void reptilian() {
		websiteManagementMapper.timingInsertData();
	}
}
