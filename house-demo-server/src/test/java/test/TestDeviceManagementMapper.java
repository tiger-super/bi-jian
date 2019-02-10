package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;
import com.house.mapper.DeviceManagementMapper;
import com.house.mapper.HouseManagementMapper;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestDeviceManagementMapper {
	@Autowired
	DeviceManagementMapper deviceManagementMapper;

  @Test
  public void testSelectDeviceInfoAccordingHouseId() {
	  System.out.println(deviceManagementMapper.selectDeviceInfoAccordingHouseId("10000"));
  }
 
}
