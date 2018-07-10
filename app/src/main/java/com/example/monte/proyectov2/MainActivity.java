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
    private Button buttonAlertas;
    private Button buttonDiario;

    private static final String VIDEO_SAMPLE = "tacoma_narrows";
    private VideoView mVideoView;

    Calendar calendar = Calendar.getInstance();
    int day = calendar.get(Calendar.DAY_OF_WEEK);

    private Uri getMedia(String ian) {
        if(day == Calendar.MONDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ejercicio8);
        }
        if(day == Calendar.TUESDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ejercicio9);
        }
        if(day == Calendar.WEDNESDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ejercicio1);
        }
        if(day == Calendar.THURSDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ejercicio4);
        }
        if(day == Calendar.FRIDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ejercicio10);
        }
        if(day == Calendar.SATURDAY){
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ejercicio2);
        }
        else{
            return Uri.parse("android.resource://" + getPackageName() +
                    "/raw/" + R.raw.ejercicio3);
        }

    }

    private int mCurrentPosition = 0;
    private static final String PLAYBACK_TIME = "play_time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageButton) findViewById(R.id.buttonejercicios);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEjerciciosActivity();
            }
        });

        button3 = (Button) findViewById(R.id.buttonejercicios3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEjerciciosDiarios();
            }
        });

        buttonAlimentacion = (Button) findViewById(R.id.button_alimentacion);
        buttonAlimentacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAlimentacionActivity();
            }
        });

        buttonAlertas = (Button) findViewById(R.id.button_alertas);
        buttonAlertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenAlertasActivity();
            }
        });

        buttonDiario = (Button) findViewById(R.id.button_diario);
        buttonDiario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEjerciciosDiarios();
            }
        });

    }

    public void openEjerciciosDiarios(){
        Intent intent = new Intent(this, EjerciciosDiarios.class);
        startActivity(intent);
    }

    public void openEjerciciosActivity(){
        Intent intent = new Intent(this, EjerciciosActivity.class);
        startActivity(intent);
    }

    public void OpenAlimentacionActivity(){
        Intent intent = new Intent(this, Alimentacion.class);
        startActivity(intent);
    }

    public void OpenAlertasActivity(){
        Intent intent = new Intent(this, Alertas.class);
        startActivity(intent);
    }

}
