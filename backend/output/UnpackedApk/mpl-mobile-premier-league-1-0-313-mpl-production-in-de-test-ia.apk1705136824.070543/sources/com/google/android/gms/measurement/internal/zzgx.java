package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgx implements Callable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzha zzb;

    public zzgx(zzha zzha, String str) {
        this.zzb = zzha;
        this.zza = str;
    }

    public final Object call() throws Exception {
        this.zzb.zza.zzA();
        zzal zzal = this.zzb.zza.zze;
        zzli.zzak(zzal);
        return zzal.zzu(this.zza);
    }
}
