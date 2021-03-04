package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class loginpage extends AppCompatActivity {

    TextView textView;
    TextInputLayout editmail,editpassword;
    Button loginbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        textView=findViewById(R.id.newuser);
        loginbutton=findViewById(R.id.loginbutton);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(loginpage.this,signuppage.class);
                startActivity(i);
                finish();
            }
        });

    }
}