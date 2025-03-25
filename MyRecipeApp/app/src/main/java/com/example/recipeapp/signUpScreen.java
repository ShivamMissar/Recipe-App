package com.example.recipeapp;

import static android.view.View.Z;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signUpScreen extends AppCompatActivity {
    private EditText uFullname;
    private EditText uEmail;
    private EditText uPassword;
    private Button submitButton;
    private FirebaseAuth userCreate;
    FirebaseFirestore firebaseFirestore;
    private static final String SUCCESS_MESSAGE = "Account created successfully";
    private static final String FAIL_MESSAGE = "Account not created";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);


        uFullname = findViewById(R.id.fullname);
        uEmail = findViewById(R.id.userEmail);
        uPassword = findViewById(R.id.userPassword);
        submitButton = findViewById(R.id.signUpSubmit);
        // connect to the database
        userCreate = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userFullname = uFullname.getText().toString();
                String userEmail = uEmail.getText().toString();
                boolean validationOFEMAIL = validateEmail(userEmail);
                String userPassword = uPassword.getText().toString();
                boolean checkPassword = passwordStrength(userPassword);
                //ifs will check to see if either of the fields are empty/or if email is malformed.
                if(TextUtils.isEmpty(userFullname))
                {
                    uFullname.setError("Please enter a name");
                    return;
                }
                else if(TextUtils.isEmpty(userEmail))
                {
                    uEmail.setError("Please enter a valid email");
                    return;
                }
                else if(validationOFEMAIL == false)
                {
                    uEmail.setError("Please check your email address to match the correct format: name@domain.com");
                    return;
                }
                else if(TextUtils.isEmpty(userPassword))
                {
                    uPassword.setError("Please enter a password");
                    return;
                }
                else if(checkPassword == false)
                {
                    uPassword.setError("Password does not match the password format, it must include: a lowercase,uppercase,a special character _-^$()!");
                    return;
                }

                userCreate.createUserWithEmailAndPassword(userEmail, userPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                        enable_custom_toast(SUCCESS_MESSAGE);

                        firebaseFirestore.collection("Users").document(FirebaseAuth.getInstance().getUid()).set(new UserBase(userFullname, userEmail));
                        Intent moveToLoginPage = new Intent(signUpScreen.this, loginScreen.class);
                        startActivity(moveToLoginPage);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        enable_custom_toast(FAIL_MESSAGE);
                    }
                });
            }
        });


    }

    //pattern taken from: https://regexr.com/3e48o
    public boolean validateEmail(String email) {
        Pattern email_pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        Matcher matchEmail = email_pattern.matcher(email);
        if(matchEmail.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //pattern taken from:https://regexr.com/3bfsi
    public boolean passwordStrength(String password)
    {
        Pattern password_pattern = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
        Matcher matchPassword = password_pattern.matcher(password);
        if(matchPassword.matches())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void enable_custom_toast(String message)
    {
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