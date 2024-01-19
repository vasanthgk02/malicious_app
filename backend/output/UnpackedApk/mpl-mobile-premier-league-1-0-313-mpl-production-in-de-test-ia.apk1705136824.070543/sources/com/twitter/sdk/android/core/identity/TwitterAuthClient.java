package com.twitter.sdk.android.core.identity;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.PersistedSessionManager;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;

public class TwitterAuthClient {
    public final TwitterAuthConfig authConfig;
    public final AuthState authState = AuthStateLazyHolder.INSTANCE;
    public final SessionManager<TwitterSession> sessionManager;

    public static class AuthStateLazyHolder {
        public static final AuthState INSTANCE = new AuthState();
    }

    public static class CallbackWrapper extends Callback<TwitterSession> {
        public final Callback<TwitterSession> callback;
        public final SessionManager<TwitterSession> sessionManager;

        public CallbackWrapper(SessionManager<TwitterSession> sessionManager2, Callback<TwitterSession> callback2) {
            this.sessionManager = sessionManager2;
            this.callback = callback2;
        }

        public void failure(TwitterException twitterException) {
            this.callback.failure(twitterException);
        }

        public void success(Result<TwitterSession> result) {
            SessionManager<TwitterSession> sessionManager2 = this.sessionManager;
            Session session = (Session) result.data;
            PersistedSessionManager persistedSessionManager = (PersistedSessionManager) sessionManager2;
            if (persistedSessionManager == null) {
                throw null;
            } else if (session != null) {
                persistedSessionManager.restoreAllSessionsIfNecessary();
                persistedSessionManager.internalSetSession(session.id, session, true);
                this.callback.success(result);
            } else {
                throw new IllegalArgumentException("Session must not be null!");
            }
        }
    }

    public TwitterAuthClient() {
        TwitterCore.getInstance();
        TwitterAuthConfig twitterAuthConfig = TwitterCore.getInstance().authConfig;
        SessionManager<TwitterSession> sessionManager2 = TwitterCore.getInstance().twitterSessionManager;
        this.authConfig = twitterAuthConfig;
        this.sessionManager = sessionManager2;
    }
}
