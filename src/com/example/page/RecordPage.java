package com.example.page;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.R;
import com.example.logic.QrResult;
import com.example.logic.RecordManager;

public class RecordPage extends Activity{
		
	ListView listView = null;
	ArrayList<HashMap<String, String> > list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_page);
        
        listView = (ListView)findViewById(R.id.recordListView);
        list = new ArrayList<HashMap<String, String> >();
        RecordManager rm = new RecordManager(this);
        ArrayList<QrResult> results = rm.getRecords();
        for(int i = 0; i < results.size(); i++)
        {
        	HashMap<String, String> _map = new HashMap<String, String>();
        	_map.put("courseName", results.get(i).getCourseName());
        	_map.put("date", results.get(i).getDate());
        	list.add(_map);
        }
        
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.record_layout, new String[]{"courseName","date"}, new int[]{R.id.id_course,R.id.id_date});
        
        listView.setAdapter(adapter);
        
    }
    
}
