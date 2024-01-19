package com.twitter.sdk.android.core;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.material.resources.TextAppearanceConfig;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service.OAuth2Api;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Token;
import java.util.concurrent.CountDownLatch;
import okio.ByteString;

public class GuestSessionProvider {
    public final OAuth2Service oAuth2Service;
    public final SessionManager<GuestSession> sessionManager;

    public GuestSessionProvider(OAuth2Service oAuth2Service2, SessionManager<GuestSession> sessionManager2) {
        this.oAuth2Service = oAuth2Service2;
        this.sessionManager = sessionManager2;
    }

    public void refreshToken() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        OAuth2Service oAuth2Service2 = this.oAuth2Service;
        com.twitter.sdk.android.core.internal.oauth.OAuth2Service.AnonymousClass1 r3 = new Callback<OAuth2Token>(new Callback<GuestAuthToken>() {
            public void failure(TwitterException twitterException) {
                ((PersistedSessionManager) GuestSessionProvider.this.sessionManager).clearSession(0);
                countDownLatch.countDown();
            }

            public void success(Result<GuestAuthToken> result) {
                SessionManager<GuestSession> sessionManager = GuestSessionProvider.this.sessionManager;
                GuestSession guestSession = new GuestSession((GuestAuthToken) result.data);
                PersistedSessionManager persistedSessionManager = (PersistedSessionManager) sessionManager;
                if (persistedSessionManager != null) {
                    persistedSessionManager.restoreAllSessionsIfNecessary();
                    persistedSessionManager.internalSetSession(guestSession.id, guestSession, true);
                    countDownLatch.countDown();
                    return;
                }
                throw null;
            }
        }) {
            public final /* synthetic */ Callback val$callback;

            {
                this.val$callback = r2;
            }

            public void failure(TwitterException twitterException) {
                Callback callback = this.val$callback;
                if (callback != null) {
                    callback.failure(twitterException);
                }
            }

            public void success(Result<OAuth2Token> result) {
                final OAuth2Token oAuth2Token = (OAuth2Token) result.data;
                AnonymousClass1 r0 = new Callback<GuestTokenResponse>() {
                    public void failure(TwitterException twitterException) {
                        AnonymousClass1.this.val$callback.failure(twitterException);
                    }

                    public void success(Result<GuestTokenResponse> result) {
                        OAuth2Token oAuth2Token = oAuth2Token;
                        AnonymousClass1.this.val$callback.success(new Result(new GuestAuthToken(oAuth2Token.tokenType, oAuth2Token.accessToken, ((GuestTokenResponse) result.data).guestToken), null));
                    }
                };
                OAuth2Api oAuth2Api = OAuth2Service.this.api;
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("Bearer ");
                outline73.append(oAuth2Token.accessToken);
                oAuth2Api.getGuestToken(outline73.toString()).enqueue(r0);
            }
        };
        OAuth2Api oAuth2Api = oAuth2Service2.api;
        TwitterAuthConfig twitterAuthConfig = oAuth2Service2.twitterCore.authConfig;
        ByteString encodeUtf8 = ByteString.encodeUtf8(TextAppearanceConfig.percentEncode(twitterAuthConfig.consumerKey) + ":" + TextAppearanceConfig.percentEncode(twitterAuthConfig.consumerSecret));
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Basic ");
        outline73.append(encodeUtf8.base64());
        oAuth2Api.getAppAuthToken(outline73.toString(), "client_credentials").enqueue(r3);
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            ((PersistedSessionManager) this.sessionManager).clearSession(0);
        }
    }
}
