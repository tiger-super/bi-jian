package com.manage.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.house.entity.Employee;
import com.house.entity.Page;

public interface EmployeeManageService {
	// 员工上传照片缓存
	public String cacheEmployeeImg(MultipartFile multipartFile);

	// 添加员工
	String addEmployeeService(Employee employee);
	
	//获取所有员工
	Map<String,Object> getEmployee(Page page);
	
	//修改密码
	boolean modifyPasswordService(Employee employee);
	
	Map<String,Object> getEmployeeWithEmployeeId(String employeeId);
}
