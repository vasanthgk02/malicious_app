package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.internal.oauth.GuestAuthToken;

public class GuestSession extends Session<GuestAuthToken> {
    public GuestSession(GuestAuthToken guestAuthToken) {
        super(guestAuthToken, 0);
    }
}
