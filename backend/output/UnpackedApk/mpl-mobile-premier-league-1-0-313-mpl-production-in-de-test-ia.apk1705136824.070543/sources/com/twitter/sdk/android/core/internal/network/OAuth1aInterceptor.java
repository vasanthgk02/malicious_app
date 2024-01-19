package com.twitter.sdk.android.core.internal.network;

import com.google.android.material.resources.TextAppearanceConfig;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OAuth1aInterceptor implements Interceptor {
    public final TwitterAuthConfig authConfig;
    public final Session<? extends TwitterAuthToken> session;

    public OAuth1aInterceptor(Session<? extends TwitterAuthToken> session2, TwitterAuthConfig twitterAuthConfig) {
        this.session = session2;
        this.authConfig = twitterAuthConfig;
    }

    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Builder newBuilder = request.newBuilder();
        HttpUrl url = request.url();
        HttpUrl.Builder query = url.newBuilder().query(null);
        int querySize = url.querySize();
        for (int i = 0; i < querySize; i++) {
            query.addEncodedQueryParameter(TextAppearanceConfig.percentEncode(url.queryParameterName(i)), TextAppearanceConfig.percentEncode(url.queryParameterValue(i)));
        }
        Request build = newBuilder.url(query.build()).build();
        Builder newBuilder2 = build.newBuilder();
        OAuth1aHeaders oAuth1aHeaders = new OAuth1aHeaders();
        TwitterAuthConfig twitterAuthConfig = this.authConfig;
        TwitterAuthToken twitterAuthToken = (TwitterAuthToken) this.session.authToken;
        String method = build.method();
        String httpUrl = build.url().toString();
        HashMap hashMap = new HashMap();
        if (RNCWebViewManager.HTTP_METHOD_POST.equals(build.method().toUpperCase(Locale.US))) {
            RequestBody body = build.body();
            if (body instanceof FormBody) {
                FormBody formBody = (FormBody) body;
                for (int i2 = 0; i2 < formBody.size(); i2++) {
                    hashMap.put(formBody.encodedName(i2), formBody.value(i2));
                }
            }
        }
        return chain.proceed(newBuilder2.header("Authorization", oAuth1aHeaders.getAuthorizationHeader(twitterAuthConfig, twitterAuthToken, null, method, httpUrl, hashMap)).build());
    }
}
