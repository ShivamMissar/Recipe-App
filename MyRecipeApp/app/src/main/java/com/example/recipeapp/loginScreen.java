package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginScreen extends AppCompatActivity {

    private FirebaseAuth userAuth;
    private EditText userEnteredPassword;
    private EditText userEnteredEmail;
    private Button loginSubmitButton;
    private static final String LOGIN_SUCCESS_MESSAGE = "Login Successful";
    private static final String LOGIN_FAIL_MESSAGE = "Login failed, try again";
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen2);


        userAuth = FirebaseAuth.getInstance();
        userEnteredEmail = findViewById(R.id.loginEmail);
        userEnteredPassword = findViewById(R.id.loginPassword);
        loginSubmitButton = findViewById(R.id.submit_login);

        loginSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String signInEmail = userEnteredEmail.getText().toString();
                String signInPassword = userEnteredPassword.getText().toString();

                userAuth.signInWithEmailAndPassword(signInEmail, signInPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                       enable_toast_notification(LOGIN_SUCCESS_MESSAGE);
                        Intent moveToMainMenu = new Intent(loginScreen.this, mainMenu.class);
                        startActivity(moveToMainMenu);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        enable_toast_notification(LOGIN_FAIL_MESSAGE);
                    }

                });
            }
        });
    }

    public void forgotPassword(View view) {

        Intent userForgotPassword = new Intent(loginScreen.this, forgottenPassword.class);
        startActivity(userForgotPassword);

    }
public void enable_toast_notification(String message){

    LayoutInflater inflater = getLayoutInflater();
    View toastLayout = inflater.inflate(R.layout.activity_toast, (ViewGroup) findViewById(R.id.custom_toast));
    TextView toastMessage = toastLayout.findViewById(R.id.toastmessage);
        toastMessage.setText(message);


    Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastLayout);
        toast.show();
}



}