package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
public final class zax implements zabz {
    public final /* synthetic */ zaaa zaa;

    public /* synthetic */ zax(zaaa zaaa) {
        this.zaa = zaaa;
    }

    public final void zaa(ConnectionResult connectionResult) {
        this.zaa.zam.lock();
        try {
            this.zaa.zaj = connectionResult;
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    public final void zab(Bundle bundle) {
        this.zaa.zam.lock();
        try {
            zaaa zaaa = this.zaa;
            Bundle bundle2 = zaaa.zai;
            if (bundle2 == null) {
                zaaa.zai = bundle;
            } else if (bundle != null) {
                bundle2.putAll(bundle);
            }
            this.zaa.zaj = ConnectionResult.RESULT_SUCCESS;
            zaaa.zap(this.zaa);
        } finally {
            this.zaa.zam.unlock();
        }
    }

    public final void zac(int i, boolean z) {
        Lock lock;
        this.zaa.zam.lock();
        try {
            zaaa zaaa = this.zaa;
            if (!zaaa.zal && zaaa.zak != null) {
                if (zaaa.zak.isSuccess()) {
                    this.zaa.zal = true;
                    this.zaa.zae.onConnectionSuspended(i);
                    lock = this.zaa.zam;
                    lock.unlock();
                }
            }
            this.zaa.zal = false;
            zaaa zaaa2 = this.zaa;
            zaaa2.zab.zac(i, z);
            zaaa2.zak = null;
            zaaa2.zaj = null;
            lock = this.zaa.zam;
            lock.unlock();
        } catch (Throwable th) {
            this.zaa.zam.unlock();
            throw th;
        }
    }
}
