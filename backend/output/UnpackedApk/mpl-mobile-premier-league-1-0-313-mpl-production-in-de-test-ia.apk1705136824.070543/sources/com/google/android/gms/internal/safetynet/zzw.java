package com.google.android.gms.internal.safetynet;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.safetynet.zzk.zzf;
import com.google.android.gms.internal.safetynet.zzk.zzi;
import com.google.android.gms.safetynet.SafeBrowsingData;

public final class zzw extends zze {
    public final /* synthetic */ zzf zzak;

    public zzw(zzf zzf) {
        this.zzak = zzf;
    }

    public final void zza(Status status, SafeBrowsingData safeBrowsingData) {
        this.zzak.setResult(new zzi(status, safeBrowsingData));
    }
}
