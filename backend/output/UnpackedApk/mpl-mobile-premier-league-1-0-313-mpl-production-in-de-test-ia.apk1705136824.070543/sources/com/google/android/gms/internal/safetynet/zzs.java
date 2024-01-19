package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk.zzb;
import com.google.android.gms.safetynet.zza;

public final class zzs extends zze {
    public final /* synthetic */ zzb zzag;

    public zzs(zzb zzb) {
        this.zzag = zzb;
    }

    public final void zza(Status status, zza zza) {
        this.zzag.setResult(new zzk.zza(status, zza));
    }
}
