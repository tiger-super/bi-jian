package com.house.demo.provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.website.WebsiteService;
import com.house.entity.WebsiteCount;
import com.house.mapper.WebsiteManagementMapper;
import com.house.tool.Time;
@Service
public class WebsiteServiceImpl implements WebsiteService{
    @Autowired
    WebsiteManagementMapper websiteManagementMapper;
	@Override
	public int website() {
		int number = websiteManagementMapper.selectVisitNumberToday(Time.getNowTimeforYearAndMonthAndDay());
		WebsiteCount wc = new WebsiteCount();
		wc.setTime(Time.getNowTimeforYearAndMonthAndDay());
		wc.setVisitNumberToday(number+1);
		websiteManagementMapper.updateWebsiteWithVisitNumber(wc);
		return 0;
	}

}
