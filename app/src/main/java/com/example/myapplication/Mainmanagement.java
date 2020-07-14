package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mainmanagement extends AppCompatActivity {
    EditText mname;
    EditText mnum;
    Button mcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmanage);
        mname = (EditText) findViewById(R.id.managername);
        mnum = (EditText) findViewById(R.id.managernumber);
        mcheck = (Button) findViewById(R.id.managerloginbtn);

        mname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        mcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}