package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zau;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zak implements Callback {
    @VisibleForTesting
    public final ArrayList zaa = new ArrayList();
    @NotOnlyInitialized
    public final zaj zab;
    public final ArrayList zac = new ArrayList();
    public final ArrayList zad = new ArrayList();
    public volatile boolean zae = false;
    public final AtomicInteger zaf = new AtomicInteger(0);
    public boolean zag = false;
    public final Handler zah;
    public final Object zai = new Object();

    public zak(Looper looper, zaj zaj) {
        this.zab = zaj;
        this.zah = new zau(looper, this);
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) message.obj;
            synchronized (this.zai) {
                if (this.zae && this.zab.isConnected() && this.zac.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle message: " + i, new Exception());
        return false;
    }

    public final void zaa() {
        this.zae = false;
        this.zaf.incrementAndGet();
    }

    public final void zag(OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.zai) {
            if (this.zad.contains(onConnectionFailedListener)) {
                String.valueOf(onConnectionFailedListener);
            } else {
                this.zad.add(onConnectionFailedListener);
            }
        }
    }
}
