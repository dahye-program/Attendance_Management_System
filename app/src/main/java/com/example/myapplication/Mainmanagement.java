package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Mainmanagement extends AppCompatActivity {
    public static String manageName, manageNum;
    EditText mname;
    EditText mnum;
    Button mcheck;
    String member_status = "1";
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
                if(mname.getText().toString().equals("")||mnum.getText().toString().equals("")){
                    Toast.makeText(Mainmanagement.this,"입력 제대로 하세요!!",Toast.LENGTH_LONG).show();
                }
                else{
                    manageName = mname.getText().toString();        // editText 에서 관리자 이름 저장
                    manageNum = mnum.getText().toString();   // editText 에서 관리자 학번 저장
                    HttpConnectThread http = new HttpConnectThread(
                            "http://192.168.0.104:80/login.php",
                            "&status=" + member_status + "&name=" + manageName+
                                    "&number=" + manageNum);
                    http.start();
                    for(int i=0;i<5000;i++){
                        Log.i("TEST : ", "test");
                    }
                    String temp = http.GetResult();
                    // TODO : 서버로 관리자의 학번,이름 전송
                    if(temp.equals("1\n")){
                        Toast.makeText(Mainmanagement.this,"로그인 성공",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), recording_output.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Mainmanagement.this,"로그인 실패",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}