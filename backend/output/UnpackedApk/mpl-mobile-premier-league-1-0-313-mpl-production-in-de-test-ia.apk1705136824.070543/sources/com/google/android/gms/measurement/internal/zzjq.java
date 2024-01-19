package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjq implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzav zzc;
    public final /* synthetic */ zzkb zze;

    public zzjq(zzkb zzkb, zzp zzp, boolean z, zzav zzav, String str) {
        this.zze = zzkb;
        this.zza = zzp;
        this.zzb = z;
        this.zzc = zzav;
    }

    public final void run() {
        zzav zzav;
        zzkb zzkb = this.zze;
        zzeo zzeo = zzkb.zzb;
        if (zzeo == null) {
            zzkb.zzs.zzaz().zzd.zza("Discarding data. Failed to send event to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzkb zzkb2 = this.zze;
        if (this.zzb) {
            zzav = null;
        } else {
            zzav = this.zzc;
        }
        zzkb2.zzD(zzeo, zzav, this.zza);
        this.zze.zzQ();
    }
}
