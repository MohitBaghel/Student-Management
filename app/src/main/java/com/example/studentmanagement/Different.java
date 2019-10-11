package com.example.studentmanagement;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Different extends AppCompatActivity {
    ImageView i1;
    Button b1;
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_different);
        Bundle extras=getIntent().getExtras();//image ko parse karne k liye
        i1=findViewById(R.id.image1);
        i1.setImageResource(extras.getInt("key"));
        b1=findViewById(R.id.add);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm=getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.frame,new fragmentregister()).commit();

            }
        });

    }
}
