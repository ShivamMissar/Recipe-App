// Generated by view binder compiler. Do not edit!
package com.example.recipeapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.recipeapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySpongeCakeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView ChickenRiceSoupDesc;

  @NonNull
  public final TextView ETSstep1;

  @NonNull
  public final TextView ETSstep2;

  @NonNull
  public final CheckBox FavouritesCheck;

  @NonNull
  public final TextView RequiredList;

  @NonNull
  public final TextView SpongeCakeTitle;

  @NonNull
  public final Button checkedForRequiredItems;

  @NonNull
  public final TextView difficultyLevel12;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final TextView requiredItem1;

  @NonNull
  public final TextView requiredItem2;

  @NonNull
  public final TextView requiredItem3;

  @NonNull
  public final TextView requiredItem6;

  @NonNull
  public final TextView requiredItem7;

  @NonNull
  public final TextView requiredItem8;

  @NonNull
  public final TextView requireditem4;

  @NonNull
  public final TextView requireditem5;

  @NonNull
  public final TextView totaltime12;

  private ActivitySpongeCakeBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView ChickenRiceSoupDesc, @NonNull TextView ETSstep1, @NonNull TextView ETSstep2,
      @NonNull CheckBox FavouritesCheck, @NonNull TextView RequiredList,
      @NonNull TextView SpongeCakeTitle, @NonNull Button checkedForRequiredItems,
      @NonNull TextView difficultyLevel12, @NonNull ImageView imageView6,
      @NonNull TextView requiredItem1, @NonNull TextView requiredItem2,
      @NonNull TextView requiredItem3, @NonNull TextView requiredItem6,
      @NonNull TextView requiredItem7, @NonNull TextView requiredItem8,
      @NonNull TextView requireditem4, @NonNull TextView requireditem5,
      @NonNull TextView totaltime12) {
    this.rootView = rootView;
    this.ChickenRiceSoupDesc = ChickenRiceSoupDesc;
    this.ETSstep1 = ETSstep1;
    this.ETSstep2 = ETSstep2;
    this.FavouritesCheck = FavouritesCheck;
    this.RequiredList = RequiredList;
    this.SpongeCakeTitle = SpongeCakeTitle;
    this.checkedForRequiredItems = checkedForRequiredItems;
    this.difficultyLevel12 = difficultyLevel12;
    this.imageView6 = imageView6;
    this.requiredItem1 = requiredItem1;
    this.requiredItem2 = requiredItem2;
    this.requiredItem3 = requiredItem3;
    this.requiredItem6 = requiredItem6;
    this.requiredItem7 = requiredItem7;
    this.requiredItem8 = requiredItem8;
    this.requireditem4 = requireditem4;
    this.requireditem5 = requireditem5;
    this.totaltime12 = totaltime12;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySpongeCakeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySpongeCakeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_sponge_cake, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySpongeCakeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ChickenRiceSoupDesc;
      TextView ChickenRiceSoupDesc = ViewBindings.findChildViewById(rootView, id);
      if (ChickenRiceSoupDesc == null) {
        break missingId;
      }

      id = R.id.ETSstep_1;
      TextView ETSstep1 = ViewBindings.findChildViewById(rootView, id);
      if (ETSstep1 == null) {
        break missingId;
      }

      id = R.id.ETSstep_2;
      TextView ETSstep2 = ViewBindings.findChildViewById(rootView, id);
      if (ETSstep2 == null) {
        break missingId;
      }

      id = R.id.FavouritesCheck;
      CheckBox FavouritesCheck = ViewBindings.findChildViewById(rootView, id);
      if (FavouritesCheck == null) {
        break missingId;
      }

      id = R.id.RequiredList;
      TextView RequiredList = ViewBindings.findChildViewById(rootView, id);
      if (RequiredList == null) {
        break missingId;
      }

      id = R.id.SpongeCakeTitle;
      TextView SpongeCakeTitle = ViewBindings.findChildViewById(rootView, id);
      if (SpongeCakeTitle == null) {
        break missingId;
      }

      id = R.id.checkedForRequiredItems;
      Button checkedForRequiredItems = ViewBindings.findChildViewById(rootView, id);
      if (checkedForRequiredItems == null) {
        break missingId;
      }

      id = R.id.difficultyLevel12;
      TextView difficultyLevel12 = ViewBindings.findChildViewById(rootView, id);
      if (difficultyLevel12 == null) {
        break missingId;
      }

      id = R.id.imageView6;
      ImageView imageView6 = ViewBindings.findChildViewById(rootView, id);
      if (imageView6 == null) {
        break missingId;
      }

      id = R.id.requiredItem1;
      TextView requiredItem1 = ViewBindings.findChildViewById(rootView, id);
      if (requiredItem1 == null) {
        break missingId;
      }

      id = R.id.requiredItem2;
      TextView requiredItem2 = ViewBindings.findChildViewById(rootView, id);
      if (requiredItem2 == null) {
        break missingId;
      }

      id = R.id.requiredItem3;
      TextView requiredItem3 = ViewBindings.findChildViewById(rootView, id);
      if (requiredItem3 == null) {
        break missingId;
      }

      id = R.id.requiredItem6;
      TextView requiredItem6 = ViewBindings.findChildViewById(rootView, id);
      if (requiredItem6 == null) {
        break missingId;
      }

      id = R.id.requiredItem7;
      TextView requiredItem7 = ViewBindings.findChildViewById(rootView, id);
      if (requiredItem7 == null) {
        break missingId;
      }

      id = R.id.requiredItem8;
      TextView requiredItem8 = ViewBindings.findChildViewById(rootView, id);
      if (requiredItem8 == null) {
        break missingId;
      }

      id = R.id.requireditem4;
      TextView requireditem4 = ViewBindings.findChildViewById(rootView, id);
      if (requireditem4 == null) {
        break missingId;
      }

      id = R.id.requireditem5;
      TextView requireditem5 = ViewBindings.findChildViewById(rootView, id);
      if (requireditem5 == null) {
        break missingId;
      }

      id = R.id.totaltime12;
      TextView totaltime12 = ViewBindings.findChildViewById(rootView, id);
      if (totaltime12 == null) {
        break missingId;
      }

      return new ActivitySpongeCakeBinding((ConstraintLayout) rootView, ChickenRiceSoupDesc,
          ETSstep1, ETSstep2, FavouritesCheck, RequiredList, SpongeCakeTitle,
          checkedForRequiredItems, difficultyLevel12, imageView6, requiredItem1, requiredItem2,
          requiredItem3, requiredItem6, requiredItem7, requiredItem8, requireditem4, requireditem5,
          totaltime12);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
