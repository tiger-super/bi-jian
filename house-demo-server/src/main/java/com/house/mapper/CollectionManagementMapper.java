package com.house.mapper;

import com.house.entity.Collection;

public interface CollectionManagementMapper {
//  添加收藏信息
	int insertCollectionInformation(Collection collection);
	// 删除收藏信息
	int deleteCollectionInformation(Collection collection);
	// 判断收藏信息是否存在
	Collection ifExistCollectionInformation(Collection collection);
}
