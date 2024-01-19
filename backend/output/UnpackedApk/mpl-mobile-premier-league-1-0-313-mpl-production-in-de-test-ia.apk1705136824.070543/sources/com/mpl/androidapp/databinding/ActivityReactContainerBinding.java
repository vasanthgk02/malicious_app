package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.mpl.androidapp.R;

public final class ActivityReactContainerBinding implements ViewBinding {
    public final ConstraintLayout container;
    public final LottieAnimationView dynamicSplashImageLottie;
    public final ConstraintLayout rootView;

    public ActivityReactContainerBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LottieAnimationView lottieAnimationView) {
        this.rootView = constraintLayout;
        this.container = constraintLayout2;
        this.dynamicSplashImageLottie = lottieAnimationView;
    }

    public static ActivityReactContainerBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.dynamic_splash_image_lottie);
        if (lottieAnimationView != null) {
            return new ActivityReactContainerBinding((ConstraintLayout) view, constraintLayout, lottieAnimationView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.dynamic_splash_image_lottie)));
    }

    public static ActivityReactContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityReactContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_react_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
