package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzeh extends zzkc implements zzlk {
    public static final zzeh zza;
    public int zze;
    public int zzf;
    public zzkj zzg = zzkc.zzbG();
    public zzkj zzh = zzkc.zzbG();
    public boolean zzi;
    public boolean zzj;

    static {
        zzeh zzeh = new zzeh();
        zza = zzeh;
        zzkc.zzbM(zzeh.class, zzeh);
    }

    public static /* synthetic */ void zzi(zzeh zzeh, int i, zzes zzes) {
        zzes.getClass();
        zzkj zzkj = zzeh.zzg;
        if (!zzkj.zzc()) {
            zzeh.zzg = zzkc.zzbH(zzkj);
        }
        zzeh.zzg.set(i, zzes);
    }

    public static /* synthetic */ void zzj(zzeh zzeh, int i, zzej zzej) {
        zzej.getClass();
        zzkj zzkj = zzeh.zzh;
        if (!zzkj.zzc()) {
            zzeh.zzh = zzkc.zzbH(zzkj);
        }
        zzeh.zzh.set(i, zzej);
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zzh.size();
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final zzej zze(int i) {
        return (zzej) this.zzh.get(i);
    }

    public final zzes zzf(int i) {
        return (zzes) this.zzg.get(i);
    }

    public final List zzg() {
        return this.zzh;
    }

    public final List zzh() {
        return this.zzg;
    }

    public final boolean zzk() {
        return (this.zze & 1) != 0;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", zzes.class, "zzh", zzej.class, "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzeh();
        } else {
            if (i2 == 4) {
                return new zzeg(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }
}
