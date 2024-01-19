package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzkk implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzkr zzb;

    public zzkk(zzkr zzkr, long j) {
        this.zzb = zzkr;
        this.zza = j;
    }

    public final void run() {
        zzkr zzkr = this.zzb;
        long j = this.zza;
        zzkr.zzg();
        zzkr.zzm();
        zzkr.zzs.zzaz().zzl.zzb("Activity paused, time", Long.valueOf(j));
        zzkn zzkn = zzkr.zzc;
        zzkm zzkm = new zzkm(zzkn, zzkn.zza.zzs.zzr.currentTimeMillis(), j);
        zzkn.zzb = zzkm;
        zzkn.zza.zzd.postDelayed(zzkm, 2000);
        if (zzkr.zzs.zzk.zzu()) {
            zzkr.zzb.zzd.zzb();
        }
    }
}
