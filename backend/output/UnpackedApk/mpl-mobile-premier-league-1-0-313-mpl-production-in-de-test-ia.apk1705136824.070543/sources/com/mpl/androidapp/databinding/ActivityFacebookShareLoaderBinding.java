package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityFacebookShareLoaderBinding implements ViewBinding {
    public final FrameLayout rootView;

    public ActivityFacebookShareLoaderBinding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    public static ActivityFacebookShareLoaderBinding bind(View view) {
        if (view != null) {
            return new ActivityFacebookShareLoaderBinding((FrameLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static ActivityFacebookShareLoaderBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFacebookShareLoaderBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_facebook_share_loader, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
