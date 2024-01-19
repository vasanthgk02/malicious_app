package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityPokerWebViewBinding implements ViewBinding {
    public final CommonHeaderLayoutBinding headerLayout;
    public final WebView mplWebview;
    public final ConstraintLayout rootView;

    public ActivityPokerWebViewBinding(ConstraintLayout constraintLayout, CommonHeaderLayoutBinding commonHeaderLayoutBinding, WebView webView) {
        this.rootView = constraintLayout;
        this.headerLayout = commonHeaderLayoutBinding;
        this.mplWebview = webView;
    }

    public static ActivityPokerWebViewBinding bind(View view) {
        int i = R.id.header_layout;
        View findViewById = view.findViewById(R.id.header_layout);
        if (findViewById != null) {
            CommonHeaderLayoutBinding bind = CommonHeaderLayoutBinding.bind(findViewById);
            WebView webView = (WebView) view.findViewById(R.id.mpl_webview);
            if (webView != null) {
                return new ActivityPokerWebViewBinding((ConstraintLayout) view, bind, webView);
            }
            i = R.id.mpl_webview;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityPokerWebViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityPokerWebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_poker_web_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
