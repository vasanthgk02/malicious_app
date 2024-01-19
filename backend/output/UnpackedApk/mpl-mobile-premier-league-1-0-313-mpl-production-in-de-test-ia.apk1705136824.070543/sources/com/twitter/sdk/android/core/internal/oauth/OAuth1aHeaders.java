package com.twitter.sdk.android.core.internal.oauth;

import com.google.android.material.resources.TextAppearanceConfig;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

public class OAuth1aHeaders {
    public String getAuthorizationHeader(TwitterAuthConfig twitterAuthConfig, TwitterAuthToken twitterAuthToken, String str, String str2, String str3, Map<String, String> map) {
        String str4;
        OAuth1aParameters oAuth1aParameters = new OAuth1aParameters(twitterAuthConfig, twitterAuthToken, str, str2, str3, map);
        String str5 = String.valueOf(System.nanoTime()) + String.valueOf(Math.abs(OAuth1aParameters.RAND.nextLong()));
        String l = Long.toString(System.currentTimeMillis() / 1000);
        TreeMap<String, String> queryParams = TextAppearanceConfig.getQueryParams(URI.create(oAuth1aParameters.url).getRawQuery(), true);
        Map<String, String> map2 = oAuth1aParameters.postParams;
        if (map2 != null) {
            queryParams.putAll(map2);
        }
        String str6 = oAuth1aParameters.callback;
        if (str6 != null) {
            queryParams.put("oauth_callback", str6);
        }
        queryParams.put("oauth_consumer_key", oAuth1aParameters.authConfig.consumerKey);
        queryParams.put("oauth_nonce", str5);
        queryParams.put("oauth_signature_method", "HMAC-SHA1");
        queryParams.put("oauth_timestamp", l);
        TwitterAuthToken twitterAuthToken2 = oAuth1aParameters.authToken;
        if (twitterAuthToken2 != null) {
            String str7 = twitterAuthToken2.token;
            if (str7 != null) {
                queryParams.put("oauth_token", str7);
            }
        }
        queryParams.put("oauth_version", "1.0");
        StringBuilder sb = new StringBuilder();
        String str8 = "oauth_version";
        sb.append(oAuth1aParameters.method.toUpperCase(Locale.ENGLISH));
        sb.append('&');
        sb.append(TextAppearanceConfig.percentEncode(r2.getScheme() + "://" + r2.getHost() + r2.getPath()));
        sb.append('&');
        StringBuilder sb2 = new StringBuilder();
        int size = queryParams.size();
        Iterator<Entry<String, String>> it = queryParams.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Entry next = it.next();
            sb2.append(TextAppearanceConfig.percentEncode(TextAppearanceConfig.percentEncode((String) next.getKey())));
            sb2.append("%3D");
            sb2.append(TextAppearanceConfig.percentEncode(TextAppearanceConfig.percentEncode((String) next.getValue())));
            Iterator<Entry<String, String>> it2 = it;
            int i2 = i + 1;
            if (i2 < size) {
                sb2.append("%26");
            }
            i = i2;
            it = it2;
        }
        sb.append(sb2.toString());
        String sb3 = sb.toString();
        try {
            String signingKey = oAuth1aParameters.getSigningKey();
            byte[] bytes = sb3.getBytes("UTF8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(signingKey.getBytes("UTF8"), "HmacSHA1");
            Mac instance = Mac.getInstance("HmacSHA1");
            instance.init(secretKeySpec);
            byte[] doFinal = instance.doFinal(bytes);
            str4 = ByteString.of(doFinal, 0, doFinal.length).base64();
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException unused) {
            str4 = "";
        }
        StringBuilder sb4 = new StringBuilder("OAuth");
        oAuth1aParameters.appendParameter(sb4, "oauth_callback", oAuth1aParameters.callback);
        oAuth1aParameters.appendParameter(sb4, "oauth_consumer_key", oAuth1aParameters.authConfig.consumerKey);
        oAuth1aParameters.appendParameter(sb4, "oauth_nonce", str5);
        oAuth1aParameters.appendParameter(sb4, "oauth_signature", str4);
        oAuth1aParameters.appendParameter(sb4, "oauth_signature_method", "HMAC-SHA1");
        oAuth1aParameters.appendParameter(sb4, "oauth_timestamp", l);
        TwitterAuthToken twitterAuthToken3 = oAuth1aParameters.authToken;
        oAuth1aParameters.appendParameter(sb4, "oauth_token", twitterAuthToken3 != null ? twitterAuthToken3.token : null);
        oAuth1aParameters.appendParameter(sb4, str8, "1.0");
        return sb4.substring(0, sb4.length() - 1);
    }
}
