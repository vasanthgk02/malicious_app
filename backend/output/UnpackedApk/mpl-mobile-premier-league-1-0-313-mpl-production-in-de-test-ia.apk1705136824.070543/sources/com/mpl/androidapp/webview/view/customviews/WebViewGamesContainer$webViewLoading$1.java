package com.mpl.androidapp.webview.view.customviews;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mpl.androidapp.R;
import com.mpl.androidapp.utils.MLogger;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000K\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u001a\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J.\u0010\u001a\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010#\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0016H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006%"}, d2 = {"com/mpl/androidapp/webview/view/customviews/WebViewGamesContainer$webViewLoading$1", "Landroid/webkit/WebViewClient;", "finalPointForWebLoad", "", "getFinalPointForWebLoad", "()J", "setFinalPointForWebLoad", "(J)V", "initialPointForWebLoad", "getInitialPointForWebLoad", "setInitialPointForWebLoad", "sendLoadingTimeToServer", "", "getSendLoadingTimeToServer", "()Z", "setSendLoadingTimeToServer", "(Z)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "facIcon", "Landroid/graphics/Bitmap;", "onReceivedError", "req", "Landroid/webkit/WebResourceRequest;", "rerr", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "shouldOverrideUrlLoading", "urlNewString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGamesContainer.kt */
public final class WebViewGamesContainer$webViewLoading$1 extends WebViewClient {
    public long finalPointForWebLoad;
    public long initialPointForWebLoad;
    public boolean sendLoadingTimeToServer;
    public final /* synthetic */ WebViewGamesContainer this$0;

    public WebViewGamesContainer$webViewLoading$1(WebViewGamesContainer webViewGamesContainer) {
        this.this$0 = webViewGamesContainer;
    }

    public final long getFinalPointForWebLoad() {
        return this.finalPointForWebLoad;
    }

    public final long getInitialPointForWebLoad() {
        return this.initialPointForWebLoad;
    }

    public final boolean getSendLoadingTimeToServer() {
        return this.sendLoadingTimeToServer;
    }

    public void onPageFinished(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        if (!this.this$0.redirect) {
            this.this$0.loadingFinished = true;
        }
        if (!this.this$0.loadingFinished || this.this$0.redirect) {
            this.this$0.redirect = false;
        } else if (this.sendLoadingTimeToServer) {
            this.sendLoadingTimeToServer = false;
            long currentTimeMillis = System.currentTimeMillis();
            this.finalPointForWebLoad = currentTimeMillis;
            long j = currentTimeMillis - this.initialPointForWebLoad;
            Callback access$getCallback$p = this.this$0.callback;
            if (access$getCallback$p != null) {
                access$getCallback$p.isWebViewLoading(false);
            }
            Callback access$getCallback$p2 = this.this$0.callback;
            if (access$getCallback$p2 != null) {
                access$getCallback$p2.ctEventForWebViewLoading(j);
            }
            MLogger.d("WebViewGames", Intrinsics.stringPlus("Time taken to load web-view :-> ", Long.valueOf(j)));
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.sendLoadingTimeToServer = true;
        this.initialPointForWebLoad = System.currentTimeMillis();
        this.this$0.loadingFinished = false;
        Callback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.isWebViewLoading(true);
        }
        String string = this.this$0.getContext().getResources().getString(R.string.loading);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getString(R.string.loading)");
        this.this$0.binding.webGamesLoaderView.setLoadingMessageText(string);
    }

    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        Intrinsics.checkNotNullParameter(webResourceRequest, "req");
        Intrinsics.checkNotNullParameter(webResourceError, "rerr");
        onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    public final void setFinalPointForWebLoad(long j) {
        this.finalPointForWebLoad = j;
    }

    public final void setInitialPointForWebLoad(long j) {
        this.initialPointForWebLoad = j;
    }

    public final void setSendLoadingTimeToServer(boolean z) {
        this.sendLoadingTimeToServer = z;
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

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.this$0.publishCtEventForErrorTracking(i, webView, str, str2);
    }
}
