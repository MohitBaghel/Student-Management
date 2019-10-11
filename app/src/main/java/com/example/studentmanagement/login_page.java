package com.example.studentmanagement;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;


public class login_page extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String s1,s2;
    CheckBox cb1;
    TextInputLayout signupuser,signuppassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        if(Build.VERSION.SDK_INT>16){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        e1=findViewById(R.id.username1);
        e2=findViewById(R.id.password1);
        cb1=findViewById(R.id.checkbox);
        signupuser=findViewById(R.id.signup_input_username);
        signuppassword=findViewById(R.id.signup_input_password);
        b1=findViewById(R.id.login);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString().trim();
                s2=e2.getText().toString().trim();
                if(s1.contentEquals("mohit")&& s2.contentEquals("1234")){

                    Intent i=new Intent(login_page.this,course.class);
                    startActivity(i);
                }

            }
        });

       cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(!isChecked)
               {
                   e2.setTransformationMethod(PasswordTransformationMethod.getInstance());
               }
               else
               {
                   e2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
               }
           }
       });

    }
}
