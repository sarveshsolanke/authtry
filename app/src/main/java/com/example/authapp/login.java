package com.example.authapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    TextView alre;
    EditText email,password;

    ProgressBar pbar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        Button login1=(Button) findViewById(R.id.lbutton);
        email=findViewById(R.id.lemail);

        password=findViewById(R.id.lpassword);
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        pbar=findViewById(R.id.progressBar);
        setContentView(R.layout.activity_login);
      //  login1.setOnClickListener(this);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uemail=email.getText().toString().trim();
                String upass=password.getText().toString().trim();
                if(TextUtils.isEmpty(uemail))
                {email.setError("Field must not be empty");return;}
                if(TextUtils.isEmpty(uemail))
                {password.setError("Field must not be empty");return;}
                if(upass.length()<=6){password.setError("must be greater than 6 characters");}
                pbar.setVisibility(v.VISIBLE);

             mAuth.signInWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                 @Override
                 public void onComplete(@NonNull Task<AuthResult> task) {
                     if(task.isSuccessful()){Toast.makeText(login.this,"Registration Successful", Toast.LENGTH_SHORT).show();
                        // startActivity(new Intent(getApplicationContext(),MainActivity.class));
                         Intent activityChangeIntent = new Intent(login.this, reg.class);
                         login.this.startActivity(activityChangeIntent);
                     }
                     else{Toast.makeText(login.this,"error!!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();}


                 }

      });
            }
        });

    }
//  public void ylo(){
//        String uemail=email.getText().toString().trim();
//                String upass=password.getText().toString().trim();
//                if(TextUtils.isEmpty(uemail))
//                {email.setError("Field must not be empty");return;}
//                if(TextUtils.isEmpty(uemail))
//                {password.setError("Field must not be empty");return;}
//                if(upass.length()<=6){password.setError("must be greater than 6 characters");}
//              //  pbar.setVisibility(onCreatePanelView().VISIBLE);
//
//             mAuth.signInWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                 @Override
//                 public void onComplete(@NonNull Task<AuthResult> task) {
//                     if(task.isSuccessful()){Toast.makeText(login.this,"Registration Successful", Toast.LENGTH_SHORT).show();
//                        // startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                         Intent activityChangeIntent = new Intent(login.this, reg.class);
//                         login.this.startActivity(activityChangeIntent);
//                     }
//                     else{Toast.makeText(login.this,"error!!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();}
//
//
//                 }
//
//      });

    }

