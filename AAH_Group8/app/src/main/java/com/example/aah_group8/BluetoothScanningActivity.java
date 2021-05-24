package com.example.aah_group8;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BluetoothScanningActivity extends AppCompatActivity {

    Button btnBluetoothScan;
    TextView txtBluetooth;
    IntentFilter scanIntentFilter = new IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED);
    BroadcastReceiver scanModeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)){
                int modeValue = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE,BluetoothAdapter.ERROR);

                if(modeValue == BluetoothAdapter.SCAN_MODE_CONNECTABLE){
                    txtBluetooth.setText("The device is not in discoverable mode but can still received connection.");
                }else if(modeValue == BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE){
                    txtBluetooth.setText("The device is in discoverable mode!");
                }else if(modeValue == BluetoothAdapter.SCAN_MODE_NONE){
                    txtBluetooth.setText("The device is not in discoverable mode and can not received connection.");
                }else {
                    txtBluetooth.setText("Error");
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_scanning);
        btnBluetoothScan = findViewById(R.id.btnBluetooth);
        txtBluetooth = findViewById(R.id.txtBluetooth);
        btnBluetoothScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent discoverableItent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                discoverableItent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION,8);
                startActivity(discoverableItent);
                registerReceiver(scanModeReceiver,scanIntentFilter);
            }
        });
    }
}
