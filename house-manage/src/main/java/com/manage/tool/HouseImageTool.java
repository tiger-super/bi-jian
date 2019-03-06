package com.manage.tool;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.house.entity.House;

public class HouseImageTool {
	public String getHouseImage(String path) {
		File file = null;
		StringBuffer sb = new StringBuffer();
		try {
			file = new File(new File("").getCanonicalPath() + "/src/main/resources/static/publish-house-img/"+ path);
			String[] contents = file.list();
			sb.append(path+"/"+contents[0]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	public void getHouseImages() {

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
	public String getProjectPath() {
		File file = new File(HouseImageTool.class.getResource("/").getFile());
		File f = file.getParentFile().getParentFile().getParentFile();
		return f.toString();
	}
}
