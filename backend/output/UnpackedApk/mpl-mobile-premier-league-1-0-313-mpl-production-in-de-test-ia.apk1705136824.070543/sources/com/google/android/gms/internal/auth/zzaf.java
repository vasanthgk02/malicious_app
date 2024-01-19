package com.google.android.gms.internal.auth;

import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzaf extends zzah {
    public final /* synthetic */ zzag zza;

    public zzaf(zzag zzag) {
        this.zza = zzag;
    }

    public final void zzc(boolean z) {
        this.zza.setResult(new zzak(z ? Status.RESULT_SUCCESS : zzal.zza));
    }
}
