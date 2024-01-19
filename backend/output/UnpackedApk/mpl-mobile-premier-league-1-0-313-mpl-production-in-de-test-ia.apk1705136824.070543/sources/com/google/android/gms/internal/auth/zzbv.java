package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzbv implements SpatulaHeaderResult {
    public final Status zza;
    public final String zzb;

    public zzbv(Status status) {
        Preconditions.checkNotNull(status);
        this.zza = status;
        this.zzb = "";
    }

    public final String getSpatulaHeader() {
        return this.zzb;
    }

    public final Status getStatus() {
        return this.zza;
    }

    public zzbv(String str) {
        Preconditions.checkNotNull(str);
        this.zzb = str;
        this.zza = Status.RESULT_SUCCESS;
    }
}
