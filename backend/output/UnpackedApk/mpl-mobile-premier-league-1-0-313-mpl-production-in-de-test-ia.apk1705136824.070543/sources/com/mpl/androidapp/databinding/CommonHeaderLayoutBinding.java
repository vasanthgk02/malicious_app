package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class CommonHeaderLayoutBinding implements ViewBinding {
    public final RelativeLayout headerLayout;
    public final RelativeLayout rootView;
    public final AppCompatImageView webviewBack;

    public CommonHeaderLayoutBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, AppCompatImageView appCompatImageView) {
        this.rootView = relativeLayout;
        this.headerLayout = relativeLayout2;
        this.webviewBack = appCompatImageView;
    }

    public static CommonHeaderLayoutBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.webview_back);
        if (appCompatImageView != null) {
            return new CommonHeaderLayoutBinding((RelativeLayout) view, relativeLayout, appCompatImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.webview_back)));
    }

    public static CommonHeaderLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CommonHeaderLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.common_header_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
