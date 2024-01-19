package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabd extends zabw {
    public final WeakReference zaa;

    public zabd(zabe zabe) {
        this.zaa = new WeakReference(zabe);
    }

    public final void zaa() {
        zabe zabe = (zabe) this.zaa.get();
        if (zabe != null) {
            zabe.zai(zabe);
        }
    }
}
