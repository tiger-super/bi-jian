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
	
	// 查询用户的id和姓名
	Customer selectCustomerIdAndCustomerName(Customer customer);
	
	// 根据id查询用户的所有信息
	Customer selectCustomerAllInfoFromId(Customer customer);

	// 根据id查询图片地址
	String selectPhotoAddressFromId(String id);
	
	// 更新图片地址
	int updatePhotoAddressFromId(Customer customer);
		
	
	// 查询用户的id和邮箱
	Customer selectCustomerIdAndMail(Customer customer);
}
