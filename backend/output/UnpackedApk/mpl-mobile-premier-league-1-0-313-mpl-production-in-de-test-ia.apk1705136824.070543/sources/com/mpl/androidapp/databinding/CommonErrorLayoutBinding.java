package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class CommonErrorLayoutBinding implements ViewBinding {
    public final FrameLayout errorWebview;
    public final FrameLayout rootView;
    public final Button webviewOk;

    public CommonErrorLayoutBinding(FrameLayout frameLayout, FrameLayout frameLayout2, Button button) {
        this.rootView = frameLayout;
        this.errorWebview = frameLayout2;
        this.webviewOk = button;
    }

    public static CommonErrorLayoutBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        Button button = (Button) view.findViewById(R.id.webview_ok);
        if (button != null) {
            return new CommonErrorLayoutBinding((FrameLayout) view, frameLayout, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.webview_ok)));
    }

    public static CommonErrorLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CommonErrorLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.common_error_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
