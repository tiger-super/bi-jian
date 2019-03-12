package com.manage.dao;

import org.springframework.stereotype.Repository;

import com.house.entity.WebsiteCount;
@Repository
public interface WebsiteManagementMapper {
	public int timingInsertData();
	public int updateWebsiteData(WebsiteCount websiteCount);
}
