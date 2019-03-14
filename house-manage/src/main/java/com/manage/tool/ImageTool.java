package com.manage.tool;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.house.entity.Customer;
import com.house.entity.Employee;
import com.house.entity.House;

@Component
public class ImageTool {
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

	public String getEmployeeImg(String path) {
		StringBuffer visit = new StringBuffer();
		String employeeVisitAddress = ax.getName(AnalysisXML.EMPLOYEEVISITADDRESS);
		visit.append(employeeVisitAddress).append(path);
		return visit.toString();
	}

	public List<String> getHouseImages(String path) {
		List<String> list = new ArrayList<String>();
		StringBuffer keep = new StringBuffer();
		String houseKeepAddress = ax.getName(AnalysisXML.HOUSEKEEPADDRESS);
		keep.append(houseKeepAddress).append(path);
		File file = new File(keep.toString());
		String[] result = file.list();
		for (int i = 0; i < result.length; i++) {
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

	public List<Customer> getCustomerImageList(List<Customer> list) {
		for (int i = 0; i < list.size(); i++) {
			Customer customer = list.get(i);
			StringBuffer visit = new StringBuffer();
			String customerVisitAddress = ax.getName(AnalysisXML.CUSTOMERVISITADDRESS);
			String customerImg = customer.getCustomerHeadImageAddress();
			if (customerImg == null) {
				customerImg = "/static/img/renyuanzengjia.png";
				customer.setCustomerHeadImageAddress(customerImg);
			} else {

				visit.append(customerVisitAddress).append(customerImg);
				customer.setCustomerHeadImageAddress(visit.toString());
			}
		}
		return list;
	}
	public void getEmployeeImage(List<Employee> list) {
		int length = list.size();
		if (length > 0) {
			for (int i = 0; i < length; i++) {
				StringBuffer employeeVisit = new StringBuffer();
				employeeVisit.append(ax.getName(AnalysisXML.EMPLOYEEVISITADDRESS));
				Employee employee = list.get(i);
				employeeVisit.append(employee.getEmployeeImgAddress()); 
				employee.setEmployeeImgAddress(employeeVisit.toString());
			}
		}
	}
}
