package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class managerCertified extends AppCompatActivity {
    EditText managercertified;
    Button managerloginCheckbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_certified);
        managercertified = (EditText)findViewById(R.id.managerword); // 관리자가 입력한 인증번호
        managerloginCheckbtn = (Button)findViewById(R.id.managercertifiedbtn);

        managerloginCheckbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputWord = managercertified.getText().toString(); //입력한 인증번호 확인
                // TODO 인증번호 확인

                //성공 시
                Intent intent = new Intent(getApplicationContext(),recording_output.class); //관리자 모드 진입
            }
        });
    }
}