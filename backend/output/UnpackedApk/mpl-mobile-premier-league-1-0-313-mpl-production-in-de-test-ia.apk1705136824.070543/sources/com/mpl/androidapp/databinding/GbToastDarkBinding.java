package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class GbToastDarkBinding implements ViewBinding {
    public final AppCompatImageView icon;
    public final LinearLayout rootView;
    public final AppCompatTextView text;
    public final LinearLayout toastContainer;

    public GbToastDarkBinding(LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatTextView appCompatTextView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.icon = appCompatImageView;
        this.text = appCompatTextView;
        this.toastContainer = linearLayout2;
    }

    public static GbToastDarkBinding bind(View view) {
        int i = R.id.icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.icon);
        if (appCompatImageView != null) {
            i = R.id.text;
            AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.text);
            if (appCompatTextView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new GbToastDarkBinding(linearLayout, appCompatImageView, appCompatTextView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static GbToastDarkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GbToastDarkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.gb_toast_dark, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
