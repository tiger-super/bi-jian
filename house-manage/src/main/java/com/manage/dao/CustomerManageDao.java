package com.manage.dao;


import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.house.entity.Customer;
import com.house.entity.Page;


@Repository
public interface CustomerManageDao {
    // 获取所有用户的信息
    List<Customer> selectAllCustomer(Page page);
    // 统计用户数量
    int totalAllCustomer();
    // 获取所有黑名单用户的信息
    List<Customer> selectAllBlackCustomer(Page page);
    // 统计黑名单用户数量
    int totalAllBlackCustomer();
    // 添加黑名单
    int addBlack(String customerId);
    // 取消黑名单
    int deleteBlack(String customerId);
    
    //获取用户的邮箱
    List<String> selectCustomerMailBoxFromId(Set<String> list);
}
