package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzkm implements Runnable {
    public final long zza;
    public final long zzb;
    public final /* synthetic */ zzkn zzc;

    public zzkm(zzkn zzkn, long j, long j2) {
        this.zzc = zzkn;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzs.zzaA().zzp(new zzkl(this));
    }
}
