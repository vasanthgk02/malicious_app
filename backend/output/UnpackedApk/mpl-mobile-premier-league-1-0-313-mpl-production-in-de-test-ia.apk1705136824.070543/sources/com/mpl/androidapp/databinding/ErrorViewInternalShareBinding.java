package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.miniprofile.view.customviews.CustomMediumTextView;
import com.mpl.androidapp.miniprofile.view.customviews.CustomRegularTextView;

public final class ErrorViewInternalShareBinding implements ViewBinding {
    public final AppCompatImageView icon;
    public final ConstraintLayout rootView;
    public final CustomMediumTextView textViewHeading;
    public final CustomRegularTextView textViewSubHeading;
    public final CustomMediumTextView textViewTryAgain;

    public ErrorViewInternalShareBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, CustomMediumTextView customMediumTextView, CustomRegularTextView customRegularTextView, CustomMediumTextView customMediumTextView2) {
        this.rootView = constraintLayout;
        this.icon = appCompatImageView;
        this.textViewHeading = customMediumTextView;
        this.textViewSubHeading = customRegularTextView;
        this.textViewTryAgain = customMediumTextView2;
    }

    public static ErrorViewInternalShareBinding bind(View view) {
        int i = R.id.icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.icon);
        if (appCompatImageView != null) {
            i = R.id.textViewHeading;
            CustomMediumTextView customMediumTextView = (CustomMediumTextView) view.findViewById(R.id.textViewHeading);
            if (customMediumTextView != null) {
                i = R.id.textViewSubHeading;
                CustomRegularTextView customRegularTextView = (CustomRegularTextView) view.findViewById(R.id.textViewSubHeading);
                if (customRegularTextView != null) {
                    i = R.id.textViewTryAgain;
                    CustomMediumTextView customMediumTextView2 = (CustomMediumTextView) view.findViewById(R.id.textViewTryAgain);
                    if (customMediumTextView2 != null) {
                        ErrorViewInternalShareBinding errorViewInternalShareBinding = new ErrorViewInternalShareBinding((ConstraintLayout) view, appCompatImageView, customMediumTextView, customRegularTextView, customMediumTextView2);
                        return errorViewInternalShareBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ErrorViewInternalShareBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ErrorViewInternalShareBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.error_view_internal_share, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
