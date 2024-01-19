package com.google.android.gms.common.api.internal;

import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaar extends zac {
    public final WeakReference zaa;

    public zaar(zaaw zaaw) {
        this.zaa = new WeakReference(zaaw);
    }

    public final void zab(zak zak) {
        zaaw zaaw = (zaaw) this.zaa.get();
        if (zaaw != null) {
            zabi zabi = zaaw.zaa;
            zabi.zam.sendMessage(zabi.zam.obtainMessage(1, new zaaq(zaaw, zaaw, zak)));
        }
    }
}
