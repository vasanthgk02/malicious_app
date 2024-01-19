package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.base.zau;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zabh extends zau {
    public final /* synthetic */ zabi zaa;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public zabh(zabi zabi, Looper looper) {
        // this.zaa = zabi;
        super(looper);
    }

    public final void handleMessage(Message message) {
        Lock lock;
        int i = message.what;
        if (i == 1) {
            zabg zabg = (zabg) message.obj;
            zabi zabi = this.zaa;
            if (zabg != null) {
                zabi.zai.lock();
                try {
                    if (zabi.zan != zabg.zaa) {
                        lock = zabi.zai;
                    } else {
                        zabg.zaa();
                        lock = zabi.zai;
                    }
                    lock.unlock();
                } catch (Throwable th) {
                    zabi.zai.unlock();
                    throw th;
                }
            } else {
                throw null;
            }
        } else if (i == 2) {
            throw ((RuntimeException) message.obj);
        }
    }
}
