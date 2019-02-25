package com.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.house.entity.House;
import com.house.entity.Page;
@Repository
public interface HouseManageDao {
	// 查询所有待审核的房源
    List<House> selectAllToBeAuditingHouse(Page page);
    // 查询所有已发布的房源
    List<House> selectAllHasBeenPublishHouse(Page page);
}
