package com.google.android.gms.common.api.internal;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabn implements Runnable {
    public final /* synthetic */ int zaa;
    public final /* synthetic */ zabq zab;

    public zabn(zabq zabq, int i) {
        this.zab = zabq;
        this.zaa = i;
    }

    public final void run() {
        this.zab.zaH(this.zaa);
    }
}
