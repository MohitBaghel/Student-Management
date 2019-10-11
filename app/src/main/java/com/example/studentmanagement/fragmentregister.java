package com.example.studentmanagement;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class fragmentregister extends Fragment {
    EditText e1,e2,e3,e4,e5;
    Spinner sp;
    Button register,show;
    View v;
    String prog[]={"BCA","MCA","B.Tech","M.Tech"};
    ArrayAdapter<String> adp;
    String s1,s2,s3,s4,s5,s6;

    public fragmentregister() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragmentregister, container, false);
        e1=v.findViewById(R.id.roll);
        e2=v.findViewById(R.id.name);
        e3=v.findViewById(R.id.mobile);
        e4=v.findViewById(R.id.email);
        e5=v.findViewById(R.id.address);
        sp=v.findViewById(R.id.spins);
        register=v.findViewById(R.id.register);
        show=v.findViewById(R.id.showdetails);
        adp=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,prog);
        sp.setAdapter(adp);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=sp.getSelectedItem().toString();
                register();

            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),Fetch.class);
                startActivity(i);
            }
        });



        return v;
    }
    public void register(){
        RequestQueue rq= Volley.newRequestQueue(getActivity());
        String url="https://mohitbaghel908566.000webhostapp.com/SMS/register.php";
        StringRequest sr= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getActivity(), "Data Register", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Data not Registered"+error, Toast.LENGTH_SHORT).show();

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


}
