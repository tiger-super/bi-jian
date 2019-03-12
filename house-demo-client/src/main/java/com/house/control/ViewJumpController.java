package com.house.control;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.area.AnalysisAreaXmlService;
import com.house.demo.house.HouseService;
import com.house.demo.website.WebsiteService;
import com.house.entity.Customer;
import com.house.entity.House;
import com.house.entity.WebsiteCount;

@Controller
@RequestMapping("/house")
public class ViewJumpController {
	@Reference
	WebsiteService websiteCount;
	@Reference
	HouseService houseService;
	@Reference(timeout = 20000)
	AnalysisAreaXmlService analysisAreaXmlService;

	// 显示注册界面
	@RequestMapping("/show/registerView")
	public String showRegister() {
		return "register";
	}

	// 显示登录界面
	@RequestMapping("/show/loginView")
	public String showLogin() {
		return "login";
	}

	// 显示注册成功
	@RequestMapping("/show/successView")
	public String registerSuccessJump() {
		return "registerSuccess";
	}

	// 显示主界面
	@RequestMapping("/show/indexView")
	public String showIndex() {
		websiteCount.website();
		return "index";
	}

	// 显示个人中心
	@RequestMapping("/session/show/personView")
	public String showPerson(HttpSession session) {
		return "person";
	}

	// 显示找回密码
	@RequestMapping("/show/retrievePasswordView")
	public String showRetrievePassword() {
		return "retrievePassword";
	}

	// 显示选择区域界面
	@RequestMapping("/show/selectAreaView")
	public String showSelectArea() {
		return "selectArea";
	}

	// 显示发布界面
	@RequestMapping("/session/show/publish/house")
	public String showPublishHouseView() {
		System.out.println("control"+Thread.currentThread().getName());
		return "publish-house";
	}

	// 显示发布成功界面
	@RequestMapping("/show/publish/success")
	public String showPublishSuccessView() {
		return "publishSuccess";
	}

	// 显示房源界面
	@RequestMapping("/show/house/list")
	public ModelAndView showHouseListView(HttpServletRequest request, String houseSellWay) {
		ModelAndView mv = new ModelAndView();
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
		} else {
			mv.setViewName("selectArea");
			return mv;
		}
		List<String> areaList = analysisAreaXmlService.analysisAreaXmlGainArea(province, city);
		mv.setViewName("house-list");
		mv.addObject("areaList", areaList);
		mv.addObject("houseSellWay", houseSellWay);
		return mv;
	}

	// 显示房源详细信息界面
	@RequestMapping("/show/house/info")
	public ModelAndView showHouseDetailedInformationView(String houseId) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("house-detailed-information");
		House house = houseService.getHouseInformation(houseId);
		mv.addObject("house", house);
		return mv;
	}
}
