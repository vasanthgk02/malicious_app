package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgs extends zzkc implements zzlk {
    public static final zzgs zza;
    public int zze;
    public zzkj zzf = zzkc.zzbG();
    public zzgo zzg;

    static {
        zzgs zzgs = new zzgs();
        zza = zzgs;
        zzkc.zzbM(zzgs.class, zzgs);
    }

    public final zzgo zza() {
        zzgo zzgo = this.zzg;
        return zzgo == null ? zzgo.zzc() : zzgo;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", zzgx.class, "zzg"});
        } else if (i2 == 3) {
            return new zzgs();
        } else {
            if (i2 == 4) {
                return new zzgr(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
