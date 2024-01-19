package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfu extends zzkc implements zzlk {
    public static final zzfu zza;
    public int zze;
    public String zzf = "";
    public long zzg;

    static {
        zzfu zzfu = new zzfu();
        zza = zzfu;
        zzkc.zzbM(zzfu.class, zzfu);
    }

    public static zzft zza() {
        return (zzft) zza.zzbA();
    }

    public static /* synthetic */ void zzc(zzfu zzfu, String str) {
        str.getClass();
        zzfu.zze |= 1;
        zzfu.zzf = str;
    }

    public static /* synthetic */ void zzd(zzfu zzfu, long j) {
        zzfu.zze |= 2;
        zzfu.zzg = j;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzfu();
        } else {
            if (i2 == 4) {
                return new zzft(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
