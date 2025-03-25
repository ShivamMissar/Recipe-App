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

public class veggieChilli extends AppCompatActivity {
    private Button got_requiredItems;
    CheckBox addToFav;
    private TextView step1;

    private FirebaseFirestore db;
    private FirebaseUser user;
    private static final String MESSAGE = "Added to favourites";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veggie_chilli);





        got_requiredItems = findViewById(R.id.checkedForRequiredItems);
        step1 = (TextView) findViewById(R.id.VCstep_1);


        got_requiredItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step1.setVisibility(View.VISIBLE);
            }
        });

        addToFav = findViewById(R.id.FavouritesCheck);

        addToFav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                //read from recipes document where it is CarrotSoup
                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                firebaseFirestore.collection("AllRecipes").document("VeggieChilli").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task)
                    {
                        DocumentSnapshot documentSnapshot = task.getResult();
                        if (documentSnapshot.exists())
                        {
                            String recipeName = documentSnapshot.getString("RecipeName");
                            String imageLink = documentSnapshot.getString("RecipeImage");

                            HashMap<String,Object> fav = new HashMap<>();
                            fav.put("RecipeName",recipeName);
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