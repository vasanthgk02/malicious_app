package com.google.android.gms.internal.auth;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzcf extends ContentObserver {
    public final /* synthetic */ zzcg zza;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zzcf(zzcg zzcg, Handler handler) {
        // this.zza = zzcg;
        super(null);
    }

    public final void onChange(boolean z) {
        this.zza.zze();
    }
}
