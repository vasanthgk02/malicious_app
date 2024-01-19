package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityFantasyWebViewBinding implements ViewBinding {
    public final FrameLayout rootView;
    public final WebView webView;

    public ActivityFantasyWebViewBinding(FrameLayout frameLayout, WebView webView2) {
        this.rootView = frameLayout;
        this.webView = webView2;
    }

    public static ActivityFantasyWebViewBinding bind(View view) {
        WebView webView2 = (WebView) view.findViewById(R.id.webView);
        if (webView2 != null) {
            return new ActivityFantasyWebViewBinding((FrameLayout) view, webView2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.webView)));
    }

    public static ActivityFantasyWebViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityFantasyWebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_fantasy_web_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }
}
