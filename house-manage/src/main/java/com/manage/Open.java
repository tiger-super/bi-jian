package com.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
@MapperScan(value="com.manage.dao")
@SpringBootApplication
public class Open {
	public static void main(String[] args) {
	   	 SpringApplication.run(Open.class,args);
	   	 System.out.println("后台已启动");
	}

}
