package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zak;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zacr implements Runnable {
    public final /* synthetic */ zak zaa;
    public final /* synthetic */ zact zab;

    public zacr(zact zact, zak zak) {
        this.zab = zact;
        this.zaa = zak;
    }

    public final void run() {
        zact.zad(this.zab, this.zaa);
    }
}
