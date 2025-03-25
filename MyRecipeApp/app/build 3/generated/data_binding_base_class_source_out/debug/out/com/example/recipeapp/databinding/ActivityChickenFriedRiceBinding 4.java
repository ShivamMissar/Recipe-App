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

public final class ActivityChickenFriedRiceBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView ChickenRiceSoupDesc;

  @NonNull
  public final CheckBox FavouritesCheck;

  @NonNull
  public final TextView RequiredList;

  @NonNull
  public final Button checkedForRequiredItems;

  @NonNull
  public final TextView chickenRiceTitle;

  @NonNull
  public final TextView ckStep1;

  @NonNull
  public final TextView ckStep2;

  @NonNull
  public final TextView ckStep3;

  @NonNull
  public final TextView difficultyLevel2;

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
  public final TextView requiredItem9;

  @NonNull
  public final TextView requireditem4;

  @NonNull
  public final TextView requireditem5;

  @NonNull
  public final TextView totaltime2;

  private ActivityChickenFriedRiceBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView ChickenRiceSoupDesc, @NonNull CheckBox FavouritesCheck,
      @NonNull TextView RequiredList, @NonNull Button checkedForRequiredItems,
      @NonNull TextView chickenRiceTitle, @NonNull TextView ckStep1, @NonNull TextView ckStep2,
      @NonNull TextView ckStep3, @NonNull TextView difficultyLevel2, @NonNull ImageView imageView6,
      @NonNull TextView requiredItem1, @NonNull TextView requiredItem2,
      @NonNull TextView requiredItem3, @NonNull TextView requiredItem6,
      @NonNull TextView requiredItem7, @NonNull TextView requiredItem8,
      @NonNull TextView requiredItem9, @NonNull TextView requireditem4,
      @NonNull TextView requireditem5, @NonNull TextView totaltime2) {
    this.rootView = rootView;
    this.ChickenRiceSoupDesc = ChickenRiceSoupDesc;
    this.FavouritesCheck = FavouritesCheck;
    this.RequiredList = RequiredList;
    this.checkedForRequiredItems = checkedForRequiredItems;
    this.chickenRiceTitle = chickenRiceTitle;
    this.ckStep1 = ckStep1;
    this.ckStep2 = ckStep2;
    this.ckStep3 = ckStep3;
    this.difficultyLevel2 = difficultyLevel2;
    this.imageView6 = imageView6;
    this.requiredItem1 = requiredItem1;
    this.requiredItem2 = requiredItem2;
    this.requiredItem3 = requiredItem3;
    this.requiredItem6 = requiredItem6;
    this.requiredItem7 = requiredItem7;
    this.requiredItem8 = requiredItem8;
    this.requiredItem9 = requiredItem9;
    this.requireditem4 = requireditem4;
    this.requireditem5 = requireditem5;
    this.totaltime2 = totaltime2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChickenFriedRiceBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChickenFriedRiceBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_chicken_fried_rice, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChickenFriedRiceBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ChickenRiceSoupDesc;
      TextView ChickenRiceSoupDesc = ViewBindings.findChildViewById(rootView, id);
      if (ChickenRiceSoupDesc == null) {
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

      id = R.id.checkedForRequiredItems;
      Button checkedForRequiredItems = ViewBindings.findChildViewById(rootView, id);
      if (checkedForRequiredItems == null) {
        break missingId;
      }

      id = R.id.chickenRiceTitle;
      TextView chickenRiceTitle = ViewBindings.findChildViewById(rootView, id);
      if (chickenRiceTitle == null) {
        break missingId;
      }

      id = R.id.ck_step_1;
      TextView ckStep1 = ViewBindings.findChildViewById(rootView, id);
      if (ckStep1 == null) {
        break missingId;
      }

      id = R.id.ck_step_2;
      TextView ckStep2 = ViewBindings.findChildViewById(rootView, id);
      if (ckStep2 == null) {
        break missingId;
      }

      id = R.id.ck_step_3;
      TextView ckStep3 = ViewBindings.findChildViewById(rootView, id);
      if (ckStep3 == null) {
        break missingId;
      }

      id = R.id.difficultyLevel2;
      TextView difficultyLevel2 = ViewBindings.findChildViewById(rootView, id);
      if (difficultyLevel2 == null) {
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

      id = R.id.requiredItem9;
      TextView requiredItem9 = ViewBindings.findChildViewById(rootView, id);
      if (requiredItem9 == null) {
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

      id = R.id.totaltime2;
      TextView totaltime2 = ViewBindings.findChildViewById(rootView, id);
      if (totaltime2 == null) {
        break missingId;
      }

      return new ActivityChickenFriedRiceBinding((ConstraintLayout) rootView, ChickenRiceSoupDesc,
          FavouritesCheck, RequiredList, checkedForRequiredItems, chickenRiceTitle, ckStep1,
          ckStep2, ckStep3, difficultyLevel2, imageView6, requiredItem1, requiredItem2,
          requiredItem3, requiredItem6, requiredItem7, requiredItem8, requiredItem9, requireditem4,
          requireditem5, totaltime2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
