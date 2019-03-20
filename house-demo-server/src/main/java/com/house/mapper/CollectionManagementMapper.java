package com.house.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.house.entity.Collection;

@Repository
public interface CollectionManagementMapper {
    //  添加收藏信息
	int insertCollectionInformation(Collection collection);
	// 删除收藏信息
	int deleteCollectionInformation(Collection collection);
	// 判断收藏信息是否存在
	Collection ifExistCollectionInformation(Collection collection);
	//根据收藏人id查询出所有收藏房源的id
	List<String> selectCollectionHouseIdFormCollectorsId(Map<String,Object> map);
	// 根据id查询出该用户一共收藏了多少房源
	int totalSelectCollectionHouseIdFormCollectorsId(String collectorsId);
}
