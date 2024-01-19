package com.google.android.gms.internal.auth;

import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzgw extends zzgy {
    public zzgw(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(zzj(obj, j));
    }

    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(zzi(obj, j));
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zzgz.zza) {
            zzgz.zzi(obj, j, z);
        } else {
            zzgz.zzj(obj, j, z);
        }
    }

    public final void zzd(Object obj, long j, double d2) {
        zzn(obj, j, Double.doubleToLongBits(d2));
    }

    public final void zze(Object obj, long j, float f2) {
        zzm(obj, j, Float.floatToIntBits(f2));
    }

    public final boolean zzf(Object obj, long j) {
        if (zzgz.zza) {
            return zzgz.zzq(obj, j);
        }
        return zzgz.zzr(obj, j);
    }
}
