package com.manage.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.house.entity.WebsiteCount;
@Repository
public interface WebsiteManagementMapper {
	public int timingInsertData();
	public int updateWebsiteData(WebsiteCount websiteCount);
	public String selectVisitFromDay(String day);
	public String  selectPublishNumberFromDay(String day);
	public List<Integer> selectNowWeekVisitWebsite(List<String> list);
	public List<Integer> selectNowWeekPublishHouse(List<String> list);
	}
