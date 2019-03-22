package com.house.demo.house;

import java.util.List;
import java.util.Map;
import com.house.entity.House;
import com.house.entity.Page;

public interface HouseService {
	//房源图片缓存
	public List<String> cacheHouseImg(byte[] houseImg,String folder,String suffixName,String id);
	// 发布房源
	public String housePublish(String folder, House house);

	// 获取房源信息
	public House getHouseInformation(String houseId);

	// 获取房源的图片信息
	public List<String> getHouseImageInfo(String houseImageAddress);

	/**
	 * 此方法用来获取符合一定条件下的所有房源
	 * 
	 * @param house     此参数对象保存着房源的省市区
	 * @param sort      此参数表示排序方式
	 * @param Condition 此参数表示其他条件，如面积、金额
	 * @return 返回一个List，保存着符合条件的所有房源
	 */
	public Map<String,Object> getHouseFromProvinceAndCityAndAreaAndSortAndOtherCondition(House house, String sort,
			String condition,Page page);
	
	
	public Map<String,Object> publishManageService(House house,Page page);
	// 修改房源状态
	public Map<String,Object> ModifyHouseState(House house);
	// 删除房源服务
	public boolean deleteHouseService(House house);
	// 查询房源审核失败
	public Map<String,Object> houseReasonService(String houseId);
    // 重新发布
	public Map<String,Object> againHouseService(String houseId);
	//删除
	public void deleteAndUpdateInformation(String houseId);
}
