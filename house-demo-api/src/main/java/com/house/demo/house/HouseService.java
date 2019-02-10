package com.house.demo.house;

import java.util.List;

import com.house.entity.House;

public interface HouseService {
	// 发布房源
   public String housePublish(List<byte[]> list,House house);
   // 获取房源信息
   public House getHouseInformation(String houseId);
}
