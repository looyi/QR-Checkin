package com.example.page;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.R;

public class TeacherMainPage  extends Activity{
	
	Button createQR = null;
	Button query = null;	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_main);   
        createQR = (Button)findViewById(R.id.createQRButton);
        query = (Button)findViewById(R.id.querystudent);
        createQR.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(TeacherMainPage.this,QRCreatePage.class);
				TeacherMainPage.this.startActivity(intent);				
			}
		});
    }

}
