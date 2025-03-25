package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class other_recipes extends AppCompatActivity {
    private BottomNavigationView navigation;
    private CardView rec_calcheese;
    private CardView rec_chickenKiev;
    private CardView rec_oats;
    private CardView rec_spongecake;
    private CardView rec_vegChilli;
    private CardView rec_pancake;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_recipes);
        navigation = findViewById(R.id.othersBottomNav);
        rec_calcheese = findViewById(R.id.MicrowaveCauliflowerCheese);
        rec_chickenKiev = findViewById(R.id.chickenKiev);
        rec_oats = findViewById(R.id.oats);
        rec_spongecake = findViewById(R.id.SpongeCake);
        rec_vegChilli = findViewById(R.id.VeggieChilli);
        rec_pancake = findViewById(R.id.pancake);


        rec_calcheese.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                cauliflowerCheese();
            }
        });
        rec_chickenKiev.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                chickenKiev();
            }
        });
        rec_oats.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                oats();
            }
        });
        rec_spongecake.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                spongeCake();
            }
        });
        rec_vegChilli.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                veggieChilli();
            }
        });
        rec_pancake.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                pancake();
            }
        });

        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent userClicked;
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        userClicked =  new Intent(other_recipes.this, mainMenu.class);
                        startActivity(userClicked);

                    case R.id.settings:
                        userClicked =  new Intent(other_recipes.this, manageAccount.class);
                        startActivity(userClicked);

                    case R.id.favourites:
                        userClicked =  new Intent(other_recipes.this, favourites.class);
                        startActivity(userClicked);

                    case R.id.MealPlanner:
                        userClicked =  new Intent(other_recipes.this, mealplanner.class);
                        startActivity(userClicked);

                    default:
                        return other_recipes.super.onOptionsItemSelected(item);
                }
            }
        });
    }

    private void cauliflowerCheese()
    {
        Intent intent = new Intent(other_recipes.this, cauliflowerCheese.class);
        startActivity(intent);
    }
    private void chickenKiev()
    {
        Intent intent = new Intent(other_recipes.this, chickenKiev.class);
        startActivity(intent);
    }
    private void oats()
    {
        Intent intent = new Intent(other_recipes.this, oats.class);
        startActivity(intent);
    }
    private void pancake()
    {
        Intent intent = new Intent(other_recipes.this, pancake.class);
        startActivity(intent);
    }
    private void veggieChilli()
    {
        Intent intent = new Intent(other_recipes.this, veggieChilli.class);
        startActivity(intent);
    }
    private void spongeCake()
    {
        Intent intent = new Intent(other_recipes.this, spongeCake.class);
        startActivity(intent);
    }
}