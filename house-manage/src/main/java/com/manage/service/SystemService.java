package com.manage.service;

import javax.servlet.http.HttpSession;

import com.house.entity.Employee;

public interface SystemService {
	String loginService(Employee employee,HttpSession httpSession);
}
