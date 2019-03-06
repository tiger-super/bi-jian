package com.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class CoumterApplication {
    public static void main(String[] args) {
    	 SpringApplication.run(CoumterApplication.class,args);
    	 System.out.println("客户端启动");
    }
} 
