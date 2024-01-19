package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class AdsViewBinding implements ViewBinding {
    public final ConstraintLayout rootView;

    public AdsViewBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    public static AdsViewBinding bind(View view) {
        if (view != null) {
            return new AdsViewBinding((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    public static AdsViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AdsViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ads_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
