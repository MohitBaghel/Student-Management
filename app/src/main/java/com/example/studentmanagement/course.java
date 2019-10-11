package com.example.studentmanagement;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class course extends AppCompatActivity {
    //MediaPlayer mp;
    ImageView im;
    ListView lv;
    String name[]={"B.Tech","M.Tech","BCA","MCA","BSC"};
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        //mp= MediaPlayer.create(course.this,R.raw.awari);
        im=findViewById(R.id.image1);
        adp=new ArrayAdapter<String>(course.this,android.R.layout.simple_list_item_1,name);
        lv=findViewById(R.id.list);
        lv.setAdapter(adp);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){

                    case 0:
                        Intent i=new Intent(course.this,RegisterImage.class);
                        startActivity(i);
                        break;
                    case 1:
                        Intent i1=new Intent(course.this,RegisterImage.class);
                        startActivity(i1);
                        break;
                    case 2:
                        Intent i2=new Intent(course.this,RegisterImage.class);
                        startActivity(i2);
                        break;
                    case 3:
                        Intent i3=new Intent(course.this,RegisterImage.class);
                        startActivity(i3);
                        break;
                    case 4:
                        Intent i4=new Intent(course.this,RegisterImage.class);
                        startActivity(i4);
                        break;

                }
            }
        });
        im.post(new Runnable() {
            @Override
            public void run() {
                ((AnimationDrawable)im.getBackground()).start();
               // mp.start();
                }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
      //  mp.stop();
    }
}



