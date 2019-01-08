package com.house;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;

import com.house.demo.customer.PersonInfoService;
@SpringBootApplication
@MapperScan(value="com.house.mapper")
public class ServiceApplication {
    public static void main(String[] args) {
    	 SpringApplication.run(ServiceApplication.class,args);
    	 System.out.println("服务启动");
    }
} 
