package com.example.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class falafelBurgerPage extends AppCompatActivity {

    private Button got_The_Required_Ingr;
    private FirebaseUser user;
    CheckBox add_To_Fav;
    TextView step1;
    TextView step2;
    TextView step3;
    TextView step4;

    private static final String MESSAGE = "Added to favourites";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_falafel_burger_page);


        got_The_Required_Ingr = findViewById(R.id.gotTheRequiredItems);
        add_To_Fav = findViewById(R.id.FavouritesCheck);
        step1 = findViewById(R.id.FBstep_1);
        step2 = findViewById(R.id.FBstep_2);
        step3 = findViewById(R.id.FBstep_3);
        step4 = findViewById(R.id.FBstep_4);


        // this make the instructions appear
        got_The_Required_Ingr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this will make the instructions to follow appear once the user has clicked the button for having got all the recipes.
                step1.setVisibility(View.VISIBLE);
                step2.setVisibility(View.VISIBLE);
                step3.setVisibility(View.VISIBLE);
                step4.setVisibility(View.VISIBLE);
            }
        });


        // this will check to see if the user has added this recipe to their favourites
        add_To_Fav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                firebaseFirestore.collection("AllRecipes").document("FalafelBurger").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task)
                    {
                        DocumentSnapshot documentSnapshot = task.getResult();
                        if (documentSnapshot.exists()) {
                            String recipeName = documentSnapshot.getString("RecipeName");
                            String imageLink = documentSnapshot.getString("RecipeImage");

                            HashMap<String, Object> fav = new HashMap<>();
                            fav.put("RecipeName", recipeName);
                            fav.put("RecipeImage", imageLink);
                            user = FirebaseAuth.getInstance().getCurrentUser();
                            firebaseFirestore.collection("Users").document(user.getUid()).collection("Favourites").add(fav).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                    enable_custom_toast();
                                }
                            });

                        }
                    }
                });
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