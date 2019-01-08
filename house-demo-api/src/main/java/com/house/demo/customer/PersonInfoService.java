package com.house.demo.customer;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

import com.house.entity.Customer;

public interface PersonInfoService {
   // 修改用户名
	public String modifyCustomerName(Customer customer);
	// 修改用户性别
	public String modifyCustomerSex(Customer customer);
	// 修改用户年龄
	public String modifyCustomerAge(Customer customer);
	// 修改用户邮箱
	public String modifyCustomerMailbox(Customer customer);
	// 修改用户密码
	public String modifyCustomerPassword(Customer customer);
	// 查询用户id
	public Customer queryCustomerIdAndCustomerName(Customer customer);
    // 查询用户的信息
	public Customer queryCustomerInfo(Customer customer);
	// 处理用户头像
	public String photoUploadService(byte[] arr,String suffix,String id);
}
