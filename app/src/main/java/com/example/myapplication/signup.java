package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    public static String member_status;
    RadioButton managebtn;
    EditText user_name;
    EditText user_number;
    RadioButton membtn;
    RadioGroup radioGroup;
    Button check;
    String user_name_text;
    String user_number_text;
    String signupResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        user_name=(EditText)findViewById(R.id.memname);
        user_number=(EditText)findViewById(R.id.memnumber);
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
            public void onClick(View view) { //확인 버튼 누를시
                user_name_text=user_name.getText().toString();
                user_number_text=user_number.getText().toString();

                if(signupResult!=null){
                    if(signupResult.equals("관리자")){
                        member_status="1";
                    }else if(signupResult.equals("회원")){
                        member_status="0";
                    }
                    Toast.makeText(signup.this,signupResult+" 회원가입", Toast.LENGTH_SHORT).show();
                    //String 형으로 입력받은 코드들을 서버로 전송

                    HttpConnectThread http = new HttpConnectThread(
                            "http://192.168.0.104:80/insert.php",
                            "&status=" + member_status + "&name=" + user_name_text +
                                    "&number=" + user_number_text);
                    http.start();
                    String temp = http.GetResult();
                    // TODO : 회원가입 실패 예외처리 필요함
                    // TODO : 'temp' 값 이용하여 성공 실패 메시지 출력할 필요 있어보임.
                    //회원가입 완료 후 메인 화면으로 돌아가기
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(signup.this,"관리자/회원 선택 해주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}