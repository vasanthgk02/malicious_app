package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.R$id;
import com.twitter.sdk.android.core.R$layout;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.identity.OAuthController.AnonymousClass1;
import com.twitter.sdk.android.core.identity.OAuthController.Listener;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.internal.oauth.OAuthResponse;
import okhttp3.ResponseBody;

public class OAuthActivity extends Activity implements Listener {
    public OAuthController oAuthController;
    public ProgressBar spinner;
    public WebView webView;

    public void onBackPressed() {
        this.oAuthController.handleAuthError(0, new TwitterAuthException("Authorization failed, request was canceled."));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.tw__activity_oauth);
        this.spinner = (ProgressBar) findViewById(R$id.tw__spinner);
        this.webView = (WebView) findViewById(R$id.tw__web_view);
        int i = 0;
        boolean z = bundle != null ? bundle.getBoolean("progress", false) : true;
        ProgressBar progressBar = this.spinner;
        if (!z) {
            i = 8;
        }
        progressBar.setVisibility(i);
        OAuthController oAuthController2 = new OAuthController(this.spinner, this.webView, (TwitterAuthConfig) getIntent().getParcelableExtra("auth_config"), new OAuth1aService(TwitterCore.getInstance(), new TwitterApi()), this);
        this.oAuthController = oAuthController2;
        OAuth1aService oAuth1aService = oAuthController2.oAuth1aService;
        AnonymousClass1 r0 = new Callback<OAuthResponse>() {
            public void failure(TwitterException twitterException) {
                OAuthController.this.handleAuthError(1, new TwitterAuthException("Failed to get request token"));
            }

            public void success(Result<OAuthResponse> result) {
                OAuthController oAuthController = OAuthController.this;
                TwitterAuthToken twitterAuthToken = ((OAuthResponse) result.data).authToken;
                oAuthController.requestToken = twitterAuthToken;
                String[] strArr = {"oauth", "authorize"};
                Builder buildUpon = Uri.parse(oAuthController.oAuth1aService.api.baseHostUrl).buildUpon();
                for (int i = 0; i < 2; i++) {
                    buildUpon.appendPath(strArr[i]);
                }
                String uri = buildUpon.appendQueryParameter("oauth_token", twitterAuthToken.token).build().toString();
                WebView webView = OAuthController.this.webView;
                OAuthController oAuthController2 = OAuthController.this;
                OAuthWebViewClient oAuthWebViewClient = new OAuthWebViewClient(oAuthController2.oAuth1aService.buildCallbackUrl(oAuthController2.authConfig), OAuthController.this);
                OAuthWebChromeClient oAuthWebChromeClient = new OAuthWebChromeClient();
                WebSettings settings = webView.getSettings();
                settings.setAllowFileAccess(false);
                settings.setJavaScriptEnabled(false);
                settings.setSaveFormData(false);
                webView.setVerticalScrollBarEnabled(false);
                webView.setHorizontalScrollBarEnabled(false);
                webView.setWebViewClient(oAuthWebViewClient);
                webView.loadUrl(uri);
                webView.setVisibility(4);
                webView.setWebChromeClient(oAuthWebChromeClient);
            }
        };
        TwitterAuthConfig twitterAuthConfig = oAuth1aService.twitterCore.authConfig;
        oAuth1aService.api.getTempToken(new OAuth1aHeaders().getAuthorizationHeader(twitterAuthConfig, null, oAuth1aService.buildCallbackUrl(twitterAuthConfig), RNCWebViewManager.HTTP_METHOD_POST, GeneratedOutlineSupport.outline62(new StringBuilder(), oAuth1aService.api.baseHostUrl, "/oauth/request_token"), null)).enqueue(new Callback<ResponseBody>(oAuth1aService, r0) {
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
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.spinner.getVisibility() == 0) {
            bundle.putBoolean("progress", true);
        }
        super.onSaveInstanceState(bundle);
    }
}
