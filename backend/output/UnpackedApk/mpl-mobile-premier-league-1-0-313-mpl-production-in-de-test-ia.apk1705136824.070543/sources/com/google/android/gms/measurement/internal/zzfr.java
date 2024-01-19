package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
public final class zzfr {
    public final zza zza;

    /* compiled from: com.google.android.gms:play-services-measurement@@20.1.2 */
    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzfr(zza zza2) {
        Preconditions.checkNotNull(zza2);
        this.zza = zza2;
    }
}
