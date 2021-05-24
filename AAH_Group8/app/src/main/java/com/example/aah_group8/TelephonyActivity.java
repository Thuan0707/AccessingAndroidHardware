package com.example.aah_group8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aah_group8.actiion_dial.Action_DialActivity;
import com.example.aah_group8.action_call.Action_CallActivity;
import com.example.aah_group8.call_monitoring.MonitoringActivity;

public class TelephonyActivity extends AppCompatActivity {

    Button btnDial;
    Button btnCall;
    Button btnMoni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telephony);

        btnDial = findViewById(R.id.btnDial);

        btnCall = findViewById(R.id.btnCall);

        btnMoni = findViewById(R.id.btnMoni);

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelephonyActivity.this, Action_DialActivity.class);
                startActivity(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelephonyActivity.this, Action_CallActivity.class);
                startActivity(intent);
            }
        });

        btnMoni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelephonyActivity.this, MonitoringActivity.class);
                startActivity(intent);
            }
        });
    }
}