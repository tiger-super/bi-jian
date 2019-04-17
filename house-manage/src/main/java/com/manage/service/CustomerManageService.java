package com.manage.service;

import java.util.Map;

import com.house.entity.Customer;
import com.house.entity.Page;

public interface CustomerManageService {
	// 获取用户信息服务
	Map<String,Object> loadCustomerInformationService(Page page);
	// 获取黑名单用户信息服务
	Map<String,Object> loadBlackCustomerInformationService(Page page);
	// 黑名单管理
	 Map<String,Object> blackManageService(int pageCurrent,String condition,String customerId);
    // 根据客户id查询客户
	 Map<String,Object> getCustomerWithCustomerId(Customer customer);
}
