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

public class reg extends AppCompatActivity {

    TextView alreg;
    EditText name,email,phone,password;
    Button btn;
ProgressBar pbar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

//        alreg=findViewById(R.id.textreg);
//        alreg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        name=findViewById(R.id.fullname);
        email=findViewById(R.id.lemail);
        phone=findViewById(R.id.phone);
        password=findViewById(R.id.lpassword);

        mAuth = FirebaseAuth.getInstance();
        pbar=findViewById(R.id.progressBar);
        if(mAuth.getCurrentUser()!=null){   startActivity(new Intent(getApplicationContext(),firstpage.class));
        finish();

        }
    }
    public void aaal(View v){Intent activityChangeIntent = new Intent(reg.this, login.class);
        reg.this.startActivity(activityChangeIntent);}

    public void hello(View view) {

        String uemail=email.getText().toString().trim();
        String upass=password.getText().toString().trim();
        if(TextUtils.isEmpty(uemail))
        {email.setError("Field must not be empty");return;}
        if(TextUtils.isEmpty(uemail))
        {password.setError("Field must not be empty");return;}
        if(upass.length()<=6){password.setError("must be greater than 6 characters");}
        pbar.setVisibility(view.VISIBLE);
        mAuth.createUserWithEmailAndPassword(uemail,upass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(reg.this,"Registration Sucessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),login.class));
                }
                else
                {
                    Toast.makeText(reg.this,"Error poped"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}