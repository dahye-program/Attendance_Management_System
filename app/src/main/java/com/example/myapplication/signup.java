package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    RadioButton managebtn;
    RadioButton membtn;
    RadioGroup radioGroup;
    Button check;
    String signupResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // 라디오 버튼 설정
        managebtn = (RadioButton)findViewById(R.id.signupmanager);
        membtn = (RadioButton)findViewById(R.id.signupmember);
        // 라디오 그룹 설정
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        check=(Button)findViewById(R.id.signupcheckbtn);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.signupmanager){
                    Toast.makeText(signup.this,"관리자 입니다.",Toast.LENGTH_SHORT).show();
                    signupResult=managebtn.getText().toString();
                }else if(i==R.id.signupmember){
                    Toast.makeText(signup.this, "회원 입니다.", Toast.LENGTH_SHORT).show();
                    signupResult=membtn.getText().toString();
                }
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(signupResult!=null){
                    Toast.makeText(signup.this,signupResult+" 회원가입", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(signup.this,"관리자/회원 선택 해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}