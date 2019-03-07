package com.house.tool;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Component;

@Component
public class AnalysisXML {
	public static String HOUSEVISITADDRESS = "houseVisit";
	public static String HOUSEKEEPADDRESS = "houseKeep";
   public  String getName(String condition) {
	   SAXReader reader = new SAXReader();
		 InputStream is= this.getClass().getResourceAsStream("/static/cacheAddress.xml");
		Document document = null;
		try {
			 document = reader.read(is); 
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element ele = document.getRootElement();
		  for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {
				Element e = it.next();
			if(condition.equals(e.getName()))
			return e.attribute("name").getText();
			}
		return null;
   }
}
