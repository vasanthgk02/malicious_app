package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfs extends zzkc implements zzlk {
    public static final zzfs zza;
    public int zze;
    public zzkj zzf = zzkc.zzbG();
    public String zzg = "";
    public long zzh;
    public long zzi;
    public int zzj;

    static {
        zzfs zzfs = new zzfs();
        zza = zzfs;
        zzkc.zzbM(zzfs.class, zzfs);
    }

    public static zzfr zze() {
        return (zzfr) zza.zzbA();
    }

    public static /* synthetic */ void zzj(zzfs zzfs, int i, zzfw zzfw) {
        zzfw.getClass();
        zzfs.zzv();
        zzfs.zzf.set(i, zzfw);
    }

    public static /* synthetic */ void zzk(zzfs zzfs, zzfw zzfw) {
        zzfw.getClass();
        zzfs.zzv();
        zzfs.zzf.add(zzfw);
    }

    public static /* synthetic */ void zzm(zzfs zzfs, Iterable iterable) {
        zzfs.zzv();
        zzil.zzbw(iterable, zzfs.zzf);
    }

    public static /* synthetic */ void zzo(zzfs zzfs, int i) {
        zzfs.zzv();
        zzfs.zzf.remove(i);
    }

    public static /* synthetic */ void zzp(zzfs zzfs, String str) {
        str.getClass();
        zzfs.zze |= 1;
        zzfs.zzg = str;
    }

    public static /* synthetic */ void zzq(zzfs zzfs, long j) {
        zzfs.zze |= 2;
        zzfs.zzh = j;
    }

    public static /* synthetic */ void zzr(zzfs zzfs, long j) {
        zzfs.zze |= 4;
        zzfs.zzi = j;
    }

    private final void zzv() {
        zzkj zzkj = this.zzf;
        if (!zzkj.zzc()) {
            this.zzf = zzkc.zzbH(zzkj);
        }
    }

    public final int zza() {
        return this.zzj;
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzh;
    }

    public final zzfw zzg(int i) {
        return (zzfw) this.zzf.get(i);
    }

    public final String zzh() {
        return this.zzg;
    }

    public final List zzi() {
        return this.zzf;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", zzfw.class, "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzfs();
        } else {
            if (i2 == 4) {
                return new zzfr(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final boolean zzs() {
        return (this.zze & 8) != 0;
    }

    public final boolean zzt() {
        return (this.zze & 4) != 0;
    }

    public final boolean zzu() {
        return (this.zze & 2) != 0;
    }
}
