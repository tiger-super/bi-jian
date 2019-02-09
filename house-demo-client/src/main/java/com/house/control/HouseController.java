package com.house.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
import com.house.tool.FileUtil;
import com.house.tool.PhoneAddressCreate;

@Controller
@RequestMapping("/house")
public class HouseController {
	@Reference
    HouseService houseService;
	@RequestMapping("/publish/house")
	@ResponseBody
	public String PublishHouse(House house, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("customerSession");
		String folder = (String) session.getAttribute("folder");
		List<byte[]> list = new ArrayList<byte[]>();
		try {
			FileUtil.readCacheImg(folder,list);
		} catch (IOException e) {
			return "false";
		}
		house.setHousePublisherId("1");
		String result = houseService.housePublish(list,house);
	    return result;
	}

	@RequestMapping("/publish/house/upload")
	@ResponseBody
	public List<String> uploadHouseImg(@RequestParam("photoFile") MultipartFile houseImg, HttpSession session) {
		String folder = (String) session.getAttribute("folder");
		if (folder == null) {
			folder = PhoneAddressCreate.createAddress();
			session.setAttribute("folder", folder);
		}

			List<String> list = new ArrayList<String>();
		
		FileUtil.uploadCache(houseImg, folder,list);
		return list;
	}

	@RequestMapping("/get/house/list")
	@ResponseBody
	public List<House> getHouseList() {
		
		return null;
	}
}
