package com.house.mapper;

import org.springframework.stereotype.Repository;

import com.house.entity.Customer;
@Repository
public interface CustomerManagementMapper {
     /**
      * 通过一个customer注册一个账号
      * @param customer
      * @return
      */
	int registerCustomer(Customer customer);
	/**
	 * 通过账号返回一个客户类
	 * @param customerPhone
	 * @return
	 */
	Customer loginSystem(String customerPhone);
}
