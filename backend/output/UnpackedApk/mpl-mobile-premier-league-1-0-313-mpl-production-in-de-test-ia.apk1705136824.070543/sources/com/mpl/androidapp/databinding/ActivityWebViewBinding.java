package com.mpl.androidapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.mpl.androidapp.R;

public final class ActivityWebViewBinding implements ViewBinding {
    public final FrameLayout errorWebview;
    public final TextView gameName;
    public final RelativeLayout headerLayout;
    public final ProgressBar loadingProgress;
    public final ImageView mplLogo;
    public final WebView mplWebview;
    public final FrameLayout mplWebviewContainer;
    public final ConstraintLayout rootView;
    public final LinearLayout webviewBack;
    public final Button webviewOk;

    public ActivityWebViewBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, TextView textView, RelativeLayout relativeLayout, ProgressBar progressBar, ImageView imageView, WebView webView, FrameLayout frameLayout2, LinearLayout linearLayout, Button button) {
        this.rootView = constraintLayout;
        this.errorWebview = frameLayout;
        this.gameName = textView;
        this.headerLayout = relativeLayout;
        this.loadingProgress = progressBar;
        this.mplLogo = imageView;
        this.mplWebview = webView;
        this.mplWebviewContainer = frameLayout2;
        this.webviewBack = linearLayout;
        this.webviewOk = button;
    }

    public static ActivityWebViewBinding bind(View view) {
        int i = R.id.error_webview;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.error_webview);
        if (frameLayout != null) {
            i = R.id.game_name;
            TextView textView = (TextView) view.findViewById(R.id.game_name);
            if (textView != null) {
                i = R.id.header_layout;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.header_layout);
                if (relativeLayout != null) {
                    i = R.id.loading_progress;
                    ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading_progress);
                    if (progressBar != null) {
                        i = R.id.mpl_logo;
                        ImageView imageView = (ImageView) view.findViewById(R.id.mpl_logo);
                        if (imageView != null) {
                            i = R.id.mpl_webview;
                            WebView webView = (WebView) view.findViewById(R.id.mpl_webview);
                            if (webView != null) {
                                i = R.id.mpl_webview_container;
                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.mpl_webview_container);
                                if (frameLayout2 != null) {
                                    i = R.id.webview_back;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.webview_back);
                                    if (linearLayout != null) {
                                        i = R.id.webview_ok;
                                        Button button = (Button) view.findViewById(R.id.webview_ok);
                                        if (button != null) {
                                            ActivityWebViewBinding activityWebViewBinding = new ActivityWebViewBinding((ConstraintLayout) view, frameLayout, textView, relativeLayout, progressBar, imageView, webView, frameLayout2, linearLayout, button);
                                            return activityWebViewBinding;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static ActivityWebViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_web_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
