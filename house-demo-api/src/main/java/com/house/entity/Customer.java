package com.house.entity;

import java.io.Serializable;

// 客户类
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	// 客户的编号
	private String customerId;
	// 客户的姓名
	private String customerName;
	// 客户的性别
	private String customerSex;
	// 客户的年龄
	private String customerAge;
	// 客户的邮箱
	private String customerMailbox;
	// 客户的电话
	private String customerPhone;
	// 客户的密码
	private String customerPassword;
	// 客户的头像地址
	private String customerHeadImageAddress;
	// 是否是被列入客户黑名单
	private String ifBlacklist;
	// 是否是vip
	private String ifVip;
	// vip充值时间
	private String vipRechargeTime;
	// vip结束时间
	private String vipStopTime;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerSex() {
		return customerSex;
	}

	public void setCustomerSex(String customerSex) {
		this.customerSex = customerSex;
	}

	public String getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(String customerAge) {
		this.customerAge = customerAge;
	}

	public String getCustomerMailbox() {
		return customerMailbox;
	}

	public void setCustomerMailbox(String customerMailbox) {
		this.customerMailbox = customerMailbox;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerHeadImageAddress() {
		return customerHeadImageAddress;
	}

	public void setCustomerHeadImageAddress(String customerHeadImageAddress) {
		this.customerHeadImageAddress = customerHeadImageAddress;
	}

	public String getIfBlacklist() {
		return ifBlacklist;
	}

	public void setIfBlacklist(String ifBlacklist) {
		this.ifBlacklist = ifBlacklist;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIfVip() {
		return ifVip;
	}

	public void setIfVip(String ifVip) {
		this.ifVip = ifVip;
	}

	public String getVipRechargeTime() {
		return vipRechargeTime;
	}

	public void setVipRechargeTime(String vipRechargeTime) {
		this.vipRechargeTime = vipRechargeTime;
	}

	public String getVipStopTime() {
		return vipStopTime;
	}

	public void setVipStopTime(String vipStopTime) {
		this.vipStopTime = vipStopTime;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerSex=" + customerSex
				+ ", customerAge=" + customerAge + ", customerMailbox=" + customerMailbox + ", customerPhone="
				+ customerPhone + ", customerPassword=" + customerPassword + ", customerHeadImageAddress="
				+ customerHeadImageAddress + ", ifBlacklist=" + ifBlacklist + ", ifVip=" + ifVip + ", vipRechargeTime="
				+ vipRechargeTime + ", vipStopTime=" + vipStopTime + "]";
	}
}
