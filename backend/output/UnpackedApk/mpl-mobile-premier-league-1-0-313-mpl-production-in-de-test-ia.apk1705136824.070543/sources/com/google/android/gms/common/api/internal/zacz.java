package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zau;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zacz extends zau {
    public final /* synthetic */ zada zaa;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zacz(zada zada, Looper looper) {
        // this.zaa = zada;
        super(looper);
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            synchronized (this.zaa.zae) {
                zada zada = this.zaa.zab;
                Preconditions.checkNotNull(zada);
                if (pendingResult == null) {
                    zada.zaj(new Status(13, "Transform returned null"));
                } else if (pendingResult instanceof zacp) {
                    zacp zacp = (zacp) pendingResult;
                    zada.zaj(null);
                } else {
                    synchronized (zada.zae) {
                        zada.zad = pendingResult;
                        zada.zak();
                    }
                }
            }
        } else if (i == 1) {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            "Runtime exception on the transformation worker thread: ".concat(String.valueOf(runtimeException.getMessage()));
            throw runtimeException;
        }
    }
}
