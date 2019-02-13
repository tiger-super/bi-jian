package com.house.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.house.entity.House;
import com.house.entity.HouseInfo;

// 操作房源有关的接口
@Repository
public interface HouseManagementMapper {
	// 插入房源
	int insertHouse(House house);

	// 插入房源信息
	int insertHouseInfo(House house);

	// 查询房源
	House selectHouseAccordingHouseId(String houseId);

	// 查询房源信息
	HouseInfo selectHouseInfoAccordingHouseId(String houseId);

	// 查询某个地区的房源的房源
	List<House> selectHouseFromProvinceAndCityAndArea(House house);
}
