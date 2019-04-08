package com.house.entity;

import java.io.Serializable;

public class Pay implements Serializable{
	private String payId;
	private String payMoney;
	private String payTime;
	private String payPeopleId;
    private String payPeopleName;
	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPayPeopleId() {
		return payPeopleId;
	}

	public void setPayPeopleId(String payPeopleId) {
		this.payPeopleId = payPeopleId;
	}

	public String getPayPeopleName() {
		return payPeopleName;
	}

	public void setPayPeopleName(String payPeopleName) {
		this.payPeopleName = payPeopleName;
	}

	@Override
	public String toString() {
		return "Pay [payId=" + payId + ", payMoney=" + payMoney + ", payTime=" + payTime + ", payPeopleId="
				+ payPeopleId + ", payPeopleName=" + payPeopleName + "]";
	}
}
