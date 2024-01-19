package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
public final class zzl implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcf;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        zzkb zzt = this.zzd.zza.zzt();
        zzcf zzcf = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        zzt.zzg();
        zzt.zza();
        zzjt zzjt = new zzjt(zzt, str, str2, zzt.zzO(false), zzcf);
        zzt.zzR(zzjt);
    }
}
