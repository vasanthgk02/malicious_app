package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;
import com.mpl.androidapp.webview.view.customviews.CustomWebView;
import com.mpl.androidapp.webview.view.customviews.WebViewLoaderContainer;

public final class ContainerWebviewGamesBinding implements ViewBinding {
    public final LinearLayout rootView;
    public final WebViewLoaderContainer webGamesLoaderView;
    public final CustomWebView webGamesView;

    public ContainerWebviewGamesBinding(LinearLayout linearLayout, WebViewLoaderContainer webViewLoaderContainer, CustomWebView customWebView) {
        this.rootView = linearLayout;
        this.webGamesLoaderView = webViewLoaderContainer;
        this.webGamesView = customWebView;
    }

    public static ContainerWebviewGamesBinding bind(View view) {
        int i = R.id.web_games_loader_view;
        WebViewLoaderContainer webViewLoaderContainer = (WebViewLoaderContainer) view.findViewById(R.id.web_games_loader_view);
        if (webViewLoaderContainer != null) {
            i = R.id.web_games_view;
            CustomWebView customWebView = (CustomWebView) view.findViewById(R.id.web_games_view);
            if (customWebView != null) {
                return new ContainerWebviewGamesBinding((LinearLayout) view, webViewLoaderContainer, customWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ContainerWebviewGamesBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ContainerWebviewGamesBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.container_webview_games, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }
}
