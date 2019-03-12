package com.house.entity;

public class WebsiteCount {
    private String time;
    private int visitNumberToday;
    private int housePublishNumberToday;
    private int houseLowerShelfNumberToday;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getVisitNumberToday() {
		return visitNumberToday;
	}
	public void setVisitNumberToday(int visitNumberToday) {
		this.visitNumberToday = visitNumberToday;
	}
	public int getHousePublishNumberToday() {
		return housePublishNumberToday;
	}
	public void setHousePublishNumberToday(int housePublishNumberToday) {
		this.housePublishNumberToday = housePublishNumberToday;
	}
	public int getHouseLowerShelfNumberToday() {
		return houseLowerShelfNumberToday;
	}
	public void setHouseLowerShelfNumberToday(int houseLowerShelfNumberToday) {
		this.houseLowerShelfNumberToday = houseLowerShelfNumberToday;
	}
	@Override
	public String toString() {
		return "WebsiteCount [time=" + time + ", visitNumberToday=" + visitNumberToday + ", housePublishNumberToday="
				+ housePublishNumberToday + ", houseLowerShelfNumberToday=" + houseLowerShelfNumberToday + "]";
	}
}
