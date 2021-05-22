package com.example.aah_group8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button1);
        btn.setOnClickListener(v -> CameraMethod());
    }
    public void CameraMethod(){
        Intent switchActivityIntent = new Intent(this, CameraActivity.class);
        startActivity(switchActivityIntent);
    }
}