package com.house.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.system.SystemService;
import com.house.entity.Customer;

@Controller
@RequestMapping("/house")
public class SystemController {
	@Reference
	SystemService systemService;

	/**
	 * 该方法用于用户退出系统
	 * 
	 * @param session 这个对象用来获取用户信息
	 * @return 返回到首页
	 */
	@RequestMapping("/quit")
	public String quitSystem(HttpSession session) {
		session.setAttribute("customerSession", null);
		return "index";
	}

	@RequestMapping("/get/cookie")
	@ResponseBody
	public Map<String, String> getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		String province = null;
		String city = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				switch (cookie.getName()) {
				case "province":
					province = cookie.getValue();
					break;
				case "city":
					city = cookie.getValue();
					break;
				}

			}
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("province", province);
		map.put("city", city);
		return map;
	}

	/**
	 * 该方法用于发布房源界面关闭时候触发的control
	 * 
	 * @param request  用于获取cookie
	 * @param response 用于保存cookie
	 */
	@RequestMapping("/delete/session")
	@ResponseBody
	public Map<String,Boolean> deleteSession(HttpServletResponse response, HttpServletRequest request) {
		Map<String,Boolean> map = new HashMap<String,Boolean>();
		Cookie[] cookies = request.getCookies();
		String folder = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				switch (cookie.getName()) {
				case "folder":
					folder = cookie.getValue();
					cookie.setValue(null);
                     cookie.setMaxAge(0);// 立即销毁cookie  
                     cookie.setPath("/"); 
                     response.addCookie(cookie); 
					break;
				}
			}
			if (folder != null) {
				systemService.deleteCache(folder);
			    map.put("result",true);
			}
		}
		return map;

	}
	@RequestMapping("/session/chat")
	@ResponseBody
	public Map<String,String> chat( HttpSession session) {
		Map<String,String> map = new HashMap<String,String>();
		Customer customer = (Customer) session.getAttribute("customerSession");
	    map.put("id",customer.getCustomerId());
	    return map;
	}
}
