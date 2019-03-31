package com.house.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
   public static int compareTime(Date compareDate,Date beCompareDate) {
	   return compareDate.compareTo(beCompareDate);
   }
   
   public static Date getDate(String date) throws ParseException {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
       return df.parse(date);
   }
   public static Date dateAddMonth(int month,Date date) {
	   Calendar calendar = Calendar.getInstance();
	      calendar.setTime(date);
	      calendar.add(Calendar.MONTH, month);
	      return calendar.getTime();
   }
}
