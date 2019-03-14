package com.manage.control;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.house.entity.Employee;
import com.house.entity.Page;
import com.manage.dao.EmployeeManageDao;
import com.manage.service.EmployeeManageService;
import com.manage.tool.FileUtil;

@Controller
@RequestMapping("/manage")
public class EmployeeControl {
	@Autowired
	FileUtil fileUtil;
	@Autowired
	EmployeeManageService employeeManageService;

	@RequestMapping("/session/photo/upload")
	@ResponseBody
	public Map<String, String> manageUpload(@RequestParam("photoFile") MultipartFile employeeImg,
			HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		String result = employeeManageService.cacheEmployeeImg(employeeImg);
		Cookie cookieAddress = new Cookie("employeeImg", result);
		cookieAddress.setPath("/");
		response.addCookie(cookieAddress);
		map.put("imgAddress",fileUtil.visitImg(result));
		return map;
	}

	@RequestMapping("/session/add/employee")
	@ResponseBody
	public Map<String, String> addEmployee(Employee employee,HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Cookie[] cookies = request.getCookies();
		String employeeImg = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				switch (cookie.getName()) {
				case "employeeImg":
					employeeImg = cookie.getValue();
					break;
				}
			}
		}
		employee.setEmployeeImgAddress(employeeImg);
	    employeeManageService.addEmployeeService(employee);
		map.put("employeeId",employee.getEmployeeId());
	    return map;
	}
	@RequestMapping("/session/get/employee/information")
	@ResponseBody
	public Map<String,Object> getEmployees(@RequestParam(required = false) Integer pageCurrent){
		Page page = new Page();
		if(pageCurrent != null) {
		page.setPageCurrent(pageCurrent);
		}
		Map<String,Object> map = employeeManageService.getEmployee(page);
		return map;
	}
	@RequestMapping("/session/modify/password")
	@ResponseBody
	public Map<String,Boolean> modifyPassword(Employee employee){
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		boolean result = employeeManageService.modifyPasswordService(employee);
		map.put("result",result);
		return map;
	}
}
