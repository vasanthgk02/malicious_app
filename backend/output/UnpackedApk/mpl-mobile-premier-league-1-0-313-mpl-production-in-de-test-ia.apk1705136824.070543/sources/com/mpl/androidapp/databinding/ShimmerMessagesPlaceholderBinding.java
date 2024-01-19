package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.mpl.androidapp.R;

public final class ShimmerMessagesPlaceholderBinding implements ViewBinding {
    public final AppCompatTextView bubble;
    public final AppCompatTextView bubble2;
    public final ShapeableImageView imageView;
    public final ShapeableImageView imageView2;
    public final ConstraintLayout rootView;

    public ShimmerMessagesPlaceholderBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2) {
        this.rootView = constraintLayout;
        this.bubble = appCompatTextView;
        this.bubble2 = appCompatTextView2;
        this.imageView = shapeableImageView;
        this.imageView2 = shapeableImageView2;
    }

    public static ShimmerMessagesPlaceholderBinding bind(View view) {
        int i = R.id.bubble;
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.bubble);
        if (appCompatTextView != null) {
            i = R.id.bubble2;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.bubble2);
            if (appCompatTextView2 != null) {
                i = R.id.imageView;
                ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.imageView);
                if (shapeableImageView != null) {
                    i = R.id.imageView2;
                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) view.findViewById(R.id.imageView2);
                    if (shapeableImageView2 != null) {
                        ShimmerMessagesPlaceholderBinding shimmerMessagesPlaceholderBinding = new ShimmerMessagesPlaceholderBinding((ConstraintLayout) view, appCompatTextView, appCompatTextView2, shapeableImageView, shapeableImageView2);
                        return shimmerMessagesPlaceholderBinding;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ShimmerMessagesPlaceholderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ShimmerMessagesPlaceholderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.shimmer_messages_placeholder, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
