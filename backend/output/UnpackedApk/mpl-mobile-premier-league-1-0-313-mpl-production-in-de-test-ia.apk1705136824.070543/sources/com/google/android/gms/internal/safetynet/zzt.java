package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk.zzc;
import com.google.android.gms.internal.safetynet.zzk.zzj;

public final class zzt extends zze {
    public final /* synthetic */ zzc zzah;

    public zzt(zzc zzc) {
        this.zzah = zzc;
    }

    public final void zza(Status status, boolean z) {
        this.zzah.setResult(new zzj(status, z));
    }
}
