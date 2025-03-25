// Generated by view binder compiler. Do not edit!
package com.example.recipeapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.recipeapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainMenuBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNav;

  @NonNull
  public final CardView card1Veg;

  @NonNull
  public final CardView card2NonVeg;

  @NonNull
  public final CardView card3Other;

  @NonNull
  public final TextView information;

  @NonNull
  public final TextView menuTitle;

  @NonNull
  public final CardView recommendations;

  private ActivityMainMenuBinding(@NonNull ConstraintLayout rootView,
      @NonNull BottomNavigationView bottomNav, @NonNull CardView card1Veg,
      @NonNull CardView card2NonVeg, @NonNull CardView card3Other, @NonNull TextView information,
      @NonNull TextView menuTitle, @NonNull CardView recommendations) {
    this.rootView = rootView;
    this.bottomNav = bottomNav;
    this.card1Veg = card1Veg;
    this.card2NonVeg = card2NonVeg;
    this.card3Other = card3Other;
    this.information = information;
    this.menuTitle = menuTitle;
    this.recommendations = recommendations;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainMenuBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainMenuBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_menu, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainMenuBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomNav;
      BottomNavigationView bottomNav = ViewBindings.findChildViewById(rootView, id);
      if (bottomNav == null) {
        break missingId;
      }

      id = R.id.card1Veg;
      CardView card1Veg = ViewBindings.findChildViewById(rootView, id);
      if (card1Veg == null) {
        break missingId;
      }

      id = R.id.card2NonVeg;
      CardView card2NonVeg = ViewBindings.findChildViewById(rootView, id);
      if (card2NonVeg == null) {
        break missingId;
      }

      id = R.id.card3Other;
      CardView card3Other = ViewBindings.findChildViewById(rootView, id);
      if (card3Other == null) {
        break missingId;
      }

      id = R.id.information;
      TextView information = ViewBindings.findChildViewById(rootView, id);
      if (information == null) {
        break missingId;
      }

      id = R.id.menuTitle;
      TextView menuTitle = ViewBindings.findChildViewById(rootView, id);
      if (menuTitle == null) {
        break missingId;
      }

      id = R.id.recommendations;
      CardView recommendations = ViewBindings.findChildViewById(rootView, id);
      if (recommendations == null) {
        break missingId;
      }

      return new ActivityMainMenuBinding((ConstraintLayout) rootView, bottomNav, card1Veg,
          card2NonVeg, card3Other, information, menuTitle, recommendations);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
