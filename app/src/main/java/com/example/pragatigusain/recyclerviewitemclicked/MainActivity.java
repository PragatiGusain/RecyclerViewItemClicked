package com.example.pragatigusain.recyclerviewitemclicked;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    static final String TAG = MainActivity.class.getName();

    EditText enter_name, enter_phone, enter_address;
    Button add, display;
    String collegeName = "";
    ArrayList<StudentModel> studentArrayList = new ArrayList<>();
    Spinner spinnerCollegeNames;
    String collegeNames[]={"Select College Name","DIT","Graphic Era","UIT","HNB","Petroleum"};
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter_name = findViewById(R.id.et1);
        enter_phone = findViewById(R.id.et2);
        enter_address = findViewById(R.id.et3);
        add = findViewById(R.id.b1);
        display = findViewById(R.id.b2);
        spinnerCollegeNames = findViewById(R.id.s1);
        databaseHelper = new DatabaseHelper(this);
        spinnerCollegeNames.setOnItemSelectedListener(this);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, collegeNames);
        spinnerCollegeNames.setAdapter(arrayAdapter);
        spinnerCollegeNames.setPrompt(collegeNames[0]);

        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    String name = enter_name.getText().toString();
                    long phone = Long.parseLong(enter_phone.getText().toString());
                    String address = enter_address.getText().toString();
                    databaseHelper.addNewStudent(new StudentModel(name, collegeName, address, phone));
                    Toast.makeText(getApplicationContext(), "Student data saved successfully", Toast.LENGTH_LONG).show();
                }
                catch(NumberFormatException e)
                {
                    Toast.makeText(getApplicationContext(), "Please Enter Valid Details", Toast.LENGTH_LONG).show();
                }
            }
        });

        display.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                studentArrayList.addAll(databaseHelper.allStudentsDetails());
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("Name",enter_name.getText());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        collegeName = collegeNames[position];
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
