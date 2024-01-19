package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzan implements Runnable {
    public final /* synthetic */ zzhd zza;
    public final /* synthetic */ zzao zzb;

    public zzan(zzao zzao, zzhd zzhd) {
        this.zzb = zzao;
        this.zza = zzhd;
    }

    public final void run() {
        this.zza.zzax();
        if (zzaa.zza()) {
            this.zza.zzaA().zzp(this);
            return;
        }
        boolean z = this.zzb.zzd != 0;
        this.zzb.zzd = 0;
        if (z) {
            this.zzb.zzc();
        }
    }
}
