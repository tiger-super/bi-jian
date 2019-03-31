package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.house.demo.provider.AnalysisAreaXmlServiceImpl;
import com.house.tool.Time;

public class TestFile {
 @Test
 public void test1() throws URISyntaxException, IOException {
		List<String> list = new ArrayList<String>();
        URL url = new URL("http://47.106.244.224:8080/area/areaName.xml");

		SAXReader reader = new SAXReader();
		Document document = null;
		try {
			document = reader.read(url.openStream());
		} catch (DocumentException e) {
			
		}

		Element ele = document.getRootElement();

		for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {

			list.add(it.next().attribute("name").getText());

		}

		System.out.println(list);
 }
 @Test
 public void test() throws ParseException {
	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	  Calendar calendar = Calendar.getInstance();
      calendar.setTime(df.parse(Time.getNowTimeforYearAndMonthAndDay()));
      calendar.add(Calendar.MONTH, 1);
      Date newTime =  Time.dateAddMonth(1,df.parse(Time.getNowTimeforYearAndMonthAndDay()));;
      Date oldTime = df.parse("2019-03-31");
      System.out.println(newTime.compareTo(oldTime));
      System.out.println(df.format(newTime) );
 }
}
