package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class vegrecipes extends AppCompatActivity {

    private CardView carrot;
    private CardView falafel;
    private CardView blt;

    private CardView pasta;
    private CardView noodles;
    private CardView risotto;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg_recipes);


        carrot = findViewById(R.id.carrotSoup);
        falafel = findViewById(R.id.FalafelBurger);
        navigation = findViewById(R.id.vegRecBottomNav);
        blt = findViewById(R.id.veggie_blt);
        pasta = findViewById(R.id.pancake);
        noodles = findViewById(R.id.veganRamen);
        risotto = findViewById(R.id.Tomato_risotto);



        carrot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                carrotPage();
            }
        });

        falafel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                falafelBurgerPage();
            }
        });

        blt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veggieBLT();
            }
        });

        pasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                creamyPasta();
            }
        });
        noodles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                veganNoodles();
            }
        });
        risotto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tomatoRisotto();
            }
        });


        navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent userClicked;
                switch (item.getItemId())
                {
                    case R.id.settings:
                        userClicked =  new Intent(vegrecipes.this, manageAccount.class);
                        startActivity(userClicked);
                        return true;
                    case R.id.favourites:
                        userClicked =  new Intent(vegrecipes.this, favourites.class);
                        startActivity(userClicked);
                        return true;
                    case R.id.MealPlanner:
                        userClicked =  new Intent(vegrecipes.this, mealplanner.class);
                        startActivity(userClicked);
                        return true;
                    default:
                        return vegrecipes.super.onOptionsItemSelected(item);
                }
            }
        });




    }



    final private void carrotPage()
    {
        Intent goTo = new Intent( vegrecipes.this, carrotSoupPage.class);
        startActivity(goTo);
    }
    final private  void falafelBurgerPage()
    {
        Intent goTo = new Intent(vegrecipes.this, falafelBurgerPage.class);
        startActivity(goTo);
    }
    final private  void veggieBLT()
    {
        Intent goTo = new Intent(vegrecipes.this, veggieBLTpage.class);
        startActivity(goTo);
    }
    final private  void creamyPasta()
    {
        Intent goTo = new Intent(vegrecipes.this, pasta.class);
        startActivity(goTo);
    }

    final private  void veganNoodles()
    {
        Intent goTo = new Intent(vegrecipes.this, ramenNoodlesPage.class);
        startActivity(goTo);
    }
    final private  void tomatoRisotto()
    {
        Intent goTo = new Intent(vegrecipes.this, tomatoRissitoPage.class);
        startActivity(goTo);
    }
}