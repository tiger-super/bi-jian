package com.manage.tool;
// 照片地址生成类
public class EmployeeAddressCreate {
	
    public static String createAddress() {
    	long time = System.currentTimeMillis();
    	StringBuffer sb = new StringBuffer();
    	sb.append(String.valueOf(time));
    	return sb.toString();
    }
}
