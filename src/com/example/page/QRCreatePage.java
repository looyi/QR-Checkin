package com.example.page;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.R;
import com.example.encoding.QRCreator;

public class QRCreatePage extends Activity{
	
	Button confirm = null;
	Button back = null;	
	EditText courseBox = null;
	EditText dateBox = null;
	EditText keyBox = null;
	ImageView qrImage = null;	
	ImageView qrContent = null;
	String text = "";
	int winWidth, winHeight;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qr_create_page);   
        confirm = (Button)findViewById(R.id.qrCreatorConfirm);
        back = (Button)findViewById(R.id.qrCreatorback);
        courseBox = (EditText)findViewById(R.id.courseBox);
        dateBox = (EditText)findViewById(R.id.dateBox);
        keyBox = (EditText)findViewById(R.id.keyBox);
        qrImage = (ImageView)findViewById(R.id.qr);
        qrContent = (ImageView)findViewById(R.id.qrcontentimage);   
        
        
		Display mDisplay = getWindowManager().getDefaultDisplay();
		winWidth = mDisplay.getWidth();
		winHeight = mDisplay.getHeight();
    	
		qrContent.setImageBitmap(createWhitePic((int)(0.8*winWidth),(int)(0.8*winWidth)));
		
        confirm.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(courseBox.getText().toString().equals(""))
				{
					Toast.makeText(QRCreatePage.this, "请输入课程名称", Toast.LENGTH_SHORT).show();
					return;
				}
				if(dateBox.getText().toString().equals(""))
				{
					Toast.makeText(QRCreatePage.this, "请输入上课时间", Toast.LENGTH_SHORT).show();
					return;
				}
				if(keyBox.getText().toString().equals(""))
				{
					Toast.makeText(QRCreatePage.this, "请输入密钥", Toast.LENGTH_SHORT).show();
					return;
				}
				text += courseBox.getText().toString() + " " + dateBox.getText().toString()+ " "+keyBox.getText().toString();

				qrImage.setImageBitmap(QRCreator.createImage(text,winWidth,winHeight));
			}
		});
        back.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				QRCreatePage.this.finish();
			}
        });
        
        
        
    }
    
    public Bitmap createWhitePic(int w, int h)
    {
    	int []pixes = new int[w*h];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {                                                    
            	pixes[y * w + x] = 0xffffffff;                
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h,
                Bitmap.Config.ARGB_8888);

        bitmap.setPixels(pixes, 0, w, 0, 0, w, h);

        return bitmap;
    }
}
