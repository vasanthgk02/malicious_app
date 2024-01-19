package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhl extends ContentObserver {
    public zzhl(zzhm zzhm, Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzhy.zzd();
    }
}
