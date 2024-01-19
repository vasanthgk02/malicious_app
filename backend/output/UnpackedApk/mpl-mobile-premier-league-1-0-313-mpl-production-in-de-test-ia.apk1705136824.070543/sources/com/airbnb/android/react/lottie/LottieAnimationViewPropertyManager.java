package com.airbnb.android.react.lottie;

import android.widget.ImageView.ScaleType;
import com.airbnb.lottie.LottieAnimationView;
import com.facebook.react.bridge.ReadableArray;
import java.lang.ref.WeakReference;

public class LottieAnimationViewPropertyManager {
    public String animationJson;
    public String animationName;
    public boolean animationNameDirty;
    public ReadableArray colorFilters;
    public Boolean enableMergePaths;
    public String imageAssetsFolder;
    public Boolean loop;
    public Float progress;
    public ScaleType scaleType;
    public Float speed;
    public final WeakReference<LottieAnimationView> viewWeakReference;

    public LottieAnimationViewPropertyManager(LottieAnimationView lottieAnimationView) {
        this.viewWeakReference = new WeakReference<>(lottieAnimationView);
    }
}
