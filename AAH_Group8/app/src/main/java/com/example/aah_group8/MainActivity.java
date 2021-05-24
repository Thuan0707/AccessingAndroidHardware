
package com.example.aah_group8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn, btnCompass,button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button1);
        btnCompass = findViewById(R.id.btnCompass);

        btn.setOnClickListener(v -> CameraMethod());
        btnCompass.setOnClickListener(v -> compassMethod());

        button  =  findViewById(R.id.buttonHien);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TelephonyActivity.class);
                startActivity(intent);
            }
        });
    }
    public void CameraMethod(){
        Intent switchActivityIntent = new Intent(this, CameraActivity.class);
        startActivity(switchActivityIntent);
    }

    public void compassMethod(){
        Intent intent = new Intent(this, CompassActivity.class);
        startActivity(intent);
    }
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, KhuongActivity.class);
        startActivity(intent);
    }
}
