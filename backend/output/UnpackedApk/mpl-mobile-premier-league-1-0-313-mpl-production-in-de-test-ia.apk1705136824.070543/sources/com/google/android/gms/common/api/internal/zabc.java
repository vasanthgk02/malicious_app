package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zau;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabc extends zau {
    public final /* synthetic */ zabe zaa;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zabc(zabe zabe, Looper looper) {
        // this.zaa = zabe;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            zabe zabe = this.zaa;
            zabe.zaj.lock();
            try {
                if (zabe.zak()) {
                    zabe.zan();
                }
            } finally {
                zabe.zaj.unlock();
            }
        } else if (i == 2) {
            zabe.zai(this.zaa);
        }
    }
}
