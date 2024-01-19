package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzt;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final /* synthetic */ class zzfs implements Callable {
    public final /* synthetic */ zzfz zza;

    public /* synthetic */ zzfs(zzfz zzfz) {
        this.zza = zzfz;
    }

    public final Object call() {
        return new zzt(this.zza.zze);
    }
}
