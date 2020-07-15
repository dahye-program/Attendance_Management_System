package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Mainmember extends AppCompatActivity {
    EditText memname;
    EditText memnum;
    Button memcheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmember);
        memname = (EditText) findViewById(R.id.memname);
        memnum = (EditText) findViewById(R.id.memnumber);
        memcheck = (Button)findViewById(R.id.memberloginbtn);

        memname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memname.setText("");
            }
        });
        memnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memnum.setText("");
            }
        });
        memcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}