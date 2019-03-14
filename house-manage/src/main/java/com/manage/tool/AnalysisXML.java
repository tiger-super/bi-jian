package com.manage.tool;

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
	public static String CUSTOMERVISITADDRESS = "customerVisit";
	public static String CUSTOMERKEEPADDRESS = "customerKeep";
	public static String EMPLOYEEVISITADDRESS = "employeeVisit";
	public static String EMPLOYEEKEEPADDRESS = "employeeKeep";
	public static String EMPLOYEECACHEADDRESS = "employeeCache";
	public static String EMPLOYEEVISITCACHEADDRESS = "employeeVisitCache";
	public static String SOCKET = "socket";
   public List<String> oneLevelAnalysis(String path){
	   List<String> list = new ArrayList<String>();
		Element ele = analysixResult(path,list);
		return  shuaiElection(list,ele);
   }
   public List<String> twoLevelAnalysis(String path,String conditionOne){
	   List<String> list = new ArrayList<String>();
		Element ele = analysixResult(path,list);
		return  shuaiElection(list,ele,conditionOne);
   }
   
   public List<String> threeLevelAnalysis(String path,String conditionOne,String conditionTwo){
	   List<String> list = new ArrayList<String>();
		Element ele = analysixResult(path,list);
		return  shuaiElection(list,ele,conditionOne,conditionTwo);
   }
   private Element analysixResult(String path,List<String> list) {
		SAXReader reader = new SAXReader();
		 InputStream is=this.getClass().getResourceAsStream(path);
		Document document = null;
		try {
			 document = reader.read(is); 
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document.getRootElement();
   }
   private List<String> shuaiElection(List<String> list,Element ele){
	   for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {
			list.add(it.next().attribute("name").getText());
		}
		return list;
   }
   
   private List<String>  shuaiElection(List<String> list,Element ele,String conditionOne){
	   for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {

			ele = it.next();

			String name = ele.attribute("name").getText();

			if (name.equals(conditionOne)) {

				List<Element> myList = ele.elements();

				for (Iterator<Element> its = myList.iterator(); its.hasNext();) {

					list.add(its.next().attribute("name").getText());

				}

			}

		}
		return list;
   }
   
   private List<String>  shuaiElection(List<String> list,Element ele,String conditionOne,String conditionTwo){
	   for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {

			ele = it.next();

			String name = ele.attribute("name").getText();

			if (name.equals(conditionOne)) {

				List<Element> myList = ele.elements();

				for (Iterator<Element> its = myList.iterator(); its.hasNext();) {

					ele = its.next();

					name = ele.attribute("name").getText();

					if (name.equals(conditionTwo)) {

						myList = ele.elements();

						for (Iterator<Element> itss = myList.iterator(); itss.hasNext();) {

							list.add(itss.next().attribute("name").getText());
						}

					}

				}

			}

		}
		return list;
   }
   
   public  String getName(String condition) {
	   SAXReader reader = new SAXReader();
		 InputStream is= this.getClass().getResourceAsStream("/static/imgAddress.xml");
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
