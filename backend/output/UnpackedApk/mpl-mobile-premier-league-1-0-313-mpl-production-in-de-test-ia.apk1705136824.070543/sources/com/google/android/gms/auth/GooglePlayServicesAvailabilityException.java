package com.google.android.gms.auth;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class GooglePlayServicesAvailabilityException extends UserRecoverableAuthException {
    public GooglePlayServicesAvailabilityException(int i, String str, Intent intent) {
        super(str, intent);
    }
}
