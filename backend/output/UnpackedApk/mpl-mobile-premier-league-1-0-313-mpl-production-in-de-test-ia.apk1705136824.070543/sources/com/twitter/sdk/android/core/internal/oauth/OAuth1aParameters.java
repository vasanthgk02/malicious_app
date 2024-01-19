package com.twitter.sdk.android.core.internal.oauth;

import com.google.android.material.resources.TextAppearanceConfig;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import java.security.SecureRandom;
import java.util.Map;

public class OAuth1aParameters {
    public static final SecureRandom RAND = new SecureRandom();
    public final TwitterAuthConfig authConfig;
    public final TwitterAuthToken authToken;
    public final String callback;
    public final String method;
    public final Map<String, String> postParams;
    public final String url;

    public OAuth1aParameters(TwitterAuthConfig twitterAuthConfig, TwitterAuthToken twitterAuthToken, String str, String str2, String str3, Map<String, String> map) {
        this.authConfig = twitterAuthConfig;
        this.authToken = twitterAuthToken;
        this.callback = str;
        this.method = str2;
        this.url = str3;
        this.postParams = map;
    }

    public final void appendParameter(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ');
            sb.append(TextAppearanceConfig.percentEncode(str));
            sb.append("=\"");
            sb.append(TextAppearanceConfig.percentEncode(str2));
            sb.append("\",");
        }
    }

    public final String getSigningKey() {
        TwitterAuthToken twitterAuthToken = this.authToken;
        String str = twitterAuthToken != null ? twitterAuthToken.secret : null;
        return TextAppearanceConfig.urlEncode(this.authConfig.consumerSecret) + '&' + TextAppearanceConfig.urlEncode(str);
    }
}
