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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class updatePassword extends AppCompatActivity {
    private FirebaseUser userProfile;

    private TextView new_Password;
    private TextView current_user_email;
    private TextView current_user_password;

    private Button confirmUpdateOfPassword;
    private Button authenticateLogin;

    private static final String MESSAGE = "Password updated successfully";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_password);
        current_user_email = findViewById(R.id.reAuthEmail);
        current_user_password = findViewById(R.id.reAuthPassword);
        confirmUpdateOfPassword = findViewById(R.id.confirmPasswordButton);
        new_Password = findViewById(R.id.newPassword);
        authenticateLogin = findViewById(R.id.reAuthButton);

        authenticateLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticateUser(current_user_email.getText().toString(), current_user_password.getText().toString());
            }
        });


        confirmUpdateOfPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatePassword();
            }
        });
    }



    public void authenticateUser(String email, String password)
    {
        final String CURRENT_EMAIL = email;
        final String CURRENT_PASSWORD = password;
        // as this function is only interacting with the database directly, the main function does need the database instance.
        userProfile = FirebaseAuth.getInstance().getCurrentUser();

        //will need to re-authenticate the user to enable the update password function to work.
        AuthCredential credentials = EmailAuthProvider.getCredential(CURRENT_EMAIL, CURRENT_PASSWORD);
        userProfile.reauthenticate(credentials).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if(task.isSuccessful())
                {
                    current_user_email.setVisibility(View.GONE);
                    current_user_password.setVisibility(View.GONE);
                    authenticateLogin.setVisibility(View.GONE);

                    new_Password.setVisibility(View.VISIBLE);
                    confirmUpdateOfPassword.setVisibility(View.VISIBLE);

                }
            }
        });
    }

    public void updatePassword()
    {
        userProfile = FirebaseAuth.getInstance().getCurrentUser();
        final String NEW_PASSWORD  = new_Password.getText().toString();
        userProfile.updatePassword(NEW_PASSWORD).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    enable_custom_toast();
                    Intent backToSettings = new Intent(updatePassword.this, manageAccount.class);
                    startActivity(backToSettings);
                }
            }
        });

    }
    public void enable_custom_toast()
    {
        LayoutInflater inflater = getLayoutInflater();
        View toastLayout = inflater.inflate(R.layout.activity_toast, (ViewGroup) findViewById(R.id.custom_toast));
        TextView toastMessage = toastLayout.findViewById(R.id.toastmessage);
        toastMessage.setText(MESSAGE);


        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);

        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(toastLayout);
        toast.show();
    }
}