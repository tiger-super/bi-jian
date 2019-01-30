package com.house.mapper;

import org.springframework.stereotype.Repository;

import com.house.entity.House;
@Repository
public interface DeviceManagementMapper {
	// 插入房源设备信息
   public void inserDeviceInfo(House house);
}
