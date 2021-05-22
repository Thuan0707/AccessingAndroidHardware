package com.example.aah_group8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.VideoView;

public class CameraActivity extends AppCompatActivity {
    private ImageView mimageView;
    private static final int REQUEST_IMAGE_CAPTURE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        mimageView = findViewById(R.id.imageView);
    }

    public void TakePicture(View view) {
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (imageTakeIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void Record(View view) {
        Intent recordIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        recordIntent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 10);
        startActivityForResult(recordIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        {
            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                mimageView.setImageBitmap(imageBitmap);
            }
            if (requestCode == 1 && resultCode == RESULT_OK) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                VideoView videoView = new VideoView(this);
                videoView.setVideoURI(data.getData());
                videoView.start();
                builder.setView(videoView).show();
            }
        }
    }
}