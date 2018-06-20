package com.example.pragatigusain.recyclerviewitemclicked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity
{
    TextView tv1,tv2,tv3,tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        tv3=(TextView)findViewById(R.id.tv3);
        tv4=(TextView)findViewById(R.id.tv4);
        Intent intent=getIntent();
        String name,college,address;
        long phone;
        name=intent.getStringExtra("Name");
        college=intent.getStringExtra("College");
        phone=intent.getLongExtra("Phone",0);
        address=intent.getStringExtra("Address");
        tv1.setText("Student Name:"+name);
        tv2.setText("Student College:"+college);
        tv3.setText("Student Phone Number:"+""+phone);
        tv4.setText("Student Address:"+address);
    }
}

