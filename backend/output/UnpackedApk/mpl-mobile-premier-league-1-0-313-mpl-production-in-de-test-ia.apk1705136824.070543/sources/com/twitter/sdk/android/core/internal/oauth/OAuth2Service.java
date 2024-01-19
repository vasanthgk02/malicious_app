package com.twitter.sdk.android.core.internal.oauth;

import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class OAuth2Service extends OAuthService {
    public OAuth2Api api = ((OAuth2Api) this.retrofit.create(OAuth2Api.class));

    public interface OAuth2Api {
        @FormUrlEncoded
        @POST("/oauth2/token")
        @Headers({"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        Call<OAuth2Token> getAppAuthToken(@Header("Authorization") String str, @Field("grant_type") String str2);

        @POST("/1.1/guest/activate.json")
        Call<GuestTokenResponse> getGuestToken(@Header("Authorization") String str);
    }

    public OAuth2Service(TwitterCore twitterCore, TwitterApi twitterApi) {
        super(twitterCore, twitterApi);
    }
}
