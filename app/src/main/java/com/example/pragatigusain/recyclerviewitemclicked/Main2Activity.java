package com.example.pragatigusain.recyclerviewitemclicked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements RecyclerAdapter.ListItemClickListener
{
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    DatabaseHelper databaseHelper;
    StudentModel studentModel;
    ArrayList<StudentModel> studentModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i=getIntent();
        String string=i.getStringExtra("Name");
        recyclerView = findViewById(R.id.rv);
        databaseHelper = new DatabaseHelper(this);

        studentModelArrayList.addAll(databaseHelper.allStudentsDetails());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter(studentModelArrayList, this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onListItemClickListener(int clickedItemIndex)
    {
        StudentModel studentModel = studentModelArrayList.get(clickedItemIndex);
        Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        intent.putExtra("Name",studentModel.getName());
        intent.putExtra("College",studentModel.getCollegeName());
        intent.putExtra("Phone",studentModel.getPhoneNumber());
        intent.putExtra("Address",studentModel.getAddress());
        startActivity(intent);
        Toast.makeText(getApplicationContext(),studentModelArrayList.get(clickedItemIndex).name,Toast.LENGTH_SHORT).show();
    }
}

