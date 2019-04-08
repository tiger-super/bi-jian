package TestDao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.house.entity.Page;
import com.house.entity.Pay;
import com.manage.Open;
import com.manage.dao.VipManageDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Open.class)
public class TestVipManageDao {
	@Autowired
	VipManageDao vipManageDao;
	@Test
	public void test() {
		Page page = new Page();
		page.setPageCurrent(1);
		List<Pay> list = vipManageDao.queryAllVipOrder(page);
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	@Test
	public void testAccountPayMoneyAndNowDay() {
		List<String> list = vipManageDao.accountPayMoneyAndNowDay("2019-04-07");
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
