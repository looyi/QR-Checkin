package com.example.logic;

import android.content.Context;

public class UserManager {

	private Context context;
	public UserManager(Context c)
	{
		this.context = c;
	}
	
	public boolean login(UserData user)
	{
		UserDataDBAdapter dbAdapter = new UserDataDBAdapter(context,"users", null, 1);
		boolean isTeacher = true;
		if(user.getIdentity() == UserData.STUDENT)
			isTeacher = false;
		String s = dbAdapter.getPassword(user.getUserName(), isTeacher);
		if(s == null)
			return false;
		if(s.equals(user.getPassword()))
			return true;
		else 
			return false;
	}
	
	public boolean register(String userName, String pwd, boolean isTeacher)
	{
		UserDataDBAdapter dbAdapter = new UserDataDBAdapter(context,"users", null, 1);
		if(dbAdapter.isUserExit(userName))
			return false;
		return dbAdapter.insertRecord(userName, pwd, isTeacher);
		
	}
}
