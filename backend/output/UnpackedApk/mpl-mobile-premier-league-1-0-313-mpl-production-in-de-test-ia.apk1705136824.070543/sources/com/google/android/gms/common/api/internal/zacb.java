package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final /* synthetic */ class zacb implements Runnable {
    public final /* synthetic */ ListenerHolder zaa;
    public final /* synthetic */ Notifier zab;

    public /* synthetic */ zacb(ListenerHolder listenerHolder, Notifier notifier) {
        this.zaa = listenerHolder;
        this.zab = notifier;
    }

    public final void run() {
        ListenerHolder listenerHolder = this.zaa;
        Notifier notifier = this.zab;
        Object obj = listenerHolder.zab;
        if (obj == null) {
            notifier.onNotifyListenerFailed();
            return;
        }
        try {
            notifier.notifyListener(obj);
        } catch (RuntimeException e2) {
            notifier.onNotifyListenerFailed();
            throw e2;
        }
    }
}
