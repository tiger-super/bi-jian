package com.house.tool;

import java.util.ArrayList;
import java.util.List;

import com.house.entity.Page;

public class PageShow {
	public static List<String> handlePage(Page page) {
		List<String> list = new ArrayList<String>();
		int pageMax = page.getPageMax();
		int pageCurrent = page.getPageCurrent();
		if(pageCurrent > 0) {
			list.add("上一页");
		}
		list.add("1");
		if(pageCurrent > 2 && pageMax > 3) {
			list.add("...");
		}
		if(pageCurrent > 2 && pageCurrent < pageMax - 3) {
		for(int i = pageCurrent+1; i < pageCurrent+3 ; i ++) {
			list.add(String.valueOf(i));
		}
		}else if(pageCurrent <= 2 ) {
			list.add("2");
			list.add("3");
		}else {
			list.add(String.valueOf(pageMax-2));
			list.add(String.valueOf(pageMax-1));
		}
		
		if(pageCurrent < pageMax - 3 && pageMax > 3) {
			list.add("...");
		}
		list.add(String.valueOf(pageMax));
		if(pageCurrent < pageMax - 3 && pageMax > 3) {
			list.add("下一页");
		}
		return list;
	}
}
