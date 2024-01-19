package com.mpl.androidapp.webview.view.customviews;

import android.webkit.JavascriptInterface;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer.Callback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J0\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0014"}, d2 = {"com/mpl/androidapp/webview/view/customviews/WebViewGamesContainer$gameCallBacks$1", "", "closeWeb", "", "closeWebViewWithReason", "failReason", "", "failUrl", "initiateShare", "gameName", "screenName", "shareMessage", "platform", "openDeepLink", "actionParams", "performAction", "action", "sendEvent", "eventName", "eventProps", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WebViewGamesContainer.kt */
public final class WebViewGamesContainer$gameCallBacks$1 {
    public final /* synthetic */ WebViewGamesContainer this$0;

    public WebViewGamesContainer$gameCallBacks$1(WebViewGamesContainer webViewGamesContainer) {
        this.this$0 = webViewGamesContainer;
    }

    @JavascriptInterface
    public final void closeWeb() {
        Callback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.closeWeb();
        }
    }

    @JavascriptInterface
    public final void closeWebViewWithReason(String str, String str2) {
        Callback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.closeWebViewWithReason(str, str2);
        }
    }

    @JavascriptInterface
    public final void initiateShare(String str, String str2, String str3, String str4) {
        if (str != null && str2 != null && str3 != null) {
            Callback access$getCallback$p = this.this$0.callback;
            if (access$getCallback$p != null) {
                access$getCallback$p.initiateShare(str, str2, str3, str4);
            }
        }
    }

    @JavascriptInterface
    public final void openDeepLink(String str) {
        Callback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.openDeepLink(str);
        }
    }

    @JavascriptInterface
    public final void performAction(String str) {
        Callback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.performAction(str);
        }
    }

    @JavascriptInterface
    public final void sendEvent(String str, String str2) {
        Callback access$getCallback$p = this.this$0.callback;
        if (access$getCallback$p != null) {
            access$getCallback$p.sendEvent(str, str2);
        }
    }
}
