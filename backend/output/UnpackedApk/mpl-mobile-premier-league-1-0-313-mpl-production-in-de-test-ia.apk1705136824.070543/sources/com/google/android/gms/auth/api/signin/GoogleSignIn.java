package com.google.android.gms.auth.api.signin;

import android.content.Context;
import com.google.android.gms.auth.api.signin.internal.zbn;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class GoogleSignIn {
    public static GoogleSignInAccount getLastSignedInAccount(Context context) {
        GoogleSignInAccount googleSignInAccount;
        zbn zbc = zbn.zbc(context);
        synchronized (zbc) {
            try {
                googleSignInAccount = zbc.zbb;
            }
        }
        return googleSignInAccount;
    }
}
