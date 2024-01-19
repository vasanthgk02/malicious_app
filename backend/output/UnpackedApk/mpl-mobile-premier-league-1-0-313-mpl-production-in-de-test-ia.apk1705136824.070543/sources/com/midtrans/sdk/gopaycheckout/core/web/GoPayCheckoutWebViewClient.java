package com.midtrans.sdk.gopaycheckout.core.web;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/midtrans/sdk/gopaycheckout/core/web/GoPayCheckoutWebViewClient;", "Landroid/webkit/WebViewClient;", "action", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "shouldOverrideUrlLoading", "view", "Landroid/webkit/WebView;", "url", "gopay-checkout_release"}, k = 1, mv = {1, 1, 16})
public final class GoPayCheckoutWebViewClient extends WebViewClient {
    public final Function1<String, Boolean> action;

    public GoPayCheckoutWebViewClient(Function1<? super String, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(function1, "action");
        this.action = function1;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Function1<String, Boolean> function1 = this.action;
        if (str == null) {
            str = "";
        }
        return ((Boolean) function1.invoke(str)).booleanValue();
    }
}
