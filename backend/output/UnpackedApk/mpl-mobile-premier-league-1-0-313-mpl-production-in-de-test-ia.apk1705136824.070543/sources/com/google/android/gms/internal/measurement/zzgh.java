package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgh extends zzkc implements zzlk {
    public static final zzgh zza;
    public zzki zze = zzkc.zzbE();
    public zzki zzf = zzkc.zzbE();
    public zzkj zzg = zzkc.zzbG();
    public zzkj zzh = zzkc.zzbG();

    static {
        zzgh zzgh = new zzgh();
        zza = zzgh;
        zzkc.zzbM(zzgh.class, zzgh);
    }

    public static zzgg zzf() {
        return (zzgg) zza.zzbA();
    }

    public static zzgh zzh() {
        return zza;
    }

    public static /* synthetic */ void zzo(zzgh zzgh, Iterable iterable) {
        zzki zzki = zzgh.zze;
        if (!zzki.zzc()) {
            zzgh.zze = zzkc.zzbF(zzki);
        }
        zzil.zzbw(iterable, zzgh.zze);
    }

    public static /* synthetic */ void zzq(zzgh zzgh, Iterable iterable) {
        zzki zzki = zzgh.zzf;
        if (!zzki.zzc()) {
            zzgh.zzf = zzkc.zzbF(zzki);
        }
        zzil.zzbw(iterable, zzgh.zzf);
    }

    public static /* synthetic */ void zzs(zzgh zzgh, Iterable iterable) {
        zzgh.zzw();
        zzil.zzbw(iterable, zzgh.zzg);
    }

    public static /* synthetic */ void zzt(zzgh zzgh, int i) {
        zzgh.zzw();
        zzgh.zzg.remove(i);
    }

    public static /* synthetic */ void zzu(zzgh zzgh, Iterable iterable) {
        zzgh.zzx();
        zzil.zzbw(iterable, zzgh.zzh);
    }

    public static /* synthetic */ void zzv(zzgh zzgh, int i) {
        zzgh.zzx();
        zzgh.zzh.remove(i);
    }

    private final void zzw() {
        zzkj zzkj = this.zzg;
        if (!zzkj.zzc()) {
            this.zzg = zzkc.zzbH(zzkj);
        }
    }

    private final void zzx() {
        zzkj zzkj = this.zzh;
        if (!zzkj.zzc()) {
            this.zzh = zzkc.zzbH(zzkj);
        }
    }

    public final int zza() {
        return this.zzg.size();
    }

    public final int zzb() {
        return this.zzf.size();
    }

    public final int zzc() {
        return this.zzh.size();
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final zzfq zze(int i) {
        return (zzfq) this.zzg.get(i);
    }

    public final zzgj zzi(int i) {
        return (zzgj) this.zzh.get(i);
    }

    public final List zzj() {
        return this.zzg;
    }

    public final List zzk() {
        return this.zzf;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(1);
        }
        if (i2 == 2) {
            return zzkc.zzbL(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", zzfq.class, "zzh", zzgj.class});
        } else if (i2 == 3) {
            return new zzgh();
        } else {
            if (i2 == 4) {
                return new zzgg(null);
            }
            if (i2 != 5) {
                return null;
            }
            return zza;
        }
    }

    public final List zzm() {
        return this.zzh;
    }

    public final List zzn() {
        return this.zze;
    }
}
