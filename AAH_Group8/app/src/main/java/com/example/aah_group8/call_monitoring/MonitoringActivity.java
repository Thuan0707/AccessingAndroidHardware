package com.example.aah_group8.call_monitoring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aah_group8.R;

public class MonitoringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);

        if (ContextCompat.checkSelfPermission(MonitoringActivity.this,
                Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MonitoringActivity.this,
                    Manifest.permission.READ_PHONE_STATE)){
                ActivityCompat.requestPermissions(MonitoringActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
            }else {
                ActivityCompat.requestPermissions(MonitoringActivity.this,
                        new String[]{Manifest.permission.READ_PHONE_STATE}, 1);
            }
        }else {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(MonitoringActivity.this,
                            Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission granted !", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "No Permission granted !", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}