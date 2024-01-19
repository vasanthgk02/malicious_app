package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.safetynet.zzk;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfm extends zzkc implements zzlk {
    public static final zzfm zza;
    public int zze;
    public String zzf = "";
    public String zzg = "";
    public String zzh = "";
    public String zzi = "";
    public String zzj = "";
    public String zzk = "";
    public String zzl = "";

    static {
        zzfm zzfm = new zzfm();
        zza = zzfm;
        zzkc.zzbM(zzfm.class, zzfm);
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzk.TAG, "zzl"});
        } else if (i2 == 3) {
            return new zzfm();
        } else {
            if (i2 == 4) {
                return new zzfl(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
