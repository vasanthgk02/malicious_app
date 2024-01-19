package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjk implements Runnable {
    public final /* synthetic */ zzp zza;
    public final /* synthetic */ Bundle zzb;
    public final /* synthetic */ zzkb zzc;

    public zzjk(zzkb zzkb, zzp zzp, Bundle bundle) {
        this.zzc = zzkb;
        this.zza = zzp;
        this.zzb = bundle;
    }

    public final void run() {
        zzkb zzkb = this.zzc;
        zzeo zzeo = zzkb.zzb;
        if (zzeo == null) {
            zzkb.zzs.zzaz().zzd.zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzeo.zzr(this.zzb, this.zza);
        } catch (RemoteException e2) {
            this.zzc.zzs.zzaz().zzd.zzb("Failed to send default event parameters to service", e2);
        }
    }
}
