package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzji implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ zzkb zzb;

    public zzji(zzkb zzkb, zzp zzp) {
        this.zzb = zzkb;
        this.zza = zzp;
    }

    public final void run() {
        zzkb zzkb = this.zzb;
        zzeo zzeo = zzkb.zzb;
        if (zzeo == null) {
            zzkb.zzs.zzaz().zzd.zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzeo.zzj(this.zza);
            this.zzb.zzs.zzi().zzm();
            this.zzb.zzD(zzeo, null, this.zza);
            this.zzb.zzQ();
        } catch (RemoteException e2) {
            this.zzb.zzs.zzaz().zzd.zzb("Failed to send app launch to the service", e2);
        }
    }
}
