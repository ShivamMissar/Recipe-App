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

public class non_veg_recipes extends AppCompatActivity {

    private CardView SpinachChicken;
    private CardView ChickenNoodleSoup;
    private CardView PrawnHarrisaSpaghetti;
    private CardView chickenFriedRice;
    private CardView SalmonSalad;
    private CardView TunaBurger;

    private BottomNavigationView navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_veg_recipes);

        TunaBurger = findViewById(R.id.TunaBurger);
        SalmonSalad = findViewById(R.id.SalmonSalad);
        chickenFriedRice = findViewById(R.id.chickenFriedRice);
        PrawnHarrisaSpaghetti = findViewById(R.id.PrawnHarrisaSpaghetti);
        ChickenNoodleSoup = findViewById(R.id.ChickenNoodleSoup);
        SpinachChicken = findViewById(R.id.SpinachChicken);
        navigation = findViewById(R.id.nonvegRecBottomNav);


        SalmonSalad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {salmonSalad();}});

        chickenFriedRice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {chickenRice();}});
        PrawnHarrisaSpaghetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {prawnSpaghetti();}});

        ChickenNoodleSoup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {noodleSoup();}});

        SpinachChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {spinachChicken();}});

        TunaBurger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {tunaBurger();}});


        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent userClicked;
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        userClicked =  new Intent(non_veg_recipes.this, mainMenu.class);
                        startActivity(userClicked);

                    case R.id.settings:
                        userClicked =  new Intent(non_veg_recipes.this, manageAccount.class);
                        startActivity(userClicked);

                    case R.id.favourites:
                        userClicked =  new Intent(non_veg_recipes.this, favourites.class);
                        startActivity(userClicked);

                    case R.id.MealPlanner:
                        userClicked =  new Intent(non_veg_recipes.this, mealplanner.class);
                        startActivity(userClicked);

                    default:
                        return non_veg_recipes.super.onOptionsItemSelected(item);
                }
            }
        });
    }

    final private void tunaBurger()
    {
        Intent goTo = new Intent( non_veg_recipes.this, tunaBurger.class);
        startActivity(goTo);
    }

    final private void salmonSalad()
    {
        Intent goTo = new Intent( non_veg_recipes.this, salmonSalad.class);
        startActivity(goTo);
    }
    final private void chickenRice()
    {
        Intent goTo = new Intent( non_veg_recipes.this, chickenFriedRice.class);
        startActivity(goTo);
    }
    final private void prawnSpaghetti()
    {
        Intent goTo = new Intent( non_veg_recipes.this, prawnSpaghetti.class);
        startActivity(goTo);
    }
    final private void noodleSoup()
    {
        Intent goTo = new Intent( non_veg_recipes.this, chickennoodleSoup.class);
        startActivity(goTo);
    }
    final private void spinachChicken()
    {
        Intent goTo = new Intent( non_veg_recipes.this, spinachChicken.class);
        startActivity(goTo);
    }
}