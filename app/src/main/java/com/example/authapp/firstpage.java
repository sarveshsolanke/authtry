package com.example.authapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class firstpage extends AppCompatActivity {
    Button ssout;
    FirebaseAuth mAuth;
Toolbar tb;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
mAuth = FirebaseAuth.getInstance();


//ActionBar
        ssout= (Button) findViewById(R.id.sout);
            ssout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
              mAuth.signOut();
                Intent st=new Intent(firstpage.this,login.class);
                firstpage.this.startActivity(st);
            }
        });
    }


}