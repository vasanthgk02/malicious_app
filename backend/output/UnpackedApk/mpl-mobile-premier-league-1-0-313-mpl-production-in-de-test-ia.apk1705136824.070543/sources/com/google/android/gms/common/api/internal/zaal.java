package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zaal implements ConnectionProgressReportCallbacks {
    public final WeakReference zaa;
    public final Api zab;
    public final boolean zac;

    public zaal(zaaw zaaw, Api api, boolean z) {
        this.zaa = new WeakReference(zaaw);
        this.zab = api;
        this.zac = z;
    }

    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        Lock lock;
        zaaw zaaw = (zaaw) this.zaa.get();
        if (zaaw != null) {
            Preconditions.checkState(Looper.myLooper() == zaaw.zaa.zag.zao, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zaaw.zab.lock();
            try {
                if (!zaaw.zaG(0)) {
                    lock = zaaw.zab;
                } else {
                    if (!connectionResult.isSuccess()) {
                        zaaw.zaE(connectionResult, this.zab, this.zac);
                    }
                    if (zaaw.zaH()) {
                        zaaw.zaF();
                    }
                    lock = zaaw.zab;
                }
                lock.unlock();
            } catch (Throwable th) {
                zaaw.zab.unlock();
                throw th;
            }
        }
    }
}
