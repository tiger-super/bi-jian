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
	public int registerCustomer(Customer customer);
	/**
	 * 通过账号返回一个客户类
	 * @param customerPhone
	 * @return
	 */
	public Customer loginSystem(String customerPhone);
	
	public String ifExistBlack(String customerId);
	
	public String selectCustomerWhetherVipAccordingToId(String customerId);
}
