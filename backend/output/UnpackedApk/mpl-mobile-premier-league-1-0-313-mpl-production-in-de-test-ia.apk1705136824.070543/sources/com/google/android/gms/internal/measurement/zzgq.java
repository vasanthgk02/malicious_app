package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgq extends zzkc implements zzlk {
    public static final zzgq zza;
    public int zze;
    public String zzf = "";
    public zzkj zzg = zzkc.zzbG();

    static {
        zzgq zzgq = new zzgq();
        zza = zzgq;
        zzkc.zzbM(zzgq.class, zzgq);
    }

    public final String zzb() {
        return this.zzf;
    }

    public final List zzc() {
        return this.zzg;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", zzgx.class});
        } else if (i2 == 3) {
            return new zzgq();
        } else {
            if (i2 == 4) {
                return new zzgp(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
