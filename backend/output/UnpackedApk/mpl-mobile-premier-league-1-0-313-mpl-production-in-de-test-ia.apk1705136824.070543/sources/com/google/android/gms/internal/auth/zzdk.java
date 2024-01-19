package com.google.android.gms.internal.auth;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzdk {
    public static <T> zzdg<T> zza(zzdg<T> zzdg) {
        zzdg<T> zzdg2;
        if ((zzdg instanceof zzdi) || (zzdg instanceof zzdh)) {
            return zzdg;
        }
        if (zzdg instanceof Serializable) {
            zzdg2 = new zzdh<>(zzdg);
        } else {
            zzdg2 = new zzdi<>(zzdg);
        }
        return zzdg2;
    }

    public static <T> zzdg<T> zzb(T t) {
        return new zzdj(t);
    }
}
