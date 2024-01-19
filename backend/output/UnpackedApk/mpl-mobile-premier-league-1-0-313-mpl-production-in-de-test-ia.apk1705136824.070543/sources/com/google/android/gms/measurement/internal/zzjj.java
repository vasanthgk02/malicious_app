package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjj implements Runnable {
    public final /* synthetic */ zziu zza;
    public final /* synthetic */ zzkb zzb;

    public zzjj(zzkb zzkb, zziu zziu) {
        this.zzb = zzkb;
        this.zza = zziu;
    }

    public final void run() {
        zzkb zzkb = this.zzb;
        zzeo zzeo = zzkb.zzb;
        if (zzeo == null) {
            zzkb.zzs.zzaz().zzd.zza("Failed to send current screen to service");
            return;
        }
        try {
            zziu zziu = this.zza;
            if (zziu == null) {
                zzeo.zzq(0, null, null, zzkb.zzs.zze.getPackageName());
            } else {
                zzeo.zzq(zziu.zzc, zziu.zza, zziu.zzb, zzkb.zzs.zze.getPackageName());
            }
            this.zzb.zzQ();
        } catch (RemoteException e2) {
            this.zzb.zzs.zzaz().zzd.zzb("Failed to send current screen to the service", e2);
        }
    }
}
