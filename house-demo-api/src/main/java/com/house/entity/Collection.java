package com.house.entity;

import java.io.Serializable;

// 收藏类
public class Collection implements Serializable {

	private static final long serialVersionUID = 1L;
	// 收藏人的id
	private String collectorsId;
	// 收藏的房源id
	private String collectionHouseId;
	// 收藏的时间
	private String collectionTime;

	public String getCollectorsId() {
		return collectorsId;
	}

	public void setCollectorsId(String collectorsId) {
		this.collectorsId = collectorsId;
	}

	public String getCollectionHouseId() {
		return collectionHouseId;
	}

	public void setCollectionHouseId(String collectionHouseId) {
		this.collectionHouseId = collectionHouseId;
	}

	public String getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
	}

	@Override
	public String toString() {
		return "Collection [collectorsId=" + collectorsId + ", collectionHouseId=" + collectionHouseId
				+ ", collectionTime=" + collectionTime + "]";
	}

}
