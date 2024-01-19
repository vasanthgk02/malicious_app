package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public abstract class zzde<T> implements Serializable {
    public static <T> zzde<T> zzc() {
        return zzdc.zza;
    }

    public static <T> zzde<T> zzd(T t) {
        return new zzdf(t);
    }

    public abstract T zza();

    public abstract boolean zzb();
}
