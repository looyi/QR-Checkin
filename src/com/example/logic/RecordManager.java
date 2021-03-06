package com.example.logic;

import java.util.ArrayList;

import android.content.Context;

public class RecordManager {	
	public RecordDBAdapter dbAdapter = null;
	public Context context;
	
	public RecordManager(Context context)
	{
		this.context = context;
		dbAdapter = new RecordDBAdapter(context, "records", null, 1);        
	}
		
	
	public boolean signIn(QrResult result)
	{
		return dbAdapter.insertRecord(result);		
	}
	
	public ArrayList<QrResult> getRecords()
	{
		return dbAdapter.getRecords();
	}
	
}
