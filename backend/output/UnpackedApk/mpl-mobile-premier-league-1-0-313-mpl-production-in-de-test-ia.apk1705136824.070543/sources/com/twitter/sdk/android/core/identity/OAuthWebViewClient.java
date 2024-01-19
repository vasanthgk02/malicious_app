package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.internal.oauth.OAuthResponse;
import java.net.URI;
import java.util.Map.Entry;
import java.util.TreeMap;
import okhttp3.ResponseBody;
import sfs2x.client.requests.HandshakeRequest;

public class OAuthWebViewClient extends WebViewClient {
    public final String completeUrl;
    public final Listener listener;

    public interface Listener {
    }

    public OAuthWebViewClient(String str, Listener listener2) {
        this.completeUrl = str;
        this.listener = listener2;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        ((OAuthController) this.listener).spinner.setVisibility(8);
        webView.setVisibility(0);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        ((OAuthController) this.listener).onError(new WebViewException(i, str, str2));
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        ((OAuthController) this.listener).onError(new WebViewException(sslError.getPrimaryError(), null, null));
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith(this.completeUrl)) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        TreeMap<String, String> queryParams = TextAppearanceConfig.getQueryParams(URI.create(str).getRawQuery(), false);
        Bundle bundle = new Bundle(queryParams.size());
        for (Entry next : queryParams.entrySet()) {
            bundle.putString((String) next.getKey(), (String) next.getValue());
        }
        OAuthController oAuthController = (OAuthController) this.listener;
        if (oAuthController != null) {
            String string = bundle.getString("oauth_verifier");
            if (string != null) {
                OAuth1aService oAuth1aService = oAuthController.oAuth1aService;
                oAuth1aService.api.getAccessToken(new OAuth1aHeaders().getAuthorizationHeader(oAuth1aService.twitterCore.authConfig, oAuthController.requestToken, null, RNCWebViewManager.HTTP_METHOD_POST, GeneratedOutlineSupport.outline62(new StringBuilder(), oAuth1aService.api.baseHostUrl, "/oauth/access_token"), null), string).enqueue(new Callback<ResponseBody>(oAuth1aService, new Callback<OAuthResponse>() {
                    public void failure(TwitterException twitterException) {
                        OAuthController.this.handleAuthError(1, new TwitterAuthException("Failed to get access token"));
                    }

                    public void success(Result<OAuthResponse> result) {
                        Intent intent = new Intent();
                        OAuthResponse oAuthResponse = (OAuthResponse) result.data;
                        intent.putExtra("screen_name", oAuthResponse.userName);
                        intent.putExtra("user_id", oAuthResponse.userId);
                        intent.putExtra(HandshakeRequest.KEY_SESSION_TOKEN, oAuthResponse.authToken.token);
                        intent.putExtra("ts", oAuthResponse.authToken.secret);
                        OAuthActivity oAuthActivity = (OAuthActivity) OAuthController.this.listener;
                        oAuthActivity.setResult(-1, intent);
                        oAuthActivity.finish();
                    }
                }) {
                    public final /* synthetic */ Callback val$callback;

                    {
                        this.val$callback = r2;
                    }

                    public void failure(TwitterException twitterException) {
                        this.val$callback.failure(twitterException);
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c A[Catch:{ IOException -> 0x0060 }] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void success(com.twitter.sdk.android.core.Result<okhttp3.ResponseBody> r5) {
                        /*
                            r4 = this;
                            java.lang.StringBuilder r0 = new java.lang.StringBuilder
                            r0.<init>()
                            r1 = 0
                            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0059 }
                            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ all -> 0x0059 }
                            T r5 = r5.data     // Catch:{ all -> 0x0059 }
                            okhttp3.ResponseBody r5 = (okhttp3.ResponseBody) r5     // Catch:{ all -> 0x0059 }
                            java.io.InputStream r5 = r5.byteStream()     // Catch:{ all -> 0x0059 }
                            r3.<init>(r5)     // Catch:{ all -> 0x0059 }
                            r2.<init>(r3)     // Catch:{ all -> 0x0059 }
                        L_0x0018:
                            java.lang.String r5 = r2.readLine()     // Catch:{ all -> 0x0056 }
                            if (r5 == 0) goto L_0x0022
                            r0.append(r5)     // Catch:{ all -> 0x0056 }
                            goto L_0x0018
                        L_0x0022:
                            r2.close()     // Catch:{ IOException -> 0x0060 }
                            java.lang.String r5 = r0.toString()     // Catch:{ IOException -> 0x0060 }
                            com.twitter.sdk.android.core.internal.oauth.OAuthResponse r0 = com.twitter.sdk.android.core.internal.oauth.OAuth1aService.parseAuthResponse(r5)     // Catch:{ IOException -> 0x0060 }
                            if (r0 != 0) goto L_0x004b
                            com.twitter.sdk.android.core.Callback r0 = r4.val$callback     // Catch:{ IOException -> 0x0060 }
                            com.twitter.sdk.android.core.TwitterAuthException r1 = new com.twitter.sdk.android.core.TwitterAuthException     // Catch:{ IOException -> 0x0060 }
                            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0060 }
                            r2.<init>()     // Catch:{ IOException -> 0x0060 }
                            java.lang.String r3 = "Failed to parse auth response: "
                            r2.append(r3)     // Catch:{ IOException -> 0x0060 }
                            r2.append(r5)     // Catch:{ IOException -> 0x0060 }
                            java.lang.String r5 = r2.toString()     // Catch:{ IOException -> 0x0060 }
                            r1.<init>(r5)     // Catch:{ IOException -> 0x0060 }
                            r0.failure(r1)     // Catch:{ IOException -> 0x0060 }
                            goto L_0x006f
                        L_0x004b:
                            com.twitter.sdk.android.core.Callback r5 = r4.val$callback     // Catch:{ IOException -> 0x0060 }
                            com.twitter.sdk.android.core.Result r2 = new com.twitter.sdk.android.core.Result     // Catch:{ IOException -> 0x0060 }
                            r2.<init>(r0, r1)     // Catch:{ IOException -> 0x0060 }
                            r5.success(r2)     // Catch:{ IOException -> 0x0060 }
                            goto L_0x006f
                        L_0x0056:
                            r5 = move-exception
                            r1 = r2
                            goto L_0x005a
                        L_0x0059:
                            r5 = move-exception
                        L_0x005a:
                            if (r1 == 0) goto L_0x005f
                            r1.close()     // Catch:{ IOException -> 0x0060 }
                        L_0x005f:
                            throw r5     // Catch:{ IOException -> 0x0060 }
                        L_0x0060:
                            r5 = move-exception
                            com.twitter.sdk.android.core.Callback r0 = r4.val$callback
                            com.twitter.sdk.android.core.TwitterAuthException r1 = new com.twitter.sdk.android.core.TwitterAuthException
                            java.lang.String r2 = r5.getMessage()
                            r1.<init>(r2, r5)
                            r0.failure(r1)
                        L_0x006f:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.oauth.OAuth1aService.AnonymousClass1.success(com.twitter.sdk.android.core.Result):void");
                    }
                });
            } else {
                "Failed to get authorization, bundle incomplete " + bundle;
                oAuthController.handleAuthError(1, new TwitterAuthException("Failed to get authorization, bundle incomplete"));
            }
            oAuthController.webView.stopLoading();
            oAuthController.spinner.setVisibility(8);
            return true;
        }
        throw null;
    }
}
