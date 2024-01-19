package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzga extends zzkc implements zzlk {
    public static final zzga zza;
    public zzkj zze = zzkc.zzbG();

    static {
        zzga zzga = new zzga();
        zza = zzga;
        zzkc.zzbM(zzga.class, zzga);
    }

    public static zzfz zza() {
        return (zzfz) zza.zzbA();
    }

    public static /* synthetic */ void zze(zzga zzga, zzgc zzgc) {
        zzgc.getClass();
        zzkj zzkj = zzga.zze;
        if (!zzkj.zzc()) {
            zzga.zze = zzkc.zzbH(zzkj);
        }
        zzga.zze.add(zzgc);
    }

    public final zzgc zzc(int i) {
        return (zzgc) this.zze.get(0);
    }

    public final List zzd() {
        return this.zze;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzgc.class});
        } else if (i2 == 3) {
            return new zzga();
        } else {
            if (i2 == 4) {
                return new zzfz(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
