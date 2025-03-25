package com.example.recipeapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

// Code taken from the LAB
public class ListAdapter extends BaseAdapter {
    Context context;
    private ArrayList<String> RecipeName = new ArrayList<>();
    private ArrayList<String> RecipeImage = new ArrayList<>();

    private Button deleteRecipe;

    public String getItemId;

    favourites favourites;



    public ListAdapter(Context context, ArrayList<String> RecipeName, ArrayList<String> RecipeImage) {
        this.context = context;
        this.RecipeName = RecipeName;
        this.RecipeImage = RecipeImage;
    }

    public void setGetItemId(String itemId){this.getItemId = itemId;}
    public String getGetItemId(){return getItemId; }

    @Override
    public int getCount() {
       return RecipeName.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if(convertView == null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.single_list_item,parent,false);

            viewHolder.txtName = convertView.findViewById(R.id.recipeName);

            viewHolder.icon = convertView.findViewById(R.id.recipeImage);

            viewHolder.delete = convertView.findViewById(R.id.delete);


            convertView.setTag(viewHolder);
        }else {
          viewHolder = (ViewHolder) convertView.getTag();

        }
        viewHolder.txtName.setText(RecipeName.get(position));
        Picasso.get().load(RecipeImage.get(position)).into(viewHolder.icon);

        // read the data first and then delete the entry.

        viewHolder.delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //Integer index = (Integer) v.getTag();
                RecipeName.remove(position);
                RecipeImage.remove(position);
                notifyDataSetChanged();
                // after deleting it from the screen, delete it from the database.
                ArrayList<String>getListOfIds = new ArrayList<>();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();

                //String Ids = firebaseFirestore.collection("Users").document(user.getUid()).collection("Favourites").document().getId();

                firebaseFirestore.collection("Users").document(user.getUid()).collection("Favourites").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>()
                {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task)
                    {
                        if(task.isSuccessful())
                        {
                            for(QueryDocumentSnapshot documentSnapshot: task.getResult())
                            {
                                getListOfIds.add(documentSnapshot.getId());
                            }
                            firebaseFirestore.collection("Users").document(user.getUid()).collection("Favourites").document(getListOfIds.get(position)).delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task)
                                {
                                    Toast.makeText(context, "This has successfully been deleted.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });
            }
        });
        return convertView;
    }

    private static class ViewHolder
    {
        TextView txtName;

        ImageView icon;

        Button delete;
    }


    public void delete()
    {

    }
}
