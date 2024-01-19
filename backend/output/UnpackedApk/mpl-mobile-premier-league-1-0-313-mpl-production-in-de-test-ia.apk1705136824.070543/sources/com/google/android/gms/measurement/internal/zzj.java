package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
public final class zzj implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ AppMeasurementDynamiteService zze;

    public zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, String str, String str2, boolean z) {
        this.zze = appMeasurementDynamiteService;
        this.zza = zzcf;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
    }

    public final void run() {
        zzkb zzt = this.zze.zza.zzt();
        zzcf zzcf = this.zza;
        String str = this.zzb;
        String str2 = this.zzc;
        boolean z = this.zzd;
        zzt.zzg();
        zzt.zza();
        zzjc zzjc = new zzjc(zzt, str, str2, zzt.zzO(false), z, zzcf);
        zzt.zzR(zzjc);
    }
}
