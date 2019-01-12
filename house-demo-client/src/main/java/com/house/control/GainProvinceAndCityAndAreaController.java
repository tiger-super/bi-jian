package com.house.control;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.area.AnalysisAreaXmlService;

@Controller
@RequestMapping("/house")
public class GainProvinceAndCityAndAreaController {
	@Reference
	AnalysisAreaXmlService analysisAreaXmlService;
	@RequestMapping("/gain/province/and/city")
	@ResponseBody
    public Map<String,List<String>> gainProvinceAndCity(){
    	return analysisAreaXmlService.analysisAreaXml();
    }
	@RequestMapping("/gain/province")
	@ResponseBody
    public List<String> gainProvince(){
    	return analysisAreaXmlService.analysisAreaXmlGainProvince();
    }
	@RequestMapping("/gain/city")
	@ResponseBody
    public List<String> gainCity(String province){
    	return analysisAreaXmlService.analysisAreaXmlGainCity(province);
    }
	@RequestMapping("/gain/area")
	@ResponseBody
    public List<String> gainArea(String province,String city){
    	return analysisAreaXmlService.analysisAreaXmlGainArea(province,city);
    }
}
