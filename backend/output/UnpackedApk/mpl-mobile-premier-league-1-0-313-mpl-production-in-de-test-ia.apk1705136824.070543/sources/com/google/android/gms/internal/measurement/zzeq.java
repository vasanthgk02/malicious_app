package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzeq extends zzkc implements zzlk {
    public static final zzeq zza;
    public int zze;
    public int zzf;
    public boolean zzg;
    public String zzh = "";
    public String zzi = "";
    public String zzj = "";

    static {
        zzeq zzeq = new zzeq();
        zza = zzeq;
        zzkc.zzbM(zzeq.class, zzeq);
    }

    public static zzeq zzb() {
        return zza;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final String zzd() {
        return this.zzj;
    }

    public final String zze() {
        return this.zzi;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zze & 1) != 0;
    }

    public final boolean zzh() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzi() {
        return (this.zze & 2) != 0;
    }

    public final boolean zzj() {
        return (this.zze & 16) != 0;
    }

    public final boolean zzk() {
        return (this.zze & 8) != 0;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", zzeo.zza, "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzeq();
        } else {
            if (i2 == 4) {
                return new zzem(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final int zzm() {
        int zza2 = zzep.zza(this.zzf);
        if (zza2 == 0) {
            return 1;
        }
        return zza2;
    }
}
