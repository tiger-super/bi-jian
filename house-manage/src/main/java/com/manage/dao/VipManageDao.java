package com.manage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.house.entity.Customer;
import com.house.entity.Page;
import com.house.entity.Pay;

@Repository
public interface VipManageDao {
	public int accountAllVipCustomer();
    public List<Customer> selectAllVipCustomer(Page page);
    public Customer seletctVipCustomerAccordingId(Customer customer);
    public List<Pay> queryAllVipOrder(Page page);
    public int accountVipOrder();
    public List<String> accountPayMoneyAndNowDay(String today);
}
