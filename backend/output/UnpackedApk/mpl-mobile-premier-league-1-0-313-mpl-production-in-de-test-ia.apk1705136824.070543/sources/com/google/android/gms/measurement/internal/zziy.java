package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zziy implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzjb zzb;

    public zziy(zzjb zzjb, long j) {
        this.zzb = zzjb;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzd().zzf(this.zza);
        this.zzb.zza = null;
    }
}
