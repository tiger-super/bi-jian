package com.house.demo.area;

import java.util.List;
import java.util.Map;

public interface AnalysisAreaXmlService {
	// 解析xml获得所有省市的内容
    public Map<String,List<String>> analysisAreaXml();
    // 解析xml获得所有省
    public List<String> analysisAreaXmlGainProvince();
    // 解析xml获得所有市
    public List<String> analysisAreaXmlGainCity(String province);
    // 解析xml获得所有区
    public List<String> analysisAreaXmlGainArea(String province,String city);
}
