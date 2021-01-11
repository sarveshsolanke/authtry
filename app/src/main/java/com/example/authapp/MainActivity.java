package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;
import java.util.logging.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
     //  startActivity(new Intent(getApplicationContext(),login.class));


        setContentView(R.layout.activity_main);
        int secs = 2; // Delay in seconds

        new Timer().schedule(new TimerTask(){
            @Override
            public void run() {
                runOnUiThread(new Runnable(){
                    @Override
                    public void run() {
                        Intent activityChangeIntent = new Intent(MainActivity.this, reg.class);
                        MainActivity.this.startActivity(activityChangeIntent);
                        finish();
                    };
                }); }},2000); }}