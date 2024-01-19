package com.razorpay;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RazorpayWebViewClient extends WebViewClient {
    public BaseRazorpay R$$r_;

    public RazorpayWebViewClient(BaseRazorpay baseRazorpay) {
        this.R$$r_ = baseRazorpay;
    }

    public void onPageFinished(WebView webView, String str) {
        this.R$$r_.d__1_(webView, str);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.R$$r_.Q_$2$(webView, str);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.R$$r_.R$$r_(2, str);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }
}
