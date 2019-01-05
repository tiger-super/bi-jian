package com.house.control;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.DemoService;
@RestController
@RequestMapping("demo")
public class HelloWorldServlet {
	@Reference(version="1.0.0")
	DemoService demoService ;
	 @RequestMapping("index")
    public String say() {
 
    	return demoService.sayHello("tiger");
    }
}
