package com.example.logic;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter extends SQLiteOpenHelper {
	
	public SQLiteDatabase DB = null;	
	
	public DBAdapter(Context context, String name, CursorFactory cursorFactory, int version)
	{
		super(context,name,cursorFactory,version);					
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE records (_id INTEGER PRIMARY KEY AUTOINCREMENT, courseName TEXT, date TEXT);");
	}
	
	boolean insertRecord(QrResult result)
	{				
		DB = getWritableDatabase();		
		try {
			ContentValues values = new ContentValues();
			values.put("courseName", result.getCourseName());
			values.put("date", result.getDate());
			DB.insert("records", null, values);
			DB.close();
			DB = null;
		} catch (SQLException e) {
			// TODO: handle exception
			return false;
		}		
		return true;
	}
	
	ArrayList<QrResult> getRecords()
	{		
		DB = getReadableDatabase();
		Cursor result=DB.rawQuery("SELECT * FROM records", null);
		result.moveToFirst(); 
		ArrayList<QrResult> list = new ArrayList<QrResult>();
	    while (!result.isAfterLast()) {
	    	QrResult qr = new QrResult();
	        qr.course=result.getString(1); 
	        qr.date=result.getString(2); 	        
	        // do something useful with these 
	        result.moveToNext(); 
	        list.add(qr);
	      }
	    DB.close();
	    DB = null;	    
	    return list;
	}

//	void updateContact(Contact contact, Contact newContact)
//	{
//		DB = getWritableDatabase();
//		ContentValues values = new ContentValues();
//		values.put("name", newContact.name);
//		values.put("phone", newContact.phone);
//		values.put("extra", newContact.extra);
//		values.put("gender", newContact.gender);	
//		String[] args = {contact.name,contact.phone,contact.extra, contact.gender};
//		DB.update("myContact", values, "name=? AND phone=? AND extra=? AND gender=?", args);
//		DB.close();
//		DB = null;
//	}
	
//	void deleteContact(Contact contact)
//	{
//		DB = getWritableDatabase();
//		String[] args = {contact.name,contact.phone,contact.extra, contact.gender};
//		DB.delete("myContact", "name=? AND phone=? AND extra=? AND gender=?", args);
//		DB.close();
//		DB = null;
//	}
	
	
	


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}
