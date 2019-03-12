package com.manage.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
public class Time {
   public static String getNowTime() {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
      return df.format(new Date());// new Date()为获取当前系统时间
   }
   public static String getNowTime(Date date) {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
      return df.format(date);// new Date()为获取当前系统时间
   }
   public static String getNowTimeforYearAndMonthAndDay() {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
      return df.format(new Date());// new Date()为获取当前系统时间
   }
   public static int dayForWeek(String pTime) throws Exception {
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	   Calendar c = Calendar.getInstance();
	   c.setTime(format.parse(pTime));
	   int dayForWeek = 0;
	   if(c.get(Calendar.DAY_OF_WEEK) == 1){
	    dayForWeek = 7;
	   }else{
	    dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
	   }
	   return dayForWeek;
	  }
   
   public static Date dayAddNum(Date time, Integer num) {    
       Calendar calendar = Calendar.getInstance();
       calendar.setTime(time);
       calendar.add(Calendar.DATE, num);
       Date newTime = calendar.getTime();
       return newTime;
   }
   public static Date stringSwitchDate(String date) throws ParseException {
	   SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
	   return df.parse(date);
   }
   public static List<String> getWeek(int today,String date) throws ParseException{
	   System.out.println(today);
	   System.out.println(date);
	   List<String> list = new ArrayList<String>();
	   for(int i = today-1; i >= 0; i--) {
			Date d = stringSwitchDate(date);
			Date newDate = dayAddNum(d,-i);
			String stringDate = getNowTime(newDate);
			list.add(stringDate);
	   }
	   return list;
   }
}
