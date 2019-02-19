package com.house.demo.provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.collection.CollectionService;
import com.house.entity.Collection;
import com.house.entity.House;
import com.house.mapper.CollectionManagementMapper;
import com.house.mapper.HouseManagementMapper;
@Service
public class CollectionServiceImpl implements CollectionService{
	@Autowired
	CollectionManagementMapper collectionManagementMapper;
	@Autowired
	HouseManagementMapper houseManagementMapper; 
	@Override
	public String addHouseCollectionInformation(Collection collection) {
		House house = houseManagementMapper.seleteFollowNumber(collection.getCollectionHouseId());
		if(house.getHousePublisherId().equals(collection.getCollectorsId())){
			return "equal";
		}else {
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

}
