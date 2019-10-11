package com.example.studentmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class RegisterImage extends AppCompatActivity {
    ImageView im1,im2,im3,im4,im5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_image);
        im1=findViewById(R.id.img1);
        im2=findViewById(R.id.img2);
        im3=findViewById(R.id.img3);
        im4=findViewById(R.id.img4);
        im5=findViewById(R.id.img5);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterImage.this,Different.class);
                i.putExtra("key",R.drawable.aa);
                startActivity(i);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterImage.this,Different.class);
                i.putExtra("key",R.drawable.bb);
                startActivity(i);

            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterImage.this,Different.class);
                i.putExtra("key",R.drawable.cc);
                startActivity(i);

            }
        });
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterImage.this,Different.class);
                i.putExtra("key",R.drawable.dd);
                startActivity(i);

            }
        });
        im5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(RegisterImage.this,Different.class);
                i.putExtra("key",R.drawable.ee);
                startActivity(i);

            }
        });

    }
}






