package com.google.android.gms.internal.auth;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzeg {
    public static final zzeg zza = new zzeg(true);
    public static volatile boolean zzb;
    public static volatile zzeg zzc;
    public final Map zzd;

    public zzeg() {
        this.zzd = new HashMap();
    }

    public static zzeg zza() {
        zzeg zzeg = zzc;
        if (zzeg == null) {
            synchronized (zzeg.class) {
                try {
                    zzeg = zzc;
                    if (zzeg == null) {
                        zzeg = zza;
                        zzc = zzeg;
                    }
                }
            }
        }
        return zzeg;
    }

    public zzeg(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
