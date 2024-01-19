package com.razorpay;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class RazorpayWebChromeClient extends WebChromeClient {
    public BaseRazorpay Q_$2$;

    public RazorpayWebChromeClient(BaseRazorpay baseRazorpay) {
        this.Q_$2$ = baseRazorpay;
    }

    public void onProgressChanged(WebView webView, int i) {
        this.Q_$2$.d__1_(webView, i);
    }
}
