package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zziw implements Runnable {
    public final /* synthetic */ zziu zza;
    public final /* synthetic */ zziu zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzjb zze;

    public zziw(zzjb zzjb, zziu zziu, zziu zziu2, long j, boolean z) {
        this.zze = zzjb;
        this.zza = zziu;
        this.zzb = zziu2;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zzB(this.zza, this.zzb, this.zzc, this.zzd, null);
    }
}
