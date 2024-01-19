package com.freshchat.consumer.sdk.activity;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.mpl.androidapp.webview.view.customviews.WebViewGamesContainer;
import java.io.InputStream;
import java.net.URLConnection;

public class v extends WebViewClient {
    public final /* synthetic */ ArticleDetailActivity F;

    public v(ArticleDetailActivity articleDetailActivity) {
        this.F = articleDetailActivity;
    }

    private String t() {
        return GeneratedOutlineSupport.outline42("javascript:(function(){ document.body.style.paddingBottom = '", (int) this.F.getResources().getDimension(R.dimen.freshchat_faq_content_padding_bottom), "px'})();");
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        i.a(this.F.getContext(), this.F.j, this.F.i);
        this.F.k.postDelayed(new w(this), 500);
        webView.loadUrl(t());
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        int indexOf = str.indexOf("freshchat_assets");
        if (indexOf > 0) {
            InputStream resourceAsStream = v.class.getResourceAsStream(str.substring(indexOf - 1, str.length()));
            String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
            if (resourceAsStream != null) {
                return new WebResourceResponse(guessContentTypeFromName, WebViewGamesContainer.ENCODING_NAME, resourceAsStream);
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r4, java.lang.String r5) {
        /*
            r3 = this;
            r4 = 0
            boolean r0 = com.freshchat.consumer.sdk.j.as.a(r5)     // Catch:{ Exception -> 0x000c }
            if (r0 == 0) goto L_0x0010
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x000c }
            goto L_0x0011
        L_0x000c:
            r5 = move-exception
            com.freshchat.consumer.sdk.j.q.a(r5)
        L_0x0010:
            r5 = r4
        L_0x0011:
            r0 = 0
            if (r5 != 0) goto L_0x001c
            com.freshchat.consumer.sdk.activity.ArticleDetailActivity r4 = r3.F
            com.freshchat.consumer.sdk.b.c r5 = com.freshchat.consumer.sdk.b.c.LINKED_CONTENT_NOT_FOUND
            com.freshchat.consumer.sdk.b.i.a(r4, r5)
            return r0
        L_0x001c:
            boolean r1 = com.freshchat.consumer.sdk.util.DeepLinkUtils.c(r5)
            r2 = 1
            if (r1 != 0) goto L_0x004a
            boolean r1 = com.freshchat.consumer.sdk.util.DeepLinkUtils.d(r5)
            if (r1 == 0) goto L_0x002a
            goto L_0x004a
        L_0x002a:
            java.lang.String r4 = r5.toString()
            boolean r4 = com.freshchat.consumer.sdk.util.DeepLinkUtils.b(r4)
            if (r4 == 0) goto L_0x0035
            return r0
        L_0x0035:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r0 = "LAUNCHED_FROM_FAQ"
            r4.putBoolean(r0, r2)
            com.freshchat.consumer.sdk.activity.ArticleDetailActivity r0 = r3.F
            android.content.Context r0 = r0.getContext()
            boolean r4 = com.freshchat.consumer.sdk.util.DeepLinkUtils.c(r0, r5, r4)
            return r4
        L_0x004a:
            com.freshchat.consumer.sdk.activity.ArticleDetailActivity r0 = r3.F
            android.content.Context r0 = r0.getContext()
            com.freshchat.consumer.sdk.util.DeepLinkUtils.b(r0, r5, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.activity.v.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }
}