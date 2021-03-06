package com.manage.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.house.entity.Employee;
import com.house.entity.Page;
import com.manage.dao.EmployeeManageDao;
import com.manage.service.EmployeeManageService;
import com.manage.tool.AnalysisXML;
import com.manage.tool.EmployeeAddressCreate;
import com.manage.tool.FileUtil;
import com.manage.tool.ImageTool;
import com.manage.tool.Time;

@Service
public class EmployeeManageServiceImpl implements EmployeeManageService {
	@Autowired
	FileUtil fileUtil;
	@Autowired
	EmployeeManageDao employeeManageDao;
	@Autowired
	ImageTool hit;
	@Autowired
	AnalysisXML ax;

	@Override
	public String cacheEmployeeImg(MultipartFile multipartFile) {
		// 获取文件名称,包含后缀
		String fileName = multipartFile.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String employeeImgAddress = fileUtil.cacheFile(suffix, multipartFile);
		return employeeImgAddress;
	}

	@Override
	public String addEmployeeService(Employee employee) {
		try {
			fileUtil.deleteFile(employee.getEmployeeImgAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		employee.setEntryTime(Time.getNowTimeforYearAndMonthAndDay());
		int employeeId = employeeManageDao.insertEmployee(employee);
		return String.valueOf(employeeId);
	}

	@Override
	public Map<String, Object> getEmployee(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageTotal = employeeManageDao.selectTotalEmployee();
		if (pageTotal == 0) {
			return map;
		}
		double max = (double) pageTotal / page.getPageNumber();
		int pageMax = (int) Math.ceil(max);
		page.setPageMax(pageMax);
		if (pageMax < page.getPageCurrent()) {
			page.setPageCurrent(pageMax);
		}
		page.setPageShowNow((page.getPageCurrent() - 1) * page.getPageNumber());
		List<Employee> list = employeeManageDao.selectAllEmployee(page);
		hit.getEmployeeImage(list);
		page.setPageTotal(pageTotal);
		map.put("page", page);
		map.put("list", list);
		return map;
	}

	@Override
	public boolean modifyPasswordService(Employee employee) {
		int result = employeeManageDao.updateEmployeePassword(employee);
		if (result == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Map<String, Object> getEmployeeWithEmployeeId(String employeeId) {
		Map<String, Object> map = new HashMap<String, Object>();
		Employee employee = employeeManageDao.quaryEmployeeFromEmployeeId(employeeId);
		if (employee == null) {
			map.put("result", false);
		} else {
			StringBuffer visit = new StringBuffer();
			visit.append(ax.getName(AnalysisXML.EMPLOYEEVISITADDRESS));
			visit.append(employee.getEmployeeImgAddress());
			employee.setEmployeeImgAddress(visit.toString());
			map.put("result", true);
			map.put("employee", employee);
		}
		return map;
	}

	@Override
	public Map<String, String> modifyEmployeeImg(MultipartFile multipartFile,Employee employee) {
		 Map<String, String> map = new HashMap<String,String>();
		// 获取文件名称,包含后缀
		String fileName = multipartFile.getOriginalFilename();
		String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		StringBuffer imgKeepAddress = new StringBuffer();
		imgKeepAddress.append(ax.getName(AnalysisXML.EMPLOYEEKEEPADDRESS));
		String img = EmployeeAddressCreate.createAddress();
		imgKeepAddress.append(img).append(suffix);	
		employee.setEmployeeImgAddress(img+suffix);
		try {
			fileUtil.fileupload(multipartFile.getBytes(),imgKeepAddress.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuffer oldImg = new StringBuffer();
		oldImg.append(ax.getName(AnalysisXML.EMPLOYEEKEEPADDRESS)).append(employeeManageDao.quaryEmployeeFromEmployeeId(employee.getEmployeeId()).getEmployeeImgAddress());
		StringBuffer imgVisitAddress = new StringBuffer();
		imgVisitAddress.append(ax.getName(AnalysisXML.EMPLOYEEVISITADDRESS)).append(img).append(suffix);
		map.put("imgVisitAddress", imgVisitAddress.toString());
		int result = employeeManageDao.updateEmployeeImg(employee);
		if(result == 1) {
			map.put("result","true");
			
			new File(oldImg.toString()).delete();
		}else {
			map.put("result","false");
		}
		return map;
	}

	@Override
	public Map<String, Boolean> modifyEmployeeInfo(Employee employee) {
		Map<String, Boolean> map = new HashMap<String,Boolean>();
		int result = employeeManageDao.updateEmployeeInformation(employee);
		if(result == 1) {
			map.put("result",true);
		}else {
			map.put("result",false);
		}
		return map;
	}

}
