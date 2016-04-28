package com.ai.saas.comment.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 日期工具类
 * @author renfeng
 *
 */
public class DateUtil {
	/**
	 * str转sql date
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date StrToDate(String dateStr) throws ParseException{
		String[] split = dateStr.split("/");
		if(split.length>0){
			dateStr=dateStr.replaceAll("/", "-");
		}
		System.out.println(dateStr);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		java.util.Date parse = format.parse(dateStr);
		java.sql.Date date = new java.sql.Date(parse.getTime());
		return date;
	}
	/**
	 * str转sql date
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date StrToDate2(String dateStr) throws ParseException{
		String[] split = dateStr.split("/");
		if(split.length>0){
			dateStr=dateStr.replaceAll("/", "-");
		}
		System.out.println(dateStr);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parse = format.parse(dateStr);
		java.sql.Date date = new java.sql.Date(parse.getTime());
		return date;
	}
	/**
	 * str转Timestamp
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Timestamp StrToTimestamp3(String dateStr) throws ParseException{
		Timestamp valueOf = Timestamp.valueOf(dateStr);
		return valueOf;
	}
	/**
	 * Str转TimestampStr
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String StrToTimestampStr(String dateStr){
		dateStr+=" 00:00:00";
		return dateStr;
	}
	
	/**
	 * Timestamp转str
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String TimestampToStr3(Timestamp timestamp) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format2 = format.format(timestamp);
		return format2;
	}
	
	
	public static long getTimeLong(Timestamp timestamp){
		return timestamp.getTime();
	}
	
	//hyh 2016.01.26
	public static String StrToStr(String date){
		
		if(date!=null){
			String substring = date.substring(0,10);
			String date2=substring.replaceAll("-", "/");
			return date2;
		}
		return "";
	}
	
	
	/** 
	 * sql date转str
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String DateToStr(Date date){
		if(date!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String format2 = format.format(date);
			format2=format2.replaceAll("-", "/");
			return format2;
		}
		return "";
	}
	/**
	 * sql date转str
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String DateToStr2(Date date) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String format2 = format.format(date);
		return format2;
	}
	/**
	 * sql date转str
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String DateToStr3(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(date);
		return format2;
	}
	/**
	 * 获取当前年
	 * @return
	 */
	public static String getYear(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(new Date(System.currentTimeMillis()));
		return format2.substring(0, 4);
	}
	/**
	 * 获取当前时间
	 * @return
	 */
	public static Date getCurDate(){
		Date date = new Date(System.currentTimeMillis());
		return date;
	}
	/**
	 * 获取当前月
	 * @return
	 */
	public static String getMonth(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String format2 = format.format(new Date(System.currentTimeMillis()));
		return format2.substring(5, 7);
	}
	/**
	 * 根据日期获取是星期几
	 * @param date
	 * @throws ParseException
	 */
	public static String getWeek(String date){
		SimpleDateFormat format = new SimpleDateFormat("EEEE");
		Date strToDate2=null;
		try {
			strToDate2 = DateUtil.StrToDate2(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return format.format(strToDate2);
	}
	/**
	 * 获取可报销月
	 * @param maxNum
	 * @return
	 */
	public static List<String> getMonthList(int maxNum){
		List<String> monthList = new ArrayList<String>();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		for(int i=0;i<maxNum;i++){
			Calendar now = Calendar.getInstance();
			now.add(Calendar.MONTH, -i);
			String format2 = format.format(now.getTime());
			format2 = format.format(now.getTime());
			monthList.add(format2);
		}
		return monthList;
	}
	/**
	 * 获取两天后日期
	 * @return
	 */
	public static String getTwoDayAgo(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_YEAR, 2);
		String format2 = format.format(now.getTime());
		return format2;
	}

	/**
	 * str转Timestamp
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Timestamp strToTimestamp(String date){
		if(date!=null &&!"".equals(date)){
			String replaceAll = date.replaceAll("/", "-");
			String[] split = date.split("-");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat formatter2 =null;
			if(split.length>2){
				formatter2=new SimpleDateFormat("yyyy-MM-dd");
			}else{
				formatter2=new SimpleDateFormat("yyyy-MM");
			}
			java.util.Date parse;
			String format  = "";
			try {
				parse = formatter2.parse(replaceAll);
				format = formatter.format(parse);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Timestamp timestamp=Timestamp.valueOf(format);
			return timestamp;
		}
		return null;
	}
	/**
	 * Timestamp转sqldate
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date timestampToSqlDate(Timestamp date) throws ParseException{
		if(date!=null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String format2 = formatter.format(date);
			java.util.Date parse = formatter.parse(format2);
			java.sql.Date sqldate = new java.sql.Date(parse.getTime());
			return sqldate;
		}
		return null;
	}
	/**
	 * Timestamp转sqldate
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static Date timestampToSqlDate2(Timestamp date) {
		if(date!=null){
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
			String format2 = formatter.format(date);
			java.util.Date parse;
			java.sql.Date sqldate = new java.sql.Date(System.currentTimeMillis());
			try {
				parse = formatter.parse(format2);
				sqldate = new java.sql.Date(parse.getTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return sqldate;
		}
		return null;
	}
	
	
	public static Timestamp getSysDate() {
		String tsStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		try {
			ts = Timestamp.valueOf(tsStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ts;
	}
	
	
	
	
	
	
	/**
	 * Timestamp转str
	 * @param date
	 * @return
	 */
	public static String timestampToStr(Timestamp date){
		if(date!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM");
			String format2 = format.format(date);
			return format2;
		}
		return "";
	}
	/**
	 * Timestamp转str
	 * @param date
	 * @return
	 */
	public static String timestampToStr2(Timestamp date){
		if(date!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			String format2 = format.format(date);
			return format2;
		}
		return "";
	}
	/**
	 * Timestamp转str
	 * @param date
	 * @return
	 */
	public static String timestampToStr3(Timestamp date){
		if(date!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String format2 = format.format(date);
			return format2;
		}
		return "";
	}
	/**
	 * Timestamp转str
	 * @param date
	 * @return
	 */
	public static String timestampToStr4(Timestamp date){
		if(date!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			String format2 = format.format(date);
			return format2;
		}
		return "";
	}
	/**
	 * Timestamp转str
	 * @param date
	 * @return
	 */
	public static String timestampToStr5(Timestamp date){
		if(date!=null){
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format2 = format.format(date);
			return format2;
		}
		return "";
	}
	
	public static String getFormatSystemTime(String formatS){	
		    Date date = new Date(System.currentTimeMillis());
			SimpleDateFormat format = new SimpleDateFormat(formatS);
			String format2 = format.format(date);
			return format2;
	}
	
	public static String getFormatTime(Date date,String formatS){
		SimpleDateFormat format = new SimpleDateFormat(formatS);
		String format2 = format.format(date);
		return format2;
	}

		
		
	public static String getFormatTime( Timestamp timestamp,String formatS){
		SimpleDateFormat format = new SimpleDateFormat(formatS);
		String format2 = format.format(timestamp);
		return format2;
	}
	
	public static Date getFormatSqlDate(String dateStr,String formatStr) {
		String[] split = dateStr.split("/");
		if(split.length>0){
			dateStr=dateStr.replaceAll("/", "-");
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
		try {
			java.util.Date parse = format.parse(dateStr);
			date = new java.sql.Date(parse.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		java.util.Date parse = format.parse("205-08-01 00:00:00");
//		System.out.println(parse);
		//System.out.println(getFormatTime(new Timestamp(System.currentTimeMillis()),"yyyy-MM-dd"));
//		String strToTimestampStr = StrToTimestampStr("2015-09-09");
//		System.out.println(strToTimestampStr);
//		String week = getWeek("2016-01-10 00:00:00");
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		String format2 = format.format(new Date(System.currentTimeMillis()));
		Date a = StrToDate2("2016/01/28");
		String dateToStr = DateToStr(new Date(System.currentTimeMillis()));
		Date c = StrToDate2(dateToStr);
		System.out.println(a.compareTo(c));
	}
	
}
