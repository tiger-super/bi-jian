package com.manage.service;

import java.util.Map;

import com.house.entity.Customer;
import com.house.entity.Page;

public interface VipManageService {
    public Map<String,Object> vipInformation(Page page);
    
    public Customer selectVipFromId(Customer customer);
    
    public Map<String,Object> vipOrderServer(Page page);
}
