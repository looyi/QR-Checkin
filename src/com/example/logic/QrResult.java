package com.example.logic;

public class QrResult {

	String date = "";
	String key = "";
	String course = "";
	
	public QrResult()
	{
		
	}
	
	public QrResult(String result)
	{
		if(isValid(result))
		{
			String [] data = result.split(" ");
			course = data[0];
			date = data[1];
			key = data[2];
		}
	}
	
	public String getDate()
	{
		return date;		
	}
	
	public String getKey()
	{
		return key;
	}
	
	public String getCourseName()
	{
		return course;
	}
	
	public static boolean isValid(String resultString)
	{
		if(resultString.split(" ").length == 3)
			return true;
		return false;		
	}
	
	public boolean isValid()
	{
		if("".equals(course) || "".equals(date) || "".equals(key))
			return false;
		return true;
	}
}
