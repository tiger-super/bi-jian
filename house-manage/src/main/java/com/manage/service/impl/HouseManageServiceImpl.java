package com.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.entity.House;
import com.house.entity.Page;
import com.manage.dao.HouseManageDao;
import com.manage.service.HouseManageService;
import com.manage.tool.HouseImageTool;
@Service
public class HouseManageServiceImpl implements HouseManageService{
    @Autowired
	HouseManageDao houseManageDao;

	@Override
	public Map<String, Object> getAuditingHouse(Page page) {
		List<House> list = houseManageDao.selectAllToBeAuditingHouse(page);
		HouseImageTool  houseImageTool = new HouseImageTool();
		houseImageTool.getHouseImage(list);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("page", page);
		map.put("list", list);
		return map;
	}

    
}
