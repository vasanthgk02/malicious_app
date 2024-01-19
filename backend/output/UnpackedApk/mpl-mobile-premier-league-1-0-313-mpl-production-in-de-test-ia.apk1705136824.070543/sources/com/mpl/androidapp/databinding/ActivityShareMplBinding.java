package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mpl.androidapp.R;

public final class ActivityShareMplBinding implements ViewBinding {
    public final CoordinatorLayout rootView;
    public final FloatingActionButton send;
    public final Toolbar toolbar;

    public ActivityShareMplBinding(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Toolbar toolbar2) {
        this.rootView = coordinatorLayout;
        this.send = floatingActionButton;
        this.toolbar = toolbar2;
    }

    public static ActivityShareMplBinding bind(View view) {
        int i = R.id.send;
        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.send);
        if (floatingActionButton != null) {
            i = R.id.toolbar;
            Toolbar toolbar2 = (Toolbar) view.findViewById(R.id.toolbar);
            if (toolbar2 != null) {
                return new ActivityShareMplBinding((CoordinatorLayout) view, floatingActionButton, toolbar2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityShareMplBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityShareMplBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_share_mpl, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
