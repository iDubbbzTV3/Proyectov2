package com.example.monte.proyectov2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private ImageButton button;
    private ImageButton button2;
    private Button button3;
    private Button buttonAlimentacion;

    private static final String VIDEO_SAMPLE = "tacoma_narrows";
    private VideoView mVideoView;

    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);

    private Uri getMedia(String ian) {
        if(day == Calendar.MONDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ian);
        }
        if(day == Calendar.TUESDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ian);
        }
        if(day == Calendar.WEDNESDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.dog);
        }
        if(day == Calendar.THURSDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ian);
        }
        if(day == Calendar.FRIDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ian);
        }
        if(day == Calendar.SATURDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ian);
        }
        else{
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ian);
        }

    }

    private int mCurrentPosition = 0;
    private static final String PLAYBACK_TIME = "play_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = findViewById(R.id.video_main);
        MediaController controller = new MediaController(this);
        controller.setMediaPlayer(mVideoView);
        mVideoView.setMediaController(controller);

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        //String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ian;

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(PLAYBACK_TIME);
        }

        button = (ImageButton) findViewById(R.id.buttonejercicios);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEjerciciosActivity();
            }
        });

        button2 = (ImageButton) findViewById(R.id.buttonejercicios2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEjerciciosActivity();
            }
        });

        button3 = (Button) findViewById(R.id.buttonejercicios3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEjerciciosActivity();
            }
        });

        buttonAlimentacion = (Button) findViewById(R.id.button_alimentacion);
        buttonAlimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAlimentacionActivity();
            }
        });

    }

    public void openEjerciciosActivity(){
        Intent intent = new Intent(this, EjerciciosActivity.class);
        startActivity(intent);
    }

    public void OpenAlimentacionActivity(){
        Intent intent = new Intent(this, Alimentacion.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(PLAYBACK_TIME, mVideoView.getCurrentPosition());
    }

    private void initializePlayer() {
        Uri videoUri = getMedia(VIDEO_SAMPLE);
        mVideoView.setVideoURI(videoUri);
        if (mCurrentPosition > 0) {
            mVideoView.seekTo(mCurrentPosition);
        } else {
            // Skipping to 1 shows the first frame of the video.
            mVideoView.seekTo(1);
        }
        mVideoView.start();
    }

    private void releasePlayer() {
        mVideoView.stopPlayback();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initializePlayer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        releasePlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            mVideoView.pause();
        }
    }


}
