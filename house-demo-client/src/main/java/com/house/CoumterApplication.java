package com.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.annotation.Reference;
@SpringBootApplication
public class CoumterApplication {
    public static void main(String[] args) {
    	 SpringApplication.run(CoumterApplication.class,args);
    }
} 
