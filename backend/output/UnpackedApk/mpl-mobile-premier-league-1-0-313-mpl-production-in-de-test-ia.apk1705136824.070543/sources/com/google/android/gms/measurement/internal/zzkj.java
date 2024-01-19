package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzkj implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzkr zzb;

    public zzkj(zzkr zzkr, long j) {
        this.zzb = zzkr;
        this.zza = j;
    }

    public final void run() {
        zzkr zzkr = this.zzb;
        long j = this.zza;
        zzkr.zzg();
        zzkr.zzm();
        zzkr.zzs.zzaz().zzl.zzb("Activity resumed, time", Long.valueOf(j));
        if (zzkr.zzs.zzk.zzu() || zzkr.zzs.zzm().zzl.zzb()) {
            zzkp zzkp = zzkr.zzb;
            zzkp.zzc.zzg();
            zzkp.zzd.zzb();
            zzkp.zza = j;
            zzkp.zzb = j;
        }
        zzkn zzkn = zzkr.zzc;
        zzkn.zza.zzg();
        zzkm zzkm = zzkn.zzb;
        if (zzkm != null) {
            zzkn.zza.zzd.removeCallbacks(zzkm);
        }
        zzkn.zza.zzs.zzm().zzl.zza(false);
        zzkq zzkq = zzkr.zza;
        zzkq.zza.zzg();
        if (zzkq.zza.zzs.zzJ()) {
            zzkq.zzb(zzkq.zza.zzs.zzr.currentTimeMillis(), false);
        }
    }
}
