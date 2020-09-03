package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class recording_output extends AppCompatActivity {
    Button recordShow;
    Button qrScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording_output);
        recordShow = (Button)findViewById(R.id.showRecordbtn);
        qrScan = (Button)findViewById(R.id.managerQRscanbtn);

        qrScan.setOnClickListener(new View.OnClickListener() { // 관리자 모드에서 QR코드 스캔 버튼 클릭시
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), manager_scan_qrcode.class);
                startActivity(intent);
            }
        });

        recordShow.setOnClickListener(new View.OnClickListener() { // 관리자 모드에서 출/퇴근 기록 보기 버튼 클릭 시
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getApplicationContext(), memberRecord.class);
                //startActivity(intent);
            }
        });
    }
}