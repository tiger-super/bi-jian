package com.house.mapper;

import org.springframework.stereotype.Repository;

import com.house.entity.Customer;
@Repository
public interface PersonInfoManagementMapper {
   // 修改密码
	int updatePassword(Customer customer);
	// 修改用户名
	int updateName(Customer customer);
	
	// 修改年龄
	int updateAge(Customer customer);
	// 修改性别
	int updateSex(Customer customer);
	// 修改邮箱
	int updateMailbox(Customer customer);
}
