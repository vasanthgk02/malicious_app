package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@20.1.2 */
public final class zzhd extends ContentObserver {
    public final /* synthetic */ zzhe zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzhd(zzhe zzhe, Handler handler) {
        // this.zza = zzhe;
        super(null);
    }

    public final void onChange(boolean z) {
        this.zza.zzf();
    }
}
