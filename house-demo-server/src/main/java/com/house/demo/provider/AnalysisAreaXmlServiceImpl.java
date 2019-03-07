package com.house.demo.provider;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.area.AnalysisAreaXmlService;
import com.house.tool.AnalysisXML;
import com.house.tool.PinyinComparator;

@Service
public class AnalysisAreaXmlServiceImpl implements AnalysisAreaXmlService {
	@Autowired
	AnalysisXML ax;
	@Autowired
	PinyinComparator pc;
	
	@Override
	public Map<String, List<String>> analysisAreaXml() {
		Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		String[] province = PinyinComparator.getStringArray(analysisAreaXmlGainProvince());
		List<String> key = Arrays.asList(province);
		Arrays.sort(province,pc);
		for (int i = 0; i < key.size(); i++) {
			String[] city = PinyinComparator.getStringArray(analysisAreaXmlGainCity(key.get(i)));
			List<String> value = Arrays.asList(city);
			Arrays.sort(city,pc);
			String deleteSuffixKey = PinyinComparator.deleteSuffix(key.get(i));
			map.put(deleteSuffixKey, value);
		}
		return map;
	}

	@Override
	public List<String> analysisAreaXmlGainArea(String province, String city) {
		return ax.threeLevelAnalysis("/static/area/areaName.xml",province,city);

	}

	@Override
	public List<String> analysisAreaXmlGainCity(String province) {
		return ax.twoLevelAnalysis("/static/area/areaName.xml",province);

	}

	@Override
	public List<String> analysisAreaXmlGainProvince() {
		return ax.oneLevelAnalysis("/static/area/areaName.xml");

	}

	@Override
	public Map<String, List<String>> sortPinyin() {
		List<String> list = analysisAreaXmlGainProvince();
		return 	pc.getSortPinyin(list);
	}
	
	
}