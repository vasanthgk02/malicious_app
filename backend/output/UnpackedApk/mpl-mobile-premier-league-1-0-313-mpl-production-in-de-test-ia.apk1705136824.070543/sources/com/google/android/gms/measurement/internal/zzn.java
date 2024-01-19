package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzci;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
public final class zzn implements zzhi {
    public final zzci zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzn(AppMeasurementDynamiteService appMeasurementDynamiteService, zzci zzci) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzci;
    }

    public final void interceptEvent(String str, String str2, Bundle bundle, long j) {
        try {
            this.zza.zze(str, str2, bundle, j);
        } catch (RemoteException e2) {
            zzgi zzgi = this.zzb.zza;
            if (zzgi != null) {
                zzgi.zzaz().zzg.zzb("Event interceptor threw exception", e2);
            }
        }
    }
}