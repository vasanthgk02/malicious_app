package com.crimzoncode.tqcontests.util;

import android.webkit.WebView;
import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
/* compiled from: CustomJavascriptInterface.kt */
public final class CustomJavascriptInterface$loadUrl$1 implements Runnable {
    public final /* synthetic */ boolean $checkPageLoaded;
    public final /* synthetic */ String $jsMethod;
    public final /* synthetic */ String $json;
    public final /* synthetic */ CustomJavascriptInterface this$0;

    public CustomJavascriptInterface$loadUrl$1(CustomJavascriptInterface customJavascriptInterface, boolean z, String str, String str2) {
        this.this$0 = customJavascriptInterface;
        this.$checkPageLoaded = z;
        this.$jsMethod = str;
        this.$json = str2;
    }

    public final void run() {
        if (!this.$checkPageLoaded || this.this$0.isPageLoaded) {
            WebView questionWebView = this.this$0.getQuestionWebView();
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("javascript:");
            outline73.append(this.$jsMethod);
            outline73.append('(');
            outline73.append(this.$json);
            outline73.append(')');
            questionWebView.loadUrl(outline73.toString());
        }
    }
}
