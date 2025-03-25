package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;

public class manageAccount extends AppCompatActivity {

    private Switch dark_light;
    private Button signTheUserOut;

    private Button userEmailChange;
    private Button userPasswordChange;

    private  SharedPreferences sp;

    MainActivity mainActivity;


    private TextView updateIntro;
    SharedPreferences userPreferences;

    BottomNavigationView navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_account);

        userPreferences =  getSharedPreferences("userPref", MODE_PRIVATE);

        dark_light = findViewById(R.id.darkLight);
        updateIntro = findViewById(R.id.manageAccountIntro);
        ImageView darkTheme = findViewById(R.id.imageView5);
        navigation = findViewById(R.id.accountBottomNav);
        navigation.setSelectedItemId(R.id.settings);


        displayMessage();

        // this will enable the dark mode here.
        if(load() == true)
        {

            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            ImageView dark = findViewById(R.id.imageView5);



            // this will change the color of the moon if it is dark mode
            Integer colr = getResources().getColor(R.color.textColor);
            dark.setColorFilter(colr);


        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            // this will change the color of the sun if it is light mode
            ImageView lightTheme = findViewById(R.id.imageView8);
            Integer colr = getResources().getColor(R.color.textColor);
            lightTheme.setColorFilter(colr);
            Integer backToDefaultCol = getResources().getColor(R.color.black);
            darkTheme.setColorFilter(backToDefaultCol);



        }

        // if dark mode is already enabled... set the switcher to be checked on load.
        if(load() == true)
        {
            dark_light.setChecked(true);
        }


        dark_light.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    set(true);
                    recreate();//in order to apply the changes the app must quickly restart
                }
                else
                {
                    set(false);
                    recreate();

                }
            }
        });







        signTheUserOut = findViewById(R.id.signOut);
        signTheUserOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userSelected =  new Intent(manageAccount.this, MainActivity.class);
                startActivity(userSelected);
                FirebaseAuth.getInstance().signOut();
            }
        });

        userEmailChange = findViewById(R.id.updateEmail);

        userEmailChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userSelected =  new Intent(manageAccount.this, updateEmail.class);
                startActivity(userSelected);
            }
        });

        userPasswordChange = findViewById(R.id.updatePassword);

        userPasswordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userSelected =  new Intent(manageAccount.this, updatePassword.class);
                startActivity(userSelected);
            }
        });

        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        Intent userSelects = new Intent(manageAccount.this, mainMenu.class);
                        startActivity(userSelects);
                        return true;
                    case R.id.MealPlanner:
                        Intent userSelected = new Intent(manageAccount.this, MainActivity.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.favourites:
                        Intent usersSelected = new Intent(manageAccount.this, favourites.class);
                        startActivity(usersSelected);
                        return true;
                    case R.id.nearbystores:
                        userSelected = new Intent(manageAccount.this,nearbystores.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.settings:
                        Intent userdataSelected = new Intent(manageAccount.this, manageAccount.class);
                        startActivity(userdataSelected);
                        return true;
                    default:
                        return manageAccount.super.onOptionsItemSelected(item);
                }
            }
        });
    }
    public void displayMessage()
    {

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("Users").document(user.getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful())
                {
                    String Name = task.getResult().getString("fullname");
                    helloMessage(Name);
                }
            }
        });
    }

    public void helloMessage(String n)
    {
        Calendar checkTime = Calendar.getInstance();
        int time = checkTime.get(Calendar.HOUR_OF_DAY);
        String name = n;
        if(time >= 0 && time <= 12)
        {
            updateIntro.setText("Good Morning, " + name );
        }
        else if(time >= 12 && time <= 18)
        {
            updateIntro.setText("Good Afternoon, " + name);
        }
        else
        {
            updateIntro.setText("Good Evening, " + name);
        }

    }

    public Boolean load()
    {
        boolean state = userPreferences.getBoolean("NightMode",false);
        return state;
    }

    public void set(Boolean state)
    {
        SharedPreferences.Editor editor = userPreferences.edit();
        editor.putBoolean("NightMode",state);
        editor.apply();
    }

}




