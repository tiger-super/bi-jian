package TestTool;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.house.entity.House;
import com.house.entity.HouseInfo;
import com.manage.tool.ImageTool;

public class TestHouseImageTool {
    @Test
    public void testGetHouseImage() {
		/* System.out.println(new HouseImageTool().getHouseImage("11549690311179")); */
        List<House> list = new ArrayList<House>();
        House house = new House();
        HouseInfo houseInfo = new HouseInfo();
        houseInfo.setHouseImageAddress("11549690311179");
        house.setHouseInfo(houseInfo);
        list.add(house);
        new ImageTool().getHouseImage(list);
        System.out.println(list.get(0).getHouseInfo().getHouseImageAddress());
    }
    
}
