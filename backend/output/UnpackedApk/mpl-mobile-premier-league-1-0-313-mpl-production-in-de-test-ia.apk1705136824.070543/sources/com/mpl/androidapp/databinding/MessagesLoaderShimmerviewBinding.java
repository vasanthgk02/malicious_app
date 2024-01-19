package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.mpl.androidapp.R;

public final class MessagesLoaderShimmerviewBinding implements ViewBinding {
    public final ShapeableImageView imageView3;
    public final ConstraintLayout rootView;
    public final ShimmerFrameLayout shimmerFrameLayout;
    public final AppCompatTextView text;

    public MessagesLoaderShimmerviewBinding(ConstraintLayout constraintLayout, ShapeableImageView shapeableImageView, ShimmerFrameLayout shimmerFrameLayout2, AppCompatTextView appCompatTextView) {
        this.rootView = constraintLayout;
        this.imageView3 = shapeableImageView;
        this.shimmerFrameLayout = shimmerFrameLayout2;
        this.text = appCompatTextView;
    }

    public static MessagesLoaderShimmerviewBinding bind(View view) {
        int i = R.id.imageView3;
        ShapeableImageView shapeableImageView = (ShapeableImageView) view.findViewById(R.id.imageView3);
        if (shapeableImageView != null) {
            i = R.id.shimmerFrameLayout;
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) view.findViewById(R.id.shimmerFrameLayout);
            if (shimmerFrameLayout2 != null) {
                i = R.id.text;
                AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.text);
                if (appCompatTextView != null) {
                    return new MessagesLoaderShimmerviewBinding((ConstraintLayout) view, shapeableImageView, shimmerFrameLayout2, appCompatTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static MessagesLoaderShimmerviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MessagesLoaderShimmerviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.messages_loader_shimmerview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
