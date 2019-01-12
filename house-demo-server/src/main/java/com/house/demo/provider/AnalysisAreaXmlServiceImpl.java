package com.house.demo.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.area.AnalysisAreaXmlService;

@Service
public class AnalysisAreaXmlServiceImpl implements AnalysisAreaXmlService {
	@Override
	public Map<String,List<String>> analysisAreaXml() {
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		List<String> key = analysisAreaXmlGainProvince();
		for(int i = 0 ; i < key.size() ;i++) {
		List<String> value = analysisAreaXmlGainCity(key.get(i));
		map.put(key.get(i), value);
		}
		return map;
	}

	@Override
	public List<String> analysisAreaXmlGainArea(String province, String city) {
		List<String> list = new ArrayList<String>();

		File file = new File(
				AnalysisAreaXmlServiceImpl.class.getClassLoader().getResource("static/area/areaName.xml").getPath());

		SAXReader reader = new SAXReader();

		Document document;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			return null;
		}

		Element ele = document.getRootElement();

		for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {

			ele = it.next();

			String name = ele.attribute("name").getText();

			if (name.equals(province)) {

				List<Element> myList = ele.elements();

				for (Iterator<Element> its = myList.iterator(); its.hasNext();) {

					ele = its.next();

					name = ele.attribute("name").getText();

					if (name.equals(city)) {

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

	@Override
	public List<String> analysisAreaXmlGainCity(String province) {
		List<String> list = new ArrayList<String>();

		File file = new File(
				AnalysisAreaXmlServiceImpl.class.getClassLoader().getResource("static/area/areaName.xml").getPath());

		SAXReader reader = new SAXReader();

		Document document;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			return null;
		}

		Element ele = document.getRootElement();

		for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {

			ele = it.next();

			String name = ele.attribute("name").getText();

			if (name.equals(province)) {

				List<Element> myList = ele.elements();

				for (Iterator<Element> its = myList.iterator(); its.hasNext();) {

					list.add(its.next().attribute("name").getText());

				}

			}

		}

		return list;

	}

	@Override
	public List<String> analysisAreaXmlGainProvince() {
		List<String> list = new ArrayList<String>();

		File file = new File(
				AnalysisAreaXmlServiceImpl.class.getClassLoader().getResource("static/area/areaName.xml").getPath());

		SAXReader reader = new SAXReader();

		Document document;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			return null;
		}

		Element ele = document.getRootElement();

		for (Iterator<Element> it = ele.elements().iterator(); it.hasNext();) {

			list.add(it.next().attribute("name").getText());

		}

		return list;

	}

}