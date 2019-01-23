package com.house.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.entity.House;

@Controller
@RequestMapping("/house")
public class HouseController {
   
	@RequestMapping("/publish/house")
	@ResponseBody
	public void PublishHouse(House house) {
	   System.out.println(house);
   }
}
