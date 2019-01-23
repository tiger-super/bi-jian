package com.house.tool;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sourceforge.pinyin4j.PinyinHelper;

public class PinyinComparator implements Comparator<Object> {
	private Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
	
	public int compare(Object o1, Object o2) {
		char c1 = ((String) o1).charAt(0);
		char c2 = ((String) o2).charAt(0);
		return concatPinyinStringArray(PinyinHelper.toHanyuPinyinStringArray(c1))
				.compareTo(concatPinyinStringArray(PinyinHelper.toHanyuPinyinStringArray(c2)));
	}

	public String concatPinyinStringArray(String[] pinyinArray) {   
        if ((pinyinArray != null) && (pinyinArray.length > 0)) {  
           return pinyinArray[0];
        }  
        return null;  
    }
	
	public static String[] getStringArray(List<String> list) {
		String[] value = list.toArray(new String[0]);
		return value;
	}
	
	public Map<String, List<String>> getSortPinyin(List<String> list) {
		loadMap();
		for(int i = 0 ; i < list.size() ;i++) {
			String province = list.get(i);
			String pinyin = null;
			if("重庆市".equals(province)) {
				pinyin = PinyinHelper.toHanyuPinyinStringArray(province.charAt(0))[1].substring(0, 1).toUpperCase();
			}else {
			 pinyin = PinyinHelper.toHanyuPinyinStringArray(province.charAt(0))[0].substring(0, 1).toUpperCase();
			}
			List<String> value = map.get(pinyin);
            if(value == null) {
            	value = new ArrayList<String>();
            }
            value.add (PinyinComparator.deleteSuffix(province));
            map.put(pinyin, value);
		}
		return map;
	}
	
	// 初始化私有属性map
	private void loadMap() {
		for(char i = 'A'; i <= 'Z' ; i++ ) {
		List<String> list = null ;
		map.put(String.valueOf(i), list);
		}
	}
	
	// 去除后缀
	public static String deleteSuffix(String value) {
		if(value.indexOf("省")!=-1 || value.indexOf("市")!=-1) {
			return value.substring(0, value.length()-1);
		}else if(value.indexOf("壮族自治区")!=-1 || value.indexOf("回族自治区")!=-1){
			return value.substring(0, value.length()-5);
		}else if(value.indexOf("自治区")!=-1){
			return value.substring(0, value.length()-3);
		}else if(value.indexOf("维吾尔自治区")!=-1){
			return value.substring(0, value.length()-6);
		}else {
			return value;
		}	
	}
}
