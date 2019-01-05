package com.house.demo;


import com.alibaba.dubbo.config.annotation.Service;
import com.house.entity.Customer;
@Service(version="1.0.0")
public class DemoServiceImpl implements DemoService {

	@Override
	public String sayHello(String name) {
		return "Hello"+name;
	}

}
