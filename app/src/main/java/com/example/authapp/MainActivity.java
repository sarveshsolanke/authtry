package com.example.authapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button lout;
   FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
     //  startActivity(new Intent(getApplicationContext(),login.class));
       Intent activityChangeIntent = new Intent(MainActivity.this, login.class);
        MainActivity.this.startActivity(activityChangeIntent);
            lout= (Button) findViewById(R.id.logb);
            mAuth = FirebaseAuth.getInstance();
//            lout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view)
//            {
//              mAuth.signOut();
//            }
//        });
        setContentView(R.layout.activity_main);
    }
}