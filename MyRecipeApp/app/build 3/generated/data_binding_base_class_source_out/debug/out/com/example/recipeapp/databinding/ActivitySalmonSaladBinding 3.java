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

public final class ActivitySalmonSaladBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView ChickenRiceSoupDesc;

  @NonNull
  public final CheckBox FavouritesCheck;

  @NonNull
  public final TextView RequiredList;

  @NonNull
  public final TextView SSstep1;

  @NonNull
  public final TextView SSstep2;

  @NonNull
  public final TextView SalmonSaladTitle;

  @NonNull
  public final Button checkedForRequiredItems;

  @NonNull
  public final TextView difficultyLevel11;

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
  public final TextView totaltime11;

  private ActivitySalmonSaladBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView ChickenRiceSoupDesc, @NonNull CheckBox FavouritesCheck,
      @NonNull TextView RequiredList, @NonNull TextView SSstep1, @NonNull TextView SSstep2,
      @NonNull TextView SalmonSaladTitle, @NonNull Button checkedForRequiredItems,
      @NonNull TextView difficultyLevel11, @NonNull ImageView imageView6,
      @NonNull TextView requiredItem1, @NonNull TextView requiredItem2,
      @NonNull TextView requiredItem3, @NonNull TextView requiredItem6,
      @NonNull TextView requiredItem7, @NonNull TextView requiredItem8,
      @NonNull TextView requireditem4, @NonNull TextView requireditem5,
      @NonNull TextView totaltime11) {
    this.rootView = rootView;
    this.ChickenRiceSoupDesc = ChickenRiceSoupDesc;
    this.FavouritesCheck = FavouritesCheck;
    this.RequiredList = RequiredList;
    this.SSstep1 = SSstep1;
    this.SSstep2 = SSstep2;
    this.SalmonSaladTitle = SalmonSaladTitle;
    this.checkedForRequiredItems = checkedForRequiredItems;
    this.difficultyLevel11 = difficultyLevel11;
    this.imageView6 = imageView6;
    this.requiredItem1 = requiredItem1;
    this.requiredItem2 = requiredItem2;
    this.requiredItem3 = requiredItem3;
    this.requiredItem6 = requiredItem6;
    this.requiredItem7 = requiredItem7;
    this.requiredItem8 = requiredItem8;
    this.requireditem4 = requireditem4;
    this.requireditem5 = requireditem5;
    this.totaltime11 = totaltime11;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySalmonSaladBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySalmonSaladBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_salmon_salad, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySalmonSaladBinding bind(@NonNull View rootView) {
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

      id = R.id.SSstep_1;
      TextView SSstep1 = ViewBindings.findChildViewById(rootView, id);
      if (SSstep1 == null) {
        break missingId;
      }

      id = R.id.SSstep_2;
      TextView SSstep2 = ViewBindings.findChildViewById(rootView, id);
      if (SSstep2 == null) {
        break missingId;
      }

      id = R.id.SalmonSaladTitle;
      TextView SalmonSaladTitle = ViewBindings.findChildViewById(rootView, id);
      if (SalmonSaladTitle == null) {
        break missingId;
      }

      id = R.id.checkedForRequiredItems;
      Button checkedForRequiredItems = ViewBindings.findChildViewById(rootView, id);
      if (checkedForRequiredItems == null) {
        break missingId;
      }

      id = R.id.difficultyLevel11;
      TextView difficultyLevel11 = ViewBindings.findChildViewById(rootView, id);
      if (difficultyLevel11 == null) {
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

      id = R.id.totaltime11;
      TextView totaltime11 = ViewBindings.findChildViewById(rootView, id);
      if (totaltime11 == null) {
        break missingId;
      }

      return new ActivitySalmonSaladBinding((ConstraintLayout) rootView, ChickenRiceSoupDesc,
          FavouritesCheck, RequiredList, SSstep1, SSstep2, SalmonSaladTitle,
          checkedForRequiredItems, difficultyLevel11, imageView6, requiredItem1, requiredItem2,
          requiredItem3, requiredItem6, requiredItem7, requiredItem8, requireditem4, requireditem5,
          totaltime11);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
