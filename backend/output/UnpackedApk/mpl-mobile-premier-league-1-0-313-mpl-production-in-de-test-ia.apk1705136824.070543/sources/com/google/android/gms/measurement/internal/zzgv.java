package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzgv implements Callable {
    public final /* synthetic */ zzav zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzha zzc;

    public zzgv(zzha zzha, zzav zzav, String str) {
        this.zzc = zzha;
        this.zza = zzav;
        this.zzb = str;
    }

    public final Object call() throws Exception {
        this.zzc.zza.zzA();
        zzis zzis = this.zzc.zza.zzj;
        zzli.zzak(zzis);
        zzis.zzg();
        zzgi.zzO();
        throw null;
    }
}
