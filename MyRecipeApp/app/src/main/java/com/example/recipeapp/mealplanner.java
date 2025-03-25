package com.example.recipeapp;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.List;


public class mealplanner extends AppCompatActivity {
    private Spinner spinnerObject;
    private ArrayList<String> r_names;
    private String selectedValue;

   private Button addToCalander;
    private BottomNavigationView navigation;

    private EditText location;
    private EditText notess;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mealplanner);
        spinnerObject = findViewById(R.id.RecipeNames);
        addToCalander = findViewById(R.id.CreateEvent);
        location = findViewById(R.id.location);
        notess = findViewById(R.id.notes);
        navigation = findViewById(R.id.mealBottomNav);


        FirebaseFirestore firebaseFirestore;
        firebaseFirestore = FirebaseFirestore.getInstance();
        r_names = new ArrayList<>();
        firebaseFirestore.collection("AllRecipes").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task)
            {
                if(task.isSuccessful())
                {
                    // to avoid duplication of data
                    for (QueryDocumentSnapshot documentSnapshot: task.getResult())
                    {
                        if(documentSnapshot.exists())
                        {
                            r_names.add(documentSnapshot.getString("RecipeName"));
                        }
                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mealplanner.this, android.R.layout.simple_spinner_dropdown_item, r_names);

                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerObject.setAdapter(arrayAdapter);
                }
            }
        });


        spinnerObject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedValue = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {}
        });

        addToCalander.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createEvent = new Intent(Intent.ACTION_INSERT);
                createEvent.setData(CalendarContract.Events.CONTENT_URI);


                createEvent.putExtra(CalendarContract.Events.TITLE, selectedValue);
                createEvent.putExtra(CalendarContract.Events.EVENT_LOCATION, location.getText().toString());
                createEvent.putExtra(CalendarContract.Events.ALL_DAY,false);
                createEvent.putExtra(CalendarContract.Events.DESCRIPTION, notess.getText().toString());

                startActivity(createEvent);

            }
        });



        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent userSelected;

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        userSelected = new Intent(mealplanner.this,mainMenu.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.favourites:
                        userSelected = new Intent(mealplanner.this,favourites.class);
                        startActivity(userSelected);
                        return true;

                    case R.id.MealPlanner:
                        userSelected = new Intent(mealplanner.this,mealplanner.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.nearbystores:
                        userSelected = new Intent(mealplanner.this,nearbystores.class);
                        startActivity(userSelected);
                        return true;

                    case R.id.settings:
                        userSelected = new Intent(mealplanner.this, manageAccount.class);
                        startActivity(userSelected);
                    default:
                        return mealplanner.super.onOptionsItemSelected(item);
                }
            }
        });
    }
}
