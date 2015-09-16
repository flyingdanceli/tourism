package com.isatk.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeFormatTemplate {
	private static final DateFormat df = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static final DateFormat dateOnly = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static final DateFormat dateAndHour = new SimpleDateFormat(
			"yyyy-MM-dd HH");
	
	private static final DateFormat dateAndMinute = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	
	private static final DateFormat hhmm = new SimpleDateFormat(
			"HH:mm");
	
	private static final DateFormat noYY = new SimpleDateFormat("MM-dd HH:mm");
	
	private static final DateFormat numberDateTime = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	/**
	 * 时间转成字符串
	 * @param date
	 * @return
	 */
	public static String Date2String(Date date) {
		if(date==null)
		{
			return "";
		}
		return df.format(date);
	}
	
	public static String getNumberDate(){
		return numberDateTime.format(new Date());
	}
	
	/**
	 * 时间转成字符串
	 * @param date
	 * @return
	 */
	public static String Date2StringOfHour(Date date) {
		if(date==null)
		{
			return "";
		}
		return dateAndHour.format(date);
	}
	
	public static String Date2StringOfMinute(Date date) {
		if(date==null)
		{
			return "";
		}
		return dateAndMinute.format(date);
	}
	
	public static String Date2StringOfHHmm(Date date) {
		if(date==null)
		{
			return "";
		}
		return hhmm.format(date);
	}
	
	/**
	 * 日期转成字符串,不显示时间
	 * @param date
	 * @return
	 */
	public static String Date2StringNoTime(Date date) {
		if(date==null)
		{
			return "";
		}
		return dateOnly.format(date);
	}
	
	public static String Date2StringNoYear(Date date) {
		if(date==null)
		{
			return "";
		}
		return noYY.format(date);
	}
	
 
	/**
	 * 字符串转成时间
	 * @param dateString
	 * @return
	 */
	public static Date string2Date(String dateString) {
		Date date = null;
		if (dateString != null && dateString.trim().length() > 0) 
		{
			try 
			{
				if(dateString.trim().length()==10)
				{
					dateString += " 00:00:00";
				}
				if(dateString.trim().length()==13)
				{
					dateString += ":00:00";
				}
				if(dateString.trim().length()==16)
				{
					dateString += ":00";
				}
				date = df.parse(dateString);			
			} 
			catch (ParseException pe) 
			{
				pe.printStackTrace();
			}
		}
		return date;
	}
	
	/**
	 * 字符串转成时间 日期保留，时间部分为 00:00:00
	 * @param dateString
	 * @return
	 */
	public static Date string2DateBegin(String dateString) {
		Date date = null;
		if (dateString != null && dateString.trim().length() > 0) {
			try {
				date = df.parse(dateString + " 00:00:00");
			} catch (ParseException pe) {
				
			}
		}
		return date;
	}
	
	/**
	 * 字符串转成时间 日期保留，时间部分为 23:59:59
	 * @param dateString
	 * @return
	 */
	public static Date string2DateEnd(String dateString) {
		Date date = null;
		if (dateString != null && dateString.trim().length() > 0) {
			try {
				date = df.parse(dateString + " 23:59:59");
			} catch (ParseException pe) {
				
			}
		}
		return date;
	}
	
	/**
	 * 距离当前时间的天数
	 * @param fromDate
	 * @return
	 */
	public static Integer getBeNowDays(String fromDate){
		if(fromDate!=null){
			try {
			Date fromd=	dateOnly.parse(fromDate);
			if(fromd!=null){
				int days=(int) Math.round((fromd.getTime()-new Date().getTime())/(1000 * 60 * 60 * 24));
				return days;
			}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 获得当前年号
	 * @return   数值表示当前年号
	 */
	public static int getThisYearsNum()
	{
		Calendar c=Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}
	
	public static int getThisMonthNum(){
		Calendar c=Calendar.getInstance();
		return c.get(Calendar.MONTH)+1;
	}
	
	public static int getThisDayNum(){
		Calendar c=Calendar.getInstance();
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	public static String getDayString(){
		Calendar c=Calendar.getInstance();
		String nowDay=getThisYearsNum()+"-"+getThisMonthNum()+"-"+getThisDayNum()+" 00:00:00";
		return nowDay;
	}
	
	public static String getThisTimeTxt()
	{	
		return Date2String(new Date());
	}
	
	public static long countTimeLengthOfMinutes(Date t1,Date t2)
	{
		return (t1==null || t2==null)?-1:Math.abs(t1.getTime()-t2.getTime())/60000;
	}
	
	public static long countTimeLengthOfHours(Date t1,Date t2)
	{
		return (t1==null || t2==null)?-1:Math.abs(t1.getTime()-t2.getTime())/3600000;
	}
	
	public static long countTimeLengthOfSeconds(Date t1,Date t2)
	{
		return (t1==null || t2==null)?-1:Math.abs(t1.getTime()-t2.getTime())/1000;
	}
	
	public static long countTimeLengthOfDays(Date t1,Date t2)
	{
		return (t1==null || t2==null)?-1:Math.abs(t1.getTime()-t2.getTime())/86400000;
	}
	//1000*60 = 1分 =6000
	//1000*60*60 = 1小时 =360000
	//1000*60*60*24 = 1天 =8640000
	
	public static String countTimeLength2(Date t1,Date t2)
	{
		long ss=countTimeLengthOfMinutes(t1,t2);
		StringBuffer txt=new StringBuffer("");
		String c="";
		long s1=0,s2=0,s3=0,s4 = 0;
		if(ss>-1)
		{
			s1=ss%60;
			s2=ss/60;
			s3=s2%24;
			s4=s2/24;
		}
		if(s4>0)
		{
			txt.append(s4+"天"+(s3>9?s3:"0"+s3)+"时"+(s1>9?s1:"0"+s1)+"分");
		}
		else
		{
			if(s3>0)
			{
				txt.append(s3+"时"+(s1>9?s1:"0"+s1)+"分");
			}
			else
			{
				txt.append(s1+"分");
			}
		}
		c="<span style='color:#93a;'>"+txt.toString()+"</span>";		
		if(ss>=60)
		{
			c="<span style='color:#369;'>"+txt.toString()+"</span>";
		}
		if(ss>=3600)
		{
			c="<span style='color:#396;'>"+txt.toString()+"</span>";
		}
		if(ss>=86400)
		{
			c="<span style='color:#a63;'>"+txt.toString()+"</span>";
		}
		if(ss>=864000)
		{
			c="<span style='color:#f63;'>"+txt.toString()+"</span>";
		}
		return c;
	}
	
	public static String countTimeLengthOfLocalTxt(Date t1,Date t2)
	{
		long ss=countTimeLengthOfMinutes(t1,t2);
		StringBuffer txt=new StringBuffer("");
		long s1=0,s2=0,s3=0,s4 = 0;
		if(ss>-1)
		{
			s1=ss%60;
			s2=ss/60;
			s3=s2%24;
			s4=s2/24;
		}
		if(s4>0)
		{
			txt.append(s4+"天"+(s3>9?s3:"0"+s3)+"时"+(s1>9?s1:"0"+s1)+"分");
		}
		else
		{
			if(s3>0)
			{
				txt.append(s3+"时"+(s1>9?s1:"0"+s1)+"分");
			}
			else
			{
				txt.append(s1+"分");
			}
		}
		return txt.toString();
	}
	
	public static String countTimeLengthOfLocalTxt(long ss)
	{
		StringBuffer txt=new StringBuffer("");
		long s1=0,s2=0,s3=0,s4 = 0;
		if(ss>-1)
		{
			s1=ss%60;
			s2=ss/60;
			s3=s2%24;
			s4=s2/24;
		}
		if(s4>0)
		{
			txt.append(s4+"天"+(s3>9?s3:"0"+s3)+"时"+(s1>9?s1:"0"+s1)+"分钟");
		}
		else
		{
			if(s3>0)
			{
				txt.append(s3+"时"+(s1>9?s1:"0"+s1)+"分钟");
			}
			else
			{
				txt.append(s1+"分钟");
			}
		}
		return txt.toString();
	}
	
	/**
	 * 获得当天日期，从0点0分0秒开始
	 * @return
	 */
	public static Date getThisDate()
	{
		Calendar cc=Calendar.getInstance();
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		return cc.getTime();
	}
	
	/**
	 * 获取到当天位移点日期，从0点0分0秒开始
	 * @return
	 */
	public static Date getOffsetDateBegin(int ds)
	{
		Calendar cc=Calendar.getInstance();
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		cc.add(Calendar.DATE, ds);
		return cc.getTime();
	}
	/**
	 * 获取到当天日期的位移点日期，从23点59分59秒开始
	 * @return
	 */
	public static Date getOffsetDateEnd(int ds)
	{
		Calendar cc=Calendar.getInstance();
		cc.set(Calendar.HOUR_OF_DAY,23);
		cc.set(Calendar.MINUTE, 59);
		cc.set(Calendar.SECOND, 59);
		cc.set(Calendar.MILLISECOND, 0);
		cc.add(Calendar.DATE, ds);
		return cc.getTime();
	}
	
	/**
	 * 获得明天日期，从0点0分0秒开始
	 * @return
	 */
	public static Date getNextDate()
	{
		Calendar cc=Calendar.getInstance();
		cc.add(Calendar.DATE, 1);
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		return cc.getTime();
	}
	
	/**
	 * 获得昨天天日期，从0点0分0秒开始
	 * @return
	 */
	public static Date getPertDate()
	{
		Calendar cc=Calendar.getInstance();
		cc.add(Calendar.DATE, -1);
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		return cc.getTime();
	}
	
	/**
	 * 获得昨天日期，23点59分59秒结束
	 * @return
	 */
	public static Date getPerDateForSecond()
	{
		Calendar cc=Calendar.getInstance();
		
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		cc.add(Calendar.SECOND, -1);
		return cc.getTime();
	}
		
	public static long getThisYearsBegin()
	{
		Calendar cc=Calendar.getInstance();
		cc.set(Calendar.MONTH, 0);
		cc.set(Calendar.DATE, 1);
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		return cc.getTimeInMillis();
	}
	
	public static long getNextYearsBegin()
	{
		Calendar cc=Calendar.getInstance();
		cc.set(Calendar.YEAR, TimeFormatTemplate.getThisYearsNum()+1);
		cc.set(Calendar.MONTH, 0);
		cc.set(Calendar.DATE, 1);
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		return cc.getTimeInMillis();
	}
	
	public static long getThisSeasonBegin()
	{
		Calendar cc=Calendar.getInstance();
		cc.set(Calendar.MONTH, 5);
		cc.set(Calendar.DATE, 1);
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		return cc.getTimeInMillis();
	}
	
	public static long getThisSeasonEnd()
	{
		Calendar cc=Calendar.getInstance();
		cc.set(Calendar.MONTH, 10);
		cc.set(Calendar.DATE, 1);
		cc.set(Calendar.HOUR_OF_DAY,0);
		cc.set(Calendar.MINUTE, 0);
		cc.set(Calendar.SECOND, 0);
		cc.set(Calendar.MILLISECOND, 0);
		return cc.getTimeInMillis();
	}
	
}
