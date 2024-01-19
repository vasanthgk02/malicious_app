package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import java.util.concurrent.atomic.AtomicReference;

public class AuthState {
    public final AtomicReference<AuthHandler> authHandlerRef = new AtomicReference<>(null);

    public boolean beginAuthorize(Activity activity, AuthHandler authHandler) {
        if (!(this.authHandlerRef.get() != null) && authHandler.authorize(activity)) {
            return this.authHandlerRef.compareAndSet(null, authHandler);
        }
        return false;
    }
}
