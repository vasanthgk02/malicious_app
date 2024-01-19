package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;

/* compiled from: com.google.android.gms:play-services-auth@@20.1.0 */
public final class zbb implements ResultConverter {
    public final Object convert(Result result) {
        return ((GoogleSignInResult) result).zbb;
    }
}
