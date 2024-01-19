package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
public final class zzy extends zzah {
    public final ResultHolder<Status> zza;

    public zzy(ResultHolder<Status> resultHolder) {
        this.zza = resultHolder;
    }

    public final void zzb(zzaa zzaa) {
        this.zza.setResult(zzaa.getStatus());
    }

    public final void zzc() {
    }
}
