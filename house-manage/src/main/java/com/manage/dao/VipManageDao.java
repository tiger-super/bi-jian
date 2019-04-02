package com.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.house.entity.Customer;
import com.house.entity.Page;

@Repository
public interface VipManageDao {
	public int accountAllVip();
    public List<Customer> selectAllVip(Page page);
}
