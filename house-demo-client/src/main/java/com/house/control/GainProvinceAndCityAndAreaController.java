package com.house.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.area.AnalysisAreaXmlService;

@Controller
@RequestMapping("/house")
public class GainProvinceAndCityAndAreaController {
	@Reference(timeout = 20000)
	AnalysisAreaXmlService analysisAreaXmlService;

	@RequestMapping("/gain/province/and/city")
	@ResponseBody
	public Map<String, List<String>> gainProvinceAndCity() {
		return analysisAreaXmlService.analysisAreaXml();
	}

	/**
	 * @return
	 */
	@RequestMapping("/gain/pinyin/province")
	@ResponseBody
	public Map<String, List<String>> gainProvincePinyin() {
		return analysisAreaXmlService.sortPinyin();
	}

	/**
	 * 该方法用于获得全国的所有省
	 * 
	 * @return 返回一个集合，内容为全国所有的省
	 */
	@RequestMapping("/gain/province")
	@ResponseBody
	public List<String> gainProvince() {
		return analysisAreaXmlService.analysisAreaXmlGainProvince();
	}

	/**
	 * 该方法根据对应的省获得对应的市
	 * 
	 * @param province 对应的省
	 * @return 返回一个集合，内容为对应的省内所有市
	 */
	@RequestMapping("/gain/city")
	@ResponseBody
	public List<String> gainCity(String province) {
		return analysisAreaXmlService.analysisAreaXmlGainCity(province);
	}

	/**
	 * 该方法根据省和市来获取对应的所有地区
	 * 
	 * @param province 对应的省
	 * @param city     对应的市
	 * @return 一个集合，集合的内容为对应的所有区
	 */
	@RequestMapping("/gain/area")
	@ResponseBody
	public List<String> gainArea(String province, String city) {
		return analysisAreaXmlService.analysisAreaXmlGainArea(province, city);
	}

	/**
	 * 该方法用于selectArea.jsp页面的城市选择 当选择完毕通过ajax访问到这个control
	 * 
	 * @param response 用于保存地址
	 * @param province 地址的省
	 * @param city     地址的市
	 * @return 返回true，用于后续界面跳转
	 */
	@RequestMapping("/keep/place")
	@ResponseBody
	public String ajaxKeepPlace(HttpServletResponse response, String province, String city) {
		Cookie cookieForProvince = new Cookie("province", province);
		cookieForProvince.setPath("/");
		cookieForProvince.setMaxAge(60*60*24*30);
		Cookie cookieForCity = new Cookie("city", city);
		cookieForCity.setPath("/");
		cookieForCity.setMaxAge(60*60*24*30);
		response.addCookie(cookieForCity);
		response.addCookie(cookieForProvince);
		return "true";
	}

	/**
	 * 该方法用于点击selectArea.jsp页面的a标签对应的地址 点击通过ajax访问这个control
	 * 
	 * @param response  用于保存地址
	 * @param province 地点的对应的省
	 * @param city     地点对应的市
	 * @return 返回index,直接调转到index界面
	 */
	@RequestMapping("/keepPlace/and/jumpIndex")
	public String aKeepPlace(HttpServletResponse response, String province, String city) {
		Cookie cookieForProvince = new Cookie("province", province);
		cookieForProvince.setPath("/");
		cookieForProvince.setMaxAge(60*60*24*30);
		Cookie cookieForCity = new Cookie("city", city);
		cookieForCity.setPath("/");
		cookieForCity.setMaxAge(60*60*24*30);
		response.addCookie(cookieForCity);
		response.addCookie(cookieForProvince);
		return "index";
	}

}
