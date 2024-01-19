package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjx implements Runnable {
    public final /* synthetic */ zzeo zza;
    public final /* synthetic */ zzka zzb;

    public zzjx(zzka zzka, zzeo zzeo) {
        this.zzb = zzka;
        this.zza = zzeo;
    }

    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzL()) {
                this.zzb.zza.zzs.zzaz().zzk.zza("Connected to remote service");
                zzkb zzkb = this.zzb.zza;
                zzeo zzeo = this.zza;
                zzkb.zzg();
                Preconditions.checkNotNull(zzeo);
                zzkb.zzb = zzeo;
                zzkb.zzQ();
                zzkb.zzP();
            }
        }
    }
}
