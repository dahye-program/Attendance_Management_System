package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    RadioButton managebtn;
    RadioButton membtn;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        managebtn = (RadioButton)findViewById(R.id.signupmanager);
        managebtn.setOnClickListener(radioButtonClickListener);

        membtn = (RadioButton)findViewById(R.id.signupmember);
        membtn.setOnClickListener(radioButtonClickListener);

        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);
    }
    RadioButton.OnClickListener radioButtonClickListener = new RadioButton.OnClickListener(){
        @Override
        public void onClick(View view){
            Toast.makeText(this,"managebtn : "+managebtn.isChecked()+"membtn:"+membtn.isChecked(),Toast.LENGTH_SHORT).show();
        }
    };
    RadioGroup.OnCheckedChangeListener radioGroupButtonChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if(i==R.id.signupmanager){
                Toast.makeText(this,"관리자!!",Toast.LENGTH_SHORT).show();
            }
        }
    }

}