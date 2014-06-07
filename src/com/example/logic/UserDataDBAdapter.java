package com.example.logic;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDataDBAdapter extends SQLiteOpenHelper {
	
	public SQLiteDatabase DB = null;	
	
	public UserDataDBAdapter(Context context, String name, CursorFactory cursorFactory, int version)
	{
		super(context,name,cursorFactory,version);					
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE users (_id INTEGER PRIMARY KEY AUTOINCREMENT, userName TEXT, password TEXT, isTeacher BOOLEAN);");
	}
	
	boolean insertRecord(String name, String pwd, boolean isTeacher)
	{				
		DB = getWritableDatabase();		
		try {
			ContentValues values = new ContentValues();
			values.put("userName", name);
			values.put("password", pwd);
			values.put("isTeacher", isTeacher);
			DB.insert("users", null, values);
			DB.close();
			DB = null;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}		
		return true;
	}
	
	String getPassword(String userName, boolean isTeacher)
	{		
		DB = getReadableDatabase();
		Cursor result=DB.rawQuery("SELECT * FROM users", null);
		result.moveToFirst(); 		
	    while (!result.isAfterLast()) {
	    	boolean dbIsTeacher = true;
	    	if(result.getString(3).equals("0"))
	    		dbIsTeacher = false;
	    	String s = result.getString(1);
	        if(result.getString(1).equals(userName) && dbIsTeacher == isTeacher)
	        	return result.getString(2);	         	        
	        result.moveToNext(); 	        
	      }
	    DB.close();
	    DB = null;	    
	    return null;
	}

	boolean isUserExit(String userName)
	{
		DB = getReadableDatabase();
		Cursor result=DB.rawQuery("SELECT * FROM users", null);
		result.moveToFirst(); 		
	    while (!result.isAfterLast()) {
	    	
	        if(result.getString(1).equals(userName))
	        	return true;
	        result.moveToNext(); 	        
	      }
	    DB.close();
	    DB = null;	    
	    return false;
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
