package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder.Notifier;
import com.google.android.gms.common.data.DataHolder;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public abstract class DataHolderNotifier<L> implements Notifier<L> {
    @KeepForSdk
    public final void notifyListener(L l) {
        notifyListener(l, null);
    }

    @KeepForSdk
    public abstract void notifyListener(L l, DataHolder dataHolder);

    @KeepForSdk
    public void onNotifyListenerFailed() {
    }
}
