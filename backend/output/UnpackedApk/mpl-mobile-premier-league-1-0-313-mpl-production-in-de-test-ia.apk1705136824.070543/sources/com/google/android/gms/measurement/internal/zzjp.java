package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjp implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzkb zzb;

    public zzjp(zzkb zzkb, zzp zzp) {
        this.zzb = zzkb;
        this.zza = zzp;
    }

    public final void run() {
        zzkb zzkb = this.zzb;
        zzeo zzeo = zzkb.zzb;
        if (zzeo == null) {
            zzkb.zzs.zzaz().zzd.zza("Failed to send consent settings to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzeo.zzp(this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e2) {
            this.zzb.zzs.zzaz().zzd.zzb("Failed to send consent settings to the service", e2);
        }
    }
}
