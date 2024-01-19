package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;

public class OAuthController implements com.twitter.sdk.android.core.identity.OAuthWebViewClient.Listener {
    public final TwitterAuthConfig authConfig;
    public final Listener listener;
    public final OAuth1aService oAuth1aService;
    public TwitterAuthToken requestToken;
    public final ProgressBar spinner;
    public final WebView webView;

    public interface Listener {
    }

    public OAuthController(ProgressBar progressBar, WebView webView2, TwitterAuthConfig twitterAuthConfig, OAuth1aService oAuth1aService2, Listener listener2) {
        this.spinner = progressBar;
        this.webView = webView2;
        this.authConfig = twitterAuthConfig;
        this.oAuth1aService = oAuth1aService2;
        this.listener = listener2;
    }

    public void handleAuthError(int i, TwitterAuthException twitterAuthException) {
        Intent intent = new Intent();
        intent.putExtra("auth_error", twitterAuthException);
        OAuthActivity oAuthActivity = (OAuthActivity) this.listener;
        oAuthActivity.setResult(i, intent);
        oAuthActivity.finish();
    }

    public void onError(WebViewException webViewException) {
        handleAuthError(1, new TwitterAuthException("OAuth web view completed with an error"));
        this.webView.stopLoading();
        this.spinner.setVisibility(8);
    }
}
