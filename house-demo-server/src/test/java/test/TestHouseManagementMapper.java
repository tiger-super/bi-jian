package test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;
import com.house.entity.House;
import com.house.entity.HouseInfo;
import com.house.mapper.HouseManagementMapper;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestHouseManagementMapper {
	@Autowired
	HouseManagementMapper houseManagementMapper;

  @Test
  public void testSelectHouseAccordingHouseId() {
	  System.out.println("查询");
	  System.out.println("房子为："+houseManagementMapper.selectHouseAccordingHouseId("10000"));
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
	  List<House> list = houseManagementMapper.selectHousesFromProvinceAndCityAndArea(house);
      for(int i = 0 ; i < list.size() ; i++) {
    	  System.out.println("第"+i+"个结果为："+list.get(i));
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
	  List<House> list = houseManagementMapper.selectHousesFromProvinceAndCityAndAreaAndSortToDesc(house);
      for(int i = 0 ; i < list.size() ; i++) {
    	  System.out.println("第"+i+"个结果为："+list.get(i).getHouseInfo().getHouseSize());
      }
  }
  
  @Test
  public void testSelectHousesFromProvinceAndCityAndAreaAndSortToAsc() {
	  House house = new House();
	  house.setHouseAddressProvince("广东省");
	  house.setHouseAddressCity("佛山市");
		/* house.setHouseAddressArea("南海区"); */
	  HouseInfo houseInfo = new HouseInfo();
	  houseInfo.setHouseSellWay("租售");
		/* houseInfo.setHouseMoney("true"); */
	  houseInfo.setHouseSize("true");
	  house.setHouseInfo(houseInfo);
	  List<House> list = houseManagementMapper.selectHousesFromProvinceAndCityAndAreaAndSortToAsc(house);
      for(int i = 0 ; i < list.size() ; i++) {
			/*
			 * System.out.println("第"+i+"个结果为："+list.get(i).getHouseInfo().getHouseMoney());
			 */

			  System.out.println("第"+i+"个结果为："+list.get(i).getHouseInfo().getHouseSize());
			 
      }
  }
}
