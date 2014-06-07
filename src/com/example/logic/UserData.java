package com.example.logic;

public class UserData {
	
	public static final int STUDENT = 1;
	public static final int TEACHER = 2;
	
	private String name;
	private String password;	
	private int identity; 
	private static UserData instance = null;
	private UserData(){}
	public static UserData get()
	{
		if(instance == null)
			instance = new UserData();
		return instance;
	}
	public void setUserName(String n)
	{
		name = n;
	}
	
	public void setPassword(String p)
	{
		password = p;
	}
	
	public void setIdentity(int i)
	{
		identity = i;
	}
		
	public String getUserName()
	{
		return name;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public int getIdentity()
	{
		return identity; 
	}
	
}
