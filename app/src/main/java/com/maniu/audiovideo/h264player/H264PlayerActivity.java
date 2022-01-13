package com.maniu.audiovideo.h264player;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.maniu.h264player.R;

import java.io.File;

public class H264PlayerActivity extends AppCompatActivity {

    H264Player h264Player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h264_player);
        initSurface();
    }

    private void initSurface() {
        SurfaceView surface = (SurfaceView) findViewById(R.id.preview);
        final SurfaceHolder surfaceHolder = surface.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder holder) {
                h264Player = new H264Player(H264PlayerActivity.this,
                        new File(Environment.getExternalStorageDirectory(), "out2.h264").getAbsolutePath(),
                        surfaceHolder.getSurface());
                h264Player.play();
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

            }
        });
    }
}