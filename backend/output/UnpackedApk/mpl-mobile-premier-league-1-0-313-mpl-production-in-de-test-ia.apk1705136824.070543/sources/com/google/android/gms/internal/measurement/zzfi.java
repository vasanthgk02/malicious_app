package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfi extends zzkc implements zzlk {
    public static final zzfi zza;
    public int zze;
    public String zzf = "";
    public String zzg = "";

    static {
        zzfi zzfi = new zzfi();
        zza = zzfi;
        zzkc.zzbM(zzfi.class, zzfi);
    }

    public final String zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzg;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfi();
        } else {
            if (i2 == 4) {
                return new zzfh(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
