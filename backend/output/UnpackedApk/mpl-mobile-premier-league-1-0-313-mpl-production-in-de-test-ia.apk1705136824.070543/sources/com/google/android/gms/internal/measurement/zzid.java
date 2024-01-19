package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public abstract class zzid implements Serializable {
    public static zzid zzc() {
        return zzib.zza;
    }

    public static zzid zzd(Object obj) {
        return new zzie(obj);
    }

    public abstract Object zza();

    public abstract boolean zzb();
}
