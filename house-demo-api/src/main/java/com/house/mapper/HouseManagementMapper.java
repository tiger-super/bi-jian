package com.house.mapper;

import org.springframework.stereotype.Repository;

import com.house.entity.House;

// 操作房源有关的接口
@Repository
public interface HouseManagementMapper {
    // 插入房源
	int insertHouse(House house);
	
	//插入房源信息
	int insertHouseInfo(House house);
}
