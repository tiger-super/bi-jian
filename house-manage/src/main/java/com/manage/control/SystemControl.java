package com.manage.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.entity.Employee;
import com.house.entity.Page;
import com.manage.service.SystemService;
import com.manage.tool.PageShow;

@Controller
@RequestMapping("/manage")
public class SystemControl {
	@Autowired
	SystemService systemService;

	@RequestMapping("/get/show/page")
	@ResponseBody
	public List<String> getShowPage(Page page) {
		return PageShow.handlePage(page);
	}

	@RequestMapping("/login")
	@ResponseBody
	public Map<String, String> login(Employee employee, HttpSession httpSession) {
		Map<String, String> map = new HashMap<String, String>();
		String result = systemService.loginService(employee, httpSession);
		map.put("result", result);
		return map;
	}

	@RequestMapping("/quit")
	public String quitSystem(HttpSession session) {
		session.setAttribute("employeeSession", null);
		return "login";
	}
}
