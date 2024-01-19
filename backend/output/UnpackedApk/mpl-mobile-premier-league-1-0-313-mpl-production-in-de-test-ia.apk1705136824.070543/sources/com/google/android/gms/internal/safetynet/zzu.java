package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk.zzd;
import com.google.android.gms.internal.safetynet.zzk.zzg;

public final class zzu extends zze {
    public final /* synthetic */ zzd zzai;

    public zzu(zzd zzd) {
        this.zzai = zzd;
    }

    public final void zza(Status status, com.google.android.gms.safetynet.zzd zzd) {
        this.zzai.setResult(new zzg(status, zzd));
    }
}
