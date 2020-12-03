package com.dynamicconfiguration;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import jdk.nashorn.internal.parser.DateParser;

public class TestClass {

	public static void main(String[] args) throws ParseException {
	
	/*	System.out.println(new Date());
		
		
		try {
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
			DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("IST"));
			
			System.out.println("Hi1:"+DATE_FORMAT.parse(new Date().toString()));
			
			System.out.println("Hi2:"+DATE_FORMAT.parse("2020-02-17T13:57:24.547000"));
			
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		*/
		java.sql.Date d = new java.sql.Date(System.currentTimeMillis());
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
		String s = ts.toString();
		System.out.println();
		SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-mm-ddTHH:mm:ss");
		
		DATE_FORMAT.parse(s);
		Date dt = DATE_FORMAT.parse(s);
				System.out.println(dt);
	}
	
}
