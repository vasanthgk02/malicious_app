package com.google.android.gms.internal.auth;

import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzfy {
    public static final zzfy zza = new zzfy();
    public final zzgc zzb = new zzfi();
    public final ConcurrentMap<Class<?>, zzgb<?>> zzc = new ConcurrentHashMap();

    public static zzfy zza() {
        return zza;
    }

    public final <T> zzgb<T> zzb(Class<T> cls) {
        zzev.zzf(cls, MiPushMessage.KEY_MESSAGE_TYPE);
        zzgb<T> zzgb = (zzgb) this.zzc.get(cls);
        if (zzgb == null) {
            zzgb = this.zzb.zza(cls);
            zzev.zzf(cls, MiPushMessage.KEY_MESSAGE_TYPE);
            zzev.zzf(zzgb, "schema");
            zzgb<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzgb);
            return putIfAbsent == null ? zzgb : putIfAbsent;
        }
    }
}
