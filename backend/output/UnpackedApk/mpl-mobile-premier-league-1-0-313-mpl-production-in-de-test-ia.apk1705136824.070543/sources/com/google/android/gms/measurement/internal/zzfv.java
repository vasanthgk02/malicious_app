package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzfv implements Callable {
    public final /* synthetic */ zzfz zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzfv(zzfz zzfz, String str) {
        this.zza = zzfz;
        this.zzb = str;
    }

    public final Object call() {
        return new zzu("internal.appMetadata", new zzfu(this.zza, this.zzb));
    }
}
