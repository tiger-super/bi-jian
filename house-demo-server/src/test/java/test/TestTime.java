package test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import com.house.tool.AnalysisXML;
import com.house.tool.Time;

public class TestTime {
 @Test
 public void testGetNowTime() {
	 System.out.println(Time.getNowTime());
 }
 @Test
 public void test() {
	 List<String> list = new ArrayList<String>();
	 SAXReader reader = new SAXReader();
	 InputStream is=this.getClass().getResourceAsStream("/static/imgAddress.xml");
	Document document = null;
	try {
		 document = reader.read(is); 
	} catch (DocumentException e) {
		e.printStackTrace();
	}
	Element ele = document.getRootElement();
	  for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {
			Element e = it.next();
			System.out.println(e.attribute("name").getText());
			System.out.println(e.getName());
		}
 }
 @Test
 public void test1() {
	 System.out.println(new AnalysisXML().getName(AnalysisXML.HOUSEVISITADDRESS));
	 System.out.println(new AnalysisXML().getName(AnalysisXML.HOUSEKEEPADDRESS));
 }
}
