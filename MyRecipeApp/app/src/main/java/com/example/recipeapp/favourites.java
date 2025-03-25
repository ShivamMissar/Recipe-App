package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class favourites extends AppCompatActivity {
    public ListView listView;
    private CardView favouritesCard1;

    FirebaseFirestore firebaseFirestore;

    private Button delete;

    private BottomNavigationView navigation;

    private final ArrayList<String> RecipeName = new ArrayList<>();
    private final ArrayList<String> RecipeImage = new ArrayList<>();


    ListAdapter listAdapter;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);


       
        firebaseFirestore = FirebaseFirestore.getInstance();


        navigation = findViewById(R.id.favBottomNav);
        navigation.setSelectedItemId(R.id.favourites);
        listView = (ListView) findViewById(R.id.favListView);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();






        // retrieves the data from the database.
        assert user != null;
        firebaseFirestore.collection("Users").document(user.getUid()).collection("Favourites").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
        {
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
                            RecipeName.add(documentSnapshot.getString("RecipeName"));
                            RecipeImage.add(documentSnapshot.getString("RecipeImage"));
                        }
                    }
                }
                listAdapter = new ListAdapter(favourites.this, RecipeName, RecipeImage);
                listAdapter.notifyDataSetChanged();
                listView.setAdapter(listAdapter);
            }
        });

        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent userSelected;

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        userSelected = new Intent(favourites.this,mainMenu.class);
                        startActivity(userSelected);
                        return true;

                    case R.id.MealPlanner:
                        userSelected = new Intent(favourites.this,mealplanner.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.nearbystores:
                        userSelected = new Intent(favourites.this,nearbystores.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.favourites:
                        userSelected = new Intent(favourites.this,favourites.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.settings:
                        userSelected = new Intent(favourites.this, manageAccount.class);
                        startActivity(userSelected);
                    default:
                        return favourites.super.onOptionsItemSelected(item);
                }
            }
        });
    }


}