package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjr implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ zzab zzc;
    public final /* synthetic */ zzab zzd;
    public final /* synthetic */ zzkb zze;

    public zzjr(zzkb zzkb, zzp zzp, boolean z, zzab zzab, zzab zzab2) {
        this.zze = zzkb;
        this.zza = zzp;
        this.zzb = z;
        this.zzc = zzab;
        this.zzd = zzab2;
    }

    public final void run() {
        zzab zzab;
        zzkb zzkb = this.zze;
        zzeo zzeo = zzkb.zzb;
        if (zzeo == null) {
            zzkb.zzs.zzaz().zzd.zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        zzkb zzkb2 = this.zze;
        if (this.zzb) {
            zzab = null;
        } else {
            zzab = this.zzc;
        }
        zzkb2.zzD(zzeo, zzab, this.zza);
        this.zze.zzQ();
    }
}
