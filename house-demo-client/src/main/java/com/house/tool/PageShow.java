package com.house.tool;

import java.util.ArrayList;
import java.util.List;

import com.house.entity.Page;

public class PageShow {
	public static List<String> handlePage(Page page) {
		List<String> list = new ArrayList<String>();
		int max = page.getPageMax();
		int current = page.getPageCurrent();
		int upCurrent = current - 1;
		int nextCurrent = current + 1;
		if(max>1 && max <=5) { 
			if(current != 1) {
				list.add("上一页");
			}
			for(int i = 1 ; i <= max ; i++) {
				list.add(String.valueOf(i));
			}
		}else if(max > 5){
			if(upCurrent < 0) {
				list.add("1");
			}else {
				list.add("上一页");
				list.add("1");
			}
			if(current<=3) {
				if(upCurrent != 0 && upCurrent != 1) {
					list.add(String.valueOf(upCurrent));
					list.add(String.valueOf(current));
					list.add(String.valueOf(nextCurrent));
					list.add("...");
					list.add(String.valueOf(max));
				}else if(upCurrent == 0) {
					list.add(String.valueOf(nextCurrent));
					list.add(String.valueOf(nextCurrent+1));
					list.add(String.valueOf(nextCurrent+2));
					list.add("...");
					list.add(String.valueOf(max));
				}
				else {
					list.add(String.valueOf(current));
					list.add(String.valueOf(nextCurrent));
					list.add(String.valueOf(nextCurrent+1));
					list.add("...");
					list.add(String.valueOf(max));
				}
			}else if(current>3&&current <= max-3){
				list.add("...");
				list.add(String.valueOf(upCurrent));
				list.add(String.valueOf(current));
				list.add(String.valueOf(nextCurrent));
				list.add("...");
				list.add(String.valueOf(max));
			}else if(current > max-3){
				list.add("...");
				list.add(String.valueOf(max-2));

				list.add(String.valueOf(max-1));

				list.add(String.valueOf(max));

			}
		}
		
		if(max != current) {
			list.add("下一页");
		}
		return list;
	}
}
