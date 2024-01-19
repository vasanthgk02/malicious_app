package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzc implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzd zzb;

    public zzc(zzd zzd, long j) {
        this.zzb = zzd;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzj(this.zza);
    }
}
