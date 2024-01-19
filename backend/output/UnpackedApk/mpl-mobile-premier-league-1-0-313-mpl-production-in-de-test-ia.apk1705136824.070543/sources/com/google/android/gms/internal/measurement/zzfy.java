package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfy extends zzkc implements zzlk {
    public static final zzfy zza;
    public int zze;
    public String zzf = "";
    public String zzg = "";
    public zzfm zzh;

    static {
        zzfy zzfy = new zzfy();
        zza = zzfy;
        zzkc.zzbM(zzfy.class, zzfy);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzfy();
        } else {
            if (i2 == 4) {
                return new zzfx(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
