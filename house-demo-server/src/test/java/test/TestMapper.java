package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;
import com.house.entity.House;
import com.house.mapper.HouseManagementMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestMapper {
	@Autowired
	private HouseManagementMapper houseManagementMapper;

	@Test
	public void test() {
		System.out.println(houseManagementMapper);
     House house = new House();
     house.setHouseName("银滩万泉城");
     house.setHouseAddressProvince("广东省");
     house.setHouseAddressCity("梅州市");
     house.setHouseAddressArea("五华县");
     house.setHouseAddressInfo("水寨镇园新路爱民巷013");
     house.setHousePublisherId("10000");
     houseManagementMapper.insertHouse(house);
     System.out.println(house);
     
     
	}
}
