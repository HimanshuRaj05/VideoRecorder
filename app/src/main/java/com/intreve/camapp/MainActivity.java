package com.intreve.camapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=findViewById(R.id.videoView);
        btnClick=findViewById(R.id.btnClick);


        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);

                startActivityForResult(i, 1);
            }
        });

        ;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1) {
            // on below line setting video uri for our video view.
            videoView.setVideoURI(data.getData());
            // on below line starting a video view
            videoView.start();
        }
    }
}