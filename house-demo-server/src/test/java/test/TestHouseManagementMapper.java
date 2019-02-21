package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;
import com.house.entity.House;
import com.house.entity.HouseInfo;
import com.house.entity.Page;
import com.house.mapper.HouseManagementMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestHouseManagementMapper {
	@Autowired
	HouseManagementMapper houseManagementMapper;

	@Test
	public void testSelectHouseAccordingHouseId() {
		System.out.println("查询");
		System.out.println("房子为：" + houseManagementMapper.selectHouseAccordingHouseId("10000"));
	}

	@Test
	public void testSelectHouseInfoAccordingHouseId() {
		System.out.println(houseManagementMapper.selectHouseInfoAccordingHouseId("10000"));
	}

	@Test
	public void testSelectHousesFromProvinceAndCityAndArea() {
		House house = new House();
		house.setHouseAddressProvince("广东省");
		house.setHouseAddressCity("佛山市");
		house.setHouseAddressArea("南海区");
		HouseInfo houseInfo = new HouseInfo();
		houseInfo.setHouseSellWay("租售");
		house.setHouseInfo(houseInfo);
		System.out.println(house);
		List<House> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		Page page = new Page();
		page.setPageNumber(4);
		page.setPageShowNow(0);
		map.put("house", house);
		map.put("page", page);
		list = houseManagementMapper.selectHousesFromProvinceAndCityAndArea(map);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("第" + i + "个结果为：" + list.get(i));
		}
	}

	@Test
	public void testSelectHousesFromProvinceAndCityAndAreaAndSortToDesc() {
		House house = new House();
		house.setHouseAddressProvince("广东省");
		house.setHouseAddressCity("佛山市");
		/* house.setHouseAddressArea("南海区"); */
		HouseInfo houseInfo = new HouseInfo();
		houseInfo.setHouseSellWay("租售");
		houseInfo.setHouseSize("true");
		house.setHouseInfo(houseInfo);
		Map<String, Object> map = new HashMap<String, Object>();
		Page page = new Page();
		page.setPageNumber(4);
		page.setPageShowNow(0);
		map.put("house", house);
		map.put("page", page);
		List<House> list = houseManagementMapper.selectHousesFromProvinceAndCityAndAreaAndSortToDesc(map);
		for (int i = 0; i < list.size(); i++) {
			System.out.println("第" + i + "个结果为：" + list.get(i).getHouseInfo().getHouseSize());
		}
	}

	@Test
	public void testSelectHousesFromProvinceAndCityAndAreaAndSortToAsc() {
		House house = new House();
		  house.setHouseAddressProvince("广东省");
		  house.setHouseAddressCity("佛山市");
			 house.setHouseAddressArea("南海区");
		  HouseInfo houseInfo = new HouseInfo();
		  houseInfo.setHouseSellWay("租售");
		  houseInfo.setHouseSize("true");
		  house.setHouseInfo(houseInfo);
		  Map<String,Object> map = new HashMap<String,Object>();
			 Page page = new Page();
			 page.setPageNumber(4);
			 page.setPageShowNow(0);
			 map.put("house", house);
			 map.put("page",page);
		List<House> list = houseManagementMapper.selectHousesFromProvinceAndCityAndAreaAndSortToAsc(map);
		for (int i = 0; i < list.size(); i++) {
			/*
			 * System.out.println("第"+i+"个结果为："+list.get(i).getHouseInfo().getHouseMoney());
			 */

			System.out.println("第" + i + "个结果为：" + list.get(i).getHouseInfo().getHouseSize());

		}
	}
	
	@Test
	public void testGetHouseInformationTotal() {
		House house = new House();
		  house.setHouseAddressProvince("广东省");
		  house.setHouseAddressCity("佛山市");
			 house.setHouseAddressArea("南海区");
		  HouseInfo houseInfo = new HouseInfo();
		  houseInfo.setHouseSellWay("租售");
		  house.setHouseInfo(houseInfo);
		  System.out.println(houseManagementMapper.getHouseInformationTotal(house));
	}
	@Test
	public void testSelectPublishSituation() {
		House house = new House();
		 house.setHousePublisherId("1"); 
		/* house.setHousePublisherState("0"); */
		 house.setHouseAuditingState("1");
		 Map<String,Object> map = new HashMap<String,Object>();
		 Page page = new Page();
		 page.setPageNumber(4);
		 page.setPageShowNow(0);
		 map.put("house", house);
		 map.put("page",page);
		 System.out.println(house);
		  System.out.println("信息"+houseManagementMapper.selectPublishSituation(map));
          System.out.println("总数"+houseManagementMapper.selectPublishSituationTotal(house));	
	}
	@Test
	public void testSelectHouseInfoFromHouseIdS() {
		List<String> list = new ArrayList<String>();
		list.add("10000");
		list.add("10001");
		list.add("10002");
		List<House> houses = houseManagementMapper.selectHouseInfoFromHouseIdS(list);
		for(int i = 0 ; i < list.size() ; i ++) {
			 System.out.println("弟"+i+"个值为："+houses.get(i));
		 }
	}
}
