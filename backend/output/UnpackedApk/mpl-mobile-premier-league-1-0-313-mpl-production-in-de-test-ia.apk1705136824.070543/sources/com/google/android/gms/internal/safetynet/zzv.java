package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk.zze;
import com.google.android.gms.internal.safetynet.zzk.zzh;
import com.google.android.gms.safetynet.zzf;

public final class zzv extends zze {
    public final /* synthetic */ zze zzaj;

    public zzv(zze zze) {
        this.zzaj = zze;
    }

    public final void zza(Status status, zzf zzf) {
        this.zzaj.setResult(new zzh(status, zzf));
    }
}
