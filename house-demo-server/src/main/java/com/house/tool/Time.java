package com.house.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
   public static String getNowTime() {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
      return df.format(new Date());// new Date()为获取当前系统时间
   }
   
   public static String getNowTimeforYearAndMonthAndDay() {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
      return df.format(new Date());// new Date()为获取当前系统时间
   }
}
