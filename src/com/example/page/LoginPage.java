package com.example.page;

import com.example.R;
import com.example.logic.UserData;
import com.example.logic.UserManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class LoginPage extends Activity {
	
	RadioGroup group = null;
	EditText userName = null;
	EditText password = null;
	Button register = null;
	Button confirm = null;
	int identity = UserData.STUDENT;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        userName = (EditText)findViewById(R.id.userNameId);
        password = (EditText)findViewById(R.id.passwordId);
        
        group = (RadioGroup)findViewById(R.id.radioGroup);
        
        register = (Button)findViewById(R.id.registerId);
        confirm = (Button)findViewById(R.id.loginId);
        
        group.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				int radioButtonId = group.getCheckedRadioButtonId();
				if(radioButtonId == R.id.studentRadioId)
					identity = UserData.STUDENT;
				else
					identity = UserData.TEACHER;
				
			}        	
        });
        
        confirm.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				if(userName.getText().toString().equals(""))
				{
					Toast.makeText(LoginPage.this, "«Î ‰»Î”√ªß√˚", Toast.LENGTH_SHORT).show();
					return;
				}
				if(password.getText().toString().equals(""))
				{
					Toast.makeText(LoginPage.this, "«Î ‰»Î√‹¬Î", Toast.LENGTH_SHORT).show();
					return;
				}
				String uName = userName.getText().toString();
				String psw = password.getText().toString();
				UserData user = UserData.get();
				user.setUserName(uName);
				user.setPassword(psw);
				user.setIdentity(identity);
				UserManager userManager = new UserManager(LoginPage.this);
				if(!userManager.login(user))
				{
					Toast.makeText(LoginPage.this, "±ß«∏£¨√‹¬Î¥ÌŒÛ", Toast.LENGTH_SHORT).show();
					return;
				}
				Intent intent = null;
				if(identity == UserData.STUDENT)				
					intent = new Intent(LoginPage.this,MainPage.class);				
				else
					intent = new Intent(LoginPage.this,TeacherMainPage.class);
				LoginPage.this.startActivity(intent);				
			}
		});
        
    }
}
