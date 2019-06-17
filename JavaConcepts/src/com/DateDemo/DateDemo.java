package com.DateDemo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
public static void main(String[] args) {
	Date d = new Date();
	System.out.println(d.toString()); // to print in the standard format provided by Date class.
	
	SimpleDateFormat sdf= new SimpleDateFormat("M/d/yyyy");
	
	System.out.println(sdf.format(d));   // Date object is passed to simple date format object to simplify the format.
	
	
	
}
}
