package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
public final class zzh implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzcf;
    }

    public final void run() {
        zzkb zzt = this.zzb.zza.zzt();
        zzcf zzcf = this.zza;
        zzt.zzg();
        zzt.zza();
        zzt.zzR(new zzjh(zzt, zzt.zzO(false), zzcf));
    }
}
