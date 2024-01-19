package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzij {
    public static zzif zza(zzif zzif) {
        zzif zzif2;
        if ((zzif instanceof zzih) || (zzif instanceof zzig)) {
            return zzif;
        }
        if (zzif instanceof Serializable) {
            zzif2 = new zzig(zzif);
        } else {
            zzif2 = new zzih(zzif);
        }
        return zzif2;
    }

    public static zzif zzb(Object obj) {
        return new zzii(obj);
    }
}
