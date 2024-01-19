package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfg extends zzkc implements zzlk {
    public static final zzfg zza;
    public int zze;
    public String zzf = "";
    public String zzg = "";

    static {
        zzfg zzfg = new zzfg();
        zza = zzfg;
        zzkc.zzbM(zzfg.class, zzfg);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfg();
        } else {
            if (i2 == 4) {
                return new zzff(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
