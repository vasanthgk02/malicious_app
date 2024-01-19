package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.PersistedSessionManager;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import java.io.IOException;
import okhttp3.Authenticator;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;

public class GuestAuthenticator implements Authenticator {
    public final GuestSessionProvider guestSessionProvider;

    public GuestAuthenticator(GuestSessionProvider guestSessionProvider2) {
        this.guestSessionProvider = guestSessionProvider2;
    }

    public Request authenticate(Route route, Response response) throws IOException {
        GuestSession guestSession;
        GuestAuthToken guestAuthToken;
        boolean z = true;
        Response response2 = response;
        int i = 1;
        while (true) {
            response2 = response2.priorResponse();
            if (response2 == null) {
                break;
            }
            i++;
        }
        if (i >= 2) {
            z = false;
        }
        if (!z) {
            return null;
        }
        GuestSessionProvider guestSessionProvider2 = this.guestSessionProvider;
        Headers headers = response.request().headers();
        String str = headers.get("Authorization");
        String str2 = headers.get("x-guest-token");
        Session guestSession2 = (str == null || str2 == null) ? null : new GuestSession(new GuestAuthToken("bearer", str.replace("bearer ", ""), str2));
        synchronized (guestSessionProvider2) {
            GuestSession guestSession3 = (GuestSession) ((PersistedSessionManager) guestSessionProvider2.sessionManager).getActiveSession();
            if (guestSession2 != null && guestSession2.equals(guestSession3)) {
                guestSessionProvider2.refreshToken();
            }
            guestSession = (GuestSession) ((PersistedSessionManager) guestSessionProvider2.sessionManager).getActiveSession();
        }
        if (guestSession == null) {
            guestAuthToken = null;
        } else {
            guestAuthToken = (GuestAuthToken) guestSession.authToken;
        }
        if (guestAuthToken == null) {
            return null;
        }
        Builder newBuilder = response.request().newBuilder();
        GuestAuthInterceptor.addAuthHeaders(newBuilder, guestAuthToken);
        return newBuilder.build();
    }
}
