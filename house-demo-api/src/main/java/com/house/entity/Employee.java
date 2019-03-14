package com.house.entity;

import java.io.Serializable;

// 员工类
public class Employee implements Serializable{
	private static final long serialVersionUID = 1L;
	// 员工的id
	private String employeeId;
	// 员工的姓名
	private String employeeName;
	// 员工的性别
	private String employeeSex;
	// 员工的年龄
	private String employeeAge;
	// 员工的电话
	private String employeePhone;
	// 员工的邮箱
	private String employeeMailbox;
	// 员工住址
	private String employeeAddress;
	// 员工密码
	private String employeePassword;
	// 员工图片地址
	private String employeeImgAddress;
	// 员工的角色或者说权限
	private String employeeRole;
	// 员工的入职时间
	private String entryTime;
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	public String getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeMailbox() {
		return employeeMailbox;
	}
	public void setEmployeeMailbox(String employeeMailbox) {
		this.employeeMailbox = employeeMailbox;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getEmployeeRole() {
		return employeeRole;
	}
	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}
	public String getEmployeeImgAddress() {
		return employeeImgAddress;
	}
	public void setEmployeeImgAddress(String employeeImgAddress) {
		this.employeeImgAddress = employeeImgAddress;
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeSex=" + employeeSex
				+ ", employeeAge=" + employeeAge + ", employeePhone=" + employeePhone + ", employeeMailbox="
				+ employeeMailbox + ", employeeAddress=" + employeeAddress + ", employeePassword=" + employeePassword
				+ ", employeeImgAddress=" + employeeImgAddress + ", employeeRole=" + employeeRole + ", entryTime="
				+ entryTime + "]";
	}
}
