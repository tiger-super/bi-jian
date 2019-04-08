package com.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.entity.Customer;
import com.house.entity.Page;
import com.house.entity.Pay;
import com.manage.dao.VipManageDao;
import com.manage.service.VipManageService;
import com.manage.tool.ImageTool;
@Service
public class VipManageServiceImpl implements VipManageService {
	@Autowired
	VipManageDao vipManageDao;
	@Autowired
	ImageTool it;
	@Override
	public Map<String, Object> vipInformation(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageTotal = vipManageDao.accountAllVipCustomer();
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
		List<Customer> list = vipManageDao.selectAllVipCustomer(page);
		list = it.getCustomerImageList(list);
		page.setPageTotal(pageTotal);
		map.put("page", page);
		map.put("list", list);
		return map;
	}
	@Override
	public Customer selectVipFromId(Customer customer) {		
	Customer result = vipManageDao.seletctVipCustomerAccordingId(customer);
	result.setCustomerHeadImageAddress(it.getCustomerImg(result.getCustomerHeadImageAddress()));
	return result;
	}
	@Override
	public Map<String, Object> vipOrderServer(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		int pageTotal = vipManageDao.accountVipOrder();
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
		List<Pay> list = vipManageDao.queryAllVipOrder(page);
		page.setPageTotal(pageTotal);
		map.put("page", page);
		map.put("list", list);
		map.put("result",true);
		return map;
	}

}
