package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.FirebaseFirestore;

public class forgottenPassword extends AppCompatActivity {



    private EditText emailEntered;
    private Button submitEmail;

    private TextView message;

    private Button back_to_login;


    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotten_password);
        firebaseAuth = FirebaseAuth.getInstance();


        submitEmail = findViewById(R.id.confirmEmailButton);
        emailEntered = findViewById(R.id.emailForgotPassword);
        message = findViewById(R.id.comment);
        String email = emailEntered.getText().toString();


        submitEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.fetchSignInMethodsForEmail(emailEntered.getText().toString()).addOnCompleteListener(new OnCompleteListener<SignInMethodQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<SignInMethodQueryResult> task) {
                        if(task.getResult().getSignInMethods().size() == 0) // this line was taken from stack overflow https://stackoverflow.com/questions/51694424/how-to-check-user-email-already-exists-in-firebase-using-android-studio
                        {

                            message.setText("The Email " + email + " is not on the system");
                            message.setVisibility(View.VISIBLE);
                            backButton();
                        }
                        else
                        {
                            firebaseAuth.sendPasswordResetEmail(emailEntered.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful())
                                    {
                                        message.setText("A password link has been sent to the email " + emailEntered.getText().toString());

                                        message.setVisibility(View.VISIBLE);
                                        backButton();

                                    }
                                    else
                                    {
                                        message.setText("The Email " + emailEntered.getText().toString() + " is not not a registered email");
                                        message.setVisibility(View.VISIBLE);
                                        backButton();
                                    }
                                }
                            });
                        }

                    }
                });
            }
        });



    }
    public void backButton()
    {
        back_to_login = findViewById(R.id.back2home);

        back_to_login.setVisibility(View.VISIBLE);
        Intent userBack = new Intent(forgottenPassword.this, loginScreen.class);
        back_to_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(userBack);
            }
        });



    }
}


