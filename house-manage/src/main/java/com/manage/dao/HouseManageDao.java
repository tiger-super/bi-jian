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
    //统计所有未发布的房源
    int selectTotalNoToBeAuditingHouse();
    //根据id查询未审核的房源
    House selectAuditingHouseFromHouseId(String houseId);
    //根据id查询
    House selectPublicHouseFromHouseId(String houseId);
    //修改对应发布人的id的所有房源的发布情况
    int updateHousePublisherStateFormPublisherId(House house);
    //修改房源的id的房源的发布情况
    int updateHousePublisherStateFormHouseId(House house);
    //查询未到期的房源
    public List<House> selectHouseWhereDaysOffIsNotZero();
    //房源到期时间减一
    public int updateHouseDaysOffFromList(List<String> list);
}
