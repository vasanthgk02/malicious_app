package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.GuestSessionProvider;
import com.twitter.sdk.android.core.PersistedSessionManager;
import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.apache.fontbox.cmap.CMap;

public class GuestAuthInterceptor implements Interceptor {
    public final GuestSessionProvider guestSessionProvider;

    public GuestAuthInterceptor(GuestSessionProvider guestSessionProvider2) {
        this.guestSessionProvider = guestSessionProvider2;
    }

    public static void addAuthHeaders(Builder builder, GuestAuthToken guestAuthToken) {
        builder.header("Authorization", guestAuthToken.tokenType + CMap.SPACE + guestAuthToken.accessToken);
        builder.header("x-guest-token", guestAuthToken.guestToken);
    }

    public Response intercept(Chain chain) throws IOException {
        GuestSession guestSession;
        GuestAuthToken guestAuthToken;
        Request request = chain.request();
        GuestSessionProvider guestSessionProvider2 = this.guestSessionProvider;
        synchronized (guestSessionProvider2) {
            guestSession = (GuestSession) ((PersistedSessionManager) guestSessionProvider2.sessionManager).getActiveSession();
            boolean z = false;
            if (guestSession != null) {
                T t = guestSession.authToken;
                if (t != null) {
                    if (!(System.currentTimeMillis() >= ((GuestAuthToken) t).createdAt + 10800000)) {
                        z = true;
                    }
                }
            }
            if (!z) {
                guestSessionProvider2.refreshToken();
                guestSession = (GuestSession) ((PersistedSessionManager) guestSessionProvider2.sessionManager).getActiveSession();
            }
        }
        if (guestSession == null) {
            guestAuthToken = null;
        } else {
            guestAuthToken = (GuestAuthToken) guestSession.authToken;
        }
        if (guestAuthToken == null) {
            return chain.proceed(request);
        }
        Builder newBuilder = request.newBuilder();
        addAuthHeaders(newBuilder, guestAuthToken);
        return chain.proceed(newBuilder.build());
    }
}
