package com.house.tool;

import java.util.ArrayList;
import java.util.List;

import com.house.entity.Page;

public class PageShow {
	public static List<String> handlePage(Page page) {
		List<String> list = new ArrayList<String>();
		if(page.getPageMax() > 1) {
		int pageMax = page.getPageMax();
		int pageCurrent = page.getPageCurrent();
		if(pageCurrent != 1) {
			list.add("上一页");
		}
		list.add("1");
		if(pageCurrent >= 4 && pageMax > 5) {
			list.add("...");
		}
		if(pageCurrent >= 4 && pageCurrent <= pageMax - 3 &&  pageMax > 5) {
		for(int i = pageCurrent-1; i < pageCurrent+2 ; i ++) {
			list.add(String.valueOf(i));
		}
		}else if(pageCurrent <= 3 ) {
			switch(pageMax) {		
			case 4:
				list.add("2");
				list.add("3");
				break;
			case 3:
				list.add("2");
				break;
			case 2:break;
			default:list.add("2");
			list.add("3");
			list.add("4");
			}
			
		}else {
			list.add(String.valueOf(pageMax-3));
			list.add(String.valueOf(pageMax-2));
			list.add(String.valueOf(pageMax-1));
		}
		
		if(pageCurrent <= pageMax - 3 && pageMax > 5) {
			list.add("...");
		}
		list.add(String.valueOf(pageMax));
		if(pageCurrent != pageMax ) {
			list.add("下一页");
		}
		}
		return list;
	}
}
