package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityUnityMiniProfileBinding implements ViewBinding {
    public final FrameLayout rootView;
    public final FrameLayout unityMiniProfileContainerId;

    public ActivityUnityMiniProfileBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.unityMiniProfileContainerId = frameLayout2;
    }

    public static ActivityUnityMiniProfileBinding bind(View view) {
        if (view != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            return new ActivityUnityMiniProfileBinding(frameLayout, frameLayout);
        }
        throw new NullPointerException("rootView");
    }

    public static ActivityUnityMiniProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUnityMiniProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_unity_mini_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
