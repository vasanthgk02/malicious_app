package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;

public final class EmptyInternalShareBinding implements ViewBinding {
    public final AppCompatImageView emptyListImageView;
    public final CustomMediumTextView emptyListTextView;
    public final ConstraintLayout rootView;

    public EmptyInternalShareBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, CustomMediumTextView customMediumTextView) {
        this.rootView = constraintLayout;
        this.emptyListImageView = appCompatImageView;
        this.emptyListTextView = customMediumTextView;
    }

    public static EmptyInternalShareBinding bind(View view) {
        int i = R.id.emptyListImageView;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.emptyListImageView);
        if (appCompatImageView != null) {
            i = R.id.emptyListTextView;
            CustomMediumTextView customMediumTextView = (CustomMediumTextView) view.findViewById(R.id.emptyListTextView);
            if (customMediumTextView != null) {
                return new EmptyInternalShareBinding((ConstraintLayout) view, appCompatImageView, customMediumTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static EmptyInternalShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmptyInternalShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.empty_internal_share, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
