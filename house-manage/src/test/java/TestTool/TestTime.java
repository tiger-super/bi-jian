package TestTool;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.manage.tool.Time;


public class TestTime {
    @Test
   public void testDayForWeek() throws Exception {

		System.out.println(Time.dayForWeek(Time.getNowTimeforYearAndMonthAndDay()));
	
    	   SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
    	   Date date=simpleDateFormat.parse(Time.getNowTimeforYearAndMonthAndDay());
    	   System.out.println(simpleDateFormat.format(date));
    	   System.out.println(simpleDateFormat.format(Time.dayAddNum(date,-1)));
		/* Time.yearAddNum(date,1); */
    	 System.out.println(Time.dayForWeek(simpleDateFormat.format(Time.dayAddNum(date,-2))));
    }
    @Test
    public void testGetWeek() throws ParseException {
    	System.out.println(Time.getWeek(4,"2019-03-14"));
    }
}
