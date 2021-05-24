package com.example.aah_group8.actiion_dial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aah_group8.MainActivity;
import com.example.aah_group8.R;

public class Action_DialActivity extends AppCompatActivity {

    Button mDialButton;
    EditText mPhoneNoEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_dial);

        mDialButton = findViewById(R.id.btn_dial);

        mPhoneNoEt = findViewById(R.id.et_phone_no);

        mDialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo = mPhoneNoEt.getText().toString();
                if(!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                }else {
                    Toast.makeText(Action_DialActivity.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}