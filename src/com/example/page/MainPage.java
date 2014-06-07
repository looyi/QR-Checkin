package com.example.page;

import com.example.encoding.QRCreator;
import com.example.qrcode.CaptureActivity;
import com.example.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainPage extends Activity{
	
	Button signIn = null;
	Button check = null;
	ImageView qrCode = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        signIn = (Button)findViewById(R.id.signIn);
        check = (Button)findViewById(R.id.check);
        signIn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(MainPage.this,CaptureActivity.class);
				MainPage.this.startActivity(intent);
			}
		});
        
        check.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(MainPage.this,RecordPage.class);
				MainPage.this.startActivity(intent);
			}
		});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
