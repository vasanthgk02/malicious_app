package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzaj implements Result {
    public final Status zza;

    public zzaj(Status status) {
        this.zza = status;
    }

    public final Status getStatus() {
        return this.zza;
    }
}
