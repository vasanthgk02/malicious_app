package com.twitter.sdk.android.core.internal.oauth;

import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.material.resources.TextAppearanceConfig;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import java.util.TreeMap;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public class OAuth1aService extends OAuthService {
    public OAuthApi api = ((OAuthApi) this.retrofit.create(OAuthApi.class));

    public interface OAuthApi {
        @POST("/oauth/access_token")
        Call<ResponseBody> getAccessToken(@Header("Authorization") String str, @Query("oauth_verifier") String str2);

        @POST("/oauth/request_token")
        Call<ResponseBody> getTempToken(@Header("Authorization") String str);
    }

    public OAuth1aService(TwitterCore twitterCore, TwitterApi twitterApi) {
        super(twitterCore, twitterApi);
    }

    public static OAuthResponse parseAuthResponse(String str) {
        TreeMap<String, String> queryParams = TextAppearanceConfig.getQueryParams(str, false);
        String str2 = queryParams.get("oauth_token");
        String str3 = queryParams.get("oauth_token_secret");
        String str4 = queryParams.get("screen_name");
        long parseLong = queryParams.containsKey("user_id") ? Long.parseLong(queryParams.get("user_id")) : 0;
        if (str2 == null || str3 == null) {
            return null;
        }
        return new OAuthResponse(new TwitterAuthToken(str2, str3), str4, parseLong);
    }

    public String buildCallbackUrl(TwitterAuthConfig twitterAuthConfig) {
        Builder buildUpon = Uri.parse("twittersdk://callback").buildUpon();
        if (this.twitterCore != null) {
            return buildUpon.appendQueryParameter("version", "3.3.0.12").appendQueryParameter("app", twitterAuthConfig.consumerKey).build().toString();
        }
        throw null;
    }
}
