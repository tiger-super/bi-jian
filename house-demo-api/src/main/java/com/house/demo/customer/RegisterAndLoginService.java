package com.house.demo.customer;

import com.house.entity.Customer;

public interface RegisterAndLoginService {
    // 注册服务
	String registerService(Customer customer); 
	// 登录服务
	String loginSystemService(Customer customer);
}
