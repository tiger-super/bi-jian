package com.house.demo.collection;
import java.util.Map;
import com.house.entity.Collection;
import com.house.entity.Page;

public interface CollectionService {
	/**
	 * 房源收集服务
	 * @param collection
	 * @return
	 */
	public String addHouseCollectionInformation(Collection collection);
	public boolean judgeHouseAleardyCollection(Collection collection);
	public String cancelHouseCollectionInformation(Collection collection);
	
	public Map<String,Object> loadCollectionInformation(String collectorsId,Page page);
}
