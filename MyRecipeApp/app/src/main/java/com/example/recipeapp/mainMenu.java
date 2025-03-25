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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Random;

public class mainMenu extends AppCompatActivity {

    CardView veg_recipes;
    CardView non_veg_recipies;
    CardView other_recipes;

    TextView updateDecidedRecipe;

    Button Randomiser;

    private BottomNavigationView navigation;

    private Integer[] recipeArr;
    ImageView myRecipeRecommends;
    private TextView MY_RECIPE_RECOMMENDATIONS_TEXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        veg_recipes = findViewById(R.id.card1Veg);
        non_veg_recipies = findViewById(R.id.card2NonVeg);
        other_recipes = findViewById(R.id.card3Other);
        myRecipeRecommends = findViewById(R.id.dailyRecImage);
        navigation = findViewById(R.id.bottomNav);
        navigation.setSelectedItemId(R.id.nav_home);
        MY_RECIPE_RECOMMENDATIONS_TEXT = findViewById(R.id.dailyRecommendations);

       systemChoice();

       // cardview click listener for for veg option
        veg_recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegRecipe();
            }
        });

        // cardview click listener for for nonveg option
        non_veg_recipies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nonVegRecipe();
            }
        });

        // cardview click listener for all other options
        other_recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otherRecipes();
            }
        });

        // looks out for clicks on the bottom navigation
        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent userSelected;

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        userSelected = new Intent(mainMenu.this,mainMenu.class);
                        startActivity(userSelected);
                        return true;

                    case R.id.MealPlanner:
                        userSelected = new Intent(mainMenu.this,mealplanner.class);
                        startActivity(userSelected);
                        return true;

                    case R.id.favourites:
                        userSelected = new Intent(mainMenu.this,favourites.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.nearbystores:
                        userSelected = new Intent(mainMenu.this, nearbystores.class);
                        startActivity(userSelected);
                        return true;
                    case R.id.settings:
                        userSelected = new Intent(mainMenu.this, manageAccount.class);
                         startActivity(userSelected);
                         return true;
                    default:
                        return mainMenu.super.onOptionsItemSelected(item);
                }
            }
        });
    }

    // function creates an array which will store all the recipe images and using the random function, it will then select any of the images and give that image as the
    //recommended choice
    public void systemChoice()
    {
        recipeArr = new Integer[] {R.drawable.carrotsoup, R.drawable.cauliflowercheese, R.drawable.chickenkiev, R.drawable.chickensoup,
                R.drawable.chickerice, R.drawable.creamy_mushroom_pasta, R.drawable.falafelburger, R.drawable.oats, R.drawable.pancake,
                R.drawable.prawnharissa, R.drawable.salmonsalad, R.drawable.spinachpasta, R.drawable.veggiechilli, R.drawable.vegan_ramen,
                R.drawable.spongecake, R.drawable.tomato_risotto, R.drawable.tunaburger, R.drawable.veggie_blt};

        Random random = new Random();
        myRecipeRecommends.setImageResource(recipeArr[random.nextInt(recipeArr.length)]);
    }

    // functions for moving to a different page.
    public void vegRecipe()
    {
        Intent moveToVeg = new Intent(mainMenu.this, vegrecipes.class);
        startActivity(moveToVeg);
    }
    public void nonVegRecipe()
    {
        Intent moveToVeg = new Intent(mainMenu.this, non_veg_recipes.class);
        startActivity(moveToVeg);
    }
    public void otherRecipes()
    {
        Intent moveToVeg = new Intent(mainMenu.this, other_recipes.class);
        startActivity(moveToVeg);
    }
}
