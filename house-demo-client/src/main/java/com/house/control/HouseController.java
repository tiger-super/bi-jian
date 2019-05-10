package com.house.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.customer.PersonInfoService;
import com.house.demo.house.HouseService;
import com.house.entity.Customer;
import com.house.entity.House;
import com.house.entity.Page;
import com.house.tool.PageShow;
import com.house.tool.PhoneAddressCreate;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Reference
	HouseService houseService;
	@Reference
	PersonInfoService personInfoService;

	/**
	 * 该方法收集用户发布的房源信息
	 * 
	 * @param house   发布的房源
	 * @param session 用来获取发布人的id
	 * @param request 用来获取cookie，从cookie中的得到房源图片的地址
	 * @return 返回一个String类型数据，有"true"和"false"
	 */
	@RequestMapping("/session/publish/house")
	@ResponseBody
	public Map<String, String> PublishHouse(House house, HttpSession session, HttpServletRequest request) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		Map<String, String> map = new HashMap<String, String>();
		if(!personInfoService.ifVip(customer.getCustomerId())) {
			map.put("result","false");
			map.put("vip","true");
			return map;
		}
		String houseId = house.getHouseId();
		String result = null;
		Cookie[] cookies = request.getCookies();
		String folder = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				switch (cookie.getName()) {
				case "folder":
					folder = cookie.getValue();
					break;
				}
			}
		}
		house.setHousePublisherId(customer.getCustomerId());
		result = houseService.housePublish(folder, house);
		if(houseId != null) {
			houseService.deleteAndUpdateInformation(houseId);
		}
			map.put("result", result);			
		return map;
	}

	/**
	 * 该方法用于用户发布房源的时候缓存上传的房源图片
	 * 
	 * @param houseImg 上传的图片
	 * @param request  用于获取cookie
	 * @param response 用于保存cookie
	 * @return 返回一个集合，集合保存的是父级地址下的所有图片地址
	 */
	@RequestMapping("/session/publish/house/upload")
	@ResponseBody
	public List<String> uploadHouseImg(@RequestParam("photoFile") MultipartFile houseImg, HttpServletResponse response,
			HttpServletRequest request,HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		Cookie[] cookies = request.getCookies();
		String folder = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				switch (cookie.getName()) {
				case "folder":
					folder = cookie.getValue();
					break;
				}
			}
		}
		if (folder == null) {
			folder = PhoneAddressCreate.createAddress();
			Cookie cookieFolder = new Cookie("folder", folder);
			cookieFolder.setPath("/");
			response.addCookie(cookieFolder);
		}
		// 获取文件名称,包含后缀
		String fileName = houseImg.getOriginalFilename();
	    // 获得后缀
		String suffixName = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		
		List<String> list = null;
		try {
			list = houseService.cacheHouseImg(houseImg.getBytes(),folder,suffixName,customer.getCustomerId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 该方法用于获取一定条件下的所有房源，并用集合方式保存
	 * 
	 * @param request         用于获取cookie
	 * @param area            获得地区，但这个参数不一样需要有
	 * @param arrangementMode 排序方式
	 * @return 如果还没有选择地区，则返回null，有则返回对应的集合
	 */
	@RequestMapping("/get/house/list")
	@ResponseBody
	public Map<String, Object> getHouseList(HttpServletRequest request, @RequestParam(required = false) String sort,
			@RequestParam(required = false) String condition, House house,
			@RequestParam(required = false) Integer pageCurrent) {
		Cookie[] cookies = request.getCookies();
		Page page = new Page();
		if (pageCurrent != null) {
			page.setPageCurrent(pageCurrent);
		}
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
		if (province == null || city == null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("result", false);
			return map;
		} else {
			house.setHouseAddressProvince(province);
			house.setHouseAddressCity(city);
			System.out.println(house);
			return houseService.getHouseFromProvinceAndCityAndAreaAndSortAndOtherCondition(house, sort, condition,page);
		}
	}

	/**
	 * 该方法用于获取房源的图片
	 * 
	 * @param houseImageAddress 房源图片地址
	 * @return 返回一个集合，该集合的内容为所有的房源地址
	 */
	@RequestMapping("/get/house/image")
	@ResponseBody
	public List<String> getHouseImage(String houseImageAddress) {
		return houseService.getHouseImageInfo(houseImageAddress);
	}

	@RequestMapping("/get/show/page")
	@ResponseBody
	public List<String> getShowPage(Page page) {
		return PageShow.handlePage(page);
	}

	@RequestMapping("/session/publish/manage")
	@ResponseBody
	public Map<String, Object> pubilshManage(House house, HttpSession session,
			@RequestParam(required = false) Integer pageCurrent) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		house.setHousePublisherId(customer.getCustomerId());
		Page page = new Page();
		if (pageCurrent != null) {
			page.setPageCurrent(pageCurrent);
		}
		return houseService.publishManageService(house, page);
	}

	@RequestMapping("/session/modify/state")
	@ResponseBody
	public Map<String,Object> modifyHouseState(House house, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		house.setHousePublisherId(customer.getCustomerId());
		return houseService.ModifyHouseState(house);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Map<String,Object> deleteHouse(House house, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		house.setHousePublisherId(customer.getCustomerId());
		return houseService.ModifyHouseState(house);
	}

	@RequestMapping("/get/fail/reason")
	@ResponseBody
	public Map<String, Object> getFailReason(String houseId) {
		return houseService.houseReasonService(houseId);
	}

	@RequestMapping("/see/house/Information")
	public ModelAndView seeHouseInformation(String houseId) {
		ModelAndView mv = new ModelAndView();
		Map<String, Object> map = new HashMap<String, Object>();
		House house = houseService.getHouseInformation(houseId);
		List<String> list = houseService.getHouseImageInfo(house.getHouseInfo().getHouseImageAddress());
		map.put("house", house);
		map.put("list",list);
		mv.setViewName("house-information");
		mv.addObject("map", map);
		return mv;
	}
}
