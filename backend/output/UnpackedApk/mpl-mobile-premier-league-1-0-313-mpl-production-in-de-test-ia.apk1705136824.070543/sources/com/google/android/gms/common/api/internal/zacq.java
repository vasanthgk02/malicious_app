package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zacq implements Runnable {
    public final /* synthetic */ zact zaa;

    public zacq(zact zact) {
        this.zaa = zact;
    }

    public final void run() {
        this.zaa.zah.zae(new ConnectionResult(4));
    }
}
