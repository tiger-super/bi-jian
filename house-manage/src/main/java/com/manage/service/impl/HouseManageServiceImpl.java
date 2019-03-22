package com.manage.service.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.house.entity.AuditingFail;
import com.house.entity.House;
import com.house.entity.HouseInfo;
import com.house.entity.Page;
import com.manage.dao.AuditingManageDao;
import com.manage.dao.DeviceManageDao;
import com.manage.dao.HouseManageDao;
import com.manage.service.HouseManageService;
import com.manage.tool.AnalysisXML;
import com.manage.tool.ImageTool;
import com.manage.tool.Time;

@Service
public class HouseManageServiceImpl implements HouseManageService {
	@Autowired
	HouseManageDao houseManageDao;
	@Autowired
	ImageTool it;
	@Autowired
	DeviceManageDao deviceManageDao;
	@Autowired
	AuditingManageDao auditingManageDao;
	@Autowired
	AnalysisXML ax;

	@Override
	public Map<String, Object> getAuditingHouse(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageTotal = houseManageDao.selectTotalToBeAuditingHouse();
		if(pageTotal == 0) {
			return map;
		}
		double max = (double) pageTotal / page.getPageNumber();
		int pageMax = (int) Math.ceil(max);
		page.setPageMax(pageMax);
		if (pageMax < page.getPageCurrent()) {
			page.setPageCurrent(pageMax);
		}
		page.setPageShowNow((page.getPageCurrent() - 1) * page.getPageNumber());
		List<House> list = houseManageDao.selectAllToBeAuditingHouse(page);
		it.getHouseImage(list);
		page.setPageTotal(pageTotal);
		map.put("page", page);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> getHouseInformationFormHouseId(String houseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		House house = houseManageDao.selectHouseFromHouseId(houseId);
		HouseInfo houseInfo = houseManageDao.selectHouseInfoFromHouseId(houseId);
		house.setHouseInfo(houseInfo);
		List<String> list = it.getHouseImages(houseInfo.getHouseImageAddress());
		map.put("house", house);
		map.put("list", list);
		return map;
	}

	@Override
	public boolean modifyHouseAuditingStateService(String houseId) {
		int result = houseManageDao.updateSucceessHouseAuditingStateFromHouseId(houseId);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean auditingFailService(AuditingFail auditingFail) {
		auditingFail.setHouseAuditingTime(Time.getNowTime());
		int r1 = auditingManageDao.insertAuditingReasonFromHouseId(auditingFail);
		int r2 = houseManageDao.updateFailHouseAuditingStateFromHouseId(auditingFail.getHouseId());
		if (r1 == 1 && r2 == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<String, Object> getPublishHouse(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageTotal = houseManageDao.selectTotalHasBeenPublishHouse();
		if(pageTotal == 0) {
			return map;
		}
		double max = (double) pageTotal / page.getPageNumber();
		int pageMax = (int) Math.ceil(max);
		page.setPageMax(pageMax);
		if (pageMax < page.getPageCurrent()) {
			page.setPageCurrent(pageMax);
		}
		page.setPageShowNow((page.getPageCurrent() - 1) * page.getPageNumber());
		List<House> list = houseManageDao.selectAllHasBeenPublishHouse(page);
		it.getHouseImage(list);
		page.setPageTotal(pageTotal);
		map.put("page", page);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> getAuditingHouseFromId(String houseId) {
		Map<String,Object> map = new HashMap<String,Object>();
		House house = houseManageDao.selectAuditingHouseFromHouseId(houseId);
		if(house == null) {
			map.put("result",false);
		}else {
			String imgFolder = house.getHouseInfo().getHouseImageAddress();
			house.getHouseInfo().setHouseImageAddress(it.getHouseImage(imgFolder));
			map.put("result",true);
			map.put("house",house);
		}
		return map;
	}

	@Override
	public Map<String, Object> getPublicHouseFromId(String houseId) {
		Map<String,Object> map = new HashMap<String,Object>();
		House house = houseManageDao.selectPublicHouseFromHouseId(houseId);
		if(house == null) {
			map.put("result",false);
		}else {
			String imgFolder = house.getHouseInfo().getHouseImageAddress();
			house.getHouseInfo().setHouseImageAddress(it.getHouseImage(imgFolder));
			map.put("result",true);
			map.put("house",house);
		}
		return map;
	}

	@Override
	public Map<String, Boolean> lowerHouseFromId(String houseId) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		House house = new House();
		house.setHouseId(houseId);
		house.setHousePublisherState("0");
		int result = houseManageDao.updateHousePublisherStateFormHouseId(house);
		if(result == 1) {
			map.put("result",true);
		}else {
			map.put("result",false);
		}
		return map;
	}

}
