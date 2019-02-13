package com.house.demo.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.house.HouseService;
import com.house.entity.Device;
import com.house.entity.House;
import com.house.entity.HouseInfo;
import com.house.mapper.DeviceManagementMapper;
import com.house.mapper.HouseManagementMapper;
import com.house.tool.FileUtil;
import com.house.tool.PhoneAddressCreate;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseManagementMapper houseManagementMapper;
	@Autowired
	DeviceManagementMapper deviceManagementMapper;

	// 房源发布
	@Override
	public String housePublish(List<byte[]> list, House house) {
		String houseFolder = PhoneAddressCreate.createAddress(house.getHousePublisherId());
		house.getHouseInfo().setHouseImageAddress(houseFolder);
		for (int i = 0; i < list.size(); i++) {
			String houseImageAddress = PhoneAddressCreate.createAddress(house.getHousePublisherId());
			// 本地路径
			StringBuffer path = new StringBuffer();
			// 类路径
			StringBuffer classPath = new StringBuffer();
			try {
				path.append(new File("").getCanonicalPath() + "/src/main/resources/static/publish-house-img" + "/"
						+ houseFolder);
				new File(path.toString()).mkdirs();
				path.append("/" + houseImageAddress + ".jpg");
				classPath.append(ClassUtils.getDefaultClassLoader().getResource("").getPath()
						+ "/static/publish-house-img" + "/" + houseFolder);
				new File(classPath.toString()).mkdirs();
				classPath.append("/" + houseImageAddress + ".jpg");
				FileUtil.fileupload(list.get(i), path.toString());
				FileUtil.fileupload(list.get(i), classPath.toString());
			} catch (IOException e) {
				e.printStackTrace();
				return "false";
			}

		}

		houseManagementMapper.insertHouse(house);
		houseManagementMapper.insertHouseInfo(house);
		deviceManagementMapper.inserDeviceInfo(house);
		return "true";
	}

	// 获取房源信息
	@Override
	public House getHouseInformation(String houseId) {
		House house = houseManagementMapper.selectHouseAccordingHouseId(houseId);
		HouseInfo houseInfo = houseManagementMapper.selectHouseInfoAccordingHouseId(houseId);
		house.setHouseInfo(houseInfo);
		Device device = deviceManagementMapper.selectDeviceInfoAccordingHouseId(houseId);
		house.setDevice(device);
		return house;
	}

	// 获取房源的图片信息
	@Override
	public List<String> getHouseImageInfo(String houseImageAddress) {
		List<String> list = new ArrayList<String>();
		try {
			File file = new File(new File("").getCanonicalPath() + "/src/main/resources/static/publish-house-img" + "/"
					+ houseImageAddress);
			String[] images = file.list();
			for (int i = 0; i < images.length; i++) {
				list.add(images[i]);
			}
			return list;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<House> getHouseFromProvinceAndCityAndAreaAndSortAndOtherCondition(House house, String sort,
			String Condition) {

		return null;
	}
}
