package com.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.house.entity.House;
import com.house.entity.HouseInfo;
import com.house.entity.Page;

@Repository
public interface HouseManageDao {
	// 查询所有待审核的房源
    List<House> selectAllToBeAuditingHouse(Page page);
    // 查询所有已发布的房源
    List<House> selectAllHasBeenPublishHouse(Page page);
    // 统计所有待审审核房源
    int selectTotalToBeAuditingHouse();
    // 统计所有已经发布的房源
    int selectTotalHasBeenPublishHouse();
    //根据房源id查询房源信息
    House selectHouseFromHouseId(String houseId);
    // 根据房源id查询房源详细信息
    HouseInfo selectHouseInfoFromHouseId(String houseId);
    // 根据房源id修改房源审核成功
    int updateSucceessHouseAuditingStateFromHouseId(String houseId);
    // 根据房源id修改房源审核失败
    int updateFailHouseAuditingStateFromHouseId(String houseId);
}
