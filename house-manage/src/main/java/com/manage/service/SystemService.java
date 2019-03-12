package com.manage.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import com.house.entity.Employee;
public interface SystemService {
	String loginService(Employee employee,HttpSession httpSession);
	void websiteService(); 
	public int totalPublishHouse();
	public Map<String,Integer> webSiteDataService();
	public Map<String,List<Integer>> weekWebsite();
}
