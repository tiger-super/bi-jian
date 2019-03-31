package com.house.mapper;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.house.entity.Customer;
import com.house.entity.Pay;

@Repository
public interface PayManagementMapper {
  public int insertPayInformation(Pay pay);
  public int updateCustomerVipInformation(Map<String,String> map);
  public Customer selectCustomerVipInformationWithCustomerId(String customerId);
}
