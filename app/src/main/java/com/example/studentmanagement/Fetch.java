package com.example.studentmanagement;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Fetch extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6;
    String s1, s2, s3, s4, s5, s6;
    Button fetch, updatee, delete;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch);
        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.edit2);
        e3 = findViewById(R.id.edit3);
        e4 = findViewById(R.id.edit4);
        e5 = findViewById(R.id.edit5);
        e6 = findViewById(R.id.edit6);
        pb=findViewById(R.id.pb);
        fetch = findViewById(R.id.b1);
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();
                s5 = e5.getText().toString();
                s6 = e6.getText().toString();
                fetch();
            }
        });
        updatee = findViewById(R.id.b2);
        updatee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();
                s5 = e5.getText().toString();
                s6 = e6.getText().toString();
                updatee();
            }
        });
        delete=findViewById(R.id.b3);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                delete();
            }
        });

    }

    public void fetch() {

        s1 = e1.getText().toString();
        RequestQueue rq = Volley.newRequestQueue(Fetch.this);
        String url = config.DATA_URL + s1;
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                showJason(response);
                Toast.makeText(Fetch.this, "DATA FETCH", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Fetch.this, "DATA  NOT FETCH", Toast.LENGTH_SHORT).show();

            }
        });
        rq.add(sr);
    }

    public void showJason(String response) {

        String name1 = "";
        String mobile1 = "";
        String email1 = "";
        String address1 = "";
        String course1 = "";

        try {
            JSONObject jo = new JSONObject(response);
            JSONArray jr = jo.getJSONArray(config.KEY_RESULT);
            JSONObject jt = jr.getJSONObject(0);
            name1 = jt.getString(config.KEY_NAME);
            mobile1 = jt.getString(config.KEY_MOBILE);
            email1 = jt.getString(config.KEY_EMAIL);
            address1 = jt.getString(config.KEY_ADDRESS);
            course1 = jt.getString(config.KEY_COURSE);
        } catch (JSONException e) {

        }
        e2.setText(name1);
        e3.setText(mobile1);
        e4.setText(email1);
        e5.setText(address1);
        e6.setText(course1);
    }



            public void updatee() {

                RequestQueue rq = Volley.newRequestQueue(Fetch.this);
                String url = "https://mohitbaghel908566.000webhostapp.com/SMS/update.php";
                StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(Fetch.this, "Data Update", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Fetch.this, "Error In Updation", Toast.LENGTH_SHORT).show();

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hm = new HashMap<String, String>();
                        hm.put("r", s1);
                        hm.put("n", s2);
                        hm.put("m", s3);
                        hm.put("e", s4);
                        hm.put("a", s5);
                        hm.put("c", s6);
                        return hm;

                    }
                };

                rq.add(sr);
            }
    public void delete(){
        RequestQueue rq=Volley.newRequestQueue(Fetch.this);
        String url="https://mohitbaghel908566.000webhostapp.com/SMS/delete.php";
        StringRequest sr=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Fetch.this, "Data Deleted", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Fetch.this, "Error In Deletion", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> hm=new HashMap<String, String>();
                hm.put("r",s1);
                hm.put("n",s2);
                hm.put("m",s3);
                hm.put("e",s4);
                hm.put("a",s5);
                hm.put("c",s6);
                return  hm;


            }
        };
        rq.add(sr);
    }

        }


