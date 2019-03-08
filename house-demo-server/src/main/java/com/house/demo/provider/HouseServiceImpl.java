package com.house.demo.provider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.house.HouseService;
import com.house.entity.Device;
import com.house.entity.House;
import com.house.entity.HouseInfo;
import com.house.entity.Page;
import com.house.mapper.DeviceManagementMapper;
import com.house.mapper.HouseManagementMapper;
import com.house.tool.AnalysisXML;
import com.house.tool.FileUtil;
import com.house.tool.PhoneAddressCreate;
import com.house.tool.Time;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseManagementMapper houseManagementMapper;
	@Autowired
	DeviceManagementMapper deviceManagementMapper;
	@Autowired
	AnalysisXML ax;

	// 房源发布
	@Override
	public String housePublish(List<byte[]> list, House house) {
		String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		String houseFolder = PhoneAddressCreate.createAddress(house.getHousePublisherId());
		house.getHouseInfo().setHouseImageAddress(houseFolder);
		for (int i = 0; i < list.size(); i++) {
			String houseImageAddress = PhoneAddressCreate.createAddress(house.getHousePublisherId());
			// 本地路径
			StringBuffer path = new StringBuffer();
			try {
				path.append(houseKeepAddress+ houseFolder);
				new File(path.toString()).mkdirs();
				path.append("/" + houseImageAddress + ".jpg");
				FileUtil.fileupload(list.get(i), path.toString());
			} catch (IOException e) {
				e.printStackTrace();
				return "false";
			}

		}
        house.setApplicationTime(Time.getNowTime());
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
		String houseVisitAddress = ax.getName(AnalysisXML.HOUSEVISITADDRESS);
		String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		File file = new File(houseKeepAddress + houseImageAddress);
		String[] images = file.list();
		for (int i = 0; i < images.length; i++) {
			StringBuffer visitPath = new StringBuffer();
			visitPath.append(houseVisitAddress + houseImageAddress);
			list.add(visitPath.append("/" + images[i]).toString());
		}
		return list;
	}

	@Override
	public Map<String, Object> getHouseFromProvinceAndCityAndAreaAndSortAndOtherCondition(House house, String sort,
			String Condition, Page page) {
		String houseVisitAddress = ax.getName(AnalysisXML.HOUSEVISITADDRESS);
		String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		List<House> list = null;
		Map<String, Object> map = new HashMap<String, Object>();
		page.setPageShowNow((page.getPageCurrent() - 1) * page.getPageNumber());
		map.put("page", page);
		if ("default".equals(Condition) && sort == null) {
			map.put("house", house);
			list = houseManagementMapper.selectHousesFromProvinceAndCityAndArea(map);
		} else {
			if (Condition != null) {
				HouseInfo houseInfo = house.getHouseInfo();
				switch (Condition) {
				case "houseSize":
					houseInfo.setHouseSize("true");
					break;
				case "houseMoney":
					houseInfo.setHouseMoney("true");
					break;
				}
				house.setHouseInfo(houseInfo);
				map.put("house", house);
			}
			if (sort != null) {
				switch (sort) {
				case "0":
					list = houseManagementMapper.selectHousesFromProvinceAndCityAndAreaAndSortToAsc(map);
					break;
				case "1":
					list = houseManagementMapper.selectHousesFromProvinceAndCityAndAreaAndSortToDesc(map);
					break;
				}
			}
		}
		page.setPageTotal(houseManagementMapper.getHouseInformationTotal(house));
		page.setPageMax((int) Math.ceil((double) page.getPageTotal() / page.getPageNumber()));
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", FileUtil.readHouseImg(list, houseVisitAddress, houseKeepAddress));
		result.put("page", page);
		return result;
	}

	@Override
	public Map<String, Object> publishManageService(House house, Page page) {
		String houseVisitAddress = ax.getName(AnalysisXML.HOUSEVISITADDRESS);
		String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("house", house);
		page.setPageShowNow((page.getPageCurrent() - 1) * page.getPageNumber());
		map.put("page", page);
		List<House> list = houseManagementMapper.selectPublishSituation(map);
		page.setPageTotal(houseManagementMapper.selectPublishSituationTotal(house));
		page.setPageMax((int) Math.ceil((double) page.getPageTotal() / page.getPageNumber()));
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("list", FileUtil.readHouseImg(list, houseVisitAddress, houseKeepAddress));
		result.put("page", page);
		return result;
	}

	@Override
	public boolean ModifyHouseState(House house) {
		if (house.getHousePublisherState() != null && "1".equals(house.getHousePublisherState())) {
			house.setHousePublisherTime(Time.getNowTime());
		}
		int result = houseManagementMapper.updateHouseState(house);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteHouseService(House house) {
		int result = houseManagementMapper.deleteHouseDao(house);

		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}
}
