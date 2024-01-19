package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.internal.measurement.zzcf;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@20.1.2 */
public final class zzi implements Runnable {
    public final /* synthetic */ zzcf zza;
    public final /* synthetic */ zzav zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ AppMeasurementDynamiteService zzd;

    public zzi(AppMeasurementDynamiteService appMeasurementDynamiteService, zzcf zzcf, zzav zzav, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzcf;
        this.zzb = zzav;
        this.zzc = str;
    }

    public final void run() {
        zzkb zzt = this.zzd.zza.zzt();
        zzcf zzcf = this.zza;
        zzav zzav = this.zzb;
        String str = this.zzc;
        zzt.zzg();
        zzt.zza();
        zzlp zzv = zzt.zzs.zzv();
        if (zzv == null) {
            throw null;
        } else if (GoogleApiAvailabilityLight.zza.isGooglePlayServicesAvailable(zzv.zzs.zze, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzt.zzs.zzaz().zzg.zza("Not bundling data. Service unavailable or out of date");
            zzt.zzs.zzv().zzS(zzcf, new byte[0]);
        } else {
            zzt.zzR(new zzjm(zzt, zzav, str, zzcf));
        }
    }
}
