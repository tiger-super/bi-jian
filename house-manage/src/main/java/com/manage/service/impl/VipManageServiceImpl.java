package com.manage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.entity.Customer;
import com.house.entity.Page;
import com.manage.dao.CustomerManageDao;
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
		int pageTotal = vipManageDao.accountAllVip();
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
		List<Customer> list = vipManageDao.selectAllVip(page);
		list = it.getCustomerImageList(list);
		page.setPageTotal(pageTotal);
		map.put("page", page);
		map.put("list", list);
		return map;
	}

}
