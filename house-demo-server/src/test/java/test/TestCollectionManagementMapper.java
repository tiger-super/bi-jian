package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.ServiceApplication;
import com.house.entity.Collection;
import com.house.entity.Page;
import com.house.mapper.CollectionManagementMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestCollectionManagementMapper {
	 @Autowired
	 CollectionManagementMapper collectionManagementMapper;
	@Test
  public void testSelectCollectionHouseIdFormCollectorsId() {
		Collection collection = new Collection();
		collection.setCollectorsId("2");
		Map<String,Object> map = new HashMap<String,Object>();
		Page page = new Page();
		page.setPageCurrent(2);
		page.setPageShowNow((page.getPageCurrent()-1)*page.getPageNumber());
		map.put("collection",collection);
		System.out.println(page);
		map.put("page", page);
	 List<String> list = collectionManagementMapper.selectCollectionHouseIdFormCollectorsId(map);
	 for(int i = 0 ; i < list.size() ; i ++) {
		 System.out.println("弟"+i+"个值为："+list.get(i));
	 }
  }
	
	@Test
	public void testTotalSelectCollectionHouseIdFormCollectorsId() {
		System.out.println(collectionManagementMapper.totalSelectCollectionHouseIdFormCollectorsId("2"));
	}
}
