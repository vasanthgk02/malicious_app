package com.mpl.androidapp.webview.utils;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"com/mpl/androidapp/webview/utils/CustomWebViewCallback$initiate$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "facIcon", "Landroid/graphics/Bitmap;", "shouldOverrideUrlLoading", "", "urlNewString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomWebViewCallback.kt */
public final class CustomWebViewCallback$initiate$1 extends WebViewClient {
    public final /* synthetic */ CustomWebViewCallback this$0;

    public CustomWebViewCallback$initiate$1(CustomWebViewCallback customWebViewCallback) {
        this.this$0 = customWebViewCallback;
    }

    public void onPageFinished(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        if (!this.this$0.redirect) {
            this.this$0.loadingFinished = true;
        }
        if (!this.this$0.loadingFinished || this.this$0.redirect) {
            this.this$0.redirect = false;
            return;
        }
        WebViewCallback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.webViewLoading(false);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.this$0.loadingFinished = false;
        WebViewCallback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.webViewLoading(true);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "urlNewString");
        if (!this.this$0.loadingFinished) {
            this.this$0.redirect = true;
        }
        this.this$0.loadingFinished = false;
        webView.loadUrl(str);
        return true;
    }
}
