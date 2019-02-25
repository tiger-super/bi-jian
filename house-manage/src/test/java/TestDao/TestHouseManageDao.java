package TestDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.entity.Page;
import com.manage.Open;
import com.manage.dao.HouseManageDao;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Open.class)
public class TestHouseManageDao {
	@Autowired
	HouseManageDao houseManageDao;
	@Test
	public void testSelectAllToBeAuditingHouse() {
		Page page = new Page();
		page.setPageShowNow(page.getPageCurrent()*page.getPageNumber());
		System.out.println(houseManageDao.selectAllToBeAuditingHouse(page));
	}
}
