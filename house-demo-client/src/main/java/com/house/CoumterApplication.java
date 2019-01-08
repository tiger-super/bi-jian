package com.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.alibaba.dubbo.config.annotation.Reference;
import com.house.demo.customer.PersonInfoService;
@SpringBootApplication
public class CoumterApplication {
    public static void main(String[] args) {
    	 SpringApplication.run(CoumterApplication.class,args);
    }
} 
