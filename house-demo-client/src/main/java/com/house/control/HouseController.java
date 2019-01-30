package com.house.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.house.entity.House;
import com.house.tool.FileUtil;
import com.house.tool.PhoneAddressCreate;

@Controller
@RequestMapping("/house")
public class HouseController {

	@RequestMapping("/publish/house")
	@ResponseBody
	public void PublishHouse(House house) {
		System.out.println(house);
	}

	@RequestMapping("/publish/house/upload")
	@ResponseBody
	public List<String> uploadHouseImg(@RequestParam("photoFile") MultipartFile houseImg, HttpSession session) {
		
		List<String> list = (List<String>) session.getAttribute("list");
		String folder = (String) session.getAttribute("folder");
		System.out.println(folder);
		if (folder == null) {
			folder = PhoneAddressCreate.createAddress();
			session.setAttribute("folder", folder);
		}
		if(list == null) {
			list = new ArrayList<String>();
			session.setAttribute("list", list);
		}
		FileUtil.uploadCache(houseImg, folder, list);
		return list;
	}
}
