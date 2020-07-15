package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                if(memname.getText().toString().equals("")||memnum.getText().toString().equals("")){
                    Toast.makeText(Mainmember.this,"입력 제대로 하세요!!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}