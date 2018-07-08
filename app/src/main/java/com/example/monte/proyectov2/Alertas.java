package com.example.monte.proyectov2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Calendar;

public class Alertas extends AppCompatActivity {

    Switch switchDesayuno;
    Switch switchSnack1;
    Switch switchAlmuerzo;
    Switch switchSnack2;
    Switch switchCena;
    Switch switchSnack3;
    Switch switchBedtime;

    Button negativoDesayuno;
    Button positivoDesayuno;
    Button negativoSnack1;
    Button positivoSnack1;
    Button negativoAlmuerzo;
    Button positivoAlmuerzo;
    Button negativoSnack2;
    Button positivoSnack2;
    Button negativoCena;
    Button positivoCena;
    Button negativoSnack3;
    Button positivoSnack3;
    Button negativoBedtime;
    Button positivoBedtime;

    TextView horaDesayuno;
    TextView minutosDesayuno;
    TextView horaSnack1;
    TextView minutosSnack1;
    TextView horaAlmuerzo;
    TextView minutosAlmuerzo;
    TextView horaSnack2;
    TextView minutosSnack2;
    TextView horaCena;
    TextView minutosCena;
    TextView horaSnack3;
    TextView minutosSnack3;
    TextView horaBedtime;
    TextView minutosBedtime;

    TextView pruebaHora;
    TextView pruebaMinuto;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertas);

        horaDesayuno = (TextView) findViewById(R.id.textview_time_breakfast_hour);
        minutosDesayuno = (TextView) findViewById(R.id.textview_time_breakfast_minute);
        horaSnack1 = (TextView) findViewById(R.id.textview_time_snack1_hour);
        minutosSnack1 = (TextView) findViewById(R.id.textview_time_snack1_minute);
        horaAlmuerzo = (TextView) findViewById(R.id.textview_time_lunch_hour);
        minutosAlmuerzo = (TextView) findViewById(R.id.textview_time_lunch_minute);
        horaSnack2 = (TextView) findViewById(R.id.textview_time_snack2_hour);
        minutosSnack2 = (TextView) findViewById(R.id.textview_time_snack2_minute);
        horaCena = (TextView) findViewById(R.id.textview_time_dinner_hour);
        minutosCena = (TextView) findViewById(R.id.textview_time_dinner_minute);
        horaSnack3 = (TextView) findViewById(R.id.textview_time_snack3_hour);
        minutosSnack3 = (TextView) findViewById(R.id.textview_time_snack3_minute);
        horaBedtime = (TextView) findViewById(R.id.textview_time_bedtime_hour);
        minutosBedtime = (TextView) findViewById(R.id.textview_time_bedtime_minute);

        negativoDesayuno = (Button) findViewById(R.id.button_negative_breakfast);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String st1 = prefs.getString("st", "07");
        String st2 = prefs.getString("sta", "00");
        String st3 = prefs.getString("stsnack1", "10");
        String st4 = prefs.getString("stasnack1", "00");
        String st5 = prefs.getString("stalmuerzo", "13");
        String st6 = prefs.getString("staalmuerzo", "00");
        String st7 = prefs.getString("stsnack2", "15");
        String st8 = prefs.getString("stasnack2", "00");
        String st9 = prefs.getString("stcena", "18");
        String st10 = prefs.getString("stacena", "00");
        String st11 = prefs.getString("stsnack3", "20");
        String st12 = prefs.getString("stasnack3", "00");
        String st13 = prefs.getString("stbedtime", "22");
        String st14 = prefs.getString("stabedtime", "00");

        horaDesayuno.setText(st1);
        minutosDesayuno.setText(st2);
        horaSnack1.setText(st3);
        minutosSnack1.setText(st4);
        horaAlmuerzo.setText(st5);
        minutosAlmuerzo.setText(st6);
        horaSnack2.setText(st7);
        minutosSnack2.setText(st8);
        horaCena.setText(st9);
        minutosCena.setText(st10);
        horaSnack3.setText(st11);
        minutosSnack3.setText(st12);
        horaBedtime.setText(st13);
        minutosBedtime.setText(st14);

        negativoDesayuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int horaDesayunoInt = Integer.parseInt(horaDesayuno.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosDesayuno.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt - 15;

                if(minutosDesayunoInt == -15){
                    horaDesayunoInt = horaDesayunoInt - 1;
                    minutosDesayunoInt = 45;

                }
                if(horaDesayunoInt == -1){
                    horaDesayunoInt = 23;
                }

                if (horaDesayunoInt < 10){
                    horaDesayuno.setText("0"+horaDesayunoInt);
                    String st = horaDesayuno.getText().toString();
                    String sta = minutosDesayuno.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("st", st);
                    editor.putString("sta", sta);
                    editor.apply();

                }
                if(horaDesayunoInt > 9){
                    horaDesayuno.setText(""+horaDesayunoInt);
                    String st = horaDesayuno.getText().toString();
                    String sta = minutosDesayuno.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("st", st);
                    editor.putString("sta", sta);
                    editor.apply();

                }
                if(minutosDesayunoInt < 10){
                    minutosDesayuno.setText("0"+minutosDesayunoInt);
                    String st = horaDesayuno.getText().toString();
                    String sta = minutosDesayuno.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("st", st);
                    editor.putString("sta", sta);
                    editor.apply();

                }
                if(minutosDesayunoInt > 9){
                    minutosDesayuno.setText(""+minutosDesayunoInt);
                    String st = horaDesayuno.getText().toString();
                    String sta = minutosDesayuno.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("st", st);
                    editor.putString("sta", sta);
                    editor.apply();

                }

                switchDesayuno.setChecked(false);
            }

        });

        positivoDesayuno = (Button) findViewById(R.id.button_positive_breakfast);
        positivoDesayuno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaDesayuno.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosDesayuno.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt + 15;

                if(minutosDesayunoInt == 60){
                    minutosDesayunoInt = 0;
                    horaDesayunoInt = horaDesayunoInt + 1;
                }
                if (horaDesayunoInt == 24){
                    horaDesayunoInt = 0;
                }


                if (horaDesayunoInt < 10){
                    horaDesayuno.setText("0"+horaDesayunoInt);
                    String st = horaDesayuno.getText().toString();
                    String sta = minutosDesayuno.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("st", st);
                    editor.putString("sta", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaDesayuno.setText(""+horaDesayunoInt);
                    String st = horaDesayuno.getText().toString();
                    String sta = minutosDesayuno.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("st", st);
                    editor.putString("sta", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosDesayuno.setText("0"+minutosDesayunoInt);
                    String st = horaDesayuno.getText().toString();
                    String sta = minutosDesayuno.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("st", st);
                    editor.putString("sta", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosDesayuno.setText(""+minutosDesayunoInt);
                    String st = horaDesayuno.getText().toString();
                    String sta = minutosDesayuno.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("st", st);
                    editor.putString("sta", sta);
                    editor.apply();
                }
                switchDesayuno.setChecked(false);

            }
        });

        negativoSnack1 = (Button) findViewById(R.id.button_negative_snack1);
        negativoSnack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaSnack1.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosSnack1.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt - 15;

                if(minutosDesayunoInt == -15){
                    horaDesayunoInt = horaDesayunoInt - 1;
                    minutosDesayunoInt = 45;
                }
                if(horaDesayunoInt == -1){
                    horaDesayunoInt = 23;
                }

                if (horaDesayunoInt < 10){
                    horaSnack1.setText("0"+horaDesayunoInt);
                    String st = horaSnack1.getText().toString();
                    String sta = minutosSnack1.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack1", st);
                    editor.putString("stasnack1", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaSnack1.setText(""+horaDesayunoInt);
                    String st = horaSnack1.getText().toString();
                    String sta = minutosSnack1.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack1", st);
                    editor.putString("stasnack1", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosSnack1.setText("0"+minutosDesayunoInt);
                    String st = horaSnack1.getText().toString();
                    String sta = minutosSnack1.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack1", st);
                    editor.putString("stasnack1", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosSnack1.setText(""+minutosDesayunoInt);
                    String st = horaSnack1.getText().toString();
                    String sta = minutosSnack1.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack1", st);
                    editor.putString("stasnack1", sta);
                    editor.apply();
                }
                switchSnack1.setChecked(false);


            }
        });

        positivoSnack1 = (Button) findViewById(R.id.button_positive_snack1);
        positivoSnack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaSnack1.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosSnack1.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt + 15;

                if(minutosDesayunoInt == 60){
                    minutosDesayunoInt = 0;
                    horaDesayunoInt = horaDesayunoInt + 1;
                }
                if (horaDesayunoInt == 24){
                    horaDesayunoInt = 0;
                }


                if (horaDesayunoInt < 10){
                    horaSnack1.setText("0"+horaDesayunoInt);
                    String st = horaSnack1.getText().toString();
                    String sta = minutosSnack1.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack1", st);
                    editor.putString("stasnack1", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaSnack1.setText(""+horaDesayunoInt);
                    String st = horaSnack1.getText().toString();
                    String sta = minutosSnack1.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack1", st);
                    editor.putString("stasnack1", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosSnack1.setText("0"+minutosDesayunoInt);
                    String st = horaSnack1.getText().toString();
                    String sta = minutosSnack1.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack1", st);
                    editor.putString("stasnack1", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosSnack1.setText(""+minutosDesayunoInt);
                    String st = horaSnack1.getText().toString();
                    String sta = minutosSnack1.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack1", st);
                    editor.putString("stasnack1", sta);
                    editor.apply();
                }
                switchSnack1.setChecked(false);
            }
        });


        negativoAlmuerzo = (Button) findViewById(R.id.button_negative_lunch);
        negativoAlmuerzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaAlmuerzo.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosAlmuerzo.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt - 15;

                if(minutosDesayunoInt == -15){
                    horaDesayunoInt = horaDesayunoInt - 1;
                    minutosDesayunoInt = 45;
                }
                if(horaDesayunoInt == -1){
                    horaDesayunoInt = 23;
                }

                if (horaDesayunoInt < 10){
                    horaAlmuerzo.setText("0"+horaDesayunoInt);
                    String st = horaAlmuerzo.getText().toString();
                    String sta = minutosAlmuerzo.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stalmuerzo", st);
                    editor.putString("staalmuerzo", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaAlmuerzo.setText(""+horaDesayunoInt);
                    String st = horaAlmuerzo.getText().toString();
                    String sta = minutosAlmuerzo.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stalmuerzo", st);
                    editor.putString("staalmuerzo", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosAlmuerzo.setText("0"+minutosDesayunoInt);
                    String st = horaAlmuerzo.getText().toString();
                    String sta = minutosAlmuerzo.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stalmuerzo", st);
                    editor.putString("staalmuerzo", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosAlmuerzo.setText(""+minutosDesayunoInt);
                    String st = horaAlmuerzo.getText().toString();
                    String sta = minutosAlmuerzo.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stalmuerzo", st);
                    editor.putString("staalmuerzo", sta);
                    editor.apply();
                }
                switchAlmuerzo.setChecked(false);


            }
        });

        positivoAlmuerzo = (Button) findViewById(R.id.button_positive_lunch);
        positivoAlmuerzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaAlmuerzo.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosAlmuerzo.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt + 15;

                if(minutosDesayunoInt == 60){
                    minutosDesayunoInt = 0;
                    horaDesayunoInt = horaDesayunoInt + 1;
                }
                if (horaDesayunoInt == 24){
                    horaDesayunoInt = 0;
                }

                if (horaDesayunoInt < 10){
                    horaAlmuerzo.setText("0"+horaDesayunoInt);
                    String st = horaAlmuerzo.getText().toString();
                    String sta = minutosAlmuerzo.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stalmuerzo", st);
                    editor.putString("staalmuerzo", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaAlmuerzo.setText(""+horaDesayunoInt);
                    String st = horaAlmuerzo.getText().toString();
                    String sta = minutosAlmuerzo.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stalmuerzo", st);
                    editor.putString("staalmuerzo", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosAlmuerzo.setText("0"+minutosDesayunoInt);
                    String st = horaAlmuerzo.getText().toString();
                    String sta = minutosAlmuerzo.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stalmuerzo", st);
                    editor.putString("staalmuerzo", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosAlmuerzo.setText(""+minutosDesayunoInt);
                    String st = horaAlmuerzo.getText().toString();
                    String sta = minutosAlmuerzo.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stalmuerzo", st);
                    editor.putString("staalmuerzo", sta);
                    editor.apply();
                }
                switchAlmuerzo.setChecked(false);
            }
        });


        negativoSnack2 = (Button) findViewById(R.id.button_negative_snack2);
        negativoSnack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaSnack2.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosSnack2.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt - 15;

                if(minutosDesayunoInt == -15){
                    horaDesayunoInt = horaDesayunoInt - 1;
                    minutosDesayunoInt = 45;
                }
                if(horaDesayunoInt == -1){
                    horaDesayunoInt = 23;
                }

                if (horaDesayunoInt < 10){
                    horaSnack2.setText("0"+horaDesayunoInt);
                    String st = horaSnack2.getText().toString();
                    String sta = minutosSnack2.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack2", st);
                    editor.putString("stasnack2", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaSnack2.setText(""+horaDesayunoInt);
                    String st = horaSnack2.getText().toString();
                    String sta = minutosSnack2.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack2", st);
                    editor.putString("stasnack2", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosSnack2.setText("0"+minutosDesayunoInt);
                    String st = horaSnack2.getText().toString();
                    String sta = minutosSnack2.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack2", st);
                    editor.putString("stasnack2", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosSnack2.setText(""+minutosDesayunoInt);
                    String st = horaSnack2.getText().toString();
                    String sta = minutosSnack2.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack2", st);
                    editor.putString("stasnack2", sta);
                    editor.apply();
                }
                switchSnack2.setChecked(false);
            }
        });

        positivoSnack2 = (Button) findViewById(R.id.button_positive_snack2);
        positivoSnack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaSnack2.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosSnack2.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt + 15;

                if(minutosDesayunoInt == 60){
                    minutosDesayunoInt = 0;
                    horaDesayunoInt = horaDesayunoInt + 1;
                }
                if (horaDesayunoInt == 24){
                    horaDesayunoInt = 0;
                }


                if (horaDesayunoInt < 10){
                    horaSnack2.setText("0"+horaDesayunoInt);
                    String st = horaSnack2.getText().toString();
                    String sta = minutosSnack2.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack2", st);
                    editor.putString("stasnack2", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaSnack2.setText(""+horaDesayunoInt);
                    String st = horaSnack2.getText().toString();
                    String sta = minutosSnack2.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack2", st);
                    editor.putString("stasnack2", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosSnack2.setText("0"+minutosDesayunoInt);
                    String st = horaSnack2.getText().toString();
                    String sta = minutosSnack2.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack2", st);
                    editor.putString("stasnack2", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosSnack2.setText(""+minutosDesayunoInt);
                    String st = horaSnack2.getText().toString();
                    String sta = minutosSnack2.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack2", st);
                    editor.putString("stasnack2", sta);
                    editor.apply();
                }
                switchSnack2.setChecked(false);
            }
        });

        negativoCena = (Button) findViewById(R.id.button_negative_dinner);
        negativoCena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaCena.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosCena.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt - 15;

                if(minutosDesayunoInt == -15){
                    horaDesayunoInt = horaDesayunoInt - 1;
                    minutosDesayunoInt = 45;
                }
                if(horaDesayunoInt == -1){
                    horaDesayunoInt = 23;
                }

                if (horaDesayunoInt < 10){
                    horaCena.setText("0"+horaDesayunoInt);
                    String st = horaCena.getText().toString();
                    String sta = minutosCena.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stcena", st);
                    editor.putString("stacena", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaCena.setText(""+horaDesayunoInt);
                    String st = horaCena.getText().toString();
                    String sta = minutosCena.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stcena", st);
                    editor.putString("stacena", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosCena.setText("0"+minutosDesayunoInt);
                    String st = horaCena.getText().toString();
                    String sta = minutosCena.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stcena", st);
                    editor.putString("stacena", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosCena.setText(""+minutosDesayunoInt);
                    String st = horaCena.getText().toString();
                    String sta = minutosCena.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stcena", st);
                    editor.putString("stacena", sta);
                    editor.apply();
                }
                switchCena.setChecked(false);
            }
        });

        positivoCena = (Button) findViewById(R.id.button_positive_dinner);
        positivoCena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaCena.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosCena.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt + 15;

                if(minutosDesayunoInt == 60){
                    minutosDesayunoInt = 0;
                    horaDesayunoInt = horaDesayunoInt + 1;
                }
                if (horaDesayunoInt == 24){
                    horaDesayunoInt = 0;
                }


                if (horaDesayunoInt < 10){
                    horaCena.setText("0"+horaDesayunoInt);
                    String st = horaCena.getText().toString();
                    String sta = minutosCena.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stcena", st);
                    editor.putString("stacena", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaCena.setText(""+horaDesayunoInt);
                    String st = horaCena.getText().toString();
                    String sta = minutosCena.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stcena", st);
                    editor.putString("stacena", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosCena.setText("0"+minutosDesayunoInt);
                    String st = horaCena.getText().toString();
                    String sta = minutosCena.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stcena", st);
                    editor.putString("stacena", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosCena.setText(""+minutosDesayunoInt);
                    String st = horaCena.getText().toString();
                    String sta = minutosCena.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stcena", st);
                    editor.putString("stacena", sta);
                    editor.apply();
                }
                switchCena.setChecked(false);
            }
        });

        negativoSnack3 = (Button) findViewById(R.id.button_negative_snack3);
        negativoSnack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaSnack3.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosSnack3.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt - 15;

                if(minutosDesayunoInt == -15){
                    horaDesayunoInt = horaDesayunoInt - 1;
                    minutosDesayunoInt = 45;
                }
                if(horaDesayunoInt == -1){
                    horaDesayunoInt = 23;
                }

                if (horaDesayunoInt < 10){
                    horaSnack3.setText("0"+horaDesayunoInt);
                    String st = horaSnack3.getText().toString();
                    String sta = minutosSnack3.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack3", st);
                    editor.putString("stasnack3", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaSnack3.setText(""+horaDesayunoInt);
                    String st = horaSnack3.getText().toString();
                    String sta = minutosSnack3.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack3", st);
                    editor.putString("stasnack3", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosSnack3.setText("0"+minutosDesayunoInt);
                    String st = horaSnack3.getText().toString();
                    String sta = minutosSnack3.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack3", st);
                    editor.putString("stasnack3", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosSnack3.setText(""+minutosDesayunoInt);
                    String st = horaSnack3.getText().toString();
                    String sta = minutosSnack3.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack3", st);
                    editor.putString("stasnack3", sta);
                    editor.apply();
                }
                switchSnack3.setChecked(false);
            }
        });

        positivoSnack3 = (Button) findViewById(R.id.button_positive_snack3);
        positivoSnack3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaSnack3.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosSnack3.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt + 15;

                if(minutosDesayunoInt == 60){
                    minutosDesayunoInt = 0;
                    horaDesayunoInt = horaDesayunoInt + 1;
                }
                if (horaDesayunoInt == 24){
                    horaDesayunoInt = 0;
                }


                if (horaDesayunoInt < 10){
                    horaSnack3.setText("0"+horaDesayunoInt);
                    String st = horaSnack3.getText().toString();
                    String sta = minutosSnack3.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack3", st);
                    editor.putString("stasnack3", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaSnack3.setText(""+horaDesayunoInt);
                    String st = horaSnack3.getText().toString();
                    String sta = minutosSnack3.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack3", st);
                    editor.putString("stasnack3", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosSnack3.setText("0"+minutosDesayunoInt);
                    String st = horaSnack3.getText().toString();
                    String sta = minutosSnack3.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack3", st);
                    editor.putString("stasnack3", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosSnack3.setText(""+minutosDesayunoInt);
                    String st = horaSnack3.getText().toString();
                    String sta = minutosSnack3.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stsnack3", st);
                    editor.putString("stasnack3", sta);
                    editor.apply();
                }
                switchSnack3.setChecked(false);
            }
        });

        negativoBedtime = (Button) findViewById(R.id.button_negative_bedtime);
        negativoBedtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaBedtime.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosBedtime.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt - 15;

                if(minutosDesayunoInt == -15){
                    horaDesayunoInt = horaDesayunoInt - 1;
                    minutosDesayunoInt = 45;
                }
                if(horaDesayunoInt == -1){
                    horaDesayunoInt = 23;
                }

                if (horaDesayunoInt < 10){
                    horaBedtime.setText("0"+horaDesayunoInt);
                    String st = horaBedtime.getText().toString();
                    String sta = minutosBedtime.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stbedtime", st);
                    editor.putString("stabedtime", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaBedtime.setText(""+horaDesayunoInt);
                    String st = horaBedtime.getText().toString();
                    String sta = minutosBedtime.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stbedtime", st);
                    editor.putString("stabedtime", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosBedtime.setText("0"+minutosDesayunoInt);
                    String st = horaBedtime.getText().toString();
                    String sta = minutosBedtime.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stbedtime", st);
                    editor.putString("stabedtime", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosBedtime.setText(""+minutosDesayunoInt);
                    String st = horaBedtime.getText().toString();
                    String sta = minutosBedtime.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stbedtime", st);
                    editor.putString("stabedtime", sta);
                    editor.apply();
                }
                switchBedtime.setChecked(false);
            }
        });

        positivoBedtime = (Button) findViewById(R.id.button_positive_bedtime);
        positivoBedtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int horaDesayunoInt = Integer.parseInt(horaBedtime.getText().toString());
                int minutosDesayunoInt = Integer.parseInt(minutosBedtime.getText().toString());

                minutosDesayunoInt = minutosDesayunoInt + 15;

                if(minutosDesayunoInt == 60){
                    minutosDesayunoInt = 0;
                    horaDesayunoInt = horaDesayunoInt + 1;
                }
                if (horaDesayunoInt == 24){
                    horaDesayunoInt = 0;
                }
                if (horaDesayunoInt < 10){
                    horaBedtime.setText("0"+horaDesayunoInt);
                    String st = horaBedtime.getText().toString();
                    String sta = minutosBedtime.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stbedtime", st);
                    editor.putString("stabedtime", sta);
                    editor.apply();
                }
                if(horaDesayunoInt > 9){
                    horaBedtime.setText(""+horaDesayunoInt);
                    String st = horaBedtime.getText().toString();
                    String sta = minutosBedtime.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stbedtime", st);
                    editor.putString("stabedtime", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt < 10){
                    minutosBedtime.setText("0"+minutosDesayunoInt);
                    String st = horaBedtime.getText().toString();
                    String sta = minutosBedtime.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stbedtime", st);
                    editor.putString("stabedtime", sta);
                    editor.apply();
                }
                if(minutosDesayunoInt > 9){
                    minutosBedtime.setText(""+minutosDesayunoInt);
                    String st = horaBedtime.getText().toString();
                    String sta = minutosBedtime.getText().toString();
                    SharedPreferences prefs1 = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    SharedPreferences.Editor editor = prefs1.edit();
                    editor.putString("stbedtime", st);
                    editor.putString("stabedtime", sta);
                    editor.apply();
                }
                switchBedtime.setChecked(false);
            }
        });

        switchDesayuno = (Switch) findViewById(R.id.switch_breakfast);
        switchDesayuno.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.putBoolean("switch_desayuno", switchDesayuno.isChecked());
                editor.commit();

                if(switchDesayuno.isChecked()){
                    Calendar calendar = Calendar.getInstance();
                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    String st1 = prefs.getString("st", "07");
                    String st2 = prefs.getString("sta", "00");

                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(st1));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(st2));
                    calendar.set(Calendar.SECOND,05);

                    Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                } else {
                }
            }

        });

        switchSnack1 = (Switch) findViewById(R.id.switch_snack1);
        switchSnack1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.putBoolean("switch_snack1", switchSnack1.isChecked());
                editor.commit();

                if(switchSnack1.isChecked()){

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    String st1 = prefs.getString("stsnack1", "10");
                    String st2 = prefs.getString("stasnack1", "00");

                    Calendar calendar = Calendar.getInstance();

                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(st1));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(st2));
                    calendar.set(Calendar.SECOND,05);

                    Intent intent = new Intent(getApplicationContext(), NotificationReceiverSnack1.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),110,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                } else {
                }
            }

        });

        switchAlmuerzo = (Switch) findViewById(R.id.switch_lunch);
        switchAlmuerzo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.putBoolean("switch_almuerzo", switchAlmuerzo.isChecked());
                editor.commit();

                if(switchAlmuerzo.isChecked()){

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    String st1 = prefs.getString("stalmuerzo", "13");
                    String st2 = prefs.getString("staalmuerzo", "00");

                    Calendar calendar = Calendar.getInstance();

                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(st1));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(st2));
                    calendar.set(Calendar.SECOND,05);

                    Intent intent = new Intent(getApplicationContext(), NotificationReceiverAlmuerzo.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),120,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                } else {
                }
            }

        });

        switchSnack2 = (Switch) findViewById(R.id.switch_snack2);
        switchSnack2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.putBoolean("switch_snack2", switchSnack2.isChecked());
                editor.commit();

                if(switchSnack2.isChecked()){

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    String st1 = prefs.getString("stsnack2", "15");
                    String st2 = prefs.getString("stasnack2", "00");

                    Calendar calendar = Calendar.getInstance();

                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(st1));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(st2));
                    calendar.set(Calendar.SECOND,05);

                    Intent intent = new Intent(getApplicationContext(), NotificationReceiverSnack2.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),130,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                } else {
                }
            }

        });

        switchCena = (Switch) findViewById(R.id.switch_dinner);
        switchCena.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.putBoolean("switch_cena", switchCena.isChecked());
                editor.commit();

                if(switchCena.isChecked()){

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    String st1 = prefs.getString("stcena", "18");
                    String st2 = prefs.getString("stacena", "00");

                    Calendar calendar = Calendar.getInstance();

                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(st1));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(st2));
                    calendar.set(Calendar.SECOND,05);

                    Intent intent = new Intent(getApplicationContext(), NotificationReceiverCena.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),140,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                } else {
                }
            }

        });

        switchSnack3 = (Switch) findViewById(R.id.switch_snack3);
        switchSnack3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.putBoolean("switch_snack3", switchSnack3.isChecked());
                editor.commit();

                if(switchSnack3.isChecked()){

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    String st1 = prefs.getString("stsnack3", "20");
                    String st2 = prefs.getString("stasnack3", "00");

                    Calendar calendar = Calendar.getInstance();

                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(st1));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(st2));
                    calendar.set(Calendar.SECOND,05);

                    Intent intent = new Intent(getApplicationContext(), NotificationReceiverSnack3.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),150,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                } else {
                }
            }

        });

        switchBedtime = (Switch) findViewById(R.id.switch_bedtime);
        switchBedtime.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                SharedPreferences.Editor editor = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE).edit();
                editor.putBoolean("switch_bedtime", switchBedtime.isChecked());
                editor.commit();



                if(switchBedtime.isChecked()){

                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(Alertas.this);
                    String st1 = prefs.getString("stbedtime", "22");
                    String st2 = prefs.getString("stabedtime", "00");

                    Calendar calendar = Calendar.getInstance();

                    calendar.set(Calendar.HOUR_OF_DAY,Integer.parseInt(st1));
                    calendar.set(Calendar.MINUTE,Integer.parseInt(st2));
                    calendar.set(Calendar.SECOND,05);

                    Intent intent = new Intent(getApplicationContext(), NotificationReceiverBedtime.class);

                    PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),160,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);


                } else {
                }
            }

        });

        SharedPreferences sharedPrefs1 = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        switchDesayuno.setChecked(sharedPrefs1.getBoolean("switch_desayuno", false));
        SharedPreferences sharedPrefs2 = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        switchSnack1.setChecked(sharedPrefs2.getBoolean("switch_snack1", false));
        SharedPreferences sharedPrefs3 = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        switchAlmuerzo.setChecked(sharedPrefs3.getBoolean("switch_almuerzo", false));
        SharedPreferences sharedPrefs4 = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        switchSnack2.setChecked(sharedPrefs4.getBoolean("switch_snack2", false));
        SharedPreferences sharedPrefs5 = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        switchCena.setChecked(sharedPrefs5.getBoolean("switch_cena", false));
        SharedPreferences sharedPrefs6 = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        switchSnack3.setChecked(sharedPrefs6.getBoolean("switch_snack3", false));
        SharedPreferences sharedPrefs7 = getSharedPreferences("com.mobileapp.smartapplocker", MODE_PRIVATE);
        switchBedtime.setChecked(sharedPrefs7.getBoolean("switch_bedtime", false));

    }



}

