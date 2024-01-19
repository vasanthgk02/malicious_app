package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zziz implements Runnable {
    public final /* synthetic */ zziu zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzjb zzc;

    public zziz(zzjb zzjb, zziu zziu, long j) {
        this.zzc = zzjb;
        this.zza = zziu;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzC(this.zza, false, this.zzb);
        zzjb zzjb = this.zzc;
        zzjb.zza = null;
        zzkb zzt = zzjb.zzs.zzt();
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzjj(zzt, null));
    }
}
