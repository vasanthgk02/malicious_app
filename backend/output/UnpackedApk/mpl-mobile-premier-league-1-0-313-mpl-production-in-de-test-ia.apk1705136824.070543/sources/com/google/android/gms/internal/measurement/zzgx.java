package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.safetynet.zzk;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgx extends zzkc implements zzlk {
    public static final zzgx zza;
    public int zze;
    public int zzf;
    public zzkj zzg = zzkc.zzbG();
    public String zzh = "";
    public String zzi = "";
    public boolean zzj;
    public double zzk;

    static {
        zzgx zzgx = new zzgx();
        zza = zzgx;
        zzkc.zzbM(zzgx.class, zzgx);
    }

    public final double zza() {
        return this.zzk;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zzi;
    }

    public final List zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return this.zzj;
    }

    public final boolean zzg() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 4) != 0;
    }

    public final int zzj() {
        int zza2 = zzgw.zza(this.zzf);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", zzgv.zza, "zzg", zzgx.class, "zzh", "zzi", "zzj", zzk.TAG});
        } else if (i2 == 3) {
            return new zzgx();
        } else {
            if (i2 == 4) {
                return new zzgt(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
