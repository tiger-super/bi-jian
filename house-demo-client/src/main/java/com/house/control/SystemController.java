package com.house.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/house")
public class SystemController {

	/**
	 * 该方法用于用户退出系统
	 * @param session 这个对象用来获取用户信息
	 * @return
	 * 返回到首页
	 */
	@RequestMapping("/quit")
   public String quitSystem(HttpSession session) {
		session.setAttribute("customerSession", null);
	   return "index";
   }
	@RequestMapping("/get/cookie")
	@ResponseBody
	   public Map<String,String> getCookie(HttpServletRequest request) {
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
		Map<String,String> map = new HashMap<String,String>();
		map.put("province",province);
		map.put("city",city);
		return map;
	   }
	
}
