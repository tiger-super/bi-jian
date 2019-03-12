package com.house.mapper;

import org.springframework.stereotype.Repository;

import com.house.entity.WebsiteCount;
@Repository
public interface WebsiteManagementMapper {
	public int updateWebsiteWithVisitNumber(WebsiteCount wc);
	public int selectVisitNumberToday(String time);
}
