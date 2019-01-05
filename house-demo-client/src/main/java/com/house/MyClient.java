package com.house;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.house.demo.DemoService;



public class MyClient {
	  public static void main(String[] args) {
    	 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]
    			 {"consumer.xml"});
    	 context.start();
    	 DemoService demoService = (DemoService)context.getBean("demoService");
    	 System.out.println(demoService.sayHello("我是dubbo客户端"));
     }
}
