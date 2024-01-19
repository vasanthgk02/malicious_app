package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgo implements Callable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ zzha zzd;

    public zzgo(zzha zzha, String str, String str2, String str3) {
        this.zzd = zzha;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }

    public final Object call() throws Exception {
        this.zzd.zza.zzA();
        zzal zzal = this.zzd.zza.zze;
        zzli.zzak(zzal);
        return zzal.zzs(this.zza, this.zzb, this.zzc);
    }
}
