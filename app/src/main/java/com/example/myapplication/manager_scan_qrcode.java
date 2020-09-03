package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class manager_scan_qrcode extends AppCompatActivity {
    private IntentIntegrator qrScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_scan_qrcode);

        // new IntentIntegrator(this).initiateScan(); 세로모드로 변경하기 위해 변경
        qrScan = new IntentIntegrator(this);
        qrScan.setOrientationLocked(false); //default는 세로모드 휴대폰 방향에 따라 가로, 세로로 자동 변경
        qrScan.setPrompt("QR코드를 스캔합시다");
        qrScan.initiateScan(); //스캐너
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result!=null){
            if(result.getContents()==null){
                Toast.makeText(this,"Cancelled", Toast.LENGTH_LONG).show();
                //todo
            }else{ //읽은 qr코드 값이 NULL이 아니면,
                String contents = result.getContents().toString();
                Toast.makeText(this,"Scanned:"+result.getContents(),Toast.LENGTH_LONG).show();
                super.onActivityResult(requestCode,resultCode,data);
                // 스캔한 결과값 받아와서 처리하는 함수
                HttpConnectThread http = new HttpConnectThread(
                        "http://192.168.0.101:80/insertQRdata.php", //QR코드 데이터 전송
                        "&userdata=" + contents);
                http.start();
                for(int i=0;i<5000;i++){
                    Log.i("TEST : ", "test");
                }
                String temp_record = http.GetResult();
                if(temp_record.equals("New record create successfully")){
                    Toast.makeText(this,"출/퇴근 기록 완료", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),Mainmanagement.class);
                    startActivity(intent);
                }
            }
        }
    }
}