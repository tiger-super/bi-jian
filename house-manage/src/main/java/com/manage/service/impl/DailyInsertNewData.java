package com.manage.service.impl;

import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.entity.House;
import com.manage.dao.CustomerManageDao;
import com.manage.dao.HouseManageDao;
import com.manage.dao.WebsiteManagementMapper;
import com.manage.tool.MailVerificationCode;

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
	@Autowired
	CustomerManageDao customerManageDao;

	public void newData() {
		websiteManagementMapper.timingInsertData();
		List<House> list = houseManageDao.selectHouseWhereDaysOffIsNotZero();
		List<String> id = new ArrayList<String>();
		Set<String> publisherId = new TreeSet<String>();
		List<String> mailBox = null;
		for (int i = 0; i < list.size(); i++) {
			House house = list.get(i);
			System.out.println(house);
			id.add(house.getHouseId());
			if (house.getDaysOff() == 1) {
				publisherId.add(house.getHousePublisherId());
				house.setHousePublisherState("0");
				houseManageDao.updateHousePublisherStateFormHouseId(house);
			}
		}
		// 日期减去一天
		if (id.size() > 0) {
			houseManageDao.updateHouseDaysOffFromList(id);
		}

		if (publisherId.size() > 0) {
	    mailBox = customerManageDao.selectCustomerMailBoxFromId(publisherId);
		}
		for(int i = 0 ;i < mailBox.size();i++) {
			try {
				MailVerificationCode.send(mailBox.get(i),"你在住哪儿发布的房源上架已过一月，现系统自动下架房源，如果房源未成功出售,则请登录住哪儿网站重新发布");
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
