package com.house.demo.provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.stereotype.Service;*/

import com.alibaba.dubbo.config.annotation.Service;
import com.house.demo.pay.PayService;
import com.house.entity.Customer;
import com.house.entity.Pay;
import com.house.mapper.PayManagementMapper;
import com.house.tool.Time;

@Service
public class PayServiceImpl implements PayService {
	@Autowired
	PayManagementMapper payManagementMapper;
	@Override
	public void handlePay(Pay pay) {
		pay.setPayTime(Time.getNowTime());
		payManagementMapper.insertPayInformation(pay);
		int month = 0;
		switch (pay.getPayMoney()) {
		case "15.00":
			month = 1;
			break;
		case "40.00":
			month = 3;
			break;
		case "60.00":
			month = 6;
			break;
		case "128.00":
			month = 12;
			break;
		}
		Customer customer = payManagementMapper.selectCustomerVipInformationWithCustomerId(pay.getPayPeopleId());
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", pay.getPayPeopleId());
		map.put("ifVip", "1");
		map.put("vipRechargeTime", Time.getNowTimeforYearAndMonthAndDay());
		String vipStopTime = null;
		if (customer.getVipStopTime() != null) {
			String currentTime = Time.getNowTimeforYearAndMonthAndDay();
			try {
				int compareResult = Time.compareTime(Time.getDate(currentTime),Time.getDate(customer.getVipStopTime()));
				if (compareResult == -1 || compareResult == 0) {
					// 当前时间小于等于vip结束时间
					vipStopTime = customer.getVipStopTime();
				} else {
					vipStopTime = currentTime;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			vipStopTime = Time.getNowTimeforYearAndMonthAndDay();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			map.put("vipStopTime", df.format(Time.dateAddMonth(month, Time.getDate(vipStopTime))));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		payManagementMapper.updateCustomerVipInformation(map);
	}

}
