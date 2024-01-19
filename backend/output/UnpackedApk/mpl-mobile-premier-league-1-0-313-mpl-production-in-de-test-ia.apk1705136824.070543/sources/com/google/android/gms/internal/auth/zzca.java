package com.google.android.gms.internal.auth;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public final class zzca extends ContentObserver {
    public zzca(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzcb.zzk.set(true);
    }
}
