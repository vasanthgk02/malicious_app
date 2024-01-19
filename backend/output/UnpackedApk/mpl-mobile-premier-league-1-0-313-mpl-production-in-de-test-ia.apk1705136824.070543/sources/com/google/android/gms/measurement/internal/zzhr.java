package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhr implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzin zzb;

    public zzhr(zzin zzin, long j) {
        this.zzb = zzin;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzm().zzf.zzb(this.zza);
        this.zzb.zzs.zzaz().zzk.zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
