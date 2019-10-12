package com.zhaomengyu.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static void main(String[] args) {
		Date birth = new Date(100,12,20);
		int age = calAge(birth);
		System.out.println("age is " + age);
		System.out.println("������³���" + getMonthStart(new Date()));
		
		System.out.println("�������ĩ��"+getMonthEnd(new Date(119,1,13)));
	}
	
	public static int calAge(Date birthday) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(birthday);
		//��ȡ������������
		int birthYear = cal.get(Calendar.YEAR);
		int birthMonth = cal.get(Calendar.MONTH);
		int birthDate = cal.get(Calendar.DAY_OF_MONTH);
		//��ȡ�����������
		cal.setTime(new Date());
		int currnetYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH);
		int currentDate = cal.get(Calendar.DAY_OF_MONTH);
		
		int age = currnetYear-birthYear;
		if(currentMonth<birthMonth)
			age--;
		else if(currentMonth==birthMonth) {
			if(currentDate<birthDate)
				age--;
		}
		return age;
			
	}
	
	public static boolean isToday(Date date) {
		SimpleDateFormat smt = new SimpleDateFormat("yyyyMMdd");
		String dateStr = smt.format(date);
		String todayStr = smt.format(new Date());
		return dateStr.equals(todayStr);
	}
	
	public static Date getMonthStart(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//����0��
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	
	public static Date getMonthEnd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//����0��
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.MONTH, 1);
		cal.set(Calendar.SECOND, -1);
		return cal.getTime();
	}
	
}
