package com.house.demo.provider;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.collection.CollectionService;
import com.house.entity.Collection;
import com.house.mapper.CollectionManagementMapper;
@Service
public class CollectionServiceImpl implements CollectionService{
	@Autowired
	CollectionManagementMapper collectionManagementMapper;
	@Override
	public boolean addHouseCollectionInformation(Collection collection) {
		int result = collectionManagementMapper.insertCollectionInformation(collection);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean cancelHouseCollectionInformation(Collection collection) {
		int result = collectionManagementMapper.deleteCollectionInformation(collection);
		if(result == 1) {
			return true;
		}else {
			return false;
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
