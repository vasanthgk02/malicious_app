package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@20.1.2 */
public final class zzkv extends zzkx {
    public zzkv() {
        super(null);
    }

    public /* synthetic */ zzkv(zzku zzku) {
        super(null);
    }

    public final void zza(Object obj, long j) {
        ((zzkj) zzmv.zzf(obj, j)).zzb();
    }

    public final void zzb(Object obj, Object obj2, long j) {
        zzkj zzkj = (zzkj) zzmv.zzf(obj, j);
        zzkj zzkj2 = (zzkj) zzmv.zzf(obj2, j);
        int size = zzkj.size();
        int size2 = zzkj2.size();
        if (size > 0 && size2 > 0) {
            if (!zzkj.zzc()) {
                zzkj = zzkj.zzd(size2 + size);
            }
            zzkj.addAll(zzkj2);
        }
        if (size > 0) {
            zzkj2 = zzkj;
        }
        zzmv.zzs(obj, j, zzkj2);
    }
}
