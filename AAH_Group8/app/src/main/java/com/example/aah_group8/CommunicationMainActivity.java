package com.example.aah_group8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CommunicationMainActivity extends AppCompatActivity {
    private Button btnWifi;
    private Button btnBluetooth;
    private Button btnNetwork;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communications_main);
        btnWifi = findViewById(R.id.btnWifi);
        btnWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickWifiBtn(v);
            }
        });
    }

    public void onClickWifiBtn(View view){
//        Intent intent = new Intent(new Intent())
    }


}
