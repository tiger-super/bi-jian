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
import com.house.entity.AuditingFail;
import com.house.entity.Device;
import com.house.entity.House;
import com.house.entity.HouseInfo;
import com.house.entity.Page;
import com.house.mapper.CollectionManagementMapper;
import com.house.mapper.CustomerManagementMapper;
import com.house.mapper.DeviceManagementMapper;
import com.house.mapper.HouseManagementMapper;
import com.house.tool.AnalysisXML;
import com.house.tool.FileUtil;
import com.house.tool.PhoneAddressCreate;
import com.house.tool.SocketTool;
import com.house.tool.Time;

@Service
public class HouseServiceImpl implements HouseService {
	@Autowired
	HouseManagementMapper houseManagementMapper;
	@Autowired
	DeviceManagementMapper deviceManagementMapper;
	@Autowired
	CollectionManagementMapper collectionManagementMapper;
	@Autowired
	CustomerManagementMapper  customerManagementMapper;
	@Autowired
	AnalysisXML ax;
    @Autowired
    FileUtil fu;
	// 房源发布
	@Override
	public String housePublish(String folder, House house) {
		//获得缓存路径
		String readPath = ax.getName(AnalysisXML.HOUSECACHEKEEP);
		//拿到缓存图片
		List<byte[]> list = fu.readImg(folder, readPath);
		//获得保存地址
		String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		//创建新的文件夹
		String houseFolder = PhoneAddressCreate.createAddress(house.getHousePublisherId());
		//对象保存文件夹
		house.getHouseInfo().setHouseImageAddress(houseFolder);
		for (int i = 0; i < list.size(); i++) {
			//给各张图片创建名字
			String houseImageAddress = PhoneAddressCreate.createAddress(house.getHousePublisherId());
			StringBuffer path = new StringBuffer();
				path.append(houseKeepAddress + houseFolder);
				//创建文件夹
				fu.createFolder(path.toString());
				path.append("/" + houseImageAddress + ".jpg");
				try {
					FileUtil.fileupload(list.get(i), path.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
		for(int i = 0 ; i < list.size() ; i++) {
			House value = list.get(i);
			String imageFolder = value.getHouseInfo().getHouseImageAddress();
			value.getHouseInfo().setHouseImageAddress(FileUtil.getObjectImgVisitPath(imageFolder, houseVisitAddress, houseKeepAddress));
		}
		result.put("list", list);
		result.put("page", page);
		result.put("result", true);
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
		for(int i = 0 ; i < list.size() ; i++) {
			House value = list.get(i);
			String imageFolder = value.getHouseInfo().getHouseImageAddress();
			value.getHouseInfo().setHouseImageAddress(FileUtil.getObjectImgVisitPath(imageFolder, houseVisitAddress, houseKeepAddress));
		}
		result.put("list", list);
		result.put("page", page);
		return result;
	}

	@Override
	public Map<String,Object> ModifyHouseState(House house) {
		System.out.println(house);
		Map<String,Object> map = new HashMap<String,Object>();
		String ifBlack = customerManagementMapper.ifExistBlack(house.getHousePublisherId());
		if("1".equals(ifBlack)) {
			map.put("result",false);
			map.put("text","你已被列入黑名单");
		}else {
		if (house.getHousePublisherState() != null && "1".equals(house.getHousePublisherState())) {
			house.setHousePublisherTime(Time.getNowTime());
		}
		int result = houseManagementMapper.updateHouseState(house);
		if (result == 1) {
			SocketTool st = new SocketTool();
			st.updateSendSocket("house");
			map.put("result",true);
		} else {
			map.put("result",false);
			map.put("text","系统发生了未知错误");
		}
		}
		return map;
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

	@Override
	public Map<String, Object> houseReasonService(String houseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		AuditingFail af = houseManagementMapper.selectFailReasonFromHouseId(houseId);
		if (af != null) {
			map.put("reason", af);
			map.put("result", true);
		} else {
			map.put("result", false);
		}
		return map;
	}

	@Override
	public List<String> cacheHouseImg(byte[] houseImg, String folder,String suffixName,String id) {
		String cacheAddress = ax.getName(AnalysisXML.HOUSECACHEKEEP);
		// 图片保存
		fu.keepImg(houseImg, folder, suffixName, cacheAddress,id);
		// 访问缓存图片
		List<String> imgVisit = fu.cacheVistPath(folder, ax.getName(AnalysisXML.HOUSECACHEVISIT), cacheAddress);
		return imgVisit;
	}

	@Override
	public Map<String, Object> againHouseService(String houseId) {
		Map<String,Object> map = new HashMap<String,Object>();
		House house = getHouseInformation(houseId);
		String folder = house.getHouseInfo().getHouseImageAddress();
		map.put("folder",folder);
		map.put("house",house);
		StringBuffer houseKeepFolderPath = new StringBuffer();
		houseKeepFolderPath.append(ax.getName(AnalysisXML.HOUSEKEEPADDRESS)).append(folder);
		List<String> houseImgS = fu.getFolderValue(houseKeepFolderPath.toString());
		StringBuffer cacheFolder = new StringBuffer();
		cacheFolder.append(ax.getName(AnalysisXML.HOUSECACHEKEEP)).append(folder);
		fu.createFolder(cacheFolder.toString());
		StringBuffer cacheVisitFolder = new StringBuffer();
		cacheVisitFolder.append(ax.getName(AnalysisXML.HOUSECACHEVISIT)).append(folder);
		List<String> houseImgVisit = new ArrayList<String>();
		for(int i = 0 ; i < houseImgS.size() ; i++) {
			String img = houseImgS.get(i);
			StringBuffer houseImgPath = new StringBuffer();
			StringBuffer houseImgCachePath = new StringBuffer();
			houseImgPath.append(houseKeepFolderPath.toString()).append("/").append(img);
			houseImgCachePath.append(cacheFolder.toString()).append("/").append(img);
			byte[] houseImageBinary = FileUtil.getImageBinary(houseImgPath.toString());
			try {
				FileUtil.fileupload(houseImageBinary, houseImgCachePath.toString());
				StringBuffer houseImgVisitPath = new StringBuffer();
				houseImgVisitPath.append(cacheVisitFolder.toString()).append("/").append(img);
				houseImgVisit.add(houseImgVisitPath.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		map.put("list",houseImgVisit);
		return map;
	}

	@Override
	public void deleteAndUpdateInformation(String houseId) {
		houseManagementMapper.deleteHouseHouseInfoWithId(houseId);
		houseManagementMapper.deleteHouseWithId(houseId);
		deviceManagementMapper.deleteDeviceWithId(houseId);
	}
	
}
