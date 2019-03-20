package com.house.tool;
// 照片地址生成类
public class PhoneAddressCreate {
	
    public static String createAddress(String id) {
    	long time = System.currentTimeMillis();
    	StringBuffer sb = new StringBuffer();
    	sb.append(id).append(String.valueOf(time));
    	return sb.toString();
    }
    public static String createAddress() {
    	long time = System.currentTimeMillis();
    	StringBuffer sb = new StringBuffer();
    	sb.append(String.valueOf(time));
    	return sb.toString();
    }
}
