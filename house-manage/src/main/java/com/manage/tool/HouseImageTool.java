package com.manage.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.house.entity.House;
@Component
public class HouseImageTool {
	@Autowired
	AnalysisXML ax;
	private String getHouseImage(String path) {
		StringBuffer visit = new StringBuffer();
	    String houseVisitAddress = ax.getName(AnalysisXML.HOUSEVISITADDRESS);
	    visit.append(houseVisitAddress).append(path);
	    StringBuffer keep = new StringBuffer();
	    String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS); 
	    keep.append(houseKeepAddress).append(path);
	    String image = getImage(keep.toString());
	    visit.append("/").append(image);
		return visit.toString();
	}

	public void getHouseImages() {

	}
	public List<String> getHouseImages(String path) {
		List<String> list = new ArrayList<String>();
	    StringBuffer keep = new StringBuffer();
	    String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS); 
	    keep.append(houseKeepAddress).append(path);
	    File file = new File(keep.toString());
		String[] result = file.list();
		for(int i = 0 ; i < result.length ; i++) {
			StringBuffer visit = new StringBuffer();
			String houseVisitAddress = ax.getName(AnalysisXML.HOUSEVISITADDRESS);
			visit.append(houseVisitAddress).append(path);
			visit.append("/").append(result[i]);
			list.add(visit.toString());
		}
		return list;
	}
	public void getHouseImage(List<House> list) {
		int length = list.size();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				House house = list.get(i);
				String houseImageAddress = getHouseImage(house.getHouseInfo().getHouseImageAddress());
				house.getHouseInfo().setHouseImageAddress(houseImageAddress);
			}
		}
	}
	private String getImage(String path) {
		File file = new File(path);
		String[] result = file.list();
		return result[0];
	}
}
