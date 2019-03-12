package com.manage.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	public void reptilian() {
		websiteManagementMapper.timingInsertData();
	}
}
