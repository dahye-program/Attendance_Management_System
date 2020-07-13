package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   // public static int status;
    Button managebtn;
    Button memberbtn;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //실행시켰을 때 제일 먼저 초기화되는 메소드
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // status = 0;
        managebtn = (Button) findViewById(R.id.chosemanagebtn);
        memberbtn = (Button) findViewById(R.id.chosememberbtn);
        //edit = (EditText) findViewById(R.id.edit);
        managebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Mainmanagement.class);
                startActivity(intent);
            }
        });
        memberbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),Mainmember.class);
                startActivity(intent);
            }
        });
    }
}