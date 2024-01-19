package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityMplsplashBinding implements ViewBinding {
    public final FrameLayout rootView;

    public ActivityMplsplashBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public static ActivityMplsplashBinding bind(View view) {
        if (view != null) {
            return new ActivityMplsplashBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ActivityMplsplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMplsplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_mplsplash, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
