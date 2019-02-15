package com.house.entity;

import java.io.Serializable;

public class Page implements Serializable {
	// 分页总和
	private int pageTotal;
	// 最大页数
	private int pageMax;
	// 一页可以显示信息数量
	private int pageNumber;
	// 当前页码
	private int pageCurrent;
	// 以显示的信息数量
	private int pageShowNow;
	public Page() {
		super();
		this.pageNumber = 4;
		this.pageShowNow = 0 ;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getPageMax() {
		return pageMax;
	}
	public void setPageMax(int pageMax) {
		this.pageMax = pageMax;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getPageShowNow() {
		return pageShowNow;
	}
	public void setPageShowNow(int pageShowNow) {
		this.pageShowNow = pageShowNow;
	}
	@Override
	public String toString() {
		return "Page [pageTotal=" + pageTotal + ", pageMax=" + pageMax + ", pageNumber=" + pageNumber + ", pageCurrent="
				+ pageCurrent + ", pageShowNow=" + pageShowNow + "]";
	}
	
}
