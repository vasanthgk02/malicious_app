package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public final class ItemInternalShareBinding implements ViewBinding {
    public final AppCompatCheckBox checkbox;
    public final ShapeableImageView ivAvtar;
    public final ConstraintLayout rootView;
    public final CustomRegularTextView tvDescription;
    public final CustomMediumTextView tvName;

    public ItemInternalShareBinding(ConstraintLayout constraintLayout, AppCompatCheckBox appCompatCheckBox, ShapeableImageView shapeableImageView, CustomRegularTextView customRegularTextView, CustomMediumTextView customMediumTextView) {
        this.rootView = constraintLayout;
        this.checkbox = appCompatCheckBox;
        this.ivAvtar = shapeableImageView;
        this.tvDescription = customRegularTextView;
        this.tvName = customMediumTextView;
    }

    public static ItemInternalShareBinding bind(View view) {
        int i = R.id.checkbox;
        AppCompatCheckBox appCompatCheckBox = (AppCompatCheckBox) view.findViewById(R.id.checkbox);
        if (appCompatCheckBox != null) {
            i = R.id.ivAvtar;
            ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.ivAvtar);
            if (shapeableImageView != null) {
                i = R.id.tvDescription;
                CustomRegularTextView customRegularTextView = (CustomRegularTextView) view.findViewById(R.id.tvDescription);
                if (customRegularTextView != null) {
                    i = R.id.tvName;
                    CustomMediumTextView customMediumTextView = (CustomMediumTextView) view.findViewById(R.id.tvName);
                    if (customMediumTextView != null) {
                        ItemInternalShareBinding itemInternalShareBinding = new ItemInternalShareBinding((ConstraintLayout) view, appCompatCheckBox, shapeableImageView, customRegularTextView, customMediumTextView);
                        return itemInternalShareBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ItemInternalShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemInternalShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.item_internal_share, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
