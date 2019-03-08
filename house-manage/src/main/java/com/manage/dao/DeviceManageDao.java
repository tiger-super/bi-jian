package com.manage.dao;


import org.springframework.stereotype.Repository;

import com.house.entity.Device;


@Repository
public interface DeviceManageDao {
    // 根据房源id查询房源的设备信息
    Device selectDeviceFromHouseId(String houseId);
}
