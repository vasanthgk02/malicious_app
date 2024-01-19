package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjf implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzkb zzb;

    public zzjf(zzkb zzkb, zzp zzp) {
        this.zzb = zzkb;
        this.zza = zzp;
    }

    public final void run() {
        zzkb zzkb = this.zzb;
        zzeo zzeo = zzkb.zzb;
        if (zzeo == null) {
            zzkb.zzs.zzaz().zzd.zza("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzeo.zzm(this.zza);
        } catch (RemoteException e2) {
            this.zzb.zzs.zzaz().zzd.zzb("Failed to reset data on the service: remote exception", e2);
        }
        this.zzb.zzQ();
    }
}
