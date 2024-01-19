package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zah extends zad {
    public final ListenerKey zab;

    public zah(ListenerKey listenerKey, TaskCompletionSource taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zab = listenerKey;
    }

    public final boolean zaa(zabq zabq) {
        zaci zaci = (zaci) zabq.zag.get(this.zab);
        return zaci != null && zaci.zaa.zac;
    }

    public final Feature[] zab(zabq zabq) {
        zaci zaci = (zaci) zabq.zag.get(this.zab);
        if (zaci == null) {
            return null;
        }
        return zaci.zaa.zab;
    }

    public final void zac(zabq zabq) throws RemoteException {
        zaci zaci = (zaci) zabq.zag.remove(this.zab);
        if (zaci != null) {
            UnregisterListenerMethod unregisterListenerMethod = zaci.zab;
            ((zacl) unregisterListenerMethod).zaa.zab.accept(zabq.zac, this.zaa);
            zaci.zaa.zaa.clear();
            return;
        }
        this.zaa.trySetResult(Boolean.FALSE);
    }

    public final /* bridge */ /* synthetic */ void zag(zaad zaad, boolean z) {
    }
}
