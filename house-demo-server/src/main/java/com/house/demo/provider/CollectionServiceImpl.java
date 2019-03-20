package com.house.demo.provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.collection.CollectionService;
import com.house.entity.Collection;
import com.house.entity.House;
import com.house.entity.Page;
import com.house.mapper.CollectionManagementMapper;
import com.house.mapper.HouseManagementMapper;
import com.house.tool.AnalysisXML;
import com.house.tool.FileUtil;
import com.house.tool.Time;
@Service
public class CollectionServiceImpl implements CollectionService{
	@Autowired
	CollectionManagementMapper collectionManagementMapper;
	@Autowired
	HouseManagementMapper houseManagementMapper; 
	@Autowired
	AnalysisXML ax;
	@Override
	public String addHouseCollectionInformation(Collection collection) {
		House house = houseManagementMapper.seleteFollowNumber(collection.getCollectionHouseId());
		if(house.getHousePublisherId().equals(collection.getCollectorsId())){
			//这一步判断是否是自己的房源
			return "equal";
		}else {
		collection.setCollectionTime(Time.getNowTime());
		int result = collectionManagementMapper.insertCollectionInformation(collection);
		if(result == 1) {
			int number = Integer.valueOf(house.getFollowNumber());
			number += 1;
			house.setHouseId(collection.getCollectionHouseId());
			house.setFollowNumber(String.valueOf(number));
			houseManagementMapper.updateFollowNumber(house);
			return "true";
		}else {
			return "false";
		}
	}
	}
	@Override
	public String cancelHouseCollectionInformation(Collection collection) {
		House house = houseManagementMapper.seleteFollowNumber(collection.getCollectionHouseId());
		int result = collectionManagementMapper.deleteCollectionInformation(collection);
		if(result == 1) {
			int number = Integer.valueOf(house.getFollowNumber());
			number -= 1;
			house.setHouseId(collection.getCollectionHouseId());
			house.setFollowNumber(String.valueOf(number));
			houseManagementMapper.updateFollowNumber(house);
			return "true";
		}else {
			return "false";
		}
	}

	@Override
	public boolean judgeHouseAleardyCollection(Collection collection) {
		Collection result = collectionManagementMapper.ifExistCollectionInformation(collection);
		if(result == null) {
			return false;
		}else {			
			return true;
		}
	}
	@Override
	public Map<String,Object> loadCollectionInformation(String collectorsId,Page page) {
		String houseVisitAddress = ax.getName(AnalysisXML.HOUSEVISITADDRESS);
		String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		Map<String,Object> map = new HashMap<String,Object>();
		int pageTotal = collectionManagementMapper.totalSelectCollectionHouseIdFormCollectorsId(collectorsId);
		if(pageTotal > 0) {
		// 最大值
		page.setPageTotal(pageTotal);
		// 已显示的页面
		page.setPageShowNow((page.getPageCurrent()-1)*page.getPageNumber());
		// 最大页
		page.setPageMax((int)Math.ceil((double)page.getPageTotal()/page.getPageNumber()));
		Collection collection = new Collection();
		collection.setCollectorsId(collectorsId);
		map.put("collection",collection);
		map.put("page", page);
		List<String> houseIdS = collectionManagementMapper.selectCollectionHouseIdFormCollectorsId(map);

		List<House> houses = houseManagementMapper.selectHouseInfoFromHouseIdS(houseIdS);
		for(int i = 0 ; i < houses.size() ; i++) {
			House value = houses.get(i);
			String imageFolder = value.getHouseInfo().getHouseImageAddress();
			value.getHouseInfo().setHouseImageAddress(FileUtil.getObjectImgVisitPath(imageFolder, houseVisitAddress, houseKeepAddress));
		}
		map.put("list", houses);
		}
		return map;
	}

}
