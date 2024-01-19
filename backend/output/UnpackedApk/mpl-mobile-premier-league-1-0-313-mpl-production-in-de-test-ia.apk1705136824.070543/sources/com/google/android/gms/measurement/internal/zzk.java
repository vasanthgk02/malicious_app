package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
public final class zzk implements Runnable {
    public final /* synthetic */ zzn zza;
    public final /* synthetic */ AppMeasurementDynamiteService zzb;

    public zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, zzn zzn) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzq().zzV(this.zza);
    }
}
