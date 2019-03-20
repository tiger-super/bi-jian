package com.house.mapper;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

import com.house.entity.AuditingFail;
import com.house.entity.House;
import com.house.entity.HouseInfo;

// 操作房源有关的接口
@Repository
public  interface HouseManagementMapper {
	// 插入房源
	public int insertHouse(House house);
	// 插入房源信息
	public int insertHouseInfo(House house);
	// 查询房源
	public House selectHouseAccordingHouseId(String houseId);
	// 查询房源信息
	public HouseInfo selectHouseInfoAccordingHouseId(String houseId);
	// 查询某个地区的房源
	public List<House> selectHousesFromProvinceAndCityAndArea(Map<String,Object> map);
	// 查询某个地区的房源并按照一定条件降序排序
	public List<House> selectHousesFromProvinceAndCityAndAreaAndSortToDesc(Map<String,Object> map);
	// 查询某个地区的房源并按照一定条件升序排序
	public List<House> selectHousesFromProvinceAndCityAndAreaAndSortToAsc(Map<String,Object> map);
	// 查询某个地区的房源信息总数
	public int getHouseInformationTotal(House house);
	// 查询房源的流程情况
	public List<House> selectPublishSituation(Map<String,Object> map);
	// 查询某个地区的房源信息总数
		public int selectPublishSituationTotal(House house);
	// 修改房源的发布和审核状态
	public int	updateHouseState(House house);
	
	//删除房源
	public int deleteHouseDao(House house);
	
	//查询收藏数量
	public House seleteFollowNumber(String houseId);
	
	
	//修改收藏数量
	public  int updateFollowNumber(House house);
	
	// 根据大量的houseId查询房源
	public List<House> selectHouseInfoFromHouseIdS(List<String> list);
	
	//根据id查询房源审核失败的原因
	public AuditingFail selectFailReasonFromHouseId(String houseId);
	
	//根据id删除房子
	public int deleteHouseWithId(String houseId);
	//根据id删除房子信息
	public int deleteHouseHouseInfoWithId(String houseId);
}
