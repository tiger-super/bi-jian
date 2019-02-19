package com.house.demo.collection;

import com.house.entity.Collection;

public interface CollectionService {
	/**
	 * 房源收集服务
	 * @param collection
	 * @return
	 */
	public String addHouseCollectionInformation(Collection collection);
	public boolean judgeHouseAleardyCollection(Collection collection);
	public String cancelHouseCollectionInformation(Collection collection);
}
