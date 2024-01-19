package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzn;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzft implements Callable {
    public final /* synthetic */ zzfz zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzft(zzfz zzfz, String str) {
        this.zza = zzfz;
        this.zzb = str;
    }

    public final Object call() {
        return new zzn("internal.remoteConfig", new zzfy(this.zza, this.zzb));
    }
}
