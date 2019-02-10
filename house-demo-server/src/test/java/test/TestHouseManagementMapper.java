package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;

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
}
