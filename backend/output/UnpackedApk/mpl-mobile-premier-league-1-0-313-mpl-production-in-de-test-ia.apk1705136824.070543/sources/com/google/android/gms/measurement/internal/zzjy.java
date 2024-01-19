package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzjy implements Runnable {
    public final /* synthetic */ zzka zza;

    public zzjy(zzka zzka) {
        this.zza = zzka;
    }

    public final void run() {
        zzkb zzkb = this.zza.zza;
        Context context = zzkb.zzs.zze;
        zzaa zzaa = this.zza.zza.zzs.zzj;
        zzkb.zzo(zzkb, new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
