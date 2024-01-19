package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaf extends zad {
    public final zaci zab;

    public zaf(zaci zaci, TaskCompletionSource taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zab = zaci;
    }

    public final boolean zaa(zabq zabq) {
        return this.zab.zaa.zac;
    }

    public final Feature[] zab(zabq zabq) {
        return this.zab.zaa.zab;
    }

    public final void zac(zabq zabq) throws RemoteException {
        RegisterListenerMethod registerListenerMethod = this.zab.zaa;
        ((zack) registerListenerMethod).zaa.zaa.accept(zabq.zac, this.zaa);
        ListenerKey listenerKey = this.zab.zaa.zaa.zac;
        if (listenerKey != null) {
            zabq.zag.put(listenerKey, this.zab);
        }
    }

    public final /* bridge */ /* synthetic */ void zag(zaad zaad, boolean z) {
    }
}
