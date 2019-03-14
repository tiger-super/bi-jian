package com.manage.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.entity.WebsiteCount;
import com.manage.dao.HouseManageDao;
import com.manage.dao.WebsiteManagementMapper;
import com.manage.tool.Time;

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
