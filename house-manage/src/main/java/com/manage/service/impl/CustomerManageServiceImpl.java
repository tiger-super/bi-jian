package com.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.house.entity.Customer;
import com.house.entity.House;
import com.house.entity.Page;
import com.manage.dao.CustomerManageDao;
import com.manage.dao.HouseManageDao;
import com.manage.service.CustomerManageService;
import com.manage.tool.AnalysisXML;
import com.manage.tool.ImageTool;

@Service
public class CustomerManageServiceImpl implements CustomerManageService {
	@Autowired
	CustomerManageDao customerManageDao;
	@Autowired
	HouseManageDao houseManageDao;
	@Autowired
	ImageTool it;
	@Autowired
	AnalysisXML ax;

	@Override
	public Map<String, Object> loadCustomerInformationService(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageTotal = customerManageDao.totalAllCustomer();
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
		List<Customer> list = customerManageDao.selectAllCustomer(page);
		list = it.getCustomerImageList(list);
		page.setPageTotal(pageTotal);
		map.put("page", page);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> loadBlackCustomerInformationService(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageTotal = customerManageDao.totalAllBlackCustomer();
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
		List<Customer> list = customerManageDao.selectAllBlackCustomer(page);
		list = it.getCustomerImageList(list);
		page.setPageTotal(pageTotal);
		map.put("page", page);
		map.put("list", list);
		return map;
	}

	@Override
	public Map<String, Object> blackManageService(int pageCurrent, String condition, String customerId) {
		Map<String, Object> map = new HashMap<String, Object>();
		int result = 0;
		int pageTotal = 0;
		Page page = new Page();
		House house = new House();
		house.setHousePublisherId(customerId);
		switch (condition) {
		case "1":
			house.setHousePublisherState("0");
			result = customerManageDao.addBlack(customerId);
			pageTotal = customerManageDao.totalAllCustomer();
			houseManageDao.updateHousePublisherStateFormPublisherId(house);
			break;
		case "0":
			result = customerManageDao.deleteBlack(customerId);
			pageTotal = customerManageDao.totalAllBlackCustomer();
			break;
		}

		double max = (double) pageTotal / page.getPageNumber();
		int pageMax = (int) Math.ceil(max);
		page.setPageTotal(pageTotal);
		page.setPageMax(pageMax);
		if (pageMax < pageCurrent) {
			page.setPageCurrent(pageMax);
		}
		if (result == 1) {
			map.put("result", true);
		} else {
			map.put("result", false);
		}
		map.put("page", page);
		return map;
	}

	@Override
	public Map<String, Object> getCustomerWithCustomerId(Customer customer) {
		Map<String, Object> map = new HashMap<String, Object>();
		Customer result = customerManageDao.selectCustomerWithId(customer);
		if (result == null) {
			map.put("result", false);
		} else {
			StringBuffer visit = new StringBuffer();
			visit.append(ax.getName(AnalysisXML.CUSTOMERVISITADDRESS));
			String customerHeadImageAddress = result.getCustomerHeadImageAddress();
			if (customerHeadImageAddress == null) {
				visit.append("static/img/renyuanzengjia.png");
			} else {
				visit.append(customerHeadImageAddress);
			}
			result.setCustomerHeadImageAddress(visit.toString());
			map.put("result", true);
			map.put("customer", result);
		}
		return map;
	}

	@Override
	public Map<String, Object> getBlackCustomerWithCustomerId(Customer customer) {
		Map<String, Object> map = new HashMap<String, Object>();
		Customer result = customerManageDao.selectBlackCustomerWithId(customer);
		if (result == null) {
			map.put("result", false);
		} else {
			StringBuffer visit = new StringBuffer();
			visit.append(ax.getName(AnalysisXML.CUSTOMERVISITADDRESS));
			String customerHeadImageAddress = result.getCustomerHeadImageAddress();
			if (customerHeadImageAddress == null) {
				visit.append("static/img/renyuanzengjia.png");
			} else {
				visit.append(customerHeadImageAddress);
			}
			result.setCustomerHeadImageAddress(visit.toString());
			map.put("result", true);
			map.put("customer", result);
		}
		return map;
	}

}
