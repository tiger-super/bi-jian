package com.house.entity;

import java.io.Serializable;

// 房源详细类
public class HouseInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	// 房源的类型，如：二手房，公寓，别墅
	private String houseType;
    // 房源的价格
	private String houseMoney;
    // 房源的大小
	private String houseSize;
    // 房源的朝向
	private String houseDirection;
    // 房源的出售方式，如租售，出售
	private String houseSellWay;
    // 房源的押金方式，如：押二付一
	private String houseDepoitWay;
    // 房源的描述
	private String houseDescripe;
    // 房源的图片地址
	private String houseImageAddress;
    // 房源的结构,如：1室1厅1卫
	private String houseStructure;

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getHouseMoney() {
		return houseMoney;
	}

	public void setHouseMoney(String houseMoney) {
		this.houseMoney = houseMoney;
	}

	public String getHouseSize() {
		return houseSize;
	}

	public void setHouseSize(String houseSize) {
		this.houseSize = houseSize;
	}

	public String getHouseDirection() {
		return houseDirection;
	}

	public void setHouseDirection(String houseDirection) {
		this.houseDirection = houseDirection;
	}

	public String getHouseSellWay() {
		return houseSellWay;
	}

	public void setHouseSellWay(String houseSellWay) {
		this.houseSellWay = houseSellWay;
	}

	public String getHouseDepoitWay() {
		return houseDepoitWay;
	}

	public void setHouseDepoitWay(String houseDepoitWay) {
		this.houseDepoitWay = houseDepoitWay;
	}

	public String getHouseDescripe() {
		return houseDescripe;
	}

	public void setHouseDescripe(String houseDescripe) {
		this.houseDescripe = houseDescripe;
	}

	public String getHouseImageAddress() {
		return houseImageAddress;
	}

	public void setHouseImageAddress(String houseImageAddress) {
		this.houseImageAddress = houseImageAddress;
	}

	public String getHouseStructure() {
		return houseStructure;
	}

	public void setHouseStructure(String houseStructure) {
		this.houseStructure = houseStructure;
	}

	@Override
	public String toString() {
		return "HouseInfo [houseType=" + houseType + ", houseMoney=" + houseMoney + ", houseSize=" + houseSize
				+ ", houseDirection=" + houseDirection + ", houseSellWay=" + houseSellWay + ", houseDepoitWay="
				+ houseDepoitWay + ", houseDescripe=" + houseDescripe + ", houseImageAddress=" + houseImageAddress
				+ ", houseStructure=" + houseStructure + "]";
	}

}
