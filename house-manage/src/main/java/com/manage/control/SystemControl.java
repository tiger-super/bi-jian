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
import com.manage.tool.ServerSocketTool;

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
	@RequestMapping("/get/house/number")
	@ResponseBody
	public Map<String,String> getPuhlishHouseNumber(){
		Map<String,String> map = new HashMap<String,String>();
		String value = String.valueOf(systemService.totalPublishHouse());
		map.put("result",value);
		return map;
	}

	@RequestMapping("/update/house/data")
	@ResponseBody
	public Map<String,Boolean> wheterUpdateHouseData(){
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		map.put("result",ServerSocketTool.publishHouse);
		ServerSocketTool.setPublishHouse(false);
		return map;
	}
	
	@RequestMapping("/session/load/website/data")
	@ResponseBody
	public Map<String,Integer> loadWebsiteData(){
		Map<String,Integer> map = systemService.webSiteDataService();
		return map;
	}
	
	@RequestMapping("/session/load/website/graph")
	@ResponseBody
	public Map<String,List<Integer>> loadWebsiteGraph(){
		Map<String,List<Integer>> map = systemService.weekWebsite();
		return map;
	}
	@RequestMapping("/session/chat")
	@ResponseBody
	public Map<String,String> chat( HttpSession session) {
		Map<String,String> map = new HashMap<String,String>();
		Employee employee = (Employee)session.getAttribute("employeeSession");
	    map.put("id",employee.getEmployeeId());
	    return map;
	}
}
