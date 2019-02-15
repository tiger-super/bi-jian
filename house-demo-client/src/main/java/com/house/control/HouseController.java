package com.house.control;

import java.io.IOException;
import java.util.ArrayList;
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

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.house.HouseService;
import com.house.entity.Customer;
import com.house.entity.House;
import com.house.entity.Page;
import com.house.tool.FileUtil;
import com.house.tool.PageShow;
import com.house.tool.PhoneAddressCreate;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Reference
	HouseService houseService;

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
	public String PublishHouse(House house, HttpSession session, HttpServletRequest request) {
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
		List<byte[]> list = new ArrayList<byte[]>();
		try {
			FileUtil.readCacheImg(folder, list);
		} catch (IOException e) {
			return "false";
		}
		house.setHousePublisherId(customer.getCustomerId());
		String result = houseService.housePublish(list, house);
		return result;
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
			HttpServletRequest request) {
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

		List<String> list = new ArrayList<String>();
		FileUtil.uploadCache(houseImg, folder, list);
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
	public Map<String,Object> getHouseList(HttpServletRequest request,@RequestParam(required =false) String area, @RequestParam(required =false)String sort, @RequestParam(required =false)String condition,House house,@RequestParam(required =false)Page page) {
		Cookie[] cookies = request.getCookies();
		if(page == null) {
		    page = new Page();
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
			return null;
		} else {
			house.setHouseAddressProvince(province);
			house.setHouseAddressCity(city);
			if (area != null && !area.equals("")) {
				house.setHouseAddressArea(area);
			}
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
	public List<String> getShowPage(Page page){
		return PageShow.handlePage(page);
	}
}
