package com.house.demo.customer;

import java.util.Map;

import com.house.entity.Customer;

public interface RegisterAndLoginService {
	// 注册服务
	public Map<String, String> registerService(Customer customer);

	// 登录服务
	public String loginSystemService(Customer customer);
}
