package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.mpl.androidapp.R;

public final class LayoutLottieHeartLikeBinding implements ViewBinding {
    public final LottieAnimationView heartAnim;
    public final LottieAnimationView rootView;

    public LayoutLottieHeartLikeBinding(LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2) {
        this.rootView = lottieAnimationView;
        this.heartAnim = lottieAnimationView2;
    }

    public static LayoutLottieHeartLikeBinding bind(View view) {
        if (view != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view;
            return new LayoutLottieHeartLikeBinding(lottieAnimationView, lottieAnimationView);
        }
        throw new NullPointerException("rootView");
    }

    public static LayoutLottieHeartLikeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutLottieHeartLikeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_lottie_heart_like, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LottieAnimationView getRoot() {
        return this.rootView;
    }
}
