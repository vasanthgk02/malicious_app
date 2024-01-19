package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class GoogleSignInStatusCodes extends CommonStatusCodes {
    public static String getStatusCodeString(int i) {
        switch (i) {
            case 12500:
                return "A non-recoverable sign in failure occurred";
            case 12501:
                return "Sign in action cancelled";
            case 12502:
                return "Sign-in in progress";
            default:
                return CommonStatusCodes.getStatusCodeString(i);
        }
    }
}
