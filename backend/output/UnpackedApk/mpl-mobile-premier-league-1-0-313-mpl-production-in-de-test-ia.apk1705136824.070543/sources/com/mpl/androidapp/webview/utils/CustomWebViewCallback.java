package com.mpl.androidapp.webview.utils;

import android.webkit.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/mpl/androidapp/webview/utils/CustomWebViewCallback;", "", "()V", "callback", "Lcom/mpl/androidapp/webview/utils/WebViewCallback;", "loadingFinished", "", "redirect", "initiate", "", "webView", "Landroid/webkit/WebView;", "setCallback", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomWebViewCallback.kt */
public final class CustomWebViewCallback {
    public WebViewCallback callback;
    public boolean loadingFinished = true;
    public boolean redirect;

    public final void initiate(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        webView.setWebViewClient(new CustomWebViewCallback$initiate$1(this));
    }

    public final void setCallback(WebViewCallback webViewCallback) {
        Intrinsics.checkNotNullParameter(webViewCallback, "callback");
        this.callback = webViewCallback;
    }
}
