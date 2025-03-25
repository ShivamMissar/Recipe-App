package com.example.recipeapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.firestore.FirebaseFirestore;

public class updateEmail extends AppCompatActivity {

    private FirebaseUser userProfile;

    private TextView new_Email;
    private TextView current_user_email;
    private TextView current_user_password;

    private Button authenticateLogin;

    private Button updateCurrentEmail;

    TextView forgotPasswordForUpdatingEmail;
    private static final String MESSAGE = "Email updated successfully";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_email);

        // get the current user logged in
        // This will check to see if the email the user has entered is valid, if it is not then the user will be prompted to enter again
        current_user_email = findViewById(R.id.reAuthEmail);
        current_user_password = findViewById(R.id.reAuthPassword);
        authenticateLogin = findViewById(R.id.reAuthButton);
        new_Email = findViewById(R.id.newEmail);
        updateCurrentEmail = findViewById(R.id.updateEmailButton);
        forgotPasswordForUpdatingEmail = findViewById(R.id.forgotPasswordFromEmail);



        // having the re-authenticate within the main was causing issues hence why this has now been converted into a function.
        authenticateLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticateUser(current_user_email.getText().toString(), current_user_password.getText().toString());
            }
        });


        updateCurrentEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateEmail();
            }
        });

       forgotPasswordForUpdatingEmail.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               forgotPassword();
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
                    forgotPasswordForUpdatingEmail.setVisibility(View.GONE);

                    new_Email.setVisibility(View.VISIBLE);
                    updateCurrentEmail.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    public void updateEmail()
    {
        userProfile = FirebaseAuth.getInstance().getCurrentUser();
        final String NEW_EMAIL  = new_Email.getText().toString();
        userProfile.updateEmail(NEW_EMAIL).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection("Users").document(userProfile.getUid()).update("email",NEW_EMAIL).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            enable_custom_toast();
                            Intent backToSettings = new Intent(updateEmail.this, manageAccount.class);
                            startActivity(backToSettings);
                        }
                    }
                });
            }
        });
    }


    public  void forgotPassword()
    {
        Intent password = new Intent(updateEmail.this, forgottenPassword.class);
        startActivity(password);
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