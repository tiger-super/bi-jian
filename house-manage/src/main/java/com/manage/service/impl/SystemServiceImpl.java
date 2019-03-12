package com.manage.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.house.entity.Employee;
import com.manage.dao.EmployeeManageDao;
import com.manage.dao.HouseManageDao;
import com.manage.dao.WebsiteManagementMapper;
import com.manage.service.SystemService;
import com.manage.tool.ImageTool;
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

}
