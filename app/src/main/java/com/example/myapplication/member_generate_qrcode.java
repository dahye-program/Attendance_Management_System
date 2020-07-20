package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class member_generate_qrcode extends AppCompatActivity {
    private ImageView iv;
    private EditText membername;
    private EditText membernum;
    Button memAttendancebtn;
    Button memLeaveworkbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_generate_qrcode);
        memAttendancebtn = (Button)findViewById(R.id.memattendance);
        memLeaveworkbtn = (Button)findViewById(R.id.memLeavework);
        membername = (EditText)findViewById(R.id.memname);
        memAttendancebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv=(ImageView)findViewById(R.id.memqrcodeImage);
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                // BitMatrix, BarcodeFormat, BarcodeEncoder 모두 아까 가져온 journeyapps에서 가져온 것임.
                try{
                    BitMatrix bitMatrix = multiFormatWriter.encode("abc", BarcodeFormat.QR_CODE,300,300);
                    // BitMatrix 는 contents(원하는 내용), format(바코드 포맷 형식), width(가로), height(세로)를 인자로 받음
                    BarcodeEncoder barcodEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodEncoder.createBitmap(bitMatrix);
                    iv.setImageBitmap(bitmap);
            }catch(Exception e){}
            }
        });
        memLeaveworkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}