package com.house.entity;

import java.io.Serializable;

public class AuditingFail implements Serializable {
	private String houseId;
	private String houseAuditingReason;
	private String houseAuditingTime;

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getHouseAuditingReason() {
		return houseAuditingReason;
	}

	public void setHouseAuditingReason(String houseAuditingReason) {
		this.houseAuditingReason = houseAuditingReason;
	}

	public String getHouseAuditingTime() {
		return houseAuditingTime;
	}

	public void setHouseAuditingTime(String houseAuditingTime) {
		this.houseAuditingTime = houseAuditingTime;
	}

	@Override
	public String toString() {
		return "AuditingFail [houseId=" + houseId + ", houseAuditingReason=" + houseAuditingReason
				+ ", houseAuditingTime=" + houseAuditingTime + "]";
	}

}
