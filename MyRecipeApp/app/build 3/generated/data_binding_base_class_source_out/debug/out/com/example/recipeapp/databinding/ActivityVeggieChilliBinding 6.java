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

public final class ActivityVeggieChilliBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView ChickenRiceSoupDesc;

  @NonNull
  public final CheckBox FavouritesCheck;

  @NonNull
  public final TextView RequiredList;

  @NonNull
  public final TextView VCstep1;

  @NonNull
  public final Button checkedForRequiredItems;

  @NonNull
  public final TextView chickenRiceTitle;

  @NonNull
  public final ImageView imageView6;

  @NonNull
  public final TextView requiredItem1;

  @NonNull
  public final TextView requiredItem2;

  @NonNull
  public final TextView requiredItem3;

  @NonNull
  public final TextView requireditem4;

  private ActivityVeggieChilliBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView ChickenRiceSoupDesc, @NonNull CheckBox FavouritesCheck,
      @NonNull TextView RequiredList, @NonNull TextView VCstep1,
      @NonNull Button checkedForRequiredItems, @NonNull TextView chickenRiceTitle,
      @NonNull ImageView imageView6, @NonNull TextView requiredItem1,
      @NonNull TextView requiredItem2, @NonNull TextView requiredItem3,
      @NonNull TextView requireditem4) {
    this.rootView = rootView;
    this.ChickenRiceSoupDesc = ChickenRiceSoupDesc;
    this.FavouritesCheck = FavouritesCheck;
    this.RequiredList = RequiredList;
    this.VCstep1 = VCstep1;
    this.checkedForRequiredItems = checkedForRequiredItems;
    this.chickenRiceTitle = chickenRiceTitle;
    this.imageView6 = imageView6;
    this.requiredItem1 = requiredItem1;
    this.requiredItem2 = requiredItem2;
    this.requiredItem3 = requiredItem3;
    this.requireditem4 = requireditem4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityVeggieChilliBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityVeggieChilliBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_veggie_chilli, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityVeggieChilliBinding bind(@NonNull View rootView) {
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

      id = R.id.VCstep_1;
      TextView VCstep1 = ViewBindings.findChildViewById(rootView, id);
      if (VCstep1 == null) {
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

      id = R.id.requireditem4;
      TextView requireditem4 = ViewBindings.findChildViewById(rootView, id);
      if (requireditem4 == null) {
        break missingId;
      }

      return new ActivityVeggieChilliBinding((ConstraintLayout) rootView, ChickenRiceSoupDesc,
          FavouritesCheck, RequiredList, VCstep1, checkedForRequiredItems, chickenRiceTitle,
          imageView6, requiredItem1, requiredItem2, requiredItem3, requireditem4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
