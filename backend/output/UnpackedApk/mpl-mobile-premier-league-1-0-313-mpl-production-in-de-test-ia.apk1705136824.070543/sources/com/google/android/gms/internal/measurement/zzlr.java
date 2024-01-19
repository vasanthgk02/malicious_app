package com.google.android.gms.internal.measurement;

import com.xiaomi.mipush.sdk.MiPushMessage;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzlr {
    public static final zzlr zza = new zzlr();
    public final zzlv zzb = new zzlb();
    public final ConcurrentMap zzc = new ConcurrentHashMap();

    public static zzlr zza() {
        return zza;
    }

    public final zzlu zzb(Class cls) {
        zzkk.zzf(cls, MiPushMessage.KEY_MESSAGE_TYPE);
        zzlu zzlu = (zzlu) this.zzc.get(cls);
        if (zzlu == null) {
            zzlu = this.zzb.zza(cls);
            zzkk.zzf(cls, MiPushMessage.KEY_MESSAGE_TYPE);
            zzkk.zzf(zzlu, "schema");
            zzlu zzlu2 = (zzlu) this.zzc.putIfAbsent(cls, zzlu);
            return zzlu2 == null ? zzlu : zzlu2;
        }
    }
}
