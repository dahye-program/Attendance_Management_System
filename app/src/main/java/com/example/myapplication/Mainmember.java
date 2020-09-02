package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Mainmember extends AppCompatActivity {
    public static String studentName, studentNum;
    EditText memname;
    EditText memnum;
    Button memcheck;
    String member_status = "0";

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
            }
        });
        memnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        memcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(memname.getText().toString().equals("")||memnum.getText().toString().equals("")){
                    Toast.makeText(Mainmember.this,"입력 제대로 하세요!!",Toast.LENGTH_LONG).show();
                }
                else{
                    studentName = memname.getText().toString();        // editText 에서 회원 이름 저장
                    studentNum = memnum.getText().toString();   // editText 에서 회원 학번 저장
                    HttpConnectThread http = new HttpConnectThread(
                            "http://192.168.0.101:80/login.php",
                            "&status=" + member_status + "&name=" + studentName +
                                    "&number=" + studentNum);
                    http.start();
                    for(int i=0;i<1000;i++){
                        Log.i("TEST : ", "test");
                    }
                    String temp = http.GetResult();

                    // TODO : 서버로 회원의 학번, 이름 전송
                    if(temp.equals("1\n")){
                        Toast.makeText(Mainmember.this,"로그인 성공",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), member_generate_qrcode.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Mainmember.this,"로그인 실패",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}