package com.house.entity;

import java.io.Serializable;

// 房源类
public class House implements Serializable {
	private static final long serialVersionUID = 1L;
	// 房源的id
	private String houseId;
	// 房源的姓名
	private String houseName;
	// 房源所在的省
	private String houseAddressProvince;
	// 房源所在的市
	private String houseAddressCity;
	// 房源所在的区
	private String houseAddressArea;
	// 房源的详细地址
	private String houseAddressInfo;
	// 房源发布人的id
	private String housePublisherId;
	// 房源审核情况
	private String houseAuditingState;
	// 房源的发布情况
	private String housePublisherState;
	// 房源的发布时间
	private String housePublisherTime;
	// 房源关注数量
	private String followNumber;
	// 房源申请发布时间
	private String applicationTime;
	// 房源详细描述
	private HouseInfo houseInfo;
	// 房源的配套设施
	private Device device;

	public String getHousePublisherTime() {
		return housePublisherTime;
	}

	public void setHousePublisherTime(String housePublisherTime) {
		this.housePublisherTime = housePublisherTime;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseAddressProvince() {
		return houseAddressProvince;
	}

	public void setHouseAddressProvince(String houseAddressProvince) {
		this.houseAddressProvince = houseAddressProvince;
	}

	public String getHouseAddressCity() {
		return houseAddressCity;
	}

	public void setHouseAddressCity(String houseAddressCity) {
		this.houseAddressCity = houseAddressCity;
	}

	public String getHouseAddressArea() {
		return houseAddressArea;
	}

	public void setHouseAddressArea(String houseAddressArea) {
		this.houseAddressArea = houseAddressArea;
	}

	public String getHouseAddressInfo() {
		return houseAddressInfo;
	}

	public void setHouseAddressInfo(String houseAddressInfo) {
		this.houseAddressInfo = houseAddressInfo;
	}

	public String getHousePublisherId() {
		return housePublisherId;
	}

	public void setHousePublisherId(String housePublisherId) {
		this.housePublisherId = housePublisherId;
	}

	public String getHouseAuditingState() {
		return houseAuditingState;
	}

	public void setHouseAuditingState(String houseAuditingState) {
		this.houseAuditingState = houseAuditingState;
	}

	public String getHousePublisherState() {
		return housePublisherState;
	}

	public void setHousePublisherState(String housePublisherState) {
		this.housePublisherState = housePublisherState;
	}

	public HouseInfo getHouseInfo() {
		return houseInfo;
	}

	public void setHouseInfo(HouseInfo houseInfo) {
		this.houseInfo = houseInfo;
	}

	public Device getDevice() {
		return device;
	}

	public void setDevice(Device device) {
		this.device = device;
	}

	public String getFollowNumber() {
		return followNumber;
	}

	public void setFollowNumber(String followNumber) {
		this.followNumber = followNumber;
	}

	public String getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(String applicationTime) {
		this.applicationTime = applicationTime;
	}

	@Override
	public String toString() {
		return "House [houseId=" + houseId + ", houseName=" + houseName + ", houseAddressProvince="
				+ houseAddressProvince + ", houseAddressCity=" + houseAddressCity + ", houseAddressArea="
				+ houseAddressArea + ", houseAddressInfo=" + houseAddressInfo + ", housePublisherId=" + housePublisherId
				+ ", houseAuditingState=" + houseAuditingState + ", housePublisherState=" + housePublisherState
				+ ", housePublisherTime=" + housePublisherTime + ", followNumber=" + followNumber + ", applicationTime="
				+ applicationTime + ", houseInfo=" + houseInfo + ", device=" + device + "]";
	}
}
