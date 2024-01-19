package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzks {
    public final Clock zza;
    public long zzb;

    public zzks(Clock clock) {
        Preconditions.checkNotNull(clock);
        this.zza = clock;
    }
}
