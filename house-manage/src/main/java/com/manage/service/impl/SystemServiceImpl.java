package com.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.house.entity.Employee;
import com.manage.dao.CustomerManageDao;
import com.manage.dao.EmployeeManageDao;
import com.manage.dao.HouseManageDao;
import com.manage.dao.WebsiteManagementMapper;
import com.manage.service.SystemService;
import com.manage.tool.ImageTool;
import com.manage.tool.Time;
@Service
public class SystemServiceImpl implements SystemService {
	@Autowired
    EmployeeManageDao employeeManageDao;
	@Autowired
	HouseManageDao houseManageDao;
	@Autowired
	WebsiteManagementMapper websiteManagementMapper;
	@Autowired
	ImageTool it;
	@Autowired
	CustomerManageDao customerManageDao;
	@Override
	public String loginService(Employee employee,HttpSession httpSession) {
		Employee result = employeeManageDao.ifExistEmployee(employee);
	    if(result == null) {
	    	return "账号不存在";
	    }else if(result.getEmployeePassword().equals(employee.getEmployeePassword())) {
	    	result.setEmployeeImgAddress(it.getEmployeeImg(result.getEmployeeImgAddress()));
	    	httpSession.setAttribute("employeeSession", result);
	    	return "true";
	    }else {
	    	return "密码不正确";
	    }
	}
	
	// 网站服务
	@Override
	public void websiteService() {
		websiteManagementMapper.timingInsertData();
	}

	@Override
	public int totalPublishHouse() {
		int result = houseManageDao.selectTotalHasBeenPublishHouse();
		return result;
	}

	@Override
	public Map<String, Integer> webSiteDataService() {
		int publishHouseNumber = houseManageDao.selectTotalHasBeenPublishHouse();
		int noPublishHouseNumber = houseManageDao.selectTotalNoToBeAuditingHouse();
		int customerNumber = customerManageDao.totalAllCustomer();
		String visit = websiteManagementMapper.selectVisitFromDay(Time.getNowTimeforYearAndMonthAndDay());
		Map<String, Integer> map = new HashMap<String,Integer>();
		map.put("publishHouseNumber", publishHouseNumber);
		map.put("noPublishHouseNumber", noPublishHouseNumber);
		map.put("customerNumber",customerNumber);
		map.put("visit", Integer.valueOf(visit));
		return map;
	}

	@Override
	public Map<String,List<Integer>> weekWebsite() {
		Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
		String nowDay = Time.getNowTimeforYearAndMonthAndDay();
		try {
			int nowWeek = Time.dayForWeek(nowDay);
			List<String> list = Time.getWeek(nowWeek, nowDay);
			List<Integer> publish = websiteManagementMapper.selectNowWeekPublishHouse(list);
			List<Integer> visit = websiteManagementMapper.selectNowWeekVisitWebsite(list);
			map.put("publish",publish);
			map.put("visit",visit);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

}
