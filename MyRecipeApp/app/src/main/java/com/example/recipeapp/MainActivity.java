package com.example.recipeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button signUpButton;
    Button loginButton;

    public ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signUpButton = findViewById(R.id.signUpEmail);
        loginButton = findViewById(R.id.loginButton);
        logo = findViewById(R.id.imageView12);




        // if the user wants to sign up - it will trigger this activity:
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(MainActivity.this, signUpScreen.class);
                startActivity(signUp);
            }
        });

        // if user wants to login - it will trigger this activity:
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login = new Intent(MainActivity.this, loginScreen.class);
                startActivity(login);
            }
        });
    }

}