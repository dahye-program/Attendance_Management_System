package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class member_generate_qrcode extends AppCompatActivity {
    Button memAttendancebtn;
    Button memLeaveworkbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_generate_qrcode);
        memAttendancebtn = (Button)findViewById(R.id.memattendance);
        memLeaveworkbtn = (Button)findViewById(R.id.memLeavework);

        memAttendancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        memLeaveworkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}