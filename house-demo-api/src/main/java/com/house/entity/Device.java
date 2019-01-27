package com.house.entity;

import java.io.Serializable;

// 设备类
public class Device implements Serializable{

	private static final long serialVersionUID = 1L;
	// 是否配床
	private String bed;
    // 是否配衣柜
	private String wardrobe;
    // 是否配书桌
	private String desk;
    // 是否配空调
	private String air;
    // 是否配热水器
	private String heater;
    // 是否配洗衣机
	private String washer;
    // 是否配冰箱
	private String refigerator;
    // 是否配wifi
	private String wifi;
    // 是否配沙发
	private String sofa;
    // 是否配电视
	private String TV;
    // 是否配厕所
	private String toilet;
    // 是否配阳台
	private String balcony;
    // 是否配厨房
	private String Cook;
    // 是否配电梯
	private String elevator;
    // 是否配煤气管道
	private String tubeCoal;
    // 是否配暖气
	private String heating;
    // 是否配扶梯
	private String escalator;
    // 是否配排烟
	private String smoke;
    // 是否配排污
	private String sewageDisposal;
    // 是否配停车位
	private String parking;

	public String getBed() {
		return bed;
	}

	public void setBed(String bed) {
		this.bed = bed;
	}

	public String getWardrobe() {
		return wardrobe;
	}

	public void setWardrobe(String wardrobe) {
		this.wardrobe = wardrobe;
	}

	public String getDesk() {
		return desk;
	}

	public void setDesk(String desk) {
		this.desk = desk;
	}

	public String getAir() {
		return air;
	}

	public void setAir(String air) {
		this.air = air;
	}

	public String getHeater() {
		return heater;
	}

	public void setHeater(String heater) {
		this.heater = heater;
	}

	public String getWasher() {
		return washer;
	}

	public void setWasher(String washer) {
		this.washer = washer;
	}

	public String getRefigerator() {
		return refigerator;
	}

	public void setRefigerator(String refigerator) {
		this.refigerator = refigerator;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getSofa() {
		return sofa;
	}

	public void setSofa(String sofa) {
		this.sofa = sofa;
	}

	public String getTV() {
		return TV;
	}

	public void setTV(String tV) {
		TV = tV;
	}

	public String getToilet() {
		return toilet;
	}

	public void setToilet(String toilet) {
		this.toilet = toilet;
	}

	public String getBalcony() {
		return balcony;
	}

	public void setBalcony(String balcony) {
		this.balcony = balcony;
	}

	public String getCook() {
		return Cook;
	}

	public void setCook(String cook) {
		Cook = cook;
	}

	public String getElevator() {
		return elevator;
	}

	public void setElevator(String elevator) {
		this.elevator = elevator;
	}

	public String getTubeCoal() {
		return tubeCoal;
	}

	public void setTubeCoal(String tubeCoal) {
		this.tubeCoal = tubeCoal;
	}

	public String getHeating() {
		return heating;
	}

	public void setHeating(String heating) {
		this.heating = heating;
	}

	public String getEscalator() {
		return escalator;
	}

	public void setEscalator(String escalator) {
		this.escalator = escalator;
	}

	public String getSmoke() {
		return smoke;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	public String getSewageDisposal() {
		return sewageDisposal;
	}

	public void setSewageDisposal(String sewageDisposal) {
		this.sewageDisposal = sewageDisposal;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	@Override
	public String toString() {
		return "Device [bed=" + bed + ", wardrobe=" + wardrobe + ", desk=" + desk + ", air=" + air + ", heater="
				+ heater + ", washer=" + washer + ", refigerator=" + refigerator + ", wifi=" + wifi + ", sofa=" + sofa
				+ ", TV=" + TV + ", toilet=" + toilet + ", balcony=" + balcony + ", Cook=" + Cook + ", elevator="
				+ elevator + ", tubeCoal=" + tubeCoal + ", heating=" + heating + ", escalator=" + escalator + ", smoke="
				+ smoke + ", sewageDisposal=" + sewageDisposal + ", parking=" + parking + "]";
	}

}
