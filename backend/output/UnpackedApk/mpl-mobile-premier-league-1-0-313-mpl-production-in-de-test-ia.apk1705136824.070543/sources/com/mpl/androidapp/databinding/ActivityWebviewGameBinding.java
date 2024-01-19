package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;

public final class ActivityWebviewGameBinding implements ViewBinding {
    public final WebViewGamesContainer rootView;
    public final WebViewGamesContainer webViewGamesContainerId;

    public ActivityWebviewGameBinding(WebViewGamesContainer webViewGamesContainer, WebViewGamesContainer webViewGamesContainer2) {
        this.rootView = webViewGamesContainer;
        this.webViewGamesContainerId = webViewGamesContainer2;
    }

    public static ActivityWebviewGameBinding bind(View view) {
        if (view != null) {
            WebViewGamesContainer webViewGamesContainer = (WebViewGamesContainer) view;
            return new ActivityWebviewGameBinding(webViewGamesContainer, webViewGamesContainer);
        }
        throw new NullPointerException("rootView");
    }

    public static ActivityWebviewGameBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWebviewGameBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_webview_game, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public WebViewGamesContainer getRoot() {
        return this.rootView;
    }
}
